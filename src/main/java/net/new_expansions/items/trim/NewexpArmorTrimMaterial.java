package net.new_expansions.items.trim;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryElementCodec;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryFixedCodec;
import net.minecraft.text.Text;
import net.minecraft.text.TextCodecs;
import net.minecraft.util.dynamic.Codecs;
import net.new_expansions.materials.NewexpArmorMaterials;
import net.new_expansions.registry.NewexpRegistryKeys;

import java.util.Map;

public record NewexpArmorTrimMaterial(String assetName, RegistryEntry<Item> ingredient, float itemModelIndex, Map<NewexpArmorMaterials, String> overrideArmorMaterials, Text description) {
	public static final Codec<NewexpArmorTrimMaterial> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(Codec.STRING.fieldOf("asset_name").forGetter(NewexpArmorTrimMaterial::assetName),
				RegistryFixedCodec.of(RegistryKeys.ITEM).fieldOf("ingredient").forGetter(NewexpArmorTrimMaterial::ingredient),
				Codec.FLOAT.fieldOf("item_model_index").forGetter(NewexpArmorTrimMaterial::itemModelIndex),
				Codec.unboundedMap(NewexpArmorMaterials.CODEC, Codec.STRING).optionalFieldOf("override_armor_materials", Map.of()).forGetter(NewexpArmorTrimMaterial::overrideArmorMaterials),
				TextCodecs.CODEC.fieldOf("description").forGetter(NewexpArmorTrimMaterial::description)).apply(instance, NewexpArmorTrimMaterial::new);
	});
	public static final Codec<RegistryEntry<NewexpArmorTrimMaterial>> ENTRY_CODEC;
	
	public NewexpArmorTrimMaterial(String assetName, RegistryEntry<Item> ingredient, float itemModelIndex, Map<NewexpArmorMaterials, String> overrideArmorMaterials, Text description) {
		this.assetName = assetName;
		this.ingredient = ingredient;
		this.itemModelIndex = itemModelIndex;
		this.overrideArmorMaterials = overrideArmorMaterials;
		this.description = description;
	}
	
	public static NewexpArmorTrimMaterial of(String assetName, Item ingredient, float itemModelIndex, Text description, Map<NewexpArmorMaterials, String> overrideArmorMaterials) {
		return new NewexpArmorTrimMaterial(assetName, Registries.ITEM.getEntry(ingredient), itemModelIndex, overrideArmorMaterials, description);
	}
	
	public String assetName() {
		return this.assetName;
	}
	
	public RegistryEntry<Item> ingredient() {
		return this.ingredient;
	}
	
	public float itemModelIndex() {
		return this.itemModelIndex;
	}
	
	public Map<NewexpArmorMaterials, String> overrideArmorMaterials() {
		return this.overrideArmorMaterials;
	}
	
	public Text description() {
		return this.description;
	}
	
	static {
		ENTRY_CODEC = RegistryElementCodec.of(NewexpRegistryKeys.NEWEXP_TRIM_MATERIAL, CODEC);
	}
}