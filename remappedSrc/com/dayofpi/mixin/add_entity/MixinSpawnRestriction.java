package com.dayofpi.mixin.add_entity;

import com.dayofpi.super_block_world.entity.registry.EntityList;
import com.dayofpi.super_block_world.entity.types.mobs.*;
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
        if (type == EntityList.BUZZY_BEETLE) {
            info.setReturnValue(AbstractBuzzy.canSpawn(world, pos, random));
            info.cancel();
        } else if (type == EntityList.SPIKE_TOP) {
            info.setReturnValue(SpikeTopEntity.canSpawn(world, pos, random));
            info.cancel();
        } else if (type == EntityList.GOOMBA) {
            info.setReturnValue(GoombaEntity.canSpawn(world, pos, type));
            info.cancel();
        } else if (type == EntityList.BOO) {
            info.setReturnValue(BooEntity.canSpawn(world, reason, pos, random));
            info.cancel();
        } else if (type == EntityList.STINGBY) {
            info.setReturnValue(StingbyEntity.canSpawn(world, pos));
            info.cancel();
        } else if (type == EntityList.MOO_MOO) {
            info.setReturnValue(MooMooEntity.canSpawn(world, pos));
            info.cancel();
        } else if (type == EntityList.ROTTEN_MUSHROOM) {
            info.setReturnValue(RottenMushroomEntity.canSpawn(world, pos, random));
            info.cancel();
        } else if (type == EntityList.NIPPER_PLANT) {
            info.setReturnValue(NipperPlantEntity.canSpawn(world, pos));
            info.cancel();
        }
    }
}