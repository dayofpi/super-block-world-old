package com.dayofpi.super_block_world.world.feature.types;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomMineshaftFeature extends StructureFeature<CustomMineshaftFeatureConfig> {
    public CustomMineshaftFeature(Codec<CustomMineshaftFeatureConfig> codec) {
        super(codec);
    }

    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long l, ChunkRandom chunkRandom, ChunkPos chunkPos, Biome biome, ChunkPos chunkPos2, CustomMineshaftFeatureConfig mineshaftFeatureConfig, HeightLimitView heightLimitView) {
        chunkRandom.setCarverSeed(l, chunkPos.x, chunkPos.z);
        double d = mineshaftFeatureConfig.probability;
        return chunkRandom.nextDouble() < d;
    }

    public StructureFeature.StructureStartFactory<CustomMineshaftFeatureConfig> getStructureStartFactory() {
        return CustomMineshaftFeature.Start::new;
    }

    public static class Start extends StructureStart<CustomMineshaftFeatureConfig> {
        public Start(StructureFeature<CustomMineshaftFeatureConfig> structureFeature, ChunkPos chunkPos, int i, long l) {
            super(structureFeature, chunkPos, i, l);
        }

        public void init(DynamicRegistryManager dynamicRegistryManager, ChunkGenerator chunkGenerator, StructureManager structureManager, ChunkPos chunkPos, Biome biome, CustomMineshaftFeatureConfig mineshaftFeatureConfig, HeightLimitView heightLimitView) {
            CustomMineshaftGenerator.MineshaftRoom mineshaftRoom = new CustomMineshaftGenerator.MineshaftRoom(0, this.random, chunkPos.getOffsetX(2), chunkPos.getOffsetZ(2), mineshaftFeatureConfig.type);
            this.addPiece(mineshaftRoom);
            mineshaftRoom.fillOpenings(mineshaftRoom, this, this.random);
            if (mineshaftFeatureConfig.type == Type.NORMAL) {
                BlockBox blockBox = this.setBoundingBoxFromChildren();
                int j = chunkGenerator.getSeaLevel() - blockBox.getMaxY() + blockBox.getBlockCountY() / 2 + 5;
                this.translateUpward(j);
            } else {
                this.randomUpwardTranslation(chunkGenerator.getSeaLevel(), chunkGenerator.getMinimumY(), this.random, 10);
            }

        }
    }

    public enum Type implements StringIdentifiable {
        NORMAL("normal", BlockList.STRIPPED_AMANITA_LOG, BlockList.AMANITA_PLANKS, Blocks.OAK_FENCE),
        MESA("mesa", Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_FENCE);

        public static final Codec<CustomMineshaftFeature.Type> CODEC = StringIdentifiable.createCodec(CustomMineshaftFeature.Type::values, CustomMineshaftFeature.Type::byName);
        private static final Map<String, CustomMineshaftFeature.Type> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(CustomMineshaftFeature.Type::getName, (type) -> type));
        private final String name;
        private final BlockState log;
        private final BlockState planks;
        private final BlockState fence;

        Type(String name, Block log, Block planks, Block fence) {
            this.name = name;
            this.log = log.getDefaultState();
            this.planks = planks.getDefaultState();
            this.fence = fence.getDefaultState();
        }

        public String getName() {
            return this.name;
        }

        private static CustomMineshaftFeature.Type byName(String name) {
            return BY_NAME.get(name);
        }

        public static CustomMineshaftFeature.Type byIndex(int index) {
            return index >= 0 && index < values().length ? values()[index] : NORMAL;
        }

        public BlockState getLog() {
            return this.log;
        }

        public BlockState getPlanks() {
            return this.planks;
        }

        public BlockState getFence() {
            return this.fence;
        }

        public String asString() {
            return this.name;
        }
    }
}