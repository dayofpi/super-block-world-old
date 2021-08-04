package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.registry.blocks.Plants;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockItems {
    public static void registerBlockItems() {
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_grass"), new BlockItem(BlockRegistry.TOADSTOOL_GRASS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_soil"), new BlockItem(BlockRegistry.TOADSTOOL_SOIL, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_farmland"), new BlockItem(BlockRegistry.TOADSTOOL_FARMLAND, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate"), new BlockItem(BlockRegistry.VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_bricks"), new BlockItem(BlockRegistry.VANILLATE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_crumble"), new BlockItem(BlockRegistry.VANILLATE_CRUMBLE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_brick_slab"), new BlockItem(BlockRegistry.VANILLATE_BRICK_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_brick_stairs"), new BlockItem(BlockRegistry.VANILLATE_BRICK_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "topped_vanillate"), new BlockItem(BlockRegistry.TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "coal_topped_vanillate"), new BlockItem(BlockRegistry.COAL_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "iron_topped_vanillate"), new BlockItem(BlockRegistry.IRON_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gold_topped_vanillate"), new BlockItem(BlockRegistry.GOLD_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_ore"), new BlockItem(BlockRegistry.BRONZE_ORE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_block"), new BlockItem(BlockRegistry.BRONZE_BLOCK, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_slab"), new BlockItem(BlockRegistry.BRONZE_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_stairs"), new BlockItem(BlockRegistry.BRONZE_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone"), new BlockItem(BlockRegistry.TOADSTONE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_bricks"), new BlockItem(BlockRegistry.TOADSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "golden_bricks"), new BlockItem(BlockRegistry.GOLDEN_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "crystal_bricks"), new BlockItem(BlockRegistry.CRYSTAL_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_slab"), new BlockItem(BlockRegistry.TOADSTONE_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_stairs"), new BlockItem(BlockRegistry.TOADSTONE_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_log"), new BlockItem(BlockRegistry.AMANITA_LOG, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "mushroom_stem"), new BlockItem(BlockRegistry.MUSHROOM_STEM, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "brown_mushroom_cap"), new BlockItem(BlockRegistry.BROWN_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "red_mushroom_cap"), new BlockItem(BlockRegistry.RED_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_mushroom_cap"), new BlockItem(BlockRegistry.YELLOW_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "green_mushroom_cap"), new BlockItem(BlockRegistry.GREEN_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_mushroom"), new BlockItem(Plants.YELLOW_MUSHROOM, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "green_mushroom"), new BlockItem(Plants.GREEN_MUSHROOM, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_flowerbed"), new BlockItem(Plants.YELLOW_FLOWERBED, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "hardstone_bricks"), new BlockItem(BlockRegistry.HARDSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "cracked_hardstone_bricks"), new BlockItem(BlockRegistry.CRACKED_HARDSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "warp_frame"), new BlockItem(BlockRegistry.WARP_FRAME, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "stone_torch"), new BlockItem(BlockRegistry.STONE_TORCH, new FabricItemSettings().group(Main.MOD_GROUP)));
    }
}
