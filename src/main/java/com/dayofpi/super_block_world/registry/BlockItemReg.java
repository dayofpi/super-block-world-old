package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockItemReg {
    public static void registerBlockItems() {
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate"), new BlockItem(BlockReg.VANILLATE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "topped_vanillate"), new BlockItem(BlockReg.TOPPED_VANILLATE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_bricks"), new BlockItem(BlockReg.TOADSTONE_BRICKS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}
