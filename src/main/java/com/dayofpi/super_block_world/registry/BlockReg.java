package com.dayofpi.super_block_world.registry;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.utility.fluids.CustomFluidBlock;
import com.dayofpi.super_block_world.utility.ModFallingBlock;
import com.dayofpi.super_block_world.utility.ModStairsBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class BlockReg {
    public static final Block VANILLATE = new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_LIGHT_BLUE).requiresTool().strength(1.2F, 6.0F));
    public static final Block VANILLATE_BRICKS = new Block(FabricBlockSettings.copyOf(VANILLATE));
    public static final Block VANILLATE_CRUMBLE = new ModFallingBlock(FabricBlockSettings.copyOf(VANILLATE).mapColor(MapColor.WHITE_GRAY));
    public static final Block VANILLATE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(VANILLATE_BRICKS));
    public static final Block VANILLATE_BRICK_STAIRS = new ModStairsBlock(VANILLATE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(VANILLATE_BRICKS));
    public static final Block TOPPED_VANILLATE = new Block(FabricBlockSettings.copyOf(VANILLATE).mapColor(MapColor.WHITE_GRAY));
    public static final Block COAL_TOPPED_VANILLATE = new OreBlock(FabricBlockSettings.copyOf(TOPPED_VANILLATE).strength(1.5F, 6.0F), UniformIntProvider.create(0, 1));
    public static final Block IRON_TOPPED_VANILLATE = new OreBlock(FabricBlockSettings.copyOf(TOPPED_VANILLATE).strength(1.5F, 6.0F), UniformIntProvider.create(0, 1));
    public static final Block GOLD_TOPPED_VANILLATE = new OreBlock(FabricBlockSettings.copyOf(TOPPED_VANILLATE).strength(1.5F, 6.0F), UniformIntProvider.create(0, 1));
    public static final Block BRONZE_ORE = new Block(FabricBlockSettings.copyOf(VANILLATE).strength(1.5F, 6.0F));
    public static final Block BRONZE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.TERRACOTTA_ORANGE).requiresTool().strength(5.0F, 8.0F));
    public static final Block BRONZE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(BRONZE_BLOCK));
    public static final Block BRONZE_STAIRS = new ModStairsBlock(BRONZE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(BRONZE_BLOCK));
    //TODO: Used block
    public static final Block TOADSTONE = new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_ORANGE).requiresTool().strength(1.2F, 1.0F));
    public static final Block TOADSTONE_BRICKS = new Block(FabricBlockSettings.copyOf(TOADSTONE));
    public static final Block GOLDEN_BRICKS = new Block(FabricBlockSettings.copyOf(TOADSTONE_BRICKS).sounds(BlockSoundGroup.METAL).mapColor(MapColor.GOLD));
    public static final Block CRYSTAL_BRICKS = new Block(FabricBlockSettings.copyOf(TOADSTONE_BRICKS).sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE));
    public static final Block TOADSTONE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(TOADSTONE));
    public static final Block TOADSTONE_STAIRS = new ModStairsBlock(TOADSTONE.getDefaultState(), FabricBlockSettings.copyOf(TOADSTONE));
    public static final Block HARDSTONE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE, MapColor.LIGHT_GRAY).requiresTool().strength(4.0F, 11F));
    public static final Block POISON = new CustomFluidBlock(Main.STILL_POISON, FabricBlockSettings.of(Material.WATER, MapColor.PURPLE).noCollision().ticksRandomly().strength(100.0F).luminance(7));

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "vanillate"), VANILLATE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "vanillate_bricks"), VANILLATE_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "vanillate_crumble"), VANILLATE_CRUMBLE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "vanillate_brick_slab"), VANILLATE_BRICK_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "vanillate_brick_stairs"), VANILLATE_BRICK_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "topped_vanillate"), TOPPED_VANILLATE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "coal_topped_vanillate"), COAL_TOPPED_VANILLATE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "iron_topped_vanillate"), IRON_TOPPED_VANILLATE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "gold_topped_vanillate"), GOLD_TOPPED_VANILLATE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "bronze_ore"), BRONZE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "bronze_block"), BRONZE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "bronze_slab"), BRONZE_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "bronze_stairs"), BRONZE_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstone"), TOADSTONE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstone_bricks"), TOADSTONE_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "golden_bricks"), GOLDEN_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "crystal_bricks"), CRYSTAL_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstone_slab"), TOADSTONE_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstone_stairs"), TOADSTONE_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "hardstone_bricks"), HARDSTONE_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "poison"), POISON);
    }
}
