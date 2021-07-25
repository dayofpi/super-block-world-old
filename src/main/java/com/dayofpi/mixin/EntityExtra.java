package com.dayofpi.mixin;

import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
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
    boolean getFirstUpdate();

    @Accessor("world")
    World getWorld();

    @Accessor("blockPos")
    BlockPos getBlockPos();

    @Accessor("fluidHeight")
    Object2DoubleMap<Tag<Fluid>> getFluidHeight();

    @Accessor("fallDistance")
    float getFallDistance();

    @Invoker("isInLava")
    boolean invokeIsInLava();

    @Invoker("setOnFireFromLava")
    void invokeSetOnFireFromLava();

    @Invoker("damage")
    boolean invokeDamage(DamageSource source, float amount);
}