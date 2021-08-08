package com.dayofpi.super_block_world.core.mixin.entity;

import com.dayofpi.super_block_world.core.Main;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.RabbitEntityRenderer;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Environment(EnvType.CLIENT)
@Mixin(RabbitEntityRenderer.class)
public class RabbitEntityRendererMixin {
    private static final Identifier MIPS_TEXTURE = new Identifier(Main.MOD_ID, "textures/entity/mips.png");

    @Inject(at = @At("HEAD"), method = "getTexture(Lnet/minecraft/entity/passive/RabbitEntity;)Z", cancellable = true)
    private void getTexture(RabbitEntity rabbitEntity, CallbackInfoReturnable<Identifier> info) {
        String string = Formatting.strip(rabbitEntity.getName().getString());
        if ("MIPS".equals(string)) {
            info.setReturnValue(MIPS_TEXTURE);
            info.cancel();
        }
    }

}
