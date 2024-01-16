package net.new_expansions.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class NewexpFrostbiteEnchantment extends Enchantment {
	public NewexpFrostbiteEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
		super(weight, EnchantmentTarget.WEAPON, slotTypes);
	}
	public int getMinPower(int level) {
		return 10 + 6 * (level - 1);
	}
	
	public int getMaxPower(int level) {
		return super.getMinPower(level) + 50;
	}
	
	public int getMaxLevel() {
		return 5;
	}
	
	public void onTargetDamaged(LivingEntity user, Entity target, int level) {
		target.setFrozenTicks(target.getFrozenTicks() + (50 + 50 * level));
	}
	
	public boolean canAccept(Enchantment other) {
		return super.canAccept(other) && other != Enchantments.FIRE_ASPECT;
	}
}
