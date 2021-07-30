package com.dayofpi.super_block_world;

import com.dayofpi.super_block_world.utility.fluids.PoisonFluid;
import com.dayofpi.super_block_world.registry.BlockReg;
import com.dayofpi.super_block_world.registry.ItemReg;
import com.dayofpi.super_block_world.utility.ModSounds;
import com.dayofpi.super_block_world.utility.ModTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
@SuppressWarnings("deprecation")
public class Main implements ModInitializer {
    // Mod ID
    public static final String MOD_ID = "super_block_world";
    // Item group
    public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "item_group"), () -> new ItemStack(ItemReg.POWER_STAR));

    public static final FlowableFluid STILL_POISON = new PoisonFluid.Still();
    public static FlowableFluid FLOWING_POISON = new PoisonFluid.Flowing();

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        Registry.register(Registry.FLUID, new Identifier(MOD_ID, "poison"), STILL_POISON);
        Registry.register(Registry.FLUID, new Identifier(MOD_ID, "flowing_poison"), FLOWING_POISON);
        BlockReg.registerBlocks();
        ItemReg.registerItems();
        ModTags.registerTags();
        ModSounds.registerSounds();
        CustomPortalApiRegistry.addPortal(Blocks.OAK_PLANKS, PortalIgnitionSource.ItemUseSource(ItemReg.POWER_STAR), new Identifier(MOD_ID, "mushroom_kingdom"),230, 200, 224);
    }
}
