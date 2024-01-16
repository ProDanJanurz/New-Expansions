package net.new_expansions.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.new_expansions.items.equipment.NewexpAxe;
import net.new_expansions.items.equipment.NewexpPickaxe;

public class NewexpPerformanceEnchantment extends Enchantment {
	public NewexpPerformanceEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.DIGGER, slotTypes);
	}
	public int getMinPower(int level) {
		return 15 + 10 * (level - 1);
	}
	
	public int getMaxPower(int level) {
		return super.getMinPower(level) + 50;
	}
	
	public int getMaxLevel() {
		return 3;
	}
	
	public boolean canAccept(Enchantment other) {
		return super.canAccept(other) && other != Enchantments.EFFICIENCY;
	}
	
	public boolean isAcceptableItem(ItemStack stack) {
		return stack.getItem() instanceof NewexpPickaxe || stack.getItem() instanceof NewexpAxe;
	}
}
