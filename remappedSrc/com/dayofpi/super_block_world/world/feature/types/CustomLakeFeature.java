package com.dayofpi.super_block_world.world.feature.types;


import com.dayofpi.super_block_world.block.registry.BlockList;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.LightType;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class CustomLakeFeature extends Feature<SingleStateFeatureConfig> {
    private static final BlockState CAVE_AIR;

    static {
        CAVE_AIR = Blocks.CAVE_AIR.getDefaultState();
    }

    public CustomLakeFeature(Codec<SingleStateFeatureConfig> codec) {
        super(codec);
    }

    public boolean generate(FeatureContext<SingleStateFeatureConfig> context) {
        BlockPos $$1 = context.getOrigin();
        StructureWorldAccess $$2 = context.getWorld();
        Random $$3 = context.getRandom();

        SingleStateFeatureConfig $$4;
        for($$4 = (SingleStateFeatureConfig)context.getConfig(); $$1.getY() > $$2.getBottomY() + 5 && $$2.isAir($$1); $$1 = $$1.down()) {
        }

        if ($$1.getY() <= $$2.getBottomY() + 4) {
            return false;
        } else {
            $$1 = $$1.down(4);
            if ($$2.getStructures(ChunkSectionPos.from($$1), StructureFeature.VILLAGE).findAny().isPresent()) {
                return false;
            } else {
                boolean[] $$5 = new boolean[2048];
                int $$6 = $$3.nextInt(4) + 4;

                int $$31;
                for($$31 = 0; $$31 < $$6; ++$$31) {
                    double $$8 = $$3.nextDouble() * 6.0D + 3.0D;
                    double $$9 = $$3.nextDouble() * 4.0D + 2.0D;
                    double $$10 = $$3.nextDouble() * 6.0D + 3.0D;
                    double $$11 = $$3.nextDouble() * (16.0D - $$8 - 2.0D) + 1.0D + $$8 / 2.0D;
                    double $$12 = $$3.nextDouble() * (8.0D - $$9 - 4.0D) + 2.0D + $$9 / 2.0D;
                    double $$13 = $$3.nextDouble() * (16.0D - $$10 - 2.0D) + 1.0D + $$10 / 2.0D;

                    for(int $$14 = 1; $$14 < 15; ++$$14) {
                        for(int $$15 = 1; $$15 < 15; ++$$15) {
                            for(int $$16 = 1; $$16 < 7; ++$$16) {
                                double $$17 = ((double)$$14 - $$11) / ($$8 / 2.0D);
                                double $$18 = ((double)$$16 - $$12) / ($$9 / 2.0D);
                                double $$19 = ((double)$$15 - $$13) / ($$10 / 2.0D);
                                double $$20 = $$17 * $$17 + $$18 * $$18 + $$19 * $$19;
                                if ($$20 < 1.0D) {
                                    $$5[($$14 * 16 + $$15) * 8 + $$16] = true;
                                }
                            }
                        }
                    }
                }

                int $$33;
                int $$32;
                for($$31 = 0; $$31 < 16; ++$$31) {
                    for($$32 = 0; $$32 < 16; ++$$32) {
                        for($$33 = 0; $$33 < 8; ++$$33) {
                            boolean $$24 = !$$5[($$31 * 16 + $$32) * 8 + $$33] && ($$31 < 15 && $$5[(($$31 + 1) * 16 + $$32) * 8 + $$33] || $$31 > 0 && $$5[(($$31 - 1) * 16 + $$32) * 8 + $$33] || $$32 < 15 && $$5[($$31 * 16 + $$32 + 1) * 8 + $$33] || $$32 > 0 && $$5[($$31 * 16 + ($$32 - 1)) * 8 + $$33] || $$33 < 7 && $$5[($$31 * 16 + $$32) * 8 + $$33 + 1] || $$33 > 0 && $$5[($$31 * 16 + $$32) * 8 + ($$33 - 1)]);
                            if ($$24) {
                                Material $$25 = $$2.getBlockState($$1.add($$31, $$33, $$32)).getMaterial();
                                if ($$33 >= 4 && $$25.isLiquid()) {
                                    return false;
                                }

                                if ($$33 < 4 && !$$25.isSolid() && $$2.getBlockState($$1.add($$31, $$33, $$32)) != $$4.state) {
                                    return false;
                                }
                            }
                        }
                    }
                }

                BlockPos $$34;
                for($$31 = 0; $$31 < 16; ++$$31) {
                    for($$32 = 0; $$32 < 16; ++$$32) {
                        for($$33 = 0; $$33 < 8; ++$$33) {
                            if ($$5[($$31 * 16 + $$32) * 8 + $$33]) {
                                $$34 = $$1.add($$31, $$33, $$32);
                                boolean $$30 = $$33 >= 4;
                                $$2.setBlockState($$34, $$30 ? CAVE_AIR : $$4.state, 2);
                                if ($$30) {
                                    $$2.getBlockTickScheduler().schedule($$34, CAVE_AIR.getBlock(), 0);
                                    this.markBlocksAboveForPostProcessing($$2, $$34);
                                }
                            }
                        }
                    }
                }

                for($$31 = 0; $$31 < 16; ++$$31) {
                    for($$32 = 0; $$32 < 16; ++$$32) {
                        for($$33 = 4; $$33 < 8; ++$$33) {
                            if ($$5[($$31 * 16 + $$32) * 8 + $$33]) {
                                $$34 = $$1.add($$31, $$33 - 1, $$32);
                                if (isSoil($$2.getBlockState($$34)) && $$2.getLightLevel(LightType.SKY, $$1.add($$31, $$33, $$32)) > 0) {
                                    Biome $$35 = $$2.getBiome($$34);
                                    if ($$35.getGenerationSettings().getSurfaceConfig().getTopMaterial().isOf(Blocks.MYCELIUM)) {
                                        $$2.setBlockState($$34, Blocks.MYCELIUM.getDefaultState(), 2);
                                    } else {
                                        $$2.setBlockState($$34, BlockList.TOADSTONE.getDefaultState(), 2);
                                    }
                                }
                            }
                        }
                    }
                }

                if ($$4.state.getMaterial() == Material.WATER) {
                    for($$31 = 0; $$31 < 16; ++$$31) {
                        for($$32 = 0; $$32 < 16; ++$$32) {
                            $$34 = $$1.add($$31, 4, $$32);
                            if ($$2.getBiome($$34).canSetIce($$2, $$34, false)) {
                                $$2.setBlockState($$34, Blocks.ICE.getDefaultState(), 2);
                            }
                        }
                    }
                }

                return true;
            }
        }
    }

}
