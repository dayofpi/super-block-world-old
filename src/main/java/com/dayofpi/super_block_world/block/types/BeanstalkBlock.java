package com.dayofpi.super_block_world.block.types;

import com.dayofpi.super_block_world.block.registry.BlockList;
import net.minecraft.block.*;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

import java.util.Random;

public class BeanstalkBlock extends AbstractPlantStemBlock {
    public static final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 15.0D, 12.0D);

    public BeanstalkBlock(AbstractBlock.Settings settings) {
        super(settings, Direction.UP, SHAPE, false, 0.1D);
    }

    protected int getGrowthLength(Random random) {
        return VineLogic.getGrowthLength(random);
    }

    protected Block getPlant() {
        return BlockList.BEANSTALK_PLANT;
    }

    protected boolean chooseStemState(BlockState state) {
        return VineLogic.isValidForWeepingStem(state);
    }
}