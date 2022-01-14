package net.chakramod.mod.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class MalachitEnchant extends Enchantment {
    public MalachitEnchant(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.ARMOR, slotTypes);
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return false;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }


}
