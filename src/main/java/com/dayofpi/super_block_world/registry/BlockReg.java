package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockReg {
    public static final Block VANILLATE = new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_LIGHT_BLUE).requiresTool().strength(1.2F, 6.0F));
    public static final Block TOPPED_VANILLATE = new Block(FabricBlockSettings.copyOf(VANILLATE).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
    public static final Block TOADSTONE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_BROWN).requiresTool().strength(1.2F, 1.0F));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "vanillate"), VANILLATE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "topped_vanillate"), TOPPED_VANILLATE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstone_bricks"), TOADSTONE_BRICKS);
    }
}
