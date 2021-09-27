package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.Main;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class TagList {
    public static Tag<Item> SHELLMETS;
    public static Tag<Block> ALWAYS_CARVABLE;
    public static Tag<EntityType<?>> POISON_IMMUNE;
    public static Tag<EntityType<?>> IMMUNE_TO_BOOTS;
    public static Tag<Fluid> POISON;

    public static void registerTags() {
        SHELLMETS = addItemTag("shellmets");
        ALWAYS_CARVABLE = addBlockTag("always_carvable");
        POISON_IMMUNE = addEntityTag("poison_immune");
        IMMUNE_TO_BOOTS = addEntityTag("immune_to_boots");
        POISON = addFluidTag("poison");
    }

    private static Tag<Item> addItemTag(String id) {
        return TagFactory.ITEM.create(new Identifier(Main.MOD_ID, id));
    }

    private static Tag<Block> addBlockTag(String id) {
        return TagFactory.BLOCK.create(new Identifier(Main.MOD_ID, id));
    }

    private static Tag<EntityType<?>> addEntityTag(String id) {
        return TagFactory.ENTITY_TYPE.create(new Identifier(Main.MOD_ID, id));
    }

    private static Tag<Fluid> addFluidTag(String id) {
        return TagFactory.FLUID.create(new Identifier(Main.MOD_ID, id));
    }
}
