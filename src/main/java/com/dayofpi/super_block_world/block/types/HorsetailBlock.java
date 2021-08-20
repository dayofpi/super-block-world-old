package com.dayofpi.super_block_world.block.types;

import com.dayofpi.super_block_world.block.registry.BlockList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class HorsetailBlock extends PlantBlock {
    public static final IntProperty PART;

    static {
        PART = IntProperty.of("part", 0, 2);
    }

    public HorsetailBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(PART, 0));
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        World world = ctx.getWorld();
        return blockPos.getY() < world.getTopY() - 1 && world.getBlockState(blockPos.up()).canReplace(ctx) && world.getBlockState(blockPos.up(2)).canReplace(ctx) ? super.getPlacementState(ctx) : null;
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState floor = world.getBlockState(blockPos);
        if (state.get(PART) == 0) {
            return floor.isIn(BlockTags.DIRT) || floor.isOf(BlockList.TOADSTOOL_FARMLAND);
        } else if (state.get(PART) == 1) {
            return floor.isOf(BlockList.HORSETAIL) && floor.get(PART) == 0;
        } else return floor.isOf(BlockList.HORSETAIL) && floor.get(PART) == 1;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BlockState breakState = Blocks.AIR.getDefaultState();
        if (direction == Direction.DOWN && !state.canPlaceAt(world, pos) || state.get(PART) < 2 && !world.getBlockState(pos.up()).isOf(BlockList.HORSETAIL)) {
            return breakState;
        } else return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (state.get(PART) == 0){
            BlockPos blockPos = pos.up();
            BlockPos blockPos2 = pos.up(2);
            world.setBlockState(blockPos, BlockList.HORSETAIL.getDefaultState().with(PART, 1));
            world.setBlockState(blockPos2, BlockList.HORSETAIL.getDefaultState().with(PART, 2));
        }
    }

    public static void placeAt(WorldAccess world, BlockState state, BlockPos pos, int flags) {
        BlockPos blockPos = pos.up();
        BlockPos blockPos2 = pos.up(2);
        world.setBlockState(pos, state.with(PART, 0), flags);
        world.setBlockState(blockPos, state.with(PART, 1), flags);
        world.setBlockState(blockPos2, state.with(PART, 2), flags);
    }

        protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(PART);
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }
}
