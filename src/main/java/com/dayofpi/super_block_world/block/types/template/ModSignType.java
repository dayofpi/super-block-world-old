package com.dayofpi.super_block_world.block.types.template;

import com.dayofpi.mixin.interfaces.InterfaceSignType;
import net.minecraft.util.SignType;

public class ModSignType extends SignType {
    public static final SignType AMANITA = register(new ModSignType("amanita"));

    public ModSignType(String name) {
        super(name);
    }

    private static SignType register(SignType type) {
        InterfaceSignType.VALUES().add(type);
        return type;
    }
}
