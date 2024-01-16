package net.new_expansions.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.new_expansions.items.equipment.NewexpAxe;
import net.new_expansions.items.equipment.NewexpPickaxe;

public class NewexpMineralExtractionEnchantment extends Enchantment {
	public NewexpMineralExtractionEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.DIGGER, slotTypes);
	}
	public int getMinPower(int level) {
		return 20;
	}
	
	public int getMaxPower(int level) {
		return super.getMinPower(level) + 40;
	}
	
	public boolean canAccept(Enchantment other) {
		return super.canAccept(other) && other != Enchantments.SILK_TOUCH;
	}
	
	public int getMaxLevel() {
		return 1;
	}
	
	public boolean isTreasure() {
		return true;
	}
}