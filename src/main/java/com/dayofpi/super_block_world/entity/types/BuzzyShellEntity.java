package com.dayofpi.super_block_world.entity.types;

import com.dayofpi.super_block_world.Client;
import com.dayofpi.super_block_world.item.registry.ItemList;
import com.dayofpi.super_block_world.misc.SpawnPacket;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

public class BuzzyShellEntity extends AbstractShellEntity {
    public BuzzyShellEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    public Item asItem() {
        return ItemList.BUZZY_SHELL;
    }

    @Override
    protected void initDataTracker() {
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    public Packet<?> createSpawnPacket() {
        return SpawnPacket.create(this, Client.PacketID);
    }
}
