package net.new_expansions.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.new_expansions.items.equipment.NewexpAxe;
import net.new_expansions.items.equipment.NewexpPickaxe;

public class NewexpSlipstreamEnchantment extends Enchantment {
	public NewexpSlipstreamEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.CROSSBOW, slotTypes);
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
