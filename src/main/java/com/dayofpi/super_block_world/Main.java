package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.entity.registry.EntityList;
import com.dayofpi.super_block_world.item.registry.ItemList;
import com.dayofpi.super_block_world.misc.DispenserBehaviors;
import com.dayofpi.super_block_world.misc.SoundList;
import com.dayofpi.super_block_world.misc.TagList;
import com.dayofpi.super_block_world.world.FeatureList;
import com.dayofpi.super_block_world.world.FluidList;
import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.util.Identifier;

@SuppressWarnings("deprecation")
public class Main implements ModInitializer {
    public static final String MOD_ID = "super_block_world";

    @Override
    public void onInitialize() {
        BlockList.registerBlocks();
        ItemList.registerItems();
        EntityList.registerEntities();
        FeatureList.registerFeatures();
        TagList.registerTags();
        SoundList.registerSounds();
        FluidList.registerFluids();
        DispenserBehaviors.addDispenserBehaviors();
        CustomPortalApiRegistry.addPortal(BlockList.WARP_FRAME, PortalIgnitionSource.ItemUseSource(ItemList.POWER_STAR), new Identifier(MOD_ID, "mushroom_kingdom"), 230, 200, 224);
    }
}
