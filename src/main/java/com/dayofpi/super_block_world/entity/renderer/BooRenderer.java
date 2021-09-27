package com.dayofpi.super_block_world.entity.renderer;

import com.dayofpi.super_block_world.Main;
import com.dayofpi.super_block_world.entity.model.BooModel;
import com.dayofpi.super_block_world.entity.registry.ModelLayers;
import com.dayofpi.super_block_world.entity.types.mobs.BooEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BooRenderer<T extends BooEntity> extends MobEntityRenderer<T, BooModel<T>> {
    private static final Identifier SEEKING = new Identifier(Main.MOD_ID, "textures/entity/boo/seeking.png");
    private static final Identifier HIDING = new Identifier(Main.MOD_ID, "textures/entity/boo/hiding.png");

    public BooRenderer(EntityRendererFactory.Context context) {
        super(context, new BooModel<>(context.getPart(ModelLayers.BOO)), 0.5F);
    }

    public Identifier getTexture(BooEntity booEntity) {
        return booEntity.isHiding() ? HIDING : SEEKING;
    }
}
