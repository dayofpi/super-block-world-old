package com.dayofpi.super_block_world.entity.renderer;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.entity.registry.ModelLayers;
import com.dayofpi.super_block_world.entity.model.BuzzyModel;
import com.dayofpi.super_block_world.entity.types.mobs.BuzzyEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;

public class BuzzyRenderer<T extends BuzzyEntity> extends MobEntityRenderer<T, BuzzyModel<T>> {
    private static final Identifier DEFAULT = new Identifier(Main.MOD_ID, "textures/entity/buzzy_beetle/buzzy.png");
    private static final Identifier HIDING = new Identifier(Main.MOD_ID, "textures/entity/buzzy_beetle/buzzy_shell.png");

    public BuzzyRenderer(EntityRendererFactory.Context context) {
        super(context, new BuzzyModel<>(context.getPart(ModelLayers.BUZZY_BEETLE)), 0.5F);
        this.addFeature(new SaddleFeatureRenderer<>(this, new BuzzyModel<>(context.getPart(ModelLayers.BUZZY_BEETLE_SADDLE)), new Identifier(Main.MOD_ID, "textures/entity/buzzy_beetle/buzzy_saddle.png")));
        this.addFeature(new BuzzyEyes<>(this));
        this.model.getSpike().forEach((spikeParts) -> spikeParts.visible = false);
    }

    @Override
    protected void setupTransforms(T entity, MatrixStack matrices, float animationProgress, float bodyYaw, float tickDelta) {
        if (entity.isBaby()) {
            matrices.scale(0.5F, 0.5F, 0.5F);
        }
        if (entity.isUpsideDown()) {
            matrices.translate(0.0D, entity.getHeight() + 0.1F, 0.0D);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180.0F));
        }
        if (entity.isHiding()) {
            matrices.translate(0.0D, -0.2, 0.0D);
        }
        super.setupTransforms(entity, matrices, animationProgress, bodyYaw, tickDelta);
    }

    @Override
    public Identifier getTexture(T entity) {
        return entity.isHiding() ? HIDING : DEFAULT;
    }
}
