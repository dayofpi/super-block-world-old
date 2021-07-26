package com.dayofpi.super_block_world.utility;

import com.dayofpi.super_block_world.Main;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModTags {
    private static Tag<Block> addBlockTag(String id) {
        return TagRegistry.block(new Identifier(Main.MOD_ID, id));
    }
    private static Tag<Fluid> addFluidTag(String id) {
        return TagRegistry.fluid(new Identifier(Main.MOD_ID, id));
    }

    public static Tag<Block> ALWAYS_CARVABLE;
    public static Tag<Fluid> POISON;

    public static void registerTags() {
        ALWAYS_CARVABLE = addBlockTag("always_carvable");
        POISON = addFluidTag("poison");
    }
}
