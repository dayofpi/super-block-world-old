package com.dayofpi.mixin.enum_additions;

import com.dayofpi.super_block_world.block.registry.BlockList;
import com.dayofpi.super_block_world.misc.EnumMineshafts;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.MineshaftFeature.Type;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(MineshaftFeature.Type.class)
public class MixinMineshaftFeature {
    @Invoker("<init>")
    private static MineshaftFeature.Type newType(String internalName, int internalId, String name, Block log, Block planks, Block fence) {
        throw new AssertionError();
    }

    @Shadow
    @Mutable
    private static @Final
    MineshaftFeature.Type[] field_13688;

    @Inject(method = "<clinit>", at = @At(value = "FIELD",
            opcode = Opcodes.PUTSTATIC,
            target = "Lnet/minecraft/world/gen/feature/MineshaftFeature$Type;field_13688:[Lnet/minecraft/world/gen/feature/MineshaftFeature$Type;",
            shift = At.Shift.AFTER))
    private static void addMineshaft(CallbackInfo info) {
        ArrayList variants = new ArrayList<>(Arrays.asList(field_13688));
        Type last = variants.get(variants.size() - 1);
        Type amanita = newType("AMANITA", last.ordinal() + 1, "amanita", BlockList.AMANITA_LOG, BlockList.AMANITA_PLANKS, BlockList.AMANITA_FENCE);
        EnumMineshafts.AMANITA = amanita;
        variants.add(amanita);

        field_13688 = variants.toArray(new MineshaftFeature.Type[0]);
    }
}
