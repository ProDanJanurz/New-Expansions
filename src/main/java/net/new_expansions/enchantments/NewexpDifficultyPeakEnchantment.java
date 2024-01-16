package net.new_expansions.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class NewexpDifficultyPeakEnchantment extends Enchantment {
	public NewexpDifficultyPeakEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.WEAPON, slotTypes);
	}
	public int getMinPower(int level) {
		return 25;
	}
	
	public int getMaxPower(int level) {
		return super.getMinPower(level) + 50;
	}
	
	public int getMaxLevel() {
		return 1;
	}
	
	public boolean isTreasure() {
		return true;
	}
}
