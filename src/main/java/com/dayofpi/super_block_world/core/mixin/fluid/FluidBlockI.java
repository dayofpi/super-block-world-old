package com.dayofpi.super_block_world.core.mixin.fluid;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(FluidBlock.class)
public interface FluidBlockI {
    @Accessor("fluid")
    FlowableFluid aFluid();

    @Accessor("field_34006")
    ImmutableList<Direction> aDirection();
}
