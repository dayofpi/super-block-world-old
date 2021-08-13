package com.dayofpi.super_block_world.blocks.types.template;

import net.minecraft.block.LeavesBlock;
import net.minecraft.state.property.BooleanProperty;

public class ModLeavesBlock extends LeavesBlock {
    public static final BooleanProperty FANCY;

    static {
        FANCY = BooleanProperty.of("fancy");
    }

    public ModLeavesBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FANCY, false));
    }
}
