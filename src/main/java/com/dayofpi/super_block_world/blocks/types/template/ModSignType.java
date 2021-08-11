package com.dayofpi.super_block_world.blocks.types.template;

import com.dayofpi.mixin.SignTypeI;
import net.minecraft.util.SignType;

public class ModSignType extends SignType {
    public static final SignType AMANITA = register(new ModSignType("amanita"));

    public ModSignType(String name) {
        super(name);
    }

    private static SignType register(SignType type) {
        SignTypeI.VALUES().add(type);
        return type;
    }
}
