package com.dayofpi.super_block_world.blocks.blockentity;

import com.dayofpi.super_block_world.blocks.BlockEntities;
import com.dayofpi.super_block_world.items.ItemTypes;
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
    List<Item> defaultItems = Arrays.asList(ItemTypes.BRONZE_INGOT, Items.GOLD_NUGGET, Items.DIAMOND, Items.DIRT, Items.AZALEA, Items.ELYTRA, Items.CHICKEN_SPAWN_EGG);
    Random random = new Random();
    int index = random.nextInt(7);
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, new ItemStack(defaultItems.get(index)));

    public QuestionBlockBE(BlockPos pos, BlockState state) {
        super(BlockEntities.QUESTION_BLOCK, pos, state);
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
