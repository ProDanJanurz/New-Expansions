package net.new_expansions.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.new_expansions.items.equipment.NewexpArmorItem;

public interface NewexpArmorMaterial{
	int getDurability(NewexpArmorItem.Type type);
	
	int getProtection(NewexpArmorItem.Type type);
	
	int getTrueProtection(NewexpArmorItem.Type type);
	
	float getToughness(NewexpArmorItem.Type type);
	
	float getKnockbackResistance(NewexpArmorItem.Type type);
	
	int getEnchantability();
	
	SoundEvent getEquipSound();
	
	Ingredient getRepairIngredient();
	
	String getName();
}