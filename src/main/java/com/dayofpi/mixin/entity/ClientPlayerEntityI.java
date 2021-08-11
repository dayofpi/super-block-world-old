package com.dayofpi.mixin.entity;

import net.minecraft.client.input.Input;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientPlayerEntity.class)
public interface ClientPlayerEntityI {
    @Accessor("input")
    Input input();

    @Accessor("riding")
    boolean riding();

}
