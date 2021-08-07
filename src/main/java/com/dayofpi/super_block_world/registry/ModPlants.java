package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.common.block.Flowerbed;
import com.dayofpi.super_block_world.common.utility.blocktypes.ModSaplingBlock;
import com.dayofpi.super_block_world.common.utility.worldgen.AmanitaGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.MushroomPlantBlock;
import net.minecraft.sound.BlockSoundGroup;

public class ModPlants {
    public static final Block AMANITA_SAPLING = new ModSaplingBlock(new AmanitaGenerator(), FabricBlockSettings.of(Material.PLANT, MapColor.YELLOW).noCollision().ticksRandomly().sounds(BlockSoundGroup.GRASS));
    public static final Block YELLOW_MUSHROOM = new MushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.YELLOW).noCollision().ticksRandomly().sounds(BlockSoundGroup.GRASS), () -> ModFeatures.HUGE_YELLOW_MUSHROOM);
    public static final Block GREEN_MUSHROOM = new MushroomPlantBlock(FabricBlockSettings.copyOf(YELLOW_MUSHROOM).mapColor(MapColor.EMERALD_GREEN).luminance(2), () -> ModFeatures.HUGE_GREEN_MUSHROOM);
    public static final Block YELLOW_FLOWERBED = new Flowerbed(FabricBlockSettings.of(Material.PLANT, MapColor.YELLOW).noCollision().sounds(BlockSoundGroup.MOSS_CARPET));
}
