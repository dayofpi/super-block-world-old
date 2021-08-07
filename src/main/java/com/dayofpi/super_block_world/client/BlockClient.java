package com.dayofpi.super_block_world.client;

import com.dayofpi.super_block_world.client.entity.renderer.ModSignRender;
import com.dayofpi.super_block_world.registry.ModBlockEntities;
import com.dayofpi.super_block_world.registry.ModBlocks;
import com.dayofpi.super_block_world.registry.ModPlants;
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
                ModBlocks.TOADSTOOL_GRASS);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) ->
                        view != null && pos != null ? BiomeColors.getFoliageColor(view, pos) : FoliageColors.getColor(0.5D, 1.0D),
                ModBlocks.AMANITA_LEAVES, ModBlocks.FRUITING_AMANITA_LEAVES);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 7067428, ModBlocks.TOADSTOOL_GRASS);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 7067428, ModBlocks.AMANITA_LEAVES, ModBlocks.FRUITING_AMANITA_LEAVES);

        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntities.MOD_SIGN, ModSignRender::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOADSTOOL_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMANITA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FRUITING_AMANITA_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STONE_TORCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModPlants.YELLOW_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModPlants.GREEN_MUSHROOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModPlants.AMANITA_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModPlants.YELLOW_FLOWERBED, RenderLayer.getCutout());
    }
}