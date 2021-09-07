package com.dayofpi.super_block_world.misc;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;

public class ModDamageSource extends EntityDamageSource {
    private boolean fallingMob;

    public static final DamageSource POISON = new DamageSource("poison") {};
    public static final DamageSource SHELL = new DamageSource("shell") {};
    public static final DamageSource SPIKES = new DamageSource("spikes") {};

    public ModDamageSource(String name, Entity source) {
        super(name, source);
    }

    public static DamageSource mobDrop(LivingEntity attacker) {
        return new ModDamageSource("mob_drop", attacker).setFallingMob();
    }

    public static DamageSource spikyMob(LivingEntity attacker) {
        return new EntityDamageSource("spiky_mob", attacker);
    }

    public boolean isFallingMob() {
        return this.fallingMob;
    }

    protected ModDamageSource setFallingMob() {
        this.fallingMob = true;
        return this;
    }
}
