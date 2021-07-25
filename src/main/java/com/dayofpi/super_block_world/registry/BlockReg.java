package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.utility.CustomFluidBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockReg {
    public static final Block VANILLATE = new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_LIGHT_BLUE).requiresTool().strength(1.2F, 6.0F));
    public static final Block TOPPED_VANILLATE = new Block(FabricBlockSettings.copyOf(VANILLATE).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY));
    public static final Block COAL_TOPPED_VANILLATE = new Block(FabricBlockSettings.copyOf(TOPPED_VANILLATE).strength(1.5F, 6.0F));
    public static final Block IRON_TOPPED_VANILLATE = new Block(FabricBlockSettings.copyOf(TOPPED_VANILLATE).strength(1.5F, 6.0F));
    public static final Block GOLD_TOPPED_VANILLATE = new Block(FabricBlockSettings.copyOf(TOPPED_VANILLATE).strength(1.5F, 6.0F));
    public static final Block BRONZE_ORE = new Block(FabricBlockSettings.copyOf(VANILLATE).strength(1.5F, 6.0F));
    // Bronze block
    // Used block
    public static final Block TOADSTONE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_BROWN).requiresTool().strength(1.2F, 1.0F).sounds(BlockSoundGroup.TUFF));
    public static final Block CRYSTAL_BRICKS = new Block(FabricBlockSettings.copyOf(TOADSTONE_BRICKS).sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE));
    public static final Block POISON = new CustomFluidBlock(Main.STILL_POISON, FabricBlockSettings.of(Material.WATER, MapColor.PURPLE).noCollision().ticksRandomly().strength(100.0F).luminance(7));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "vanillate"), VANILLATE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "topped_vanillate"), TOPPED_VANILLATE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "coal_topped_vanillate"), COAL_TOPPED_VANILLATE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "iron_topped_vanillate"), IRON_TOPPED_VANILLATE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "gold_topped_vanillate"), GOLD_TOPPED_VANILLATE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "bronze_ore"), BRONZE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstone_bricks"), TOADSTONE_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "crystal_bricks"), CRYSTAL_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "poison"), POISON);
    }
}
