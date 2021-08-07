package com.dayofpi.super_block_world.common.utility;

import com.dayofpi.mixin.SignTypeI;
import net.minecraft.util.SignType;

public class ModSignType extends SignType {
    public ModSignType(String name) {
        super(name);
    }

    public static final SignType AMANITA = register(new ModSignType("amanita"));

    private static SignType register(SignType type) {
        SignTypeI.VALUES().add(type);
        return type;
    }
}
