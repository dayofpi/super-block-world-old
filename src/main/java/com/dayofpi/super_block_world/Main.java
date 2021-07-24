package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.registry.BlockReg;
import com.dayofpi.super_block_world.registry.ItemReg;
import com.dayofpi.super_block_world.registry.TagReg;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
    public static final String MOD_ID = "super_block_world";

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.

        BlockReg.registerBlocks();
        ItemReg.registerItems();
        TagReg.registerTags();
    }
}
