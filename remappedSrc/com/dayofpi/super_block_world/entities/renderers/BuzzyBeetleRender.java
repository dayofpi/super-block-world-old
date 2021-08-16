package com.dayofpi.super_block_world.entities.renderers;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.entities.ModelLayers;
import com.dayofpi.super_block_world.entities.models.BuzzyBeetleModel;
import com.dayofpi.super_block_world.entities.types.BuzzyBeetleEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.SaddleFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;

public class BuzzyBeetleRender<T extends BuzzyBeetleEntity> extends MobEntityRenderer<T, BuzzyBeetleModel<T>> {
    private static final Identifier TEXTURE = new Identifier(Main.MOD_ID, "textures/entity/buzzy_beetle/buzzy_beetle.png");

    public BuzzyBeetleRender(EntityRendererFactory.Context context) {
        super(context, new BuzzyBeetleModel<>(context.getPart(ModelLayers.BUZZY_BEETLE)), 0.5F);
        this.addFeature(new SaddleFeatureRenderer<>(this, new BuzzyBeetleModel<>(context.getPart(ModelLayers.BUZZY_BEETLE_SADDLE)), new Identifier(Main.MOD_ID, "textures/entity/buzzy_beetle/buzzy_beetle_saddle.png")));
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
        super.setupTransforms(entity, matrices, animationProgress, bodyYaw, tickDelta);
    }

    @Override
    public Identifier getTexture(T entity) {
        return TEXTURE;
    }
}
