package com.dayofpi.super_block_world.misc;

import com.dayofpi.super_block_world.Main;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class Tags {
    public static Tag<Block> ALWAYS_CARVABLE;
    public static Tag<EntityType<?>> POISON_IMMUNE;
    public static Tag<Fluid> POISON;

    public static void registerTags() {
        ALWAYS_CARVABLE = addBlockTag("always_carvable");
        POISON_IMMUNE = addEntityTag("poison_immune");
        POISON = addFluidTag("poison");
    }

    private static Tag<Block> addBlockTag(String id) {
        return TagRegistry.block(new Identifier(Main.MOD_ID, id));
    }

    private static Tag<EntityType<?>> addEntityTag(String id) {
        return TagRegistry.entityType(new Identifier(Main.MOD_ID, id));
    }

    private static Tag<Fluid> addFluidTag(String id) {
        return TagRegistry.fluid(new Identifier(Main.MOD_ID, id));
    }
}
