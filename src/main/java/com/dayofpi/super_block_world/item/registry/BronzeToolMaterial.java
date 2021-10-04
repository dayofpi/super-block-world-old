package com.dayofpi.super_block_world.item.registry;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BronzeToolMaterial implements ToolMaterial {
    public static final BronzeToolMaterial INSTANCE = new BronzeToolMaterial();

    @Override
    public int getDurability() {
        return 131;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.0F;
    }
    @Override
    public float getAttackDamage() {
        return 1.0F;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemList.BRONZE_INGOT);
    }

}
