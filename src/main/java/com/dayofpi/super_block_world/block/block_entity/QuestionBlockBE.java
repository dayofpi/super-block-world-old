package com.dayofpi.super_block_world.block.block_entity;

import com.dayofpi.super_block_world.block.registry.BlockEntityList;
import com.dayofpi.super_block_world.misc.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class QuestionBlockBE extends BlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public QuestionBlockBE(BlockPos pos, BlockState state) {
        super(BlockEntityList.QUESTION_BLOCK, pos, state);
    }

    // Serialize the BlockEntity
    @Override
    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        Inventories.writeNbt(tag, items);
    }

    // Deserialize the BlockEntity
    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        Inventories.readNbt(tag, items);}


    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }
}
