package net.new_expansions.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.new_expansions.NewExpansions;

public class NewexpItemGroups
{
	public NewexpItemGroups(){}
	private static RegistryKey<ItemGroup> register(String id) {
		return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(NewExpansions.MOD_ID, id));
	}
	public static final RegistryKey<ItemGroup> BLOCKS = register("blocks");
	public static final RegistryKey<ItemGroup> TOOLS = register("tools");
	public static final RegistryKey<ItemGroup> ITEMS = register("items");
	public static final RegistryKey<ItemGroup> USABLE_ITEMS = register("usable_items");
	public static ItemGroup registerItemGroups() {
		Registry.register(Registries.ITEM_GROUP, BLOCKS, FabricItemGroup.builder()
			.displayName(Text.translatable("itemGroup.newexp.blocks"))
			.icon(() -> new ItemStack(NewexpBlocks.TAB_ICON_BLOCK)).entries((enabledFeatures, entries) -> {
//          entries.add(new ItemStack(NewexpBlocks.STONE_KILN));
					entries.add(new ItemStack(NewexpItems.ENCHANTED_NETHERITE_STATUE));
					entries.add(new ItemStack(NewexpItems.MAGNETIC_RAIL));
		}).build());
		Registry.register(Registries.ITEM_GROUP, TOOLS, FabricItemGroup.builder()
			.displayName(Text.translatable("itemGroup.newexp.tools"))
			.icon(() -> new ItemStack(NewexpItems.DIAMOND_PICKAXE)).entries((enabledFeatures, entries) -> {
					entries.add(new ItemStack(NewexpItems.WOOD_PICKAXE));
					entries.add(new ItemStack(NewexpItems.WOOD_AXE));
					entries.add(new ItemStack(NewexpItems.WOOD_HOE));
					entries.add(new ItemStack(NewexpItems.WOOD_SHOVEL));
					entries.add(new ItemStack(NewexpItems.WOOD_SWORD));
					entries.add(new ItemStack(NewexpItems.LEATHER_HELMET));
					entries.add(new ItemStack(NewexpItems.LEATHER_CHESTPLATE));
					entries.add(new ItemStack(NewexpItems.LEATHER_LEGGINGS));
					entries.add(new ItemStack(NewexpItems.LEATHER_BOOTS));
					
					entries.add(new ItemStack(NewexpItems.STONE_PICKAXE));
					entries.add(new ItemStack(NewexpItems.STONE_AXE));
					entries.add(new ItemStack(NewexpItems.STONE_HOE));
					entries.add(new ItemStack(NewexpItems.STONE_SHOVEL));
					entries.add(new ItemStack(NewexpItems.STONE_SWORD));
					entries.add(new ItemStack(NewexpItems.CHAINMAIL_HELMET));
					entries.add(new ItemStack(NewexpItems.CHAINMAIL_CHESTPLATE));
					entries.add(new ItemStack(NewexpItems.CHAINMAIL_LEGGINGS));
					entries.add(new ItemStack(NewexpItems.CHAINMAIL_BOOTS));
					
					entries.add(new ItemStack(NewexpItems.COPPER_PICKAXE));
					entries.add(new ItemStack(NewexpItems.COPPER_AXE));
					entries.add(new ItemStack(NewexpItems.COPPER_HOE));
					entries.add(new ItemStack(NewexpItems.COPPER_SHOVEL));
					entries.add(new ItemStack(NewexpItems.COPPER_SWORD));
					entries.add(new ItemStack(NewexpItems.COPPER_HELMET));
					entries.add(new ItemStack(NewexpItems.COPPER_CHESTPLATE));
					entries.add(new ItemStack(NewexpItems.COPPER_LEGGINGS));
					entries.add(new ItemStack(NewexpItems.COPPER_BOOTS));
					
					entries.add(new ItemStack(NewexpItems.IRON_PICKAXE));
					entries.add(new ItemStack(NewexpItems.IRON_AXE));
					entries.add(new ItemStack(NewexpItems.IRON_HOE));
					entries.add(new ItemStack(NewexpItems.IRON_SHOVEL));
					entries.add(new ItemStack(NewexpItems.IRON_SWORD));
					entries.add(new ItemStack(NewexpItems.IRON_HELMET));
					entries.add(new ItemStack(NewexpItems.IRON_CHESTPLATE));
					entries.add(new ItemStack(NewexpItems.IRON_LEGGINGS));
					entries.add(new ItemStack(NewexpItems.IRON_BOOTS));
					
					entries.add(new ItemStack(NewexpItems.EMERALD_PICKAXE));
					entries.add(new ItemStack(NewexpItems.EMERALD_AXE));
					entries.add(new ItemStack(NewexpItems.EMERALD_HOE));
					entries.add(new ItemStack(NewexpItems.EMERALD_SHOVEL));
					entries.add(new ItemStack(NewexpItems.EMERALD_SWORD));
					entries.add(new ItemStack(NewexpItems.EMERALD_HELMET));
					entries.add(new ItemStack(NewexpItems.EMERALD_CHESTPLATE));
					entries.add(new ItemStack(NewexpItems.EMERALD_LEGGINGS));
					entries.add(new ItemStack(NewexpItems.EMERALD_BOOTS));
					
					entries.add(new ItemStack(NewexpItems.GOLD_PICKAXE));
					entries.add(new ItemStack(NewexpItems.GOLD_AXE));
					entries.add(new ItemStack(NewexpItems.GOLD_HOE));
					entries.add(new ItemStack(NewexpItems.GOLD_SHOVEL));
					entries.add(new ItemStack(NewexpItems.GOLD_SWORD));
					entries.add(new ItemStack(NewexpItems.GOLD_HELMET));
					entries.add(new ItemStack(NewexpItems.GOLD_CHESTPLATE));
					entries.add(new ItemStack(NewexpItems.GOLD_LEGGINGS));
					entries.add(new ItemStack(NewexpItems.GOLD_BOOTS));
					
					entries.add(new ItemStack(NewexpItems.DIAMOND_PICKAXE));
					entries.add(new ItemStack(NewexpItems.DIAMOND_AXE));
					entries.add(new ItemStack(NewexpItems.DIAMOND_HOE));
					entries.add(new ItemStack(NewexpItems.DIAMOND_SHOVEL));
					entries.add(new ItemStack(NewexpItems.DIAMOND_SWORD));
					entries.add(new ItemStack(NewexpItems.DIAMOND_HELMET));
					entries.add(new ItemStack(NewexpItems.DIAMOND_CHESTPLATE));
					entries.add(new ItemStack(NewexpItems.DIAMOND_LEGGINGS));
					entries.add(new ItemStack(NewexpItems.DIAMOND_BOOTS));
					
					entries.add(new ItemStack(NewexpItems.NETHERITE_PICKAXE));
					entries.add(new ItemStack(NewexpItems.NETHERITE_AXE));
					entries.add(new ItemStack(NewexpItems.NETHERITE_HOE));
					entries.add(new ItemStack(NewexpItems.NETHERITE_SHOVEL));
					entries.add(new ItemStack(NewexpItems.NETHERITE_SWORD));
					entries.add(new ItemStack(NewexpItems.NETHERITE_HELMET));
					entries.add(new ItemStack(NewexpItems.NETHERITE_CHESTPLATE));
					entries.add(new ItemStack(NewexpItems.NETHERITE_LEGGINGS));
					entries.add(new ItemStack(NewexpItems.NETHERITE_BOOTS));
					
					entries.add(new ItemStack(NewexpItems.ENDITE_PICKAXE));
					entries.add(new ItemStack(NewexpItems.ENDITE_AXE));
					entries.add(new ItemStack(NewexpItems.ENDITE_HOE));
					entries.add(new ItemStack(NewexpItems.ENDITE_SHOVEL));
					entries.add(new ItemStack(NewexpItems.ENDITE_SWORD));
					entries.add(new ItemStack(NewexpItems.ENDITE_HELMET));
					entries.add(new ItemStack(NewexpItems.ENDITE_CHESTPLATE));
					entries.add(new ItemStack(NewexpItems.ENDITE_LEGGINGS));
					entries.add(new ItemStack(NewexpItems.ENDITE_BOOTS));
					
					entries.add(new ItemStack(NewexpItems.TURTLE_HELMET));
					entries.add(new ItemStack(NewexpItems.DRILL));
					entries.add(new ItemStack(NewexpItems.DEDALUS_WINGS));
			}).build());
		Registry.register(Registries.ITEM_GROUP, ITEMS, FabricItemGroup.builder()
			.displayName(Text.translatable("itemGroup.newexp.items"))
			.icon(() -> new ItemStack(NewexpItems.SULFUR)).entries((enabledFeatures, entries) -> {
					entries.add(new ItemStack(NewexpItems.SULFUR));
					entries.add(new ItemStack(NewexpItems.RAW_NERERITE));
					entries.add(new ItemStack(NewexpItems.REFINED_NERERITE));
					entries.add(new ItemStack(NewexpItems.RAW_RENEFERITE));
					entries.add(new ItemStack(NewexpItems.REFINED_RENEFERITE));
					entries.add(new ItemStack(NewexpItems.ENDITE_INGOT));
					entries.add(new ItemStack(NewexpItems.ENDITE_SCRAP));
					entries.add(new ItemStack(NewexpItems.DIAMOND_NUGGET));
					entries.add(new ItemStack(NewexpItems.EMERALD_NUGGET));
					entries.add(new ItemStack(NewexpItems.IRON_NUGGET));
					entries.add(new ItemStack(NewexpItems.GOLD_NUGGET));
					entries.add(new ItemStack(NewexpItems.NETHERITE_NUGGET));
					entries.add(new ItemStack(NewexpItems.ENDITE_NUGGET));
					entries.add(new ItemStack(NewexpItems.DIAMOND_TREASURE));
					entries.add(new ItemStack(NewexpItems.EMERALD_TREASURE));
					entries.add(new ItemStack(NewexpItems.IRON_TREASURE));
					entries.add(new ItemStack(NewexpItems.GOLD_TREASURE));
					entries.add(new ItemStack(NewexpItems.NETHERITE_TREASURE));
					entries.add(new ItemStack(NewexpItems.ENDITE_TREASURE));
					entries.add(new ItemStack(NewexpItems.STEEL_HANDLE));
					entries.add(new ItemStack(NewexpItems.BLAZE_HANDLE));
					entries.add(new ItemStack(NewexpItems.CHORUS_HANDLE));
					entries.add(new ItemStack(NewexpItems.IRON_RINGS));
					entries.add(new ItemStack(NewexpItems.GEARS));
					entries.add(new ItemStack(NewexpItems.GEARBOX));
					entries.add(new ItemStack(NewexpItems.DRILL_HEAD));
					entries.add(new ItemStack(NewexpItems.DRILL_HANDLE));
					entries.add(new ItemStack(NewexpItems.ASH));
					entries.add(new ItemStack(NewexpItems.NETHERITE_STATUE));
					entries.add(new ItemStack(NewexpItems.ENDITE_STATUE));
					entries.add(new ItemStack(NewexpItems.NETHERITE_AMULET));
					entries.add(new ItemStack(NewexpItems.ENDITE_AMULET));
					entries.add(new ItemStack(NewexpItems.NETHERITE_ARTIFACT));
					entries.add(new ItemStack(NewexpItems.ENDITE_ARTIFACT));
					entries.add(new ItemStack(NewexpItems.NETHERITE_TOOLS));
					entries.add(new ItemStack(NewexpItems.ENDITE_TOOLS));
					entries.add(new ItemStack(NewexpItems.LUCKY_CLOVER));
					entries.add(new ItemStack(NewexpItems.COIN));
					entries.add(new ItemStack(NewexpItems.EXPERIENCE_NECKLACE));
					entries.add(new ItemStack(NewexpItems.GOLD_UPGRADE_SMITHING_TABLET));
					entries.add(new ItemStack(NewexpItems.DIAMOND_UPGRADE_SMITHING_TABLET));
					entries.add(new ItemStack(NewexpItems.NETHERITE_UPGRADE_SMITHING_TABLET));
					entries.add(new ItemStack(NewexpItems.ENDITE_UPGRADE_SMITHING_TABLET));
					entries.add(new ItemStack(NewexpItems.JEWELED_ALLOY));
					entries.add(new ItemStack(NewexpItems.GRAPHENE));
					entries.add(new ItemStack(NewexpItems.ELDER_GUARDIAN_SPIKE));
			}).build());
		Registry.register(Registries.ITEM_GROUP, USABLE_ITEMS, FabricItemGroup.builder()
			.displayName(Text.translatable("itemGroup.newexp.usable_items"))
			.icon(() -> new ItemStack(NewexpItems.BONE_STOCK)).entries((enabledFeatures, entries) -> {
					entries.add(new ItemStack(NewexpItems.MEATY_STEW));
					entries.add(new ItemStack(NewexpItems.POTATO_SALAD));
					entries.add(new ItemStack(NewexpItems.FRUIT_MIX));
					entries.add(new ItemStack(NewexpItems.STUFFED_CHICKEN));
					entries.add(new ItemStack(NewexpItems.FISH_SOUP));
					entries.add(new ItemStack(NewexpItems.BONE_STOCK));
					entries.add(new ItemStack(NewexpItems.RABBIT_STEW));
					entries.add(new ItemStack(NewexpItems.MUSHROOM_STEW));
					entries.add(new ItemStack(NewexpItems.BEETROOT_SOUP));
					entries.add(new ItemStack(NewexpItems.NETHER_SALAD));
					entries.add(new ItemStack(NewexpItems.PORKCHOP_SPECIAL));
					entries.add(new ItemStack(NewexpItems.MILK_ICECREAM));
					entries.add(new ItemStack(NewexpItems.CHOCOLATE_ICECREAM));
					entries.add(new ItemStack(NewexpItems.HONEY_ICECREAM));
					entries.add(new ItemStack(NewexpItems.MAGMATO_PEPPERS));
					entries.add(new ItemStack(NewexpItems.SUPPLIES));
					entries.add(new ItemStack(NewexpItems.BUG));
					entries.add(new ItemStack(NewexpItems.BANDAGE));
					entries.add(new ItemStack(NewexpItems.SYRINGE));
					entries.add(new ItemStack(NewexpItems.SPLINTS));
					entries.add(new ItemStack(NewexpItems.SMALL_MEDKIT));
					entries.add(new ItemStack(NewexpItems.MEDKIT));
					entries.add(new ItemStack(NewexpItems.HEALTH_BOOST));
					entries.add(new ItemStack(NewexpItems.MUSIC_DISC_THE_WAY));
					entries.add(new ItemStack(NewexpItems.MUSIC_DISC_THE_WHISPER));
					entries.add(new ItemStack(NewexpItems.MUSIC_DISC_RESIDENCE_OF_CORRUPTION));
					entries.add(new ItemStack(NewexpItems.MUSIC_DISC_TRIBAL_THOUGHT));
			}).build());
		return null;
	}
}
