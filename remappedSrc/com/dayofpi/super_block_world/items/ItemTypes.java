package com.dayofpi.super_block_world.items;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.blocks.BlockTypes;
import com.dayofpi.super_block_world.entities.EntityTypes;
import com.dayofpi.super_block_world.entities.types.ModBoatEntity;
import com.dayofpi.super_block_world.items.types.ModBoatItem;
import com.dayofpi.super_block_world.items.types.PowerStarItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class ItemTypes {
    public static final ArmorMaterial BUZZY_ARMOR_MATERIAL = new BuzzyArmorMaterial();

    public static final Item YOSHI_FRUIT = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6F).build()).group(Main.MOD_GROUP));
    public static final Item BRONZE_INGOT = new Item(new FabricItemSettings().group(Main.MOD_GROUP));
    public static final Item BUZZY_SHELL = new ArmorItem(BUZZY_ARMOR_MATERIAL, EquipmentSlot.HEAD, new FabricItemSettings().group(Main.MOD_GROUP));
    public static final Item BUZZY_SHELL_PIECE = new Item(new FabricItemSettings().group(Main.MOD_GROUP));
    public static final Item GREEN_MUSHROOM_ON_A_STICK = new OnAStickItem<>(new FabricItemSettings().group(Main.MOD_GROUP).maxDamage(25), EntityTypes.BUZZY_BEETLE, 2);
    public static final Item POISON_BUCKET = new BucketItem(Main.STILL_POISON, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1).group(Main.MOD_GROUP));
    public static final Item POWER_STAR = new PowerStarItem(new FabricItemSettings().rarity(Rarity.RARE).group(Main.MOD_GROUP));
    public static final Item BUZZY_BEETLE_SPAWN_EGG = new SpawnEggItem(EntityTypes.BUZZY_BEETLE, 4614307, 16768848, new FabricItemSettings().group(Main.MOD_GROUP));
    public static final Item AMANITA_BOAT = new ModBoatItem(ModBoatEntity.Type.AMANITA, new FabricItemSettings().group(Main.MOD_GROUP).maxCount(1));

    public static void registerItems() {
        registerBlockItems();
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yoshi_fruit"), YOSHI_FRUIT);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_ingot"), BRONZE_INGOT);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "buzzy_shell"), BUZZY_SHELL);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "buzzy_shell_piece"), BUZZY_SHELL_PIECE);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "green_mushroom_on_a_stick"), GREEN_MUSHROOM_ON_A_STICK);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "poison_bucket"), POISON_BUCKET);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "power_star"), POWER_STAR);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "spawn_eggs/buzzy_beetle"), BUZZY_BEETLE_SPAWN_EGG);
    }

    public static void registerBlockItems() {
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_grass"), new BlockItem(BlockTypes.TOADSTOOL_GRASS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_soil"), new BlockItem(BlockTypes.TOADSTOOL_SOIL, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_farmland"), new BlockItem(BlockTypes.TOADSTOOL_FARMLAND, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstool_path"), new BlockItem(BlockTypes.TOADSTOOL_PATH, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate"), new BlockItem(BlockTypes.VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_bricks"), new BlockItem(BlockTypes.VANILLATE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_crumble"), new BlockItem(BlockTypes.VANILLATE_CRUMBLE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_brick_slab"), new BlockItem(BlockTypes.VANILLATE_BRICK_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "vanillate_brick_stairs"), new BlockItem(BlockTypes.VANILLATE_BRICK_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "topped_vanillate"), new BlockItem(BlockTypes.TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "coal_topped_vanillate"), new BlockItem(BlockTypes.COAL_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "iron_topped_vanillate"), new BlockItem(BlockTypes.IRON_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gold_topped_vanillate"), new BlockItem(BlockTypes.GOLD_TOPPED_VANILLATE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_ore"), new BlockItem(BlockTypes.BRONZE_ORE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_block"), new BlockItem(BlockTypes.BRONZE_BLOCK, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_slab"), new BlockItem(BlockTypes.BRONZE_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "bronze_stairs"), new BlockItem(BlockTypes.BRONZE_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "question_block"), new BlockItem(BlockTypes.QUESTION_BLOCK, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "empty_block"), new BlockItem(BlockTypes.EMPTY_BLOCK, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone"), new BlockItem(BlockTypes.TOADSTONE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_bricks"), new BlockItem(BlockTypes.TOADSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gloomstone"), new BlockItem(BlockTypes.GLOOMSTONE, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "gloomstone_bricks"), new BlockItem(BlockTypes.GLOOMSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "golden_bricks"), new BlockItem(BlockTypes.GOLDEN_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "crystal_bricks"), new BlockItem(BlockTypes.CRYSTAL_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_slab"), new BlockItem(BlockTypes.TOADSTONE_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "toadstone_stairs"), new BlockItem(BlockTypes.TOADSTONE_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_log"), new BlockItem(BlockTypes.AMANITA_LOG, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_wood"), new BlockItem(BlockTypes.AMANITA_WOOD, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "stripped_amanita_log"), new BlockItem(BlockTypes.STRIPPED_AMANITA_LOG, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "stripped_amanita_wood"), new BlockItem(BlockTypes.STRIPPED_AMANITA_WOOD, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_planks"), new BlockItem(BlockTypes.AMANITA_PLANKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_slab"), new BlockItem(BlockTypes.AMANITA_SLAB, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_stairs"), new BlockItem(BlockTypes.AMANITA_STAIRS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_sign"), new SignItem(new FabricItemSettings().group(Main.MOD_GROUP).maxCount(16), BlockTypes.AMANITA_SIGN, BlockTypes.AMANITA_WALL_SIGN));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_boat"), AMANITA_BOAT);
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_leaves"), new BlockItem(BlockTypes.AMANITA_LEAVES, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "fruiting_amanita_leaves"), new BlockItem(BlockTypes.FRUITING_AMANITA_LEAVES, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "amanita_sapling"), new BlockItem(BlockTypes.AMANITA_SAPLING, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "mushroom_stem"), new BlockItem(BlockTypes.MUSHROOM_STEM, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "brown_mushroom_cap"), new BlockItem(BlockTypes.BROWN_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "red_mushroom_cap"), new BlockItem(BlockTypes.RED_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_mushroom_cap"), new BlockItem(BlockTypes.YELLOW_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "green_mushroom_cap"), new BlockItem(BlockTypes.GREEN_MUSHROOM_CAP, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_mushroom"), new BlockItem(BlockTypes.YELLOW_MUSHROOM, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "green_mushroom"), new BlockItem(BlockTypes.GREEN_MUSHROOM, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "yellow_flowerbed"), new BlockItem(BlockTypes.YELLOW_FLOWERBED, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "hardstone_bricks"), new BlockItem(BlockTypes.HARDSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "cracked_hardstone_bricks"), new BlockItem(BlockTypes.CRACKED_HARDSTONE_BRICKS, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "warp_frame"), new BlockItem(BlockTypes.WARP_FRAME, new FabricItemSettings().group(Main.MOD_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, "stone_torch"), new BlockItem(BlockTypes.STONE_TORCH, new FabricItemSettings().group(Main.MOD_GROUP)));
    }
}
