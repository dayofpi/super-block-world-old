package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.common.PowerStarItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class ItemRegistry {

    public static final Item BRONZE_INGOT = new Item(new FabricItemSettings().group(Main.MOD_GROUP));
    public static final Item POISON_BUCKET = new BucketItem(Main.STILL_POISON, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(Main.MOD_GROUP));
    public static final Item POWER_STAR = new PowerStarItem(new FabricItemSettings().rarity(Rarity.RARE).group(Main.MOD_GROUP));

    public static void registerItems() {
        BlockItems.registerBlockItems();
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_ingot"), BRONZE_INGOT);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "poison_bucket"), POISON_BUCKET);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "power_star"), POWER_STAR);
    }
}
