package com.dayofpi.mixin;

import com.dayofpi.super_block_world.utility.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.PotatoesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PotatoesBlock.class)
public class PotatoesBlockMixin extends CropBlock {
    public PotatoesBlockMixin(Settings settings) {
        super(settings);
    }
    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        BlockPos blockPos = pos.down();
        for (Direction direction : Direction.Type.HORIZONTAL) {
            FluidState fluidState = world.getFluidState(blockPos.offset(direction));
            if (fluidState.isIn(ModTags.POISON)) {
                world.breakBlock(pos, false);
                Block.dropStack(world, pos, new ItemStack(Items.POISONOUS_POTATO));
            }
        }
    }
}
