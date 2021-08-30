package com.dayofpi.mixin.important;

import com.dayofpi.mixin.InterfaceModelLoader;
import com.dayofpi.super_block_world.entity.model.BuzzyShellModel;
import com.dayofpi.super_block_world.entity.model.NipperPlantModel;
import com.dayofpi.super_block_world.entity.registry.ModelLayers;
import com.dayofpi.super_block_world.entity.model.AbstractBuzzyModel;
import com.dayofpi.super_block_world.entity.model.ModBoatModel;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.EntityModels;
import net.minecraft.resource.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityModelLoader.class)
public abstract class MixinModelLoader {

    @Inject(at = @At("TAIL"), method = "reload", cancellable = true)
    public void reload(ResourceManager manager, CallbackInfo info) {
        ((InterfaceModelLoader) this).setModelParts(new ImmutableMap.Builder<>()
                .putAll(EntityModels.getModels())
                .put(ModelLayers.MOD_BOAT, ModBoatModel.getTexturedModelData())
                .put(ModelLayers.BUZZY_SHELL, BuzzyShellModel.getTexturedModelData())
                .put(ModelLayers.BUZZY_BEETLE, AbstractBuzzyModel.getTexturedModelData())
                .put(ModelLayers.BUZZY_BEETLE_SADDLE, AbstractBuzzyModel.getTexturedModelData())
                .put(ModelLayers.NIPPER_PLANT, NipperPlantModel.getTexturedModelData())
                .build());
    }
}