package com.dayofpi.super_block_world.core;

import com.dayofpi.super_block_world.client.BlockClient;
import com.dayofpi.super_block_world.client.EntityClient;
import com.dayofpi.super_block_world.client.FluidClient;
import com.dayofpi.super_block_world.client.SpawnPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.UUID;

@Environment(EnvType.CLIENT)
@SuppressWarnings("deprecation")
public class Client implements ClientModInitializer {
    public static final Identifier PacketID = new Identifier(Main.MOD_ID, "spawn_packet");

    @Override
    public void onInitializeClient() {
        receiveEntityPacket();
        BlockClient.setRenderLayers();
        EntityClient.registerEntityRenderers();
        FluidClient.renderFluids();
    }

    public void receiveEntityPacket() {
        ClientSidePacketRegistry.INSTANCE.register(PacketID, (ctx, byteBuf) -> {
            EntityType<?> et = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
            UUID uuid = byteBuf.readUuid();
            int entityId = byteBuf.readVarInt();
            Vec3d pos = SpawnPacket.PacketBufUtil.readVec3d(byteBuf);
            float pitch = SpawnPacket.PacketBufUtil.readAngle(byteBuf);
            float yaw = SpawnPacket.PacketBufUtil.readAngle(byteBuf);
            ctx.getTaskQueue().execute(() -> {
                if (MinecraftClient.getInstance().world == null)
                    throw new IllegalStateException("Tried to spawn entity in a null world!");
                Entity e = et.create(MinecraftClient.getInstance().world);
                if (e == null)
                    throw new IllegalStateException("Failed to create instance of entity \"" + Registry.ENTITY_TYPE.getId(et) + "\"!");
                e.updateTrackedPosition(pos);
                e.setPos(pos.x, pos.y, pos.z);
                e.getPitch(pitch);
                e.getYaw(yaw);
                e.setId(entityId);
                e.setUuid(uuid);
                MinecraftClient.getInstance().world.addEntity(entityId, e);
            });
        });
    }
}
