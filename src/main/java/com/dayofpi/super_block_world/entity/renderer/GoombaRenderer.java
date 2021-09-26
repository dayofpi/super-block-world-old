package com.dayofpi.super_block_world.entity.renderer;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.entity.model.GoombaModel;
import com.dayofpi.super_block_world.entity.registry.ModelLayers;
import com.dayofpi.super_block_world.entity.types.mobs.GoombaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GoombaRenderer<T extends GoombaEntity> extends MobEntityRenderer<T, GoombaModel<T>> {
    private static final Identifier TEXTURE = new Identifier(Main.MOD_ID, "textures/entity/goomba/goomba.png");

    public GoombaRenderer(EntityRendererFactory.Context context) {
        super(context, new GoombaModel<>(context.getPart(ModelLayers.GOOMBA)), 0.4F);
    }

    @Override
    protected void setupTransforms(T entity, MatrixStack matrices, float animationProgress, float bodyYaw, float tickDelta) {
        if (entity.getSize() == 0) {
            matrices.scale(0.5F, 0.5F, 0.5F);
        } else if (entity.getSize() == 2) {
            matrices.scale(2.5F, 2.5F, 2.5F);
        }
        super.setupTransforms(entity, matrices, animationProgress, bodyYaw, tickDelta);
    }

    @Override
    public Identifier getTexture(T entity) {
        return TEXTURE;
    }
}
