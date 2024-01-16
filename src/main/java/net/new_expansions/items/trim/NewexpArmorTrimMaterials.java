package net.new_expansions.items.trim;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.new_expansions.materials.NewexpArmorMaterials;
import net.new_expansions.registry.NewexpRegistryKeys;

import java.util.Map;
import java.util.Optional;

public class NewexpArmorTrimMaterials {
	public static final RegistryKey<NewexpArmorTrimMaterial> QUARTZ = of("quartz");
	public static final RegistryKey<NewexpArmorTrimMaterial> IRON = of("iron");
	public static final RegistryKey<NewexpArmorTrimMaterial> NETHERITE = of("netherite");
	public static final RegistryKey<NewexpArmorTrimMaterial> REDSTONE = of("redstone");
	public static final RegistryKey<NewexpArmorTrimMaterial> COPPER = of("copper");
	public static final RegistryKey<NewexpArmorTrimMaterial> GOLD = of("gold");
	public static final RegistryKey<NewexpArmorTrimMaterial> EMERALD = of("emerald");
	public static final RegistryKey<NewexpArmorTrimMaterial> DIAMOND = of("diamond");
	public static final RegistryKey<NewexpArmorTrimMaterial> LAPIS = of("lapis");
	public static final RegistryKey<NewexpArmorTrimMaterial> AMETHYST = of("amethyst");
	
	public NewexpArmorTrimMaterials() {
	}
	
	public static void bootstrap(Registerable<NewexpArmorTrimMaterial> registry) {
		register(registry, QUARTZ, Items.QUARTZ, Style.EMPTY.withColor(14931140), 0.1F);
		register(registry, IRON, Items.IRON_INGOT, Style.EMPTY.withColor(15527148), 0.2F, Map.of(NewexpArmorMaterials.IRON, "iron_darker"));
		register(registry, NETHERITE, Items.NETHERITE_INGOT, Style.EMPTY.withColor(6445145), 0.3F, Map.of(NewexpArmorMaterials.NETHERITE, "netherite_darker"));
		register(registry, REDSTONE, Items.REDSTONE, Style.EMPTY.withColor(9901575), 0.4F);
		register(registry, COPPER, Items.COPPER_INGOT, Style.EMPTY.withColor(11823181), 0.5F);
		register(registry, GOLD, Items.GOLD_INGOT, Style.EMPTY.withColor(14594349), 0.6F, Map.of(NewexpArmorMaterials.GOLD, "gold_darker"));
		register(registry, EMERALD, Items.EMERALD, Style.EMPTY.withColor(1155126), 0.7F);
		register(registry, DIAMOND, Items.DIAMOND, Style.EMPTY.withColor(7269586), 0.8F, Map.of(NewexpArmorMaterials.DIAMOND, "diamond_darker"));
		register(registry, LAPIS, Items.LAPIS_LAZULI, Style.EMPTY.withColor(4288151), 0.9F);
		register(registry, AMETHYST, Items.AMETHYST_SHARD, Style.EMPTY.withColor(10116294), 1.0F);
	}
	
	public static Optional<RegistryEntry.Reference<NewexpArmorTrimMaterial>> get(DynamicRegistryManager registryManager, ItemStack stack) {
		return registryManager.get(NewexpRegistryKeys.NEWEXP_TRIM_MATERIAL).streamEntries().filter((recipe) -> {
			return stack.itemMatches(((NewexpArmorTrimMaterial)recipe.value()).ingredient());
		}).findFirst();
	}
	
	private static void register(Registerable<NewexpArmorTrimMaterial> registry, RegistryKey<NewexpArmorTrimMaterial> key, Item ingredient, Style style, float itemModelIndex) {
		register(registry, key, ingredient, style, itemModelIndex, Map.of());
	}
	
	private static void register(Registerable<NewexpArmorTrimMaterial> registry, RegistryKey<NewexpArmorTrimMaterial> key, Item ingredient, Style style, float itemModelIndex, Map<NewexpArmorMaterials, String> overrideArmorMaterials) {
		NewexpArmorTrimMaterial armorTrimMaterial = NewexpArmorTrimMaterial.of(key.getValue().getPath(), ingredient, itemModelIndex, Text.translatable(Util.createTranslationKey("trim_material", key.getValue())).fillStyle(style), overrideArmorMaterials);
		registry.register(key, armorTrimMaterial);
	}
	
	private static RegistryKey<NewexpArmorTrimMaterial> of(String id) {
		return RegistryKey.of(NewexpRegistryKeys.NEWEXP_TRIM_MATERIAL, new Identifier(id));
	}
}