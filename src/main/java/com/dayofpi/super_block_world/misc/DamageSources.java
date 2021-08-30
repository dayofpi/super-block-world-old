package com.dayofpi.super_block_world.misc;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;

public class DamageSources {
    public static final DamageSource POISON = new DamageSource("poison") {};
    public static final DamageSource SHELL = new DamageSource("shell") {};
    public static final DamageSource SPIKES = new DamageSource("spikes") {};

    public static DamageSource mobDrop(LivingEntity attacker) {
        return new EntityDamageSource("mob_drop", attacker);
    }

    public static DamageSource spikyMob(LivingEntity attacker) {
        return new EntityDamageSource("spiky_mob", attacker);
    }
}
