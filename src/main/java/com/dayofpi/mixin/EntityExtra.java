package com.dayofpi.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityExtra {
    @Accessor("firstUpdate")
    boolean accessFirstUpdate();

    @Accessor("blockPos")
    BlockPos blockPos();

    @Accessor("world")
    World world();

    @Invoker("damage")
    boolean invokeDamage(DamageSource source, float amount);
}