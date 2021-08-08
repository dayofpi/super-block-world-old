package com.dayofpi.super_block_world.core.mixin;

import com.dayofpi.super_block_world.client.ModEntityLayers;
import com.dayofpi.super_block_world.client.entity.model.ModBoatModel;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.EntityModels;
import net.minecraft.resource.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityModelLoader.class)
public abstract class EntityModelLoaderMixin {

    @Inject(at = @At("TAIL"), method = "reload", cancellable = true)
    public void reload(ResourceManager manager, CallbackInfo info) {
        ((EntityModelLoaderI) this).setModelParts(new ImmutableMap.Builder<>()
                .putAll(EntityModels.getModels())
                .put(ModEntityLayers.MOD_BOAT, ModBoatModel.getTexturedModelData())
                .build());
    }
}