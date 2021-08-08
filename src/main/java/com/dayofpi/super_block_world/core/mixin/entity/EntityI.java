package com.dayofpi.super_block_world.core.mixin.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.fluid.Fluid;
import net.minecraft.sound.SoundCategory;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityI {
    @Accessor("type")
    EntityType<?> aType();

    @Accessor("world")
    World aWorld();

    @Accessor("blockPos")
    BlockPos aBlockPos();

    @Invoker("damage")
    boolean iDamage(DamageSource source, float amount);

    @Invoker("getSoundCategory")
    SoundCategory iGetSoundCategory();

    @Invoker("updateMovementInFluid")
    boolean iUpdateMovementInFluid(Tag<Fluid> tag, double d);
}
