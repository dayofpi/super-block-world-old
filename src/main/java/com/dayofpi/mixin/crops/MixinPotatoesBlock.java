package com.dayofpi.mixin.crops;

import com.dayofpi.super_block_world.misc.TagList;
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

@SuppressWarnings("deprecation")
@Mixin(PotatoesBlock.class)
public class MixinPotatoesBlock extends CropBlock {
    public MixinPotatoesBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        BlockPos blockPos = pos.down();
        if (state.get(AGE) == 7) { // Checks if the crop is fully grown
            for (Direction direction : Direction.Type.HORIZONTAL) {
                FluidState fluidState = world.getFluidState(blockPos.offset(direction));
                if (fluidState.isIn(TagList.POISON)) {
                    // If there is poison next to it, always drop a poisonous potato
                    world.breakBlock(pos, false);
                    Block.dropStack(world, pos, new ItemStack(Items.POISONOUS_POTATO, 2));
                }
            }
        }
    }
}
