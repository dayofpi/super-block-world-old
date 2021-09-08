package com.dayofpi.mixin.interfaces;

import net.minecraft.util.SignType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(SignType.class)
public interface InterfaceSignType {
    @Accessor("VALUES")
    static Set<SignType> VALUES() {
        throw new AssertionError();
    }
}
