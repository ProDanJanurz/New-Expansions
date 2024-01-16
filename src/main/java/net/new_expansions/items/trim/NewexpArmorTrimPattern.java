package net.new_expansions.items.trim;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryElementCodec;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryFixedCodec;
import net.minecraft.text.Text;
import net.minecraft.text.TextCodecs;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Codecs;
import net.new_expansions.registry.NewexpRegistryKeys;

public record NewexpArmorTrimPattern(Identifier assetId, RegistryEntry<Item> templateItem, Text description) {
	public static final Codec<NewexpArmorTrimPattern> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(Identifier.CODEC.fieldOf("asset_id").forGetter(NewexpArmorTrimPattern::assetId), RegistryFixedCodec.of(RegistryKeys.ITEM).fieldOf("template_item").forGetter(NewexpArmorTrimPattern::templateItem), TextCodecs.CODEC.fieldOf("description").forGetter(NewexpArmorTrimPattern::description)).apply(instance, NewexpArmorTrimPattern::new);
	});
	public static final Codec<RegistryEntry<NewexpArmorTrimPattern>> ENTRY_CODEC;
	
	public NewexpArmorTrimPattern(Identifier assetId, RegistryEntry<Item> templateItem, Text description) {
		this.assetId = assetId;
		this.templateItem = templateItem;
		this.description = description;
	}
	
	public Text getDescription(RegistryEntry<NewexpArmorTrimMaterial> material) {
		return this.description.copy().fillStyle(((NewexpArmorTrimMaterial)material.value()).description().getStyle());
	}
	
	public Identifier assetId() {
		return this.assetId;
	}
	
	public RegistryEntry<Item> templateItem() {
		return this.templateItem;
	}
	
	public Text description() {
		return this.description;
	}
	
	static {
		ENTRY_CODEC = RegistryElementCodec.of(NewexpRegistryKeys.NEWEXP_TRIM_PATTERN, CODEC);
	}
}