package com.dayofpi.super_block_world.entity.renderer;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.entity.model.AbstractBuzzyModel;
import com.dayofpi.super_block_world.entity.types.BuzzyShellEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BuzzyShellRenderer extends EntityRenderer<BuzzyShellEntity> {
    private static final Identifier TEXTURE = new Identifier(Main.MOD_ID, "textures/entity/buzzy_beetle/shell.png");
    protected final EntityModel model;

    public BuzzyShellRenderer(EntityRendererFactory.Context context, EntityModelLayer layer) {
        super(context);
        this.model = new AbstractBuzzyModel<>(context.getPart(layer));
        ((AbstractBuzzyModel<?>) this.model).getSpike().forEach((spikeParts) -> spikeParts.visible = false);
        ((AbstractBuzzyModel<?>) this.model).getLegs().forEach((legParts) -> legParts.visible = false);
    }

    @Override
    public Identifier getTexture(BuzzyShellEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(BuzzyShellEntity entity, float f, float g, MatrixStack matrices, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrices.push();
        matrices.scale(-1.0F, -1.0F, 1.0F);
        matrices.translate(0.0D, -1.3F, 0.0D);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(this.getTexture(entity)));
        this.model.render(matrices, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
        super.render(entity, f, g, matrices, vertexConsumerProvider, i);
    }
}
