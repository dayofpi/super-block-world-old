package com.dayofpi.super_block_world.block.registry;

import com.dayofpi.super_block_world.entity.renderer.ModSignRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class BlockClient {
    public static void setRenderLayers() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) ->
                        view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D),
                BlockList.TOADSTOOL_GRASS);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) ->
                        view != null && pos != null ? BiomeColors.getFoliageColor(view, pos) : FoliageColors.getColor(0.5D, 1.0D),
                BlockList.AMANITA_LEAVES, BlockList.FRUITING_AMANITA_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 7067428, BlockList.TOADSTOOL_GRASS);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 7067428, BlockList.AMANITA_LEAVES, BlockList.FRUITING_AMANITA_LEAVES);

        BlockEntityRendererRegistry.INSTANCE.register(BlockEntityList.MOD_SIGN, ModSignRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(BlockList.TOADSTOOL_GRASS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockList.AMANITA_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockList.FRUITING_AMANITA_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockList.STONE_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockList.YELLOW_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockList.GREEN_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockList.PINK_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockList.PURPLE_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockList.ORANGE_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockList.AMANITA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockList.HORSETAIL, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockList.YELLOW_FLOWERBED, RenderLayer.getCutout());
    }
}