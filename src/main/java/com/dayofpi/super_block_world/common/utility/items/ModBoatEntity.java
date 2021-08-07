package com.dayofpi.super_block_world.common.utility.items;

import com.dayofpi.super_block_world.Client;
import com.dayofpi.super_block_world.client.SpawnPacket;
import com.dayofpi.super_block_world.registry.ModBlockItems;
import com.dayofpi.super_block_world.registry.ModBlocks;
import com.dayofpi.super_block_world.registry.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.world.World;

public class ModBoatEntity extends BoatEntity {
    private static final TrackedData<Integer> BOAT_TYPE;

    public ModBoatEntity(EntityType<? extends ModBoatEntity> entityType, World world) {
        super(entityType, world);
    }

    public ModBoatEntity(World world, double x, double y, double z) {
        this(ModEntities.MOD_BOAT, world);
        this.setPosition(x, y, z);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
    }

    @Override
    public Item asItem() {
        return ModBlockItems.AMANITA_BOAT;
    }

    public ModBoatEntity.Type getModBoatType() {
        return ModBoatEntity.Type.getType(this.dataTracker.get(BOAT_TYPE));
    }

    public void setBoatType(ModBoatEntity.Type type) {
        this.dataTracker.set(BOAT_TYPE, type.ordinal());
    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putString("Type", this.getModBoatType().getName());
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        if (nbt.contains("Type", 8)) {
            this.setBoatType(ModBoatEntity.Type.getType(nbt.getString("Type")));
        }
    }

    static {
        BOAT_TYPE = DataTracker.registerData(ModBoatEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }

    public enum Type {
        AMANITA(ModBlocks.AMANITA_PLANKS, "amanita");

        private final String name;
        private final Block baseBlock;

        Type(Block baseBlock, String name) {
            this.name = name;
            this.baseBlock = baseBlock;
        }

        public String getName() {
            return this.name;
        }

        public Block getBaseBlock() {
            return this.baseBlock;
        }

        public String toString() {
            return this.name;
        }

        public static ModBoatEntity.Type getType(int type) {
            ModBoatEntity.Type[] types = values();
            if (type < 0 || type >= types.length) {
                type = 0;
            }

            return types[type];
        }

        public static ModBoatEntity.Type getType(String name) {
            ModBoatEntity.Type[] types = values();

            for (Type type : types) {
                if (type.getName().equals(name)) {
                    return type;
                }
            }

            return types[0];
        }
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return SpawnPacket.create(this, Client.PacketID);
    }
}
