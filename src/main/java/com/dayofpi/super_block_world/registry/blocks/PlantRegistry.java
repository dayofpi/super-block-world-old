package com.dayofpi.super_block_world.registry.blocks;

import com.dayofpi.super_block_world.common.blocks.Flowerbed;
import com.dayofpi.super_block_world.registry.FeatureRegistry;
import com.dayofpi.super_block_world.utility.ModSaplingBlock;
import com.dayofpi.super_block_world.worldgen.AmanitaGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

public class PlantRegistry {
    public static final Block AMANITA_SAPLING = new ModSaplingBlock(new AmanitaGenerator(), FabricBlockSettings.of(Material.PLANT, MapColor.YELLOW).noCollision().ticksRandomly().sounds(BlockSoundGroup.GRASS));
    public static final Block YELLOW_MUSHROOM = new MushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.YELLOW).noCollision().ticksRandomly().sounds(BlockSoundGroup.GRASS), () -> FeatureRegistry.HUGE_YELLOW_MUSHROOM);
    public static final Block GREEN_MUSHROOM = new MushroomPlantBlock(FabricBlockSettings.copyOf(YELLOW_MUSHROOM).mapColor(MapColor.EMERALD_GREEN).luminance(2), () -> FeatureRegistry.HUGE_GREEN_MUSHROOM);
    public static final Block YELLOW_FLOWERBED = new Flowerbed(FabricBlockSettings.of(Material.PLANT, MapColor.YELLOW).noCollision().sounds(BlockSoundGroup.MOSS_CARPET));
}
