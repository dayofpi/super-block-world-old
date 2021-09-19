package com.dayofpi.mixin;

import com.dayofpi.mixin.interfaces.InterfaceClientPlayer;
import com.dayofpi.super_block_world.entity.types.ModBoatEntity;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.input.Input;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class MixinClientPlayer extends AbstractClientPlayerEntity {
    boolean riding = ((InterfaceClientPlayer) this).riding();
    Input input = ((InterfaceClientPlayer) this).input();

    public MixinClientPlayer(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    @Inject(at = @At("HEAD"), method = "tickRiding")
    public void tickRiding(CallbackInfo info) {
        if (this.getVehicle() instanceof ModBoatEntity boatEntity) {
            boatEntity.setInputs(this.input.pressingLeft, this.input.pressingRight, this.input.pressingForward, this.input.pressingBack);
            this.riding |= this.input.pressingLeft || this.input.pressingRight || this.input.pressingForward || this.input.pressingBack;
        }
    }
}
