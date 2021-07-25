package com.dayofpi.super_block_world.utility;

import com.dayofpi.super_block_world.registry.BlockReg;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class CustomFluidBlock extends FluidBlock {
    public CustomFluidBlock(FlowableFluid fluid, Settings settings) {
        super(fluid, settings);
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return !this.fluid.isIn(ModTags.POISON);
    }

    private void playExtinguishSound(WorldAccess world, BlockPos pos) {
        world.syncWorldEvent(1501, pos, 0);
    }

    /** The idea is that if poison flows over lava, it will turn into Vanillate, if lava
     * flows over poison it will turn into Topped Vanillate.
     * When poison touches water, it evaporates.
     * */
    private boolean receiveNeighborFluids(World world, BlockPos pos) {
        if (this.fluid.isIn(ModTags.POISON)) {
            for (Direction direction : field_34006) {
                BlockPos blockPos = pos.offset(direction.getOpposite());
                if (world.getFluidState(blockPos).isIn(FluidTags.WATER)) {
                    Block block = Blocks.AIR;
                    world.setBlockState(blockPos, block.getDefaultState());
                    world.playSound(null, pos, ModSounds.block_WATER_EVAPORATE, SoundCategory.BLOCKS, 0.5F, 2.6F);
                    world.addParticle(ParticleTypes.LARGE_SMOKE, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.25D, (double)pos.getZ() + 0.5D, 8D, 0.5D, 0.25D);
                    return false;
                }

                if (world.getFluidState(blockPos).isIn(ModTags.TRUE_LAVA)) {
                    Block block = !world.getFluidState(pos).isStill() ? BlockReg.VANILLATE : BlockReg.TOPPED_VANILLATE;
                    world.setBlockState(pos, block.getDefaultState());
                    this.playExtinguishSound(world, pos);
                    return false;
                }
            }
        }
        return true;
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (this.receiveNeighborFluids(world, pos)) {
            world.getFluidTickScheduler().schedule(pos, state.getFluidState().getFluid(), this.fluid.getTickRate(world));
        }
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (this.receiveNeighborFluids(world, pos)) {
            world.getFluidTickScheduler().schedule(pos, state.getFluidState().getFluid(), this.fluid.getTickRate(world));
        }
    }
}
