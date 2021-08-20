package com.dayofpi.super_block_world.entity;

import com.dayofpi.super_block_world.entity.renderer.BuzzyBeetleRender;
import com.dayofpi.super_block_world.entity.renderer.ModBoatRender;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class EntityClient {
    public static void registerEntityRenderers() {
        EntityRendererRegistry.INSTANCE.register(EntityTypes.MOD_BOAT, ModBoatRender::new);
        EntityRendererRegistry.INSTANCE.register(EntityTypes.BUZZY_BEETLE, BuzzyBeetleRender::new);
    }
}
