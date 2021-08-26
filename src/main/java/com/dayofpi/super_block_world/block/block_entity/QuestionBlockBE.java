package com.dayofpi.super_block_world.block.block_entity;

import com.dayofpi.super_block_world.block.registry.BlockEntityList;
import com.dayofpi.super_block_world.item.registry.ItemList;
import com.dayofpi.super_block_world.misc.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuestionBlockBE extends BlockEntity implements ImplementedInventory {
    List<Item> defaultItems = Arrays.asList(
            ItemList.SUPER_MUSHROOM,
            ItemList.SUPER_MUSHROOM,
            ItemList.SUPER_MUSHROOM,
            Items.WOODEN_AXE,
            Items.WOODEN_AXE);
    List<Item> rareItems = Arrays.asList(
            ItemList.ONE_UP,
            ItemList.ONE_UP,
            ItemList.GOLDEN_MUSHROOM,
            ItemList.GOLDEN_MUSHROOM,
            ItemList.POISON_MUSHROOM);
    Random random = new Random();
    int index = random.nextInt(5);
    Item prizes = random.nextInt(15) == 0 ? rareItems.get(index) : defaultItems.get(index);
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, new ItemStack(prizes));

    public QuestionBlockBE(BlockPos pos, BlockState state) {
        super(BlockEntityList.QUESTION_BLOCK, pos, state);
    }

    // Serialize the BlockEntity
    @Override
    public NbtCompound writeNbt(NbtCompound tag) {
        Inventories.writeNbt(tag, items);
        return super.writeNbt(tag);
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
