package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockItemReg {
    public static void registerBlockItems() {
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate"), new BlockItem(BlockReg.VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_bricks"), new BlockItem(BlockReg.VANILLATE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_crumbs"), new BlockItem(BlockReg.VANILLATE_CRUMBS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_brick_slab"), new BlockItem(BlockReg.VANILLATE_BRICK_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_brick_stairs"), new BlockItem(BlockReg.VANILLATE_BRICK_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "topped_vanillate"), new BlockItem(BlockReg.TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "coal_topped_vanillate"), new BlockItem(BlockReg.COAL_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "iron_topped_vanillate"), new BlockItem(BlockReg.IRON_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gold_topped_vanillate"), new BlockItem(BlockReg.GOLD_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_ore"), new BlockItem(BlockReg.BRONZE_ORE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_block"), new BlockItem(BlockReg.BRONZE_BLOCK, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_slab"), new BlockItem(BlockReg.BRONZE_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone"), new BlockItem(BlockReg.TOADSTONE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_bricks"), new BlockItem(BlockReg.TOADSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "golden_bricks"), new BlockItem(BlockReg.GOLDEN_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "crystal_bricks"), new BlockItem(BlockReg.CRYSTAL_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_slab"), new BlockItem(BlockReg.TOADSTONE_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
    }
}
