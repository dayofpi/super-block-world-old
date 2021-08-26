package com.dayofpi.super_block_world.block.types;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.block.block_entity.QuestionBlockBE;
import com.dayofpi.super_block_world.misc.SoundList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.inventory.Inventory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class QuestionBlock extends ReactiveBlock implements BlockEntityProvider {
    public QuestionBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new QuestionBlockBE(pos, state);
    }

    @Override
    public void activate(BlockState state, World world, BlockPos blockPos) {
        Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);
        BlockPos pos = blockPos.up();
        if (state.isSolidBlock(world, blockPos.up())) {
            if (!state.isSolidBlock(world, blockPos.down())) {
                pos = blockPos.down();
            }
        }
        if (blockEntity != null) {
            if (!blockEntity.getStack(0).isEmpty()) {
                Block.dropStack(world, pos, blockEntity.getStack(0));
                blockEntity.removeStack(0);
                world.setBlockState(blockPos, pushEntitiesUpBeforeBlockChange(state, BlockList.EMPTY_BLOCK.getDefaultState(), world, blockPos));
                world.playSound(null, blockPos, SoundList.ITEM_OUT, SoundCategory.NEUTRAL, 2.0F, 1.0F);
                ParticleUtil.spawnParticle(world, blockPos, ParticleTypes.WAX_OFF, UniformIntProvider.create(2, 3));
            }
        }
    }
}
