package com.dayofpi.mixin.fluid;

import com.dayofpi.super_block_world.misc.TagList;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WaterFluid.class)
public class WaterFluidMixin {
    @Inject(at = @At("HEAD"), method = "canBeReplacedWith(Lnet/minecraft/fluid/FluidState;Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/fluid/Fluid;Lnet/minecraft/util/math/Direction;)Z", cancellable = true)
    public void canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction, CallbackInfoReturnable<Boolean> info) {
        info.setReturnValue(direction == Direction.DOWN && !fluid.isIn(FluidTags.WATER) || state.getHeight(world, pos) >= 0.44444445F && fluid.isIn(TagList.POISON));
        info.cancel();
    }
}
