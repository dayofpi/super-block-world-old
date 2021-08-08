package com.dayofpi.super_block_world.core.registry;

import com.dayofpi.super_block_world.core.Main;
import com.dayofpi.super_block_world.core.utility.items.ModBoatEntity;
import com.dayofpi.super_block_world.core.utility.items.ModBoatItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockItems {
    public static final Item AMANITA_BOAT = new ModBoatItem(ModBoatEntity.Type.AMANITA, new FabricItemSettings().group(Main.MOD_GROUP).maxCount(1));

    public static void registerBlockItems() {
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_grass"), new BlockItem(BlockReg.TOADSTOOL_GRASS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_soil"), new BlockItem(BlockReg.TOADSTOOL_SOIL, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_farmland"), new BlockItem(BlockReg.TOADSTOOL_FARMLAND, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_path"), new BlockItem(BlockReg.TOADSTOOL_PATH, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate"), new BlockItem(BlockReg.VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_bricks"), new BlockItem(BlockReg.VANILLATE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_crumble"), new BlockItem(BlockReg.VANILLATE_CRUMBLE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_brick_slab"), new BlockItem(BlockReg.VANILLATE_BRICK_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_brick_stairs"), new BlockItem(BlockReg.VANILLATE_BRICK_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "topped_vanillate"), new BlockItem(BlockReg.TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "coal_topped_vanillate"), new BlockItem(BlockReg.COAL_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "iron_topped_vanillate"), new BlockItem(BlockReg.IRON_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gold_topped_vanillate"), new BlockItem(BlockReg.GOLD_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_ore"), new BlockItem(BlockReg.BRONZE_ORE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_block"), new BlockItem(BlockReg.BRONZE_BLOCK, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_slab"), new BlockItem(BlockReg.BRONZE_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_stairs"), new BlockItem(BlockReg.BRONZE_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "question_block"), new BlockItem(BlockReg.QUESTION_BLOCK, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone"), new BlockItem(BlockReg.TOADSTONE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_bricks"), new BlockItem(BlockReg.TOADSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "golden_bricks"), new BlockItem(BlockReg.GOLDEN_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "crystal_bricks"), new BlockItem(BlockReg.CRYSTAL_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_slab"), new BlockItem(BlockReg.TOADSTONE_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_stairs"), new BlockItem(BlockReg.TOADSTONE_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_log"), new BlockItem(BlockReg.AMANITA_LOG, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_wood"), new BlockItem(BlockReg.AMANITA_WOOD, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "stripped_amanita_log"), new BlockItem(BlockReg.STRIPPED_AMANITA_LOG, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "stripped_amanita_wood"), new BlockItem(BlockReg.STRIPPED_AMANITA_WOOD, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_planks"), new BlockItem(BlockReg.AMANITA_PLANKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_slab"), new BlockItem(BlockReg.AMANITA_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_stairs"), new BlockItem(BlockReg.AMANITA_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_sign"), new SignItem(new FabricItemSettings().group(Main.MOD_GROUP).maxCount(16), BlockReg.AMANITA_SIGN, BlockReg.AMANITA_WALL_SIGN));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_boat"), AMANITA_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_leaves"), new BlockItem(BlockReg.AMANITA_LEAVES, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "fruiting_amanita_leaves"), new BlockItem(BlockReg.FRUITING_AMANITA_LEAVES, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_sapling"), new BlockItem(ModPlants.AMANITA_SAPLING, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "mushroom_stem"), new BlockItem(BlockReg.MUSHROOM_STEM, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "brown_mushroom_cap"), new BlockItem(BlockReg.BROWN_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "red_mushroom_cap"), new BlockItem(BlockReg.RED_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_mushroom_cap"), new BlockItem(BlockReg.YELLOW_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "green_mushroom_cap"), new BlockItem(BlockReg.GREEN_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_mushroom"), new BlockItem(ModPlants.YELLOW_MUSHROOM, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "green_mushroom"), new BlockItem(ModPlants.GREEN_MUSHROOM, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_flowerbed"), new BlockItem(ModPlants.YELLOW_FLOWERBED, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "hardstone_bricks"), new BlockItem(BlockReg.HARDSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "cracked_hardstone_bricks"), new BlockItem(BlockReg.CRACKED_HARDSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "warp_frame"), new BlockItem(BlockReg.WARP_FRAME, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "stone_torch"), new BlockItem(BlockReg.STONE_TORCH, new FabricItemSettings().group(Main.MOD_GROUP)));
    }
}
