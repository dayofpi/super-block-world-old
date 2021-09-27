package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.entity.registry.EntityList;
import com.dayofpi.super_block_world.item.registry.ItemList;
import com.dayofpi.super_block_world.misc.DispenserBehaviors;
import com.dayofpi.super_block_world.world.FeatureList;
import com.dayofpi.super_block_world.world.FluidList;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Main implements ModInitializer {
    public static final String MOD_ID = "super_block_world";
    public static final Identifier DIMENSION_ID = new Identifier(MOD_ID, "mushroom_kingdom");

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
        //CustomPortalBuilder.beginPortal().frameBlock(BlockList.WARP_FRAME).ignitionSource(PortalIgnitionSource.FIRE).tintColor(188, 112, 255).destDimID(DIMENSION_ID).registerPortal();
    }
}
