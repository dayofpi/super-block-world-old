package com.dayofpi.super_block_world.client;

import com.dayofpi.super_block_world.common.utility.items.ModBoatEntity;
import com.dayofpi.super_block_world.registry.ModEntities;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EntityClient {
    public static void registerEntityRenderers() {
        EntityRendererRegistry.INSTANCE.register(ModEntities.MOD_BOAT, BoatEntityRenderer::new);
    }

    private static EntityModelLayer create(String id) {
        return new EntityModelLayer(new Identifier("minecraft", id), "main");
    }

    public static EntityModelLayer createBoat(ModBoatEntity.Type type) {
        return create("boat/" + type.getName());
    }
}
