package com.dayofpi.super_block_world.entity.registry;

import com.dayofpi.super_block_world.entity.renderer.BuzzyBeetleRenderer;
import com.dayofpi.super_block_world.entity.renderer.ModBoatRenderer;
import com.dayofpi.super_block_world.entity.renderer.BuzzyShellRenderer;
import com.dayofpi.super_block_world.entity.renderer.SpikeTopRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class EntityClient {
    public static void registerEntityRenderers() {
        EntityRendererRegistry.INSTANCE.register(EntityList.MOD_BOAT, ModBoatRenderer::new);
        EntityRendererRegistry.INSTANCE.register(EntityList.BUZZY_SHELL, (context) -> new BuzzyShellRenderer(context, ModelLayers.SHELL));
        EntityRendererRegistry.INSTANCE.register(EntityList.BUZZY_BEETLE, BuzzyBeetleRenderer::new);
        EntityRendererRegistry.INSTANCE.register(EntityList.SPIKE_TOP, SpikeTopRenderer::new);
    }
}
