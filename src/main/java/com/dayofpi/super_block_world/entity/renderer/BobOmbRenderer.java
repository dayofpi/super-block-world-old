package com.dayofpi.super_block_world.entity.renderer;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.entity.model.BobOmbModel;
import com.dayofpi.super_block_world.entity.registry.ModelLayers;
import com.dayofpi.super_block_world.entity.types.mobs.BobOmbEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class BobOmbRenderer<T extends BobOmbEntity> extends MobEntityRenderer<T, BobOmbModel<T>> {
    private static final Identifier TEXTURE = new Identifier(Main.MOD_ID, "textures/entity/bob_omb.png");

    public BobOmbRenderer(EntityRendererFactory.Context context) {
        super(context, new BobOmbModel<>(context.getPart(ModelLayers.BOB_OMB)), 0.4F);
    }

    protected void scale(BobOmbEntity bobOmbEntity, MatrixStack matrixStack, float f) {
        float g = bobOmbEntity.getClientFuseTime(f);
        float h = 1.0F + MathHelper.sin(g * 100.0F) * g * 0.01F;
        g = MathHelper.clamp(g, 0.0F, 1.0F);
        g *= g;
        g *= g;
        float i = (1.0F + g * 0.4F) * h;
        float j = (1.0F + g * 0.1F) / h;
        matrixStack.scale(i, j, i);
    }

    protected float getAnimationCounter(BobOmbEntity bobOmbEntity, float f) {
        float g = bobOmbEntity.getClientFuseTime(f);
        return (int)(g * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(g, 0.5F, 1.0F);
    }

    public Identifier getTexture(BobOmbEntity bobOmbEntity) {
        return TEXTURE;
    }
}
