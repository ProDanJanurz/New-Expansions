package net.new_expansions.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.new_expansions.items.equipment.*;
import net.new_expansions.registry.NewexpEnchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static net.minecraft.enchantment.EnchantmentTarget.*;
import static net.minecraft.enchantment.Enchantments.*;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
	
	@Unique
	private static Enchantment currentEnchantment;
	
	@Redirect(method = "getPossibleEntries", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;isAvailableForRandomSelection()Z"))
	private static boolean isAvailableForRandomSelection(Enchantment enchantment) {
		currentEnchantment = enchantment;
		
		return enchantment.isAvailableForRandomSelection();
	}
	
	@Redirect(method = "getPossibleEntries", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentTarget;isAcceptableItem(Lnet/minecraft/item/Item;)Z"))
	private static boolean isAcceptableItem(EnchantmentTarget enchantmentTarget, Item item) {
		ItemStack stack = new ItemStack(item);
		
		if(item instanceof NewexpArmorItem){
			if(((NewexpArmorItem) item).getSlotType() == EquipmentSlot.FEET){
				return currentEnchantment.target == BREAKABLE || currentEnchantment.target == VANISHABLE || currentEnchantment.target == WEARABLE || currentEnchantment.target == ARMOR || currentEnchantment.target == ARMOR_FEET;
			}
			if(((NewexpArmorItem) item).getSlotType() == EquipmentSlot.LEGS){
				return currentEnchantment.target == BREAKABLE || currentEnchantment.target == VANISHABLE || currentEnchantment.target == WEARABLE || currentEnchantment.target == ARMOR || currentEnchantment.target == ARMOR_LEGS;
			}
			if(((NewexpArmorItem) item).getSlotType() == EquipmentSlot.CHEST){
				return currentEnchantment.target == BREAKABLE || currentEnchantment.target == VANISHABLE || currentEnchantment.target == WEARABLE || currentEnchantment.target == ARMOR || currentEnchantment.target == ARMOR_CHEST;
			}
			if(((NewexpArmorItem) item).getSlotType() == EquipmentSlot.HEAD){
				return currentEnchantment.target == BREAKABLE || currentEnchantment.target == VANISHABLE || currentEnchantment.target == WEARABLE || currentEnchantment.target == ARMOR || currentEnchantment.target == ARMOR_HEAD;
			}
		}
		
		if(item instanceof NewexpToolItem){
			if(item instanceof NewexpMiningToolItem && !(item instanceof NewexpDrill)){
				if(item instanceof NewexpShovel || item instanceof NewexpHoe){
					return currentEnchantment.target == BREAKABLE || currentEnchantment.target == VANISHABLE || (currentEnchantment.target == DIGGER && currentEnchantment != NewexpEnchantments.PERFORMANCE);
				}else{
					return currentEnchantment.target == BREAKABLE || currentEnchantment.target == VANISHABLE || currentEnchantment.target == DIGGER;
				}
			}
			if(item instanceof NewexpSwordItem){
				return currentEnchantment.target == BREAKABLE || currentEnchantment.target == VANISHABLE || currentEnchantment.target == WEAPON;
			}
		}
		
		return enchantmentTarget.isAcceptableItem(item);
	}
}
