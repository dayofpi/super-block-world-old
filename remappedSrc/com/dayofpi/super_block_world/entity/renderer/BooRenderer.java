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
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class BooRenderer extends MobEntityRenderer<BooEntity, BooModel<BooEntity>> {
    private static final Identifier SEEKING = new Identifier(Main.MOD_ID, "textures/entity/boo/seeking.png");
    private static final Identifier HIDING = new Identifier(Main.MOD_ID, "textures/entity/boo/hiding.png");
    private static final Identifier TAMED = new Identifier(Main.MOD_ID, "textures/entity/boo/tamed.png");

    public BooRenderer(EntityRendererFactory.Context context) {
        super(context, new BooModel<>(context.getPart(ModelLayers.BOO)), 0.5F);
        this.addFeature(new BooColor(this));
        this.addFeature(new BooItem(this));
    }

    protected int getBlockLight(BooEntity glowSquidEntity, BlockPos blockPos) {
        return 15;
    }

    public Identifier getTexture(BooEntity booEntity) {
        if (booEntity.isHiding()) {
            return HIDING;
        } else if (booEntity.isTamed()) {
            return TAMED;
        } else return SEEKING;
    }
}
