package com.dayofpi.super_block_world.items;

import com.dayofpi.super_block_world.misc.Sounds;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class BuzzyArmorMaterial implements ArmorMaterial {
    @Override
    public int getDurability(EquipmentSlot slot) {
        return 130;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return Sounds.BUZZY_SHELL_EQUIP;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemTypes.BUZZY_SHELL_PIECE);
    }

    @Override
    public String getName() {
        return "buzzy";
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.2F;
    }
}
