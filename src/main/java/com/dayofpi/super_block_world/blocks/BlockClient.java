package com.dayofpi.super_block_world.blocks;

import com.dayofpi.super_block_world.entities.renderers.ModSignRender;
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
                BlockTypes.TOADSTOOL_GRASS);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) ->
                        view != null && pos != null ? BiomeColors.getFoliageColor(view, pos) : FoliageColors.getColor(0.5D, 1.0D),
                BlockTypes.AMANITA_LEAVES, BlockTypes.FRUITING_AMANITA_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 7067428, BlockTypes.TOADSTOOL_GRASS);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 7067428, BlockTypes.AMANITA_LEAVES, BlockTypes.FRUITING_AMANITA_LEAVES);

        BlockEntityRendererRegistry.INSTANCE.register(BlockEntities.MOD_SIGN, ModSignRender::new);

        BlockRenderLayerMap.INSTANCE.putBlock(BlockTypes.TOADSTOOL_GRASS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockTypes.AMANITA_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockTypes.FRUITING_AMANITA_LEAVES, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockTypes.STONE_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockTypes.YELLOW_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockTypes.GREEN_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockTypes.AMANITA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockTypes.YELLOW_FLOWERBED, RenderLayer.getCutout());
    }
}