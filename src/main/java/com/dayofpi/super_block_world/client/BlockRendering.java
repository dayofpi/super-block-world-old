package com.dayofpi.super_block_world.client;

import com.dayofpi.super_block_world.registry.BlockRegistry;
import com.dayofpi.super_block_world.registry.blocks.PlantRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;

public class BlockRendering {
    public static void setRenderLayers() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) ->
                view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D),
                BlockRegistry.TOADSTOOL_GRASS);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) ->
                        view != null && pos != null ? BiomeColors.getFoliageColor(view, pos) : FoliageColors.getColor(0.5D, 1.0D),
                BlockRegistry.AMANITA_LEAVES, BlockRegistry.FRUITING_AMANITA_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 7067428, BlockRegistry.TOADSTOOL_GRASS);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 7067428, BlockRegistry.AMANITA_LEAVES, BlockRegistry.FRUITING_AMANITA_LEAVES);

        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.TOADSTOOL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.AMANITA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.FRUITING_AMANITA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRegistry.STONE_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PlantRegistry.YELLOW_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PlantRegistry.GREEN_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PlantRegistry.AMANITA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PlantRegistry.YELLOW_FLOWERBED, RenderLayer.getCutout());
    }
}