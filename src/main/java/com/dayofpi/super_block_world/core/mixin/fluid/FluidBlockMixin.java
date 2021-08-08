package com.dayofpi.super_block_world.core.mixin.fluid;

import com.dayofpi.super_block_world.core.utility.ModTags;
import com.dayofpi.super_block_world.core.registry.BlockReg;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FluidBlock.class)
public class FluidBlockMixin extends Block {
    public FluidBlockMixin(Settings settings) {
        super(settings);
    }

    private void playExtinguishSound(WorldAccess world, BlockPos pos) {
        world.syncWorldEvent(WorldEvents.LAVA_EXTINGUISHED, pos, 0);
    }

    @Inject(at = @At("HEAD"), method = "receiveNeighborFluids(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockPos;Lnet/minecraft/block/BlockState;)Z", cancellable = true)
    private void receiveNeighborFluids(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> info) {
        if (((FluidBlockI) this).aFluid().isIn(FluidTags.LAVA)) {
            boolean bl = world.getBlockState(pos.down()).isOf(Blocks.SOUL_SOIL);

            for (Direction direction : ((FluidBlockI) this).aDirection()) {
                BlockPos blockPos = pos.offset(direction.getOpposite());
                if (world.getFluidState(blockPos).isIn(FluidTags.WATER) && !world.getFluidState(blockPos).isIn(ModTags.POISON)) {
                    Block block = world.getFluidState(pos).isStill() ? Blocks.OBSIDIAN : Blocks.COBBLESTONE;
                    world.setBlockState(pos, block.getDefaultState());
                    this.playExtinguishSound(world, pos);
                    info.setReturnValue(false);
                } else if (world.getFluidState(blockPos).isIn(ModTags.POISON)) {
                    Block block = world.getFluidState(pos).isStill() ? BlockReg.VANILLATE : BlockReg.TOPPED_VANILLATE;
                    world.setBlockState(pos, block.getDefaultState());
                    this.playExtinguishSound(world, pos);
                    info.setReturnValue(false);
                }

                if (bl && world.getBlockState(blockPos).isOf(Blocks.BLUE_ICE)) {
                    world.setBlockState(pos, Blocks.BASALT.getDefaultState());
                    this.playExtinguishSound(world, pos);
                    info.setReturnValue(false);
                }
            }
        }
        info.setReturnValue(true);
        info.cancel();
    }
}
