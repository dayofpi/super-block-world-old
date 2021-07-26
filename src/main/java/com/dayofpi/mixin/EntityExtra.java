package com.dayofpi.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityExtra {
    @Accessor("firstUpdate")
    boolean accessFirstUpdate();

    @Accessor("world")
    World accessWorld();

    @Accessor("blockPos")
    BlockPos accessBlockPos();

    @Accessor("fallDistance")
    float accessFalLDistance();

    @Invoker("updateMovementInFluid")
    boolean invokeUpdateMovementInFluid(Tag<Fluid> tag, double d);

    @Invoker("damage")
    boolean invokeDamage(DamageSource source, float amount);
}