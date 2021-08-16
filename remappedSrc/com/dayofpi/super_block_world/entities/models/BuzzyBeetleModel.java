package com.dayofpi.super_block_world.entities.models;

import com.dayofpi.super_block_world.entities.types.BuzzyBeetleEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.util.math.MathHelper;

public class BuzzyBeetleModel<T extends BuzzyBeetleEntity> extends SinglePartEntityModel<T> {
    private final ModelPart BODY;
    private final ModelPart SHELL;
    private final ModelPart LEFT_FRONT_LEG;
    private final ModelPart RIGHT_FRONT_LEG;
    private final ModelPart LEFT_HIND_LEG;
    private final ModelPart RIGHT_HIND_LEG;

    public BuzzyBeetleModel(ModelPart root) {
        this.BODY = root.getChild("body");
        this.SHELL = BODY.getChild("shell");
        this.LEFT_FRONT_LEG = BODY.getChild("left_front_leg");
        this.RIGHT_FRONT_LEG = BODY.getChild("right_front_leg");
        this.LEFT_HIND_LEG = BODY.getChild("left_hind_leg");
        this.RIGHT_HIND_LEG = BODY.getChild("right_hind_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(44, 27).cuboid(-5.0F, -10.0F, -7.0F, 10.0F, 6.0F, 14.0F), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        body.addChild("shell", ModelPartBuilder.create().uv(0, 0).cuboid(-9.0F, -9.8333F, -9.0F, 18.0F, 9.0F, 18.0F).uv(0, 27).cuboid(-9.0F, -0.8333F, -9.0F, 4.0F, 7.0F, 18.0F).mirrored().uv(0, 27).cuboid(5.0F, -0.8333F, -9.0F, 4.0F, 7.0F, 18.0F), ModelTransform.pivot(0.0F, -9.1667F, 0.0F));
        body.addChild("left_front_leg", ModelPartBuilder.create().uv(54, 0).cuboid(-2.5F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F), ModelTransform.pivot(5.5F, -5.0F, -2.5F));
        body.addChild("right_front_leg", ModelPartBuilder.create().uv(54, 0).cuboid(-2.5F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F), ModelTransform.pivot(-5.5F, -5.0F, -2.5F));
        body.addChild("left_hind_leg", ModelPartBuilder.create().uv(54, 0).cuboid(-2.5F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F), ModelTransform.pivot(5.5F, -5.0F, 5.5F));
        body.addChild("right_hind_leg", ModelPartBuilder.create().uv(54, 0).cuboid(-2.5F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F), ModelTransform.pivot(-5.5F, -5.0F, 5.5F));

        return TexturedModelData.of(modelData, 128, 64);
    }

    @Override
    public ModelPart getPart() {
        return this.BODY;
    }

    @Override
    public void setAngles(BuzzyBeetleEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.SHELL.roll = 0.1F * MathHelper.sin(limbAngle * 1.5F) * limbDistance;
        this.LEFT_FRONT_LEG.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
        this.RIGHT_FRONT_LEG.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
        this.LEFT_HIND_LEG.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
        this.RIGHT_HIND_LEG.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
    }
}
