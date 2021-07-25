package com.dayofpi.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.Fluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(LivingEntity.class)
public interface LivingEntityExtra {

    @Invoker("shouldSwimInFluids")
    boolean getShouldSwimInFluids();

    @Invoker("canWalkOnFluid")
    boolean getCanWalkOnFluid(Fluid fluid);
}
