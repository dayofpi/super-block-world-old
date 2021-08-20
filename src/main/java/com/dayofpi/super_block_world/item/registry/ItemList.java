package com.dayofpi.super_block_world.item.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.entity.registry.EntityList;
import com.dayofpi.super_block_world.entity.types.ModBoatEntity;
import com.dayofpi.super_block_world.item.types.ModBoatItem;
import com.dayofpi.super_block_world.item.types.PowerStarItem;
import com.dayofpi.super_block_world.item.types.ShellItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class ItemList {
    public static final ArmorMaterial BUZZY_ARMOR_MATERIAL = new BuzzyArmorMaterial();

    public static final Item YOSHI_FRUIT = new Item(new FabricItemSettings().food(FoodComponents.YOSHI_FRUIT).group(Main.ITEM_GROUP));
    public static final Item SUPER_MUSHROOM = new Item(new FabricItemSettings().food(FoodComponents.SUPER_MUSHROOM).maxCount(16).group(Main.ITEM_GROUP));
    public static final Item GOLDEN_MUSHROOM = new Item(new FabricItemSettings().food(FoodComponents.GOLDEN_MUSHROOM).maxCount(16).group(Main.ITEM_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item ONE_UP = new Item(new FabricItemSettings().food(FoodComponents.ONE_UP).maxCount(16).group(Main.ITEM_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item POISON_MUSHROOM = new Item(new FabricItemSettings().food(FoodComponents.POISON_MUSHROOM).maxCount(16).group(Main.ITEM_GROUP).rarity(Rarity.UNCOMMON));
    public static final Item COIN = new Item(new FabricItemSettings().group(Main.ITEM_GROUP));
    public static final Item RAW_BRONZE = new Item(new FabricItemSettings().group(Main.ITEM_GROUP));
    public static final Item BRONZE_INGOT = new Item(new FabricItemSettings().group(Main.ITEM_GROUP));
    public static final Item BUZZY_SHELL = new ShellItem(BUZZY_ARMOR_MATERIAL, EntityList.MOD_BOAT, EquipmentSlot.HEAD, new FabricItemSettings().group(Main.ITEM_GROUP));
    public static final Item BUZZY_SHELL_PIECE = new Item(new FabricItemSettings().group(Main.ITEM_GROUP));
    public static final Item GREEN_MUSHROOM_ON_A_STICK = new OnAStickItem<>(new FabricItemSettings().group(Main.ITEM_GROUP).maxDamage(25), EntityList.BUZZY_BEETLE, 2);
    public static final Item AMANITA_BOAT = new ModBoatItem(ModBoatEntity.Type.AMANITA, new FabricItemSettings().group(Main.ITEM_GROUP).maxCount(1));
    public static final Item POISON_BUCKET = new BucketItem(Main.STILL_POISON, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(Main.ITEM_GROUP));
    public static final Item POWER_STAR = new PowerStarItem(new FabricItemSettings().rarity(Rarity.RARE).group(Main.ITEM_GROUP));
    public static final Item BUZZY_BEETLE_SPAWN_EGG = new SpawnEggItem(EntityList.BUZZY_BEETLE, 16777215, 16777215, new FabricItemSettings().group(Main.ITEM_GROUP));
    public static final Item SPIKE_TOP_SPAWN_EGG = new SpawnEggItem(EntityList.SPIKE_TOP, 16777215, 16777215, new FabricItemSettings().group(Main.ITEM_GROUP));

    public static void registerItems() {
        registerBlockItems();
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yoshi_fruit"), YOSHI_FRUIT);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "super_mushroom"), SUPER_MUSHROOM);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "golden_mushroom"), GOLDEN_MUSHROOM);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "one_up"), ONE_UP);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "poison_mushroom"), POISON_MUSHROOM);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "coin"), COIN);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "raw_bronze"), RAW_BRONZE);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_ingot"), BRONZE_INGOT);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "buzzy_shell"), BUZZY_SHELL);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "buzzy_shell_piece"), BUZZY_SHELL_PIECE);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "green_mushroom_on_a_stick"), GREEN_MUSHROOM_ON_A_STICK);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_boat"), AMANITA_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "poison_bucket"), POISON_BUCKET);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "power_star"), POWER_STAR);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "spawn_eggs/buzzy_beetle"), BUZZY_BEETLE_SPAWN_EGG);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "spawn_eggs/spike_top"), SPIKE_TOP_SPAWN_EGG);
    }

    public static void registerBlockItems() {
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "warp_frame"), new BlockItem(BlockList.WARP_FRAME, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "empty_block"), new BlockItem(BlockList.EMPTY_BLOCK, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "question_block"), new BlockItem(BlockList.QUESTION_BLOCK, new FabricItemSettings().group(Main.BLOCK_GROUP).rarity(Rarity.UNCOMMON)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "coin_block"), new BlockItem(BlockList.COIN_BLOCK, new FabricItemSettings().group(Main.BLOCK_GROUP).rarity(Rarity.UNCOMMON)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "trampoline"), new BlockItem(BlockList.TRAMPOLINE, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "redstone_trampoline"), new BlockItem(BlockList.REDSTONE_TRAMPOLINE, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "stone_torch"), new BlockItem(BlockList.STONE_TORCH, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "donut_block"), new BlockItem(BlockList.DONUT_BLOCK, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_grass"), new BlockItem(BlockList.TOADSTOOL_GRASS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_soil"), new BlockItem(BlockList.TOADSTOOL_SOIL, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_farmland"), new BlockItem(BlockList.TOADSTOOL_FARMLAND, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_path"), new BlockItem(BlockList.TOADSTOOL_PATH, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate"), new BlockItem(BlockList.VANILLATE, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_bricks"), new BlockItem(BlockList.VANILLATE_BRICKS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_crumble"), new BlockItem(BlockList.VANILLATE_CRUMBLE, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_slab"), new BlockItem(BlockList.VANILLATE_SLAB, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_stairs"), new BlockItem(BlockList.VANILLATE_STAIRS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_brick_slab"), new BlockItem(BlockList.VANILLATE_BRICK_SLAB, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_brick_stairs"), new BlockItem(BlockList.VANILLATE_BRICK_STAIRS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "topped_vanillate"), new BlockItem(BlockList.TOPPED_VANILLATE, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "coal_topped_vanillate"), new BlockItem(BlockList.COAL_TOPPED_VANILLATE, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "iron_topped_vanillate"), new BlockItem(BlockList.IRON_TOPPED_VANILLATE, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gold_topped_vanillate"), new BlockItem(BlockList.GOLD_TOPPED_VANILLATE, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_ore"), new BlockItem(BlockList.BRONZE_ORE, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gloomstone_bronze_ore"), new BlockItem(BlockList.GLOOMSTONE_BRONZE_ORE, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "raw_bronze_block"), new BlockItem(BlockList.RAW_BRONZE_BLOCK, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_block"), new BlockItem(BlockList.BRONZE_BLOCK, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_slab"), new BlockItem(BlockList.BRONZE_SLAB, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_stairs"), new BlockItem(BlockList.BRONZE_STAIRS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone"), new BlockItem(BlockList.TOADSTONE, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_bricks"), new BlockItem(BlockList.TOADSTONE_BRICKS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_slab"), new BlockItem(BlockList.TOADSTONE_SLAB, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_stairs"), new BlockItem(BlockList.TOADSTONE_STAIRS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gloomstone"), new BlockItem(BlockList.GLOOMSTONE, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gloomstone_bricks"), new BlockItem(BlockList.GLOOMSTONE_BRICKS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gloomstone_slab"), new BlockItem(BlockList.GLOOMSTONE_SLAB, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gloomstone_stairs"), new BlockItem(BlockList.GLOOMSTONE_STAIRS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "golden_bricks"), new BlockItem(BlockList.GOLDEN_BRICKS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "crystal_bricks"), new BlockItem(BlockList.CRYSTAL_BRICKS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "hardstone_bricks"), new BlockItem(BlockList.HARDSTONE_BRICKS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "cracked_hardstone_bricks"), new BlockItem(BlockList.CRACKED_HARDSTONE_BRICKS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_log"), new BlockItem(BlockList.AMANITA_LOG, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_wood"), new BlockItem(BlockList.AMANITA_WOOD, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "stripped_amanita_log"), new BlockItem(BlockList.STRIPPED_AMANITA_LOG, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "stripped_amanita_wood"), new BlockItem(BlockList.STRIPPED_AMANITA_WOOD, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_planks"), new BlockItem(BlockList.AMANITA_PLANKS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_slab"), new BlockItem(BlockList.AMANITA_SLAB, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_stairs"), new BlockItem(BlockList.AMANITA_STAIRS, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_door"), new BlockItem(BlockList.AMANITA_DOOR, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_trapdoor"), new BlockItem(BlockList.AMANITA_TRAPDOOR, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_sign"), new SignItem(new FabricItemSettings().group(Main.BLOCK_GROUP).maxCount(16), BlockList.AMANITA_SIGN, BlockList.AMANITA_WALL_SIGN));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_leaves"), new BlockItem(BlockList.AMANITA_LEAVES, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "fruiting_amanita_leaves"), new BlockItem(BlockList.FRUITING_AMANITA_LEAVES, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_sapling"), new BlockItem(BlockList.AMANITA_SAPLING, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "horsetail"), new BlockItem(BlockList.HORSETAIL, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_flowerbed"), new BlockItem(BlockList.YELLOW_FLOWERBED, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "mushroom_stem"), new BlockItem(BlockList.MUSHROOM_STEM, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "brown_mushroom_cap"), new BlockItem(BlockList.BROWN_MUSHROOM_CAP, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "red_mushroom_cap"), new BlockItem(BlockList.RED_MUSHROOM_CAP, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_mushroom_cap"), new BlockItem(BlockList.YELLOW_MUSHROOM_CAP, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "green_mushroom_cap"), new BlockItem(BlockList.GREEN_MUSHROOM_CAP, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "pink_mushroom_cap"), new BlockItem(BlockList.PINK_MUSHROOM_CAP, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "purple_mushroom_cap"), new BlockItem(BlockList.PURPLE_MUSHROOM_CAP, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "orange_mushroom_cap"), new BlockItem(BlockList.ORANGE_MUSHROOM_CAP, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_mushroom"), new BlockItem(BlockList.YELLOW_MUSHROOM, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "green_mushroom"), new BlockItem(BlockList.GREEN_MUSHROOM, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "pink_mushroom"), new BlockItem(BlockList.PINK_MUSHROOM, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "purple_mushroom"), new BlockItem(BlockList.PURPLE_MUSHROOM, new FabricItemSettings().group(Main.BLOCK_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "orange_mushroom"), new BlockItem(BlockList.ORANGE_MUSHROOM, new FabricItemSettings().group(Main.BLOCK_GROUP)));
    }
}
