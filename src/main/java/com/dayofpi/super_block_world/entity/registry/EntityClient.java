package com.dayofpi.super_block_world.entity.registry;

import com.dayofpi.super_block_world.entity.renderer.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

@Environment(EnvType.CLIENT)
public class EntityClient {
    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(EntityList.TURNIP, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(EntityList.HAMMER, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(EntityList.BOMB, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(EntityList.MOD_BOAT, ModBoatRenderer::new);
        EntityRendererRegistry.register(EntityList.BUZZY_SHELL, (context) -> new BuzzyShellRenderer<>(context, ModelLayers.BUZZY_SHELL));
        EntityRendererRegistry.register(EntityList.MOO_MOO, MooMooRenderer::new);
        EntityRendererRegistry.register(EntityList.GOOMBA, GoombaRenderer::new);
        EntityRendererRegistry.register(EntityList.BUZZY_BEETLE, BuzzyRenderer::new);
        EntityRendererRegistry.register(EntityList.SPIKE_TOP, SpikeTopRenderer::new);
        EntityRendererRegistry.register(EntityList.NIPPER_PLANT, NipperPlantRenderer::new);
        EntityRendererRegistry.register(EntityList.STINGBY, StingbyRenderer::new);
        EntityRendererRegistry.register(EntityList.ROTTEN_MUSHROOM, RottenMushroomRenderer::new);
    }
}
