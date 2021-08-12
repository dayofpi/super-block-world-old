package com.dayofpi.super_block_world.blocks.types;

import com.dayofpi.super_block_world.blocks.BlockTypes;
import com.dayofpi.super_block_world.blocks.blockentity.QuestionBlockBE;
import com.dayofpi.super_block_world.misc.Sounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.util.ParticleUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;
@SuppressWarnings("deprecation")
public class QuestionBlock extends Block implements BlockEntityProvider {
    public QuestionBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new QuestionBlockBE(pos, state);
    }

    @Override
    public void onDestroyedByExplosion(World world, BlockPos blockPos, Explosion explosion) {
        this.releaseItem(world.getBlockState(blockPos), world, blockPos);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos blockPos, Block block, BlockPos fromPos, boolean notify) {
        if (world.isReceivingRedstonePower(blockPos)) {
            this.releaseItem(world.getBlockState(blockPos), world, blockPos);
        }
    }

    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos blockPos, PlayerEntity player) {
        this.releaseItem(state, world, blockPos);
    }

    public void releaseItem(BlockState state, World world, BlockPos blockPos) {
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
                world.setBlockState(blockPos, BlockTypes.EMPTY_BLOCK.getDefaultState(), 2);
                world.playSound(null, blockPos, Sounds.ITEM_OUT, SoundCategory.NEUTRAL, 2.0F, 1.0F);
                ParticleUtil.spawnParticle(world, blockPos, ParticleTypes.WAX_OFF, UniformIntProvider.create(2, 3));
            }
        }
    }
}
