package com.dayofpi.super_block_world.core.mixin.gen;

import com.dayofpi.super_block_world.core.utility.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.FluidTags;
import net.minecraft.world.gen.carver.Carver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Carver.class)
public class CarverMixin {
    // Allows carvers (caves, ravines, etc.) to go through mod blocks
    @Inject(at = @At("HEAD"), method = "canCarveBlock(Lnet/minecraft/block/BlockState;Lnet/minecraft/block/BlockState;)Z", cancellable = true)
    private void canCarveBlock(BlockState state, BlockState stateAbove, CallbackInfoReturnable<Boolean> info) {
        info.setReturnValue(state.isIn(ModTags.ALWAYS_CARVABLE) || (state.isOf(Blocks.SAND) || state.isOf(Blocks.GRAVEL)) && !stateAbove.getFluidState().isIn(FluidTags.WATER));
        info.cancel();
    }
}