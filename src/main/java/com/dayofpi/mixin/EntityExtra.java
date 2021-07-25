package com.dayofpi.mixin;

import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
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

    @Accessor("velocity")
    Vec3d getVelocity();

    @Accessor("fluidHeight")
    Object2DoubleMap<Tag<Fluid>> getFluidHeight();

    @Accessor("standingEyeHeight")
    float getStandingEyeHeight();

    @Invoker("move")
    void getMove(MovementType movementType, Vec3d movement);

    @Invoker("updateMovementInFluid")
    boolean getUpdateMovementInFluid(Tag<Fluid> tag, double d);

    @Invoker("updateVelocity")
    void getUpdateVelocity(float speed, Vec3d movementInput);

    @Invoker("setVelocity")
    void getSetVelocity(Vec3d velocity);

    @Invoker("damage")
    boolean invokeDamage(DamageSource source, float amount);

    @Invoker("hasNoGravity")
    boolean getHasNoGravity();

    @Invoker("isSprinting")
    boolean getIsSprinting();


}