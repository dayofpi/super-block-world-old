package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.common.utility.items.ModBoatEntity;
import com.dayofpi.super_block_world.common.utility.items.ModBoatItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockItems {
    public static final Item AMANITA_BOAT = new ModBoatItem(ModBoatEntity.Type.AMANITA, new FabricItemSettings().group(Main.MOD_GROUP).maxCount(1));

    public static void registerBlockItems() {
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_grass"), new BlockItem(ModBlocks.TOADSTOOL_GRASS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_soil"), new BlockItem(ModBlocks.TOADSTOOL_SOIL, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_farmland"), new BlockItem(ModBlocks.TOADSTOOL_FARMLAND, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_path"), new BlockItem(ModBlocks.TOADSTOOL_PATH, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate"), new BlockItem(ModBlocks.VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_bricks"), new BlockItem(ModBlocks.VANILLATE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_crumble"), new BlockItem(ModBlocks.VANILLATE_CRUMBLE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_brick_slab"), new BlockItem(ModBlocks.VANILLATE_BRICK_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_brick_stairs"), new BlockItem(ModBlocks.VANILLATE_BRICK_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "topped_vanillate"), new BlockItem(ModBlocks.TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "coal_topped_vanillate"), new BlockItem(ModBlocks.COAL_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "iron_topped_vanillate"), new BlockItem(ModBlocks.IRON_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gold_topped_vanillate"), new BlockItem(ModBlocks.GOLD_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_ore"), new BlockItem(ModBlocks.BRONZE_ORE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_block"), new BlockItem(ModBlocks.BRONZE_BLOCK, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_slab"), new BlockItem(ModBlocks.BRONZE_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_stairs"), new BlockItem(ModBlocks.BRONZE_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "question_block"), new BlockItem(ModBlocks.QUESTION_BLOCK, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone"), new BlockItem(ModBlocks.TOADSTONE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_bricks"), new BlockItem(ModBlocks.TOADSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "golden_bricks"), new BlockItem(ModBlocks.GOLDEN_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "crystal_bricks"), new BlockItem(ModBlocks.CRYSTAL_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_slab"), new BlockItem(ModBlocks.TOADSTONE_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_stairs"), new BlockItem(ModBlocks.TOADSTONE_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_log"), new BlockItem(ModBlocks.AMANITA_LOG, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_planks"), new BlockItem(ModBlocks.AMANITA_PLANKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_slab"), new BlockItem(ModBlocks.AMANITA_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_stairs"), new BlockItem(ModBlocks.AMANITA_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_sign"), new SignItem(new FabricItemSettings().group(Main.MOD_GROUP).maxCount(16), ModBlocks.AMANITA_SIGN, ModBlocks.AMANITA_WALL_SIGN));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_boat"), AMANITA_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_leaves"), new BlockItem(ModBlocks.AMANITA_LEAVES, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "fruiting_amanita_leaves"), new BlockItem(ModBlocks.FRUITING_AMANITA_LEAVES, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_sapling"), new BlockItem(ModPlants.AMANITA_SAPLING, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "mushroom_stem"), new BlockItem(ModBlocks.MUSHROOM_STEM, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "brown_mushroom_cap"), new BlockItem(ModBlocks.BROWN_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "red_mushroom_cap"), new BlockItem(ModBlocks.RED_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_mushroom_cap"), new BlockItem(ModBlocks.YELLOW_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "green_mushroom_cap"), new BlockItem(ModBlocks.GREEN_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_mushroom"), new BlockItem(ModPlants.YELLOW_MUSHROOM, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "green_mushroom"), new BlockItem(ModPlants.GREEN_MUSHROOM, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_flowerbed"), new BlockItem(ModPlants.YELLOW_FLOWERBED, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "hardstone_bricks"), new BlockItem(ModBlocks.HARDSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "cracked_hardstone_bricks"), new BlockItem(ModBlocks.CRACKED_HARDSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "warp_frame"), new BlockItem(ModBlocks.WARP_FRAME, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "stone_torch"), new BlockItem(ModBlocks.STONE_TORCH, new FabricItemSettings().group(Main.MOD_GROUP)));
    }
}
