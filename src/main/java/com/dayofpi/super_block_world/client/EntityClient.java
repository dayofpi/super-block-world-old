package com.dayofpi.super_block_world.client;

import com.dayofpi.super_block_world.client.entity.renderer.ModBoatRender;
import com.dayofpi.super_block_world.core.registry.EntityReg;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class EntityClient {
    public static void registerEntityRenderers() {
        EntityRendererRegistry.INSTANCE.register(EntityReg.MOD_BOAT, ModBoatRender::new);
    }
}
