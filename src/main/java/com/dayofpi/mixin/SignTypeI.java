package com.dayofpi.mixin;

import net.minecraft.util.SignType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;

@Mixin(SignType.class)
public interface SignTypeI {
    @Accessor("VALUES")
    static Set<SignType> VALUES() {
        throw new AssertionError();
    }
}
