package com.dayofpi.mixin.important;

import com.dayofpi.super_block_world.entities.EntityTypes;
import com.dayofpi.super_block_world.entities.types.BuzzyBeetleEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(SpawnRestriction.class)
public class MixinSpawnRestriction {
    @Inject(at = @At("HEAD"), method = "canSpawn(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/entity/SpawnReason;Lnet/minecraft/util/math/BlockPos;Ljava/util/Random;)Z", cancellable = true)
    private static <T extends MobEntity> void canSpawn(EntityType<T> type, ServerWorldAccess world, SpawnReason reason, BlockPos pos, Random random, CallbackInfoReturnable<Boolean> info) {
        if (type == EntityTypes.BUZZY_BEETLE) {
            info.setReturnValue(BuzzyBeetleEntity.canSpawn(world, pos, random));
            info.cancel();
        }
    }
}