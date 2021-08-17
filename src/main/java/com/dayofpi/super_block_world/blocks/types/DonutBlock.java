package com.dayofpi.super_block_world.blocks.types;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

@SuppressWarnings("deprecation")
public class DonutBlock extends FallingBlock {
    public static final BooleanProperty TRIGGERED;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 6.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    static {
        TRIGGERED = BooleanProperty.of("triggered");
    }

    public DonutBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(TRIGGERED, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TRIGGERED);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return state;
    }

    @Override
    public void onLanding(World world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
        world.breakBlock(pos, true);
    }

    @Override
    public void onSteppedOn(World world, BlockPos blockPos, BlockState state, Entity entity) {
        if (!world.getBlockState(blockPos).get(TRIGGERED)) {
            world.setBlockState(blockPos, state.cycle(TRIGGERED));
            world.getBlockTickScheduler().schedule(blockPos, this, this.getFallDelay());
            if (world.isClient) {
                double d = blockPos.getX();
                double f = blockPos.getZ();
                world.playSound(d, blockPos.getY(), f, SoundEvents.BLOCK_DRIPSTONE_BLOCK_FALL, SoundCategory.BLOCKS, 2.0F, 0.8F, true);
                for(int i = 0; i < 20; ++i) {
                    world.addParticle(ParticleTypes.POOF, d, blockPos.getY() + 0.5, f, 0.0F, 0.0F, 0.0F);
                }
            }
        }
        super.onSteppedOn(world, blockPos, state, entity);
    }

    @Override
    protected int getFallDelay() {
        return 13;
    }

    @Override
    public int getColor(BlockState state, BlockView world, BlockPos pos) {
        return 13734458;
    }
}
