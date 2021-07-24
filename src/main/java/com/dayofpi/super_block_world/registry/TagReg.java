package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class TagReg {
    // Block tags
    private static Tag<Block> addTag(String id) {
        return TagRegistry.block(new Identifier(Main.MOD_ID, id));
    }

    public static Tag<Block> ALWAYS_CARVABLE;

    public static void registerTags() {
        ALWAYS_CARVABLE = addTag("always_carvable");
    }
}
