package com.dayofpi.super_block_world.entity.renderer;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.entity.model.BooModel;
import com.dayofpi.super_block_world.entity.types.mobs.BooEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BooColor extends FeatureRenderer<BooEntity, BooModel<BooEntity>> {
	private static final Identifier SKIN = new Identifier(Main.MOD_ID, "textures/entity/boo/tamed_overlay.png");

	public BooColor(FeatureRendererContext<BooEntity, BooModel<BooEntity>> featureRendererContext) {
		super(featureRendererContext);
	}

	public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, BooEntity booEntity, float f, float g, float h, float j, float k, float l) {
		if (booEntity.isTamed() && !booEntity.isInvisible()) {
			float[] fs = booEntity.getBooColor().getColorComponents();
			VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getEntityTranslucent(SKIN));
			this.getContextModel().render(matrixStack, vertexConsumer, i, LivingEntityRenderer.getOverlay(booEntity, 0.0F), fs[0], fs[1], fs[2], 0.6F);
		}
	}
}
