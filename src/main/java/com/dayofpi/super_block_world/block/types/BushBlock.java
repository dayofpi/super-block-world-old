package com.dayofpi.super_block_world.block.types;

import com.dayofpi.super_block_world.item.registry.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@SuppressWarnings("deprecation")
public class BushBlock extends PlantBlock {
    public static final IntProperty FRUITS;

    static {
        FRUITS = IntProperty.of("fruits", 0, 2);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FRUITS);
    }

    protected BushBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(FRUITS, 0));
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(FRUITS) > 0) {
            world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 0.6F, 1.1F);
            world.setBlockState(pos, state.cycle(FRUITS), 2);
            Block.dropStack(world, pos, new ItemStack(ItemList.YOSHI_FRUIT, state.get(FRUITS)));
            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.PASS;
        }
    }
}
