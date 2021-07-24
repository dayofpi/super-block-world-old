package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class ItemReg {

    public static final Item POWER_STAR = new Item(new FabricItemSettings().rarity(Rarity.RARE).group(ItemGroup.MISC));

    public static void registerItems() {
        BlockItemReg.registerBlockItems();
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "power_star"), POWER_STAR);
    }
}
