package net.new_expansions.registry;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.new_expansions.items.trim.NewexpArmorTrimMaterial;
import net.new_expansions.items.trim.NewexpArmorTrimPattern;

public class NewexpRegistryKeys extends RegistryKeys {
	public static final RegistryKey<Registry<NewexpArmorTrimMaterial>> NEWEXP_TRIM_MATERIAL = of("trim_material");
	public static final RegistryKey<Registry<NewexpArmorTrimPattern>> NEWEXP_TRIM_PATTERN = of("trim_pattern");
	
	private static <T> RegistryKey<Registry<T>> of(String id) {
		return RegistryKey.ofRegistry(new Identifier(id));
	}
}
