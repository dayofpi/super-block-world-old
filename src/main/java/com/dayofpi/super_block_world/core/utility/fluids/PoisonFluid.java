package com.dayofpi.super_block_world.core.utility.fluids;

import com.dayofpi.super_block_world.core.Main;
import com.dayofpi.super_block_world.core.utility.ModTags;
import com.dayofpi.super_block_world.core.registry.BlockReg;
import com.dayofpi.super_block_world.core.registry.ItemReg;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.Optional;
import java.util.Random;

public abstract class PoisonFluid extends CustomFluid {
    public Fluid getStill() {
        return Main.STILL_POISON;
    }

    public Fluid getFlowing() {
        return Main.FLOWING_POISON;
    }

    public Item getBucketItem() {
        return ItemReg.POISON_BUCKET;
    }

    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ITEM_BUCKET_FILL_LAVA);
    }

    public ParticleEffect getParticle() {
        return ParticleTypes.FALLING_OBSIDIAN_TEAR;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return BlockReg.POISON.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(fluidState));
    }

    private void playExtinguishEvent(WorldAccess world, BlockPos pos) {
        world.syncWorldEvent(1501, pos, 0);
    }

    protected void flow(WorldAccess world, BlockPos pos, BlockState state, Direction direction, FluidState fluidState) {
        if (direction == Direction.DOWN) {
            FluidState fluidState2 = world.getFluidState(pos);
            if (this.isIn(ModTags.POISON) && fluidState2.isIn(FluidTags.LAVA)) {
                if (state.getBlock() instanceof FluidBlock) {
                    world.setBlockState(pos, BlockReg.VANILLATE.getDefaultState(), Block.NOTIFY_ALL);
                }
                this.playExtinguishEvent(world, pos);
                return;
            }
        }

        super.flow(world, pos, state, direction, fluidState);
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    @Override
    public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        //TODO: Give it unique particles
        BlockPos blockPos = pos.up();
        if (world.getBlockState(blockPos).isAir() && !world.getBlockState(blockPos).isOpaqueFullCube(world, blockPos)) {
            if (random.nextInt(200) == 0) {
                world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, 0.2F + random.nextFloat() * 0.2F, 1.2F + random.nextFloat() * 0.15F, false);
            }
        }
    }

    // Flowing class
    public static class Flowing extends PoisonFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    // Still class
    public static class Still extends PoisonFluid {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}