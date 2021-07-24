package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.registry.BlockReg;
import com.dayofpi.super_block_world.registry.ItemReg;
import com.dayofpi.super_block_world.registry.TagReg;
import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
    public static final String MOD_ID = "super_block_world";

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        BlockReg.registerBlocks();
        ItemReg.registerItems();
        TagReg.registerTags();
        CustomPortalApiRegistry.addPortal(Blocks.OAK_PLANKS, PortalIgnitionSource.ItemUseSource(ItemReg.POWER_STAR), new Identifier(MOD_ID, "mushroom_kingdom"),230, 200, 224);
    }
}
