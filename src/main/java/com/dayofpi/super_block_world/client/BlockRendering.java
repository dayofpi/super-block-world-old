package com.dayofpi.super_block_world.client;

import com.dayofpi.super_block_world.registry.BlockRegistry;
import com.dayofpi.super_block_world.registry.blocks.Plants;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;

public class BlockRendering {
    public static void setRenderLayers() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D), BlockRegistry.TOADSTOOL_GRASS);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 7067428, BlockRegistry.TOADSTOOL_GRASS);

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.TOADSTOOL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.STONE_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Plants.YELLOW_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Plants.GREEN_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Plants.YELLOW_FLOWERBED, RenderLayer.getCutout());
    }
}