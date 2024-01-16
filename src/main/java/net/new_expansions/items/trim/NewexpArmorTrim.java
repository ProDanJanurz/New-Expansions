package net.new_expansions.items.trim;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtOps;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryOps;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.new_expansions.materials.NewexpArmorMaterial;
import net.new_expansions.materials.NewexpArmorMaterials;
import org.slf4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class NewexpArmorTrim {
	public static final Codec<NewexpArmorTrim> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(ArmorTrimMaterial.ENTRY_CODEC.fieldOf("material").forGetter(NewexpArmorTrim::getMaterial),
				ArmorTrimPattern.ENTRY_CODEC.fieldOf("pattern").forGetter(NewexpArmorTrim::getPattern)).apply(instance, NewexpArmorTrim::new);
	});
	private static final Logger LOGGER = LogUtils.getLogger();
	public static final String NBT_KEY = "Trim";
	private static final Text UPGRADE_TEXT;
	private final RegistryEntry<ArmorTrimMaterial> material;
	private final RegistryEntry<ArmorTrimPattern> pattern;
	private final Function<NewexpArmorMaterial, Identifier> leggingsModelIdGetter;
	private final Function<NewexpArmorMaterial, Identifier> genericModelIdGetter;
	
	public NewexpArmorTrim(RegistryEntry<ArmorTrimMaterial> material, RegistryEntry<ArmorTrimPattern> pattern) {
		this.material = material;
		this.pattern = pattern;
		this.leggingsModelIdGetter = Util.memoize((armorMaterial) -> {
			Identifier identifier = ((ArmorTrimPattern)pattern.value()).assetId();
			String string = this.getMaterialAssetNameFor(armorMaterial);
			return identifier.withPath((path) -> {
				return "trims/models/armor/" + path + "_leggings_" + string;
			});
		});
		this.genericModelIdGetter = Util.memoize((armorMaterial) -> {
			Identifier identifier = ((ArmorTrimPattern)pattern.value()).assetId();
			String string = this.getMaterialAssetNameFor(armorMaterial);
			return identifier.withPath((path) -> {
				return "trims/models/armor/" + path + "_" + string;
			});
		});
	}
	
	private String getMaterialAssetNameFor(NewexpArmorMaterial armorMaterial) {
		Map<ArmorMaterials, String> map = ((ArmorTrimMaterial)this.material.value()).overrideArmorMaterials();
		return armorMaterial instanceof NewexpArmorMaterials && map.containsKey(armorMaterial) ? (String)map.get(armorMaterial) : ((ArmorTrimMaterial)this.material.value()).assetName();
	}
	
	public boolean equals(RegistryEntry<ArmorTrimPattern> pattern, RegistryEntry<ArmorTrimMaterial> material) {
		return pattern == this.pattern && material == this.material;
	}
	
	public RegistryEntry<ArmorTrimPattern> getPattern() {
		return this.pattern;
	}
	
	public RegistryEntry<ArmorTrimMaterial> getMaterial() {
		return this.material;
	}
	
	public Identifier getLeggingsModelId(NewexpArmorMaterial armorMaterial) {
		return (Identifier)this.leggingsModelIdGetter.apply(armorMaterial);
	}
	
	public Identifier getGenericModelId(NewexpArmorMaterial armorMaterial) {
		return (Identifier)this.genericModelIdGetter.apply(armorMaterial);
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof NewexpArmorTrim armorTrim)) {
			return false;
		} else {
			return armorTrim.pattern == this.pattern && armorTrim.material == this.material;
		}
	}
	
	public static boolean apply(DynamicRegistryManager registryManager, ItemStack stack, NewexpArmorTrim trim) {
		if (stack.isIn(ItemTags.TRIMMABLE_ARMOR)) {
			stack.getOrCreateNbt().put("Trim", (NbtElement)CODEC.encodeStart(RegistryOps.of(NbtOps.INSTANCE, registryManager), trim).result().orElseThrow());
			return true;
		} else {
			return false;
		}
	}
	
	public static Optional<NewexpArmorTrim> getTrim(DynamicRegistryManager registryManager, ItemStack stack) {
		if (stack.isIn(ItemTags.TRIMMABLE_ARMOR) && stack.getNbt() != null && stack.getNbt().contains("Trim")) {
			NbtCompound nbtCompound = stack.getSubNbt("Trim");
			DataResult<NewexpArmorTrim> var10000 = CODEC.parse(RegistryOps.of(NbtOps.INSTANCE, registryManager), nbtCompound);
			Logger var10001 = LOGGER;
			Objects.requireNonNull(var10001);
			NewexpArmorTrim armorTrim = var10000.resultOrPartial(var10001::error).orElse((NewexpArmorTrim)null);
			return Optional.ofNullable(armorTrim);
		} else {
			return Optional.empty();
		}
	}
	
	public static void appendTooltip(ItemStack stack, DynamicRegistryManager registryManager, List<Text> tooltip) {
		Optional<NewexpArmorTrim> optional = getTrim(registryManager, stack);
		if (optional.isPresent()) {
			NewexpArmorTrim armorTrim = (NewexpArmorTrim)optional.get();
			tooltip.add(UPGRADE_TEXT);
			tooltip.add(ScreenTexts.space().append(((ArmorTrimPattern)armorTrim.getPattern().value()).getDescription(armorTrim.getMaterial())));
			tooltip.add(ScreenTexts.space().append(((ArmorTrimMaterial)armorTrim.getMaterial().value()).description()));
		}
		
	}
	
	static {
		UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier("smithing_template.upgrade"))).formatted(Formatting.GRAY);
	}
}