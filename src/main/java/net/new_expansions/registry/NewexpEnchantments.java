package net.new_expansions.registry;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.new_expansions.NewExpansions;
import net.new_expansions.enchantments.*;

public class NewexpEnchantments {
	public static Enchantment PERFORMANCE = new NewexpPerformanceEnchantment(Enchantment.Rarity.COMMON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static Enchantment SLIPSTREAM = new NewexpSlipstreamEnchantment(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static Enchantment FROSTBITE = new NewexpFrostbiteEnchantment(Enchantment.Rarity.RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static Enchantment THERMAL_SHOCK = new NewexpThermalShockEnchantment(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static Enchantment DIFFICULTY_PEAK = new NewexpDifficultyPeakEnchantment(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
	public static Enchantment MINERAL_EXTRACTION = new NewexpMineralExtractionEnchantment(Enchantment.Rarity.VERY_RARE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});

	public static void RegisterEnchantments(){
		Registry.register(Registries.ENCHANTMENT, new Identifier(NewExpansions.MOD_ID, "performance"), PERFORMANCE);
		Registry.register(Registries.ENCHANTMENT, new Identifier(NewExpansions.MOD_ID, "slipstream"), SLIPSTREAM);
		Registry.register(Registries.ENCHANTMENT, new Identifier(NewExpansions.MOD_ID, "frostbite"), FROSTBITE);
		Registry.register(Registries.ENCHANTMENT, new Identifier(NewExpansions.MOD_ID, "thermal_shock"), THERMAL_SHOCK);
		Registry.register(Registries.ENCHANTMENT, new Identifier(NewExpansions.MOD_ID, "difficulty_peak"), DIFFICULTY_PEAK);
		Registry.register(Registries.ENCHANTMENT, new Identifier(NewExpansions.MOD_ID, "mineral_extraction"), MINERAL_EXTRACTION);
	}
}
