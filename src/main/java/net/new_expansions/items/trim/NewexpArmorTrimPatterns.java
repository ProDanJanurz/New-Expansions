package net.new_expansions.items.trim;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.new_expansions.registry.NewexpRegistryKeys;

import java.util.Optional;

public class NewexpArmorTrimPatterns {
	public static final RegistryKey<NewexpArmorTrimPattern> SENTRY = of("sentry");
	public static final RegistryKey<NewexpArmorTrimPattern> DUNE = of("dune");
	public static final RegistryKey<NewexpArmorTrimPattern> COAST = of("coast");
	public static final RegistryKey<NewexpArmorTrimPattern> WILD = of("wild");
	public static final RegistryKey<NewexpArmorTrimPattern> WARD = of("ward");
	public static final RegistryKey<NewexpArmorTrimPattern> EYE = of("eye");
	public static final RegistryKey<NewexpArmorTrimPattern> VEX = of("vex");
	public static final RegistryKey<NewexpArmorTrimPattern> TIDE = of("tide");
	public static final RegistryKey<NewexpArmorTrimPattern> SNOUT = of("snout");
	public static final RegistryKey<NewexpArmorTrimPattern> RIB = of("rib");
	public static final RegistryKey<NewexpArmorTrimPattern> SPIRE = of("spire");
	public static final RegistryKey<NewexpArmorTrimPattern> WAYFINDER = of("wayfinder");
	public static final RegistryKey<NewexpArmorTrimPattern> SHAPER = of("shaper");
	public static final RegistryKey<NewexpArmorTrimPattern> SILENCE = of("silence");
	public static final RegistryKey<NewexpArmorTrimPattern> RAISER = of("raiser");
	public static final RegistryKey<NewexpArmorTrimPattern> HOST = of("host");
	
	public NewexpArmorTrimPatterns() {
	}
	
	public static void bootstrap(Registerable<NewexpArmorTrimPattern> registry) {
		register(registry, Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE, SENTRY);
		register(registry, Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, DUNE);
		register(registry, Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE, COAST);
		register(registry, Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE, WILD);
		register(registry, Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE, WARD);
		register(registry, Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE, EYE);
		register(registry, Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE, VEX);
		register(registry, Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE, TIDE);
		register(registry, Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE, SNOUT);
		register(registry, Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE, RIB);
		register(registry, Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, SPIRE);
		register(registry, Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE, WAYFINDER);
		register(registry, Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE, SHAPER);
		register(registry, Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE, SILENCE);
		register(registry, Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE, RAISER);
		register(registry, Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE, HOST);
	}
	
	public static Optional<RegistryEntry.Reference<NewexpArmorTrimPattern>> get(DynamicRegistryManager registryManager, ItemStack stack) {
		return registryManager.get(NewexpRegistryKeys.NEWEXP_TRIM_PATTERN).streamEntries().filter((pattern) -> {
			return stack.itemMatches(((NewexpArmorTrimPattern)pattern.value()).templateItem());
		}).findFirst();
	}
	
	private static void register(Registerable<NewexpArmorTrimPattern> registry, Item template, RegistryKey<NewexpArmorTrimPattern> key) {
		NewexpArmorTrimPattern NewexpArmorTrimPattern = new NewexpArmorTrimPattern(key.getValue(), Registries.ITEM.getEntry(template), Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())));
		registry.register(key, NewexpArmorTrimPattern);
	}
	
	private static RegistryKey<NewexpArmorTrimPattern> of(String id) {
		return RegistryKey.of(NewexpRegistryKeys.NEWEXP_TRIM_PATTERN, new Identifier(id));
	}
}