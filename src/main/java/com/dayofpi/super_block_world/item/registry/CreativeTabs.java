package com.dayofpi.super_block_world.item.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.block.registry.BlockList;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class CreativeTabs {
    public static final ItemGroup BLOCK_GROUP = FabricItemGroupBuilder.build(new Identifier(Main.MOD_ID, "block_group"), () -> new ItemStack(BlockList.QUESTION_BLOCK));
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(Main.MOD_ID, "item_group"), () -> new ItemStack(ItemList.SUPER_MUSHROOM));
}
