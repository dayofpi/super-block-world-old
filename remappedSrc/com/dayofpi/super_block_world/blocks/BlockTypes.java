package com.dayofpi.super_block_world.block;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.block.types.*;
import com.dayofpi.super_block_world.block.types.template.*;
import com.dayofpi.super_block_world.world.FeatureReg;
import com.dayofpi.super_block_world.world.feature.AmanitaTree;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import java.util.function.ToIntFunction;

public class BlockTypes {
    public static final Block TOADSTOOL_GRASS = new ToadstoolGrass(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.LIME).strength(0.5F, 4.0F).sounds(BlockSoundGroup.GRASS));
    public static final Block TOADSTOOL_SOIL = new ToadstoolSoil(FabricBlockSettings.of(Material.SOIL, MapColor.TERRACOTTA_ORANGE).strength(0.5F, 4.0F).sounds(BlockSoundGroup.GRAVEL));
    public static final Block TOADSTOOL_FARMLAND = new ToadstoolFarmland(FabricBlockSettings.copyOf(TOADSTOOL_SOIL).ticksRandomly());
    public static final Block TOADSTOOL_PATH = new ToadstoolPath(FabricBlockSettings.copyOf(TOADSTOOL_SOIL).mapColor(MapColor.BROWN));
    public static final Block VANILLATE = new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_LIGHT_BLUE).requiresTool().strength(1.2F, 6.0F));
    public static final Block VANILLATE_BRICKS = new Block(FabricBlockSettings.copyOf(VANILLATE));
    public static final Block VANILLATE_BRICK_SLAB = new SlabBlock(FabricBlockSettings.copyOf(VANILLATE_BRICKS));
    public static final Block VANILLATE_BRICK_STAIRS = new ModStairsBlock(VANILLATE_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(VANILLATE_BRICKS));
    public static final Block VANILLATE_CRUMBLE = new ModFallingBlock(FabricBlockSettings.copyOf(VANILLATE).mapColor(MapColor.WHITE_GRAY));
    public static final Block TOPPED_VANILLATE = new Block(FabricBlockSettings.copyOf(VANILLATE).mapColor(MapColor.WHITE_GRAY));
    public static final Block COAL_TOPPED_VANILLATE = new OreBlock(FabricBlockSettings.copyOf(TOPPED_VANILLATE).strength(1.5F, 6.0F), UniformIntProvider.create(0, 1));
    public static final Block IRON_TOPPED_VANILLATE = new OreBlock(FabricBlockSettings.copyOf(TOPPED_VANILLATE).strength(1.5F, 6.0F), UniformIntProvider.create(0, 1));
    public static final Block GOLD_TOPPED_VANILLATE = new OreBlock(FabricBlockSettings.copyOf(TOPPED_VANILLATE).strength(1.5F, 6.0F), UniformIntProvider.create(0, 1));
    public static final Block BRONZE_ORE = new Block(FabricBlockSettings.copyOf(VANILLATE).strength(1.5F, 6.0F));
    public static final Block BRONZE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.TERRACOTTA_ORANGE).requiresTool().strength(5.0F, 8.0F));
    public static final Block BRONZE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(BRONZE_BLOCK));
    public static final Block BRONZE_STAIRS = new ModStairsBlock(BRONZE_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(BRONZE_BLOCK));
    //TODO: Used block
    public static final Block QUESTION_BLOCK = new QuestionBlock(FabricBlockSettings.of(Material.METAL, MapColor.YELLOW).requiresTool().strength(3.0F, 1.0F).luminance(3));
    public static final Block EMPTY_BLOCK = new EmptyBlock(FabricBlockSettings.of(Material.METAL, MapColor.SPRUCE_BROWN).requiresTool().strength(3.0F, 1.0F));
    public static final Block TOADSTONE = new Block(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_ORANGE).requiresTool().strength(1.2F, 1.0F));
    public static final Block TOADSTONE_BRICKS = new Block(FabricBlockSettings.copyOf(TOADSTONE));
    public static final Block GOLDEN_BRICKS = new Block(FabricBlockSettings.copyOf(TOADSTONE_BRICKS).sounds(BlockSoundGroup.METAL).mapColor(MapColor.GOLD));
    public static final Block CRYSTAL_BRICKS = new Block(FabricBlockSettings.copyOf(TOADSTONE_BRICKS).sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PURPLE));
    public static final Block GLOOMSTONE = new Block(FabricBlockSettings.of(Material.STONE, MapColor.DARK_AQUA).requiresTool().strength(1.2F, 1.0F).sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block GLOOMSTONE_BRICKS = new Block(FabricBlockSettings.copyOf(GLOOMSTONE).sounds(BlockSoundGroup.DEEPSLATE_BRICKS));
    public static final Block TOADSTONE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(TOADSTONE));
    public static final Block TOADSTONE_STAIRS = new ModStairsBlock(TOADSTONE.getDefaultState(), FabricBlockSettings.copyOf(TOADSTONE));
    public static final Block AMANITA_LOG = new WoodBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block AMANITA_WOOD = new WoodBlock(FabricBlockSettings.copyOf(AMANITA_LOG));
    public static final Block STRIPPED_AMANITA_LOG = new PillarBlock(FabricBlockSettings.copyOf(AMANITA_LOG));
    public static final Block STRIPPED_AMANITA_WOOD = new PillarBlock(FabricBlockSettings.copyOf(AMANITA_LOG).mapColor(MapColor.TERRACOTTA_YELLOW));
    public static final Block AMANITA_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD, MapColor.TERRACOTTA_YELLOW).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD));
    public static final Block AMANITA_SLAB = new SlabBlock(FabricBlockSettings.copyOf(AMANITA_PLANKS));
    public static final Block AMANITA_STAIRS = new ModStairsBlock(AMANITA_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(AMANITA_PLANKS));
    public static final Block AMANITA_SIGN = new ModSign(FabricBlockSettings.copyOf(AMANITA_PLANKS).strength(1.0F).noCollision(), ModSignType.AMANITA);
    public static final Block AMANITA_WALL_SIGN = new ModWallSign(FabricBlockSettings.copyOf(AMANITA_PLANKS).strength(1.0F).noCollision(), ModSignType.AMANITA);
    public static final Block AMANITA_LEAVES = new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS).nonOpaque().allowsSpawning(BlockTypes::canSpawnOnLeaves).suffocates(BlockTypes::never).blockVision(BlockTypes::never));
    public static final Block FRUITING_AMANITA_LEAVES = new LeavesBlock(FabricBlockSettings.copyOf(AMANITA_LEAVES));
    public static final Block AMANITA_SAPLING = new ModSaplingBlock(new AmanitaTree(), FabricBlockSettings.of(Material.PLANT, MapColor.YELLOW).noCollision().ticksRandomly().sounds(BlockSoundGroup.GRASS));
    public static final Block MUSHROOM_STEM = new PillarBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0F).sounds(BlockSoundGroup.NETHER_STEM));
    public static final Block BROWN_MUSHROOM_CAP = new MushroomCap(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.DIRT_BROWN).strength(1.0F).sounds(BlockSoundGroup.WART_BLOCK));
    public static final Block RED_MUSHROOM_CAP = new MushroomCap(FabricBlockSettings.copyOf(BROWN_MUSHROOM_CAP).mapColor(MapColor.RED));
    public static final Block YELLOW_MUSHROOM_CAP = new MushroomCap(FabricBlockSettings.copyOf(BROWN_MUSHROOM_CAP).mapColor(MapColor.YELLOW));
    public static final Block GREEN_MUSHROOM_CAP = new MushroomCap(FabricBlockSettings.copyOf(BROWN_MUSHROOM_CAP).mapColor(MapColor.EMERALD_GREEN));
    public static final Block YELLOW_MUSHROOM = new MushroomPlantBlock(FabricBlockSettings.of(Material.PLANT, MapColor.YELLOW).noCollision().ticksRandomly().sounds(BlockSoundGroup.GRASS), () -> FeatureReg.HUGE_YELLOW_MUSHROOM);
    public static final Block GREEN_MUSHROOM = new MushroomPlantBlock(FabricBlockSettings.copyOf(YELLOW_MUSHROOM).mapColor(MapColor.EMERALD_GREEN).luminance(2), () -> FeatureReg.HUGE_GREEN_MUSHROOM);
    public static final Block YELLOW_FLOWERBED = new FlowerbedBlock(FabricBlockSettings.of(Material.PLANT, MapColor.YELLOW).noCollision().sounds(BlockSoundGroup.MOSS_CARPET));
    public static final Block HARDSTONE_BRICKS = new Block(FabricBlockSettings.of(Material.STONE, MapColor.LIGHT_GRAY).requiresTool().strength(4.0F, 10.0F));
    public static final Block CRACKED_HARDSTONE_BRICKS = new Block(FabricBlockSettings.copyOf(HARDSTONE_BRICKS).strength(2.0F, 5.0F));
    public static final Block WARP_FRAME = new PillarBlock(FabricBlockSettings.of(Material.METAL, MapColor.GOLD).requiresTool().strength(3.0F, 200F));
    public static final Block STONE_TORCH = new StoneTorch(FabricBlockSettings.copyOf(VANILLATE).nonOpaque().luminance(createLightLevelFromLitBlockState(15)));
    public static final Block POISON = new ModFluidBlock(Main.STILL_POISON, FabricBlockSettings.of(Material.LAVA, MapColor.PURPLE).noCollision().ticksRandomly().strength(100.0F).luminance(7));

    private static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return type == EntityType.OCELOT || type == EntityType.PARROT;
    }

    private static boolean never(BlockState state, BlockView world, BlockPos pos) {
        return false;
    }

    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return (state) -> (Boolean) state.get(Properties.LIT) ? litLevel : 0;
    }

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstool_grass"), TOADSTOOL_GRASS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstool_soil"), TOADSTOOL_SOIL);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstool_farmland"), TOADSTOOL_FARMLAND);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstool_path"), TOADSTOOL_PATH);
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
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "question_block"), QUESTION_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "empty_block"), EMPTY_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstone"), TOADSTONE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstone_bricks"), TOADSTONE_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "gloomstone"), GLOOMSTONE);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "gloomstone_bricks"), GLOOMSTONE_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "golden_bricks"), GOLDEN_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "crystal_bricks"), CRYSTAL_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstone_slab"), TOADSTONE_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "toadstone_stairs"), TOADSTONE_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "amanita_log"), AMANITA_LOG);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "amanita_wood"), AMANITA_WOOD);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "stripped_amanita_log"), STRIPPED_AMANITA_LOG);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "stripped_amanita_wood"), STRIPPED_AMANITA_WOOD);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "amanita_planks"), AMANITA_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "amanita_slab"), AMANITA_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "amanita_stairs"), AMANITA_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "amanita_sign"), AMANITA_SIGN);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "amanita_wall_sign"), AMANITA_WALL_SIGN);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "amanita_leaves"), AMANITA_LEAVES);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "fruiting_amanita_leaves"), FRUITING_AMANITA_LEAVES);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "amanita_sapling"), AMANITA_SAPLING);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "mushroom_stem"), MUSHROOM_STEM);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "brown_mushroom_cap"), BROWN_MUSHROOM_CAP);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "red_mushroom_cap"), RED_MUSHROOM_CAP);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "yellow_mushroom_cap"), YELLOW_MUSHROOM_CAP);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "green_mushroom_cap"), GREEN_MUSHROOM_CAP);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "yellow_mushroom"), YELLOW_MUSHROOM);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "green_mushroom"), GREEN_MUSHROOM);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "yellow_flowerbed"), YELLOW_FLOWERBED);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "hardstone_bricks"), HARDSTONE_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "cracked_hardstone_bricks"), CRACKED_HARDSTONE_BRICKS);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "warp_frame"), WARP_FRAME);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "stone_torch"), STONE_TORCH);
        Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, "poison"), POISON);
        BlockEntities.registerBlockEntities();
    }
}
