package net.new_expansions.registry;

import com.mojang.serialization.Lifecycle;
import net.minecraft.registry.*;
import net.new_expansions.NewExpansions;
import net.new_expansions.items.*;
import net.new_expansions.items.equipment.*;
import net.new_expansions.items.magic_items.NewexpXpNecklace;
import net.new_expansions.items.usables.*;
import net.new_expansions.materials.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.new_expansions.util.NewexpItemUtil;

public class NewexpItems {
    //itemy
    public static final Item STEEL_HANDLE = new NewexpItem(new Item.Settings());
    public static final Item BLAZE_HANDLE = new NewexpItem(new Item.Settings());
    public static final Item CHORUS_HANDLE = new NewexpItem(new Item.Settings());
    public static final Item IRON_RINGS = new NewexpItem(new Item.Settings());
    public static final Item GEARS = new NewexpItem(new Item.Settings());
    public static final Item GEARBOX = new NewexpItem(new Item.Settings());
    public static final Item DRILL_HEAD = new NewexpItem(new Item.Settings());
    public static final Item DRILL_HANDLE = new NewexpItem(new Item.Settings());
    public static final Item ASH = new BoneMealItem(new Item.Settings());
    public static final Item NETHERITE_STATUE = new NewexpItem(new Item.Settings().maxCount(16).fireproof().rarity(Rarity.UNCOMMON));
    public static final Item ENDITE_STATUE = new NewexpItem(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON));
    public static final Item NETHERITE_AMULET = new NewexpItem(new Item.Settings().maxCount(16).fireproof().rarity(Rarity.UNCOMMON));
    public static final Item ENDITE_AMULET = new NewexpItem(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON));
    public static final Item NETHERITE_ARTIFACT = new NewexpItem(new Item.Settings().maxCount(16).fireproof().rarity(Rarity.UNCOMMON));
    public static final Item ENDITE_ARTIFACT = new NewexpItem(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON));
    public static final Item NETHERITE_TOOLS = new NewexpItem(new Item.Settings().maxCount(4).fireproof().rarity(Rarity.RARE));
    public static final Item ENDITE_TOOLS = new NewexpItem(new Item.Settings().maxCount(4).rarity(Rarity.RARE));
    public static final Item HEALTH_BOOST = new NewexpHealthBoostItem(new Item.Settings().fireproof().rarity(Rarity.RARE));
    public static final Item LUCKY_CLOVER = new NewexpItem(new Item.Settings().fireproof().rarity(Rarity.RARE));
    public static final Item GOLD_UPGRADE_SMITHING_TABLET = new NewexpItem(new Item.Settings());
    public static final Item DIAMOND_UPGRADE_SMITHING_TABLET = new NewexpItem(new Item.Settings());
    public static final Item NETHERITE_UPGRADE_SMITHING_TABLET = new NewexpItem(new Item.Settings());
    public static final Item ENDITE_UPGRADE_SMITHING_TABLET = new NewexpItem(new Item.Settings());
    public static final Item COIN = new NewexpItem(new Item.Settings());
    public static final Item ELDER_GUARDIAN_SPIKE = new NewexpItem(new Item.Settings().rarity(Rarity.UNCOMMON));
    //magiczne przedmioty
    public static final Item EXPERIENCE_NECKLACE = new NewexpXpNecklace(new Item.Settings().maxCount(1).rarity(Rarity.EPIC));
    //itemy-blok
    public static final NewexpGlintBlockItem ENCHANTED_NETHERITE_STATUE = new NewexpGlintBlockItem(NewexpBlocks.ENCHANTED_NETHERITE_STATUE ,new Item.Settings().maxCount(1).fireproof().rarity(Rarity.RARE));
    //rudy
    public static final Item SULFUR = new NewexpItem(new Item.Settings());
    public static final Item RAW_NERERITE = new NewexpItem(new Item.Settings().fireproof());
    public static final Item REFINED_NERERITE = new NewexpItem(new Item.Settings().fireproof());
    public static final Item RAW_RENEFERITE = new NewexpItem(new Item.Settings());
    public static final Item REFINED_RENEFERITE = new NewexpItem(new Item.Settings());
    public static final Item ENDITE_INGOT = new NewexpItem(new Item.Settings());
    public static final Item ENDITE_SCRAP = new NewexpItem(new Item.Settings());
    public static final Item EMERALD_NUGGET = new NewexpItem(new Item.Settings());
    public static final Item DIAMOND_NUGGET = new NewexpItem(new Item.Settings());
    public static final Item IRON_NUGGET = new NewexpItem(new Item.Settings());
    public static final Item GOLD_NUGGET = new NewexpItem(new Item.Settings());
    public static final Item NETHERITE_NUGGET = new NewexpItem(new Item.Settings().fireproof());
    public static final Item ENDITE_NUGGET = new NewexpItem(new Item.Settings());
    public static final Item EMERALD_TREASURE = new NewexpItem(new Item.Settings());
    public static final Item DIAMOND_TREASURE = new NewexpItem(new Item.Settings());
    public static final Item IRON_TREASURE = new NewexpItem(new Item.Settings());
    public static final Item GOLD_TREASURE = new NewexpItem(new Item.Settings());
    public static final Item NETHERITE_TREASURE = new NewexpItem(new Item.Settings().fireproof());
    public static final Item ENDITE_TREASURE = new NewexpItem(new Item.Settings());
    public static final Item JEWELED_ALLOY = new NewexpItem(new Item.Settings().rarity(Rarity.EPIC));
    public static final Item GRAPHENE = new NewexpItem(new Item.Settings().rarity(Rarity.RARE));
    //jedzenie
    public static final Item MAGMATO_PEPPERS = new NewexpAliasedBlockItem(NewexpBlocks.MAGMATO_BUSH, (new Item.Settings().maxCount(64).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.5f).snack().build()).fireproof()));
    public static final NewexpStewItem MEATY_STEW = new NewexpStewItem(new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(16).saturationModifier(1.2f).build()));
    public static final Item POTATO_SALAD = new NewexpStewItem(new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(13).saturationModifier(1.2f).build()));
    public static final Item FRUIT_MIX = new NewexpStewItem(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(10).saturationModifier(0.6f).build()));
    public static final Item STUFFED_CHICKEN = new NewexpStewItem(new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(12).saturationModifier(1.2f).build()));
    public static final Item FISH_SOUP = new NewexpStewItem(new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(10).saturationModifier(1.8f).build()));
    public static final Item BONE_STOCK = new NewexpStewItem(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(1.2f).build()));
    public static final Item NETHER_SALAD = new NewexpStewItem(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(9).saturationModifier(1.5f).build()));
    public static final Item PORKCHOP_SPECIAL = new NewexpStewItem(new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(11).saturationModifier(1.8f).build()));
    public static final Item RABBIT_STEW = new NewexpStewItem(new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(12).saturationModifier(1.8f).build()));
    public static final Item MUSHROOM_STEW = new NewexpStewItem(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(7).saturationModifier(1.8f).build()));
    public static final Item BEETROOT_SOUP = new NewexpStewItem(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(1.2f).build()));
    public static final Item MILK_ICECREAM = new NewexpItem(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(1.5f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*60), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*60), 1f).build()));
    public static final Item CHOCOLATE_ICECREAM = new NewexpItem(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(1.5f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*60), 1f).build()));
    public static final Item HONEY_ICECREAM = new NewexpItem(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(1.5f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20*60, 1), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*60), 1f).build()));
    public static final Item SUPPLIES = new NewexpItem(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.5f).build()));
    public static final Item BUG = new NewexpItem(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().hunger(2).saturationModifier(1.8f).snack().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*20), 1f).build()));
    //leczenie
    public static final Item BANDAGE = new NewexpBandageItem(new Item.Settings());
    public static final Item SYRINGE = new NewexpSyringeItem(new Item.Settings());
    public static final Item SPLINTS = new NewexpSplintsItem(new Item.Settings());
    public static final Item SMALL_MEDKIT = new NewexpSmallMedkitItem(new Item.Settings().maxCount(16));
    public static final Item MEDKIT = new NewexpMedkitItem(new Item.Settings().maxCount(16));
    //płyty
    public static final Item MUSIC_DISC_THE_WAY = new NewexpMusicDiscItem(15, NewexpSounds.MUSIC_DISC_THE_WAY_RECORD, (new Item.Settings()).maxCount(1).rarity(Rarity.RARE),64);
    public static final Item MUSIC_DISC_THE_WHISPER = new NewexpMusicDiscItem(15, NewexpSounds.MUSIC_DISC_THE_WHISPER_RECORD, (new Item.Settings()).maxCount(1).rarity(Rarity.RARE),112);
    public static final Item MUSIC_DISC_RESIDENCE_OF_CORRUPTION = new NewexpMusicDiscItem(15, NewexpSounds.MUSIC_DISC_RESIDENCE_OF_CORRUPTION_RECORD, (new Item.Settings()).maxCount(1).rarity(Rarity.RARE),99);
    public static final Item MUSIC_DISC_TRIBAL_THOUGHT = new NewexpMusicDiscItem(15, NewexpSounds.MUSIC_DISC_TRIBAL_THOUGHT, (new Item.Settings()).maxCount(1).rarity(Rarity.RARE),66);
    //narzędzia
    public static final Item DEDALUS_WINGS = new Item(new Item.Settings());
    public static final NewexpToolItem DRILL = new NewexpDrill(NewexpToolMaterials.DRILL,1, -2.5f, new Item.Settings());
    //wooden
    public static final NewexpToolItem WOOD_PICKAXE = new NewexpPickaxe(NewexpToolMaterials.WOOD, 1, -2.8f, new Item.Settings());
    public static final NewexpToolItem WOOD_AXE = new NewexpAxe(NewexpToolMaterials.WOOD, 5, -3.2f, new Item.Settings());
    public static final NewexpToolItem WOOD_HOE = new NewexpHoe(NewexpToolMaterials.WOOD, 0, -2f, new Item.Settings());
    public static final NewexpToolItem WOOD_SHOVEL = new NewexpShovel(NewexpToolMaterials.WOOD, 1.5f, -3f, new Item.Settings());
    public static final NewexpToolItem WOOD_SWORD = new NewexpSwordItem(NewexpToolMaterials.WOOD, 3, -2.4f, new Item.Settings());
    //stone
    public static final NewexpToolItem STONE_PICKAXE = new NewexpPickaxe(NewexpToolMaterials.STONE, 1, -2.8f, new Item.Settings());
    public static final NewexpToolItem STONE_AXE = new NewexpAxe(NewexpToolMaterials.STONE, 5, -3.2f, new Item.Settings());
    public static final NewexpToolItem STONE_HOE = new NewexpHoe(NewexpToolMaterials.STONE, 0, -2f, new Item.Settings());
    public static final NewexpToolItem STONE_SHOVEL = new NewexpShovel(NewexpToolMaterials.STONE, 1.5f, -3f, new Item.Settings());
    public static final NewexpToolItem STONE_SWORD = new NewexpSwordItem(NewexpToolMaterials.STONE, 3, -2.4f, new Item.Settings());
    //lether
    public static final NewexpArmorItem LEATHER_HELMET = new NewexpDyableArmorItem(NewexpArmorMaterials.LEATHER, NewexpArmorItem.Type.HELMET, new Item.Settings());
    public static final NewexpArmorItem LEATHER_CHESTPLATE = new NewexpDyableArmorItem(NewexpArmorMaterials.LEATHER, NewexpArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final NewexpArmorItem LEATHER_LEGGINGS = new NewexpDyableArmorItem(NewexpArmorMaterials.LEATHER, NewexpArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final NewexpArmorItem LEATHER_BOOTS = new NewexpDyableArmorItem(NewexpArmorMaterials.LEATHER, NewexpArmorItem.Type.BOOTS, new Item.Settings());
    //chain
    public static final NewexpArmorItem CHAINMAIL_HELMET = new NewexpArmorItem(NewexpArmorMaterials.CHAINMAIL, NewexpArmorItem.Type.HELMET, new Item.Settings());
    public static final NewexpArmorItem CHAINMAIL_CHESTPLATE = new NewexpArmorItem(NewexpArmorMaterials.CHAINMAIL, NewexpArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final NewexpArmorItem CHAINMAIL_LEGGINGS = new NewexpArmorItem(NewexpArmorMaterials.CHAINMAIL, NewexpArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final NewexpArmorItem CHAINMAIL_BOOTS = new NewexpArmorItem(NewexpArmorMaterials.CHAINMAIL, NewexpArmorItem.Type.BOOTS, new Item.Settings());
    //copper
    public static final NewexpToolItem COPPER_PICKAXE = new NewexpPickaxe(NewexpToolMaterials.COPPER, 1, -2.8f, new Item.Settings());
    public static final NewexpToolItem COPPER_AXE = new NewexpAxe(NewexpToolMaterials.COPPER, 5, -3.1f, new Item.Settings());
    public static final NewexpToolItem COPPER_HOE = new NewexpHoe(NewexpToolMaterials.COPPER, -1, -2f, new Item.Settings());
    public static final NewexpToolItem COPPER_SHOVEL = new NewexpShovel(NewexpToolMaterials.COPPER, 1.5f, -3f, new Item.Settings());
    public static final NewexpToolItem COPPER_SWORD = new NewexpSwordItem(NewexpToolMaterials.COPPER, 3, -2.4f, new Item.Settings());
    public static final NewexpArmorItem COPPER_HELMET = new NewexpArmorItem(NewexpArmorMaterials.COPPER, NewexpArmorItem.Type.HELMET, new Item.Settings());
    public static final NewexpArmorItem COPPER_CHESTPLATE = new NewexpArmorItem(NewexpArmorMaterials.COPPER, NewexpArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final NewexpArmorItem COPPER_LEGGINGS = new NewexpArmorItem(NewexpArmorMaterials.COPPER, NewexpArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final NewexpArmorItem COPPER_BOOTS = new NewexpArmorItem(NewexpArmorMaterials.COPPER, NewexpArmorItem.Type.BOOTS, new Item.Settings());
    //iron
    public static final NewexpToolItem IRON_PICKAXE = new NewexpPickaxe(NewexpToolMaterials.IRON, 1, -2.8f, new Item.Settings());
    public static final NewexpToolItem IRON_AXE = new NewexpAxe(NewexpToolMaterials.IRON, 5, -3.1f, new Item.Settings());
    public static final NewexpToolItem IRON_HOE = new NewexpHoe(NewexpToolMaterials.IRON, -2, -2f, new Item.Settings());
    public static final NewexpToolItem IRON_SHOVEL = new NewexpShovel(NewexpToolMaterials.IRON, 1.5f, -3f, new Item.Settings());
    public static final NewexpToolItem IRON_SWORD = new NewexpSwordItem(NewexpToolMaterials.IRON, 3, -2.4f, new Item.Settings());
    public static final NewexpArmorItem IRON_HELMET = new NewexpArmorItem(NewexpArmorMaterials.IRON, NewexpArmorItem.Type.HELMET, new Item.Settings());
    public static final NewexpArmorItem IRON_CHESTPLATE = new NewexpArmorItem(NewexpArmorMaterials.IRON, NewexpArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final NewexpArmorItem IRON_LEGGINGS = new NewexpArmorItem(NewexpArmorMaterials.IRON, NewexpArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final NewexpArmorItem IRON_BOOTS = new NewexpArmorItem(NewexpArmorMaterials.IRON, NewexpArmorItem.Type.BOOTS, new Item.Settings());
    //emerald
    public static final NewexpToolItem EMERALD_PICKAXE = new NewexpPickaxe(NewexpToolMaterials.EMERALD, 1, -2.8f, new Item.Settings());
    public static final NewexpToolItem EMERALD_AXE = new NewexpAxe(NewexpToolMaterials.EMERALD, 5, -3.1f, new Item.Settings());
    public static final NewexpToolItem EMERALD_HOE = new NewexpHoe(NewexpToolMaterials.EMERALD, -2, -2f, new Item.Settings());
    public static final NewexpToolItem EMERALD_SHOVEL = new NewexpShovel(NewexpToolMaterials.EMERALD, 1.5f, -3f, new Item.Settings());
    public static final NewexpToolItem EMERALD_SWORD = new NewexpSwordItem(NewexpToolMaterials.EMERALD, 3, -2.4f, new Item.Settings());
    public static final NewexpArmorItem EMERALD_HELMET = new NewexpArmorItem(NewexpArmorMaterials.EMERALD, NewexpArmorItem.Type.HELMET, new Item.Settings());
    public static final NewexpArmorItem EMERALD_CHESTPLATE = new NewexpArmorItem(NewexpArmorMaterials.EMERALD, NewexpArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final NewexpArmorItem EMERALD_LEGGINGS = new NewexpArmorItem(NewexpArmorMaterials.EMERALD, NewexpArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final NewexpArmorItem EMERALD_BOOTS = new NewexpArmorItem(NewexpArmorMaterials.EMERALD, NewexpArmorItem.Type.BOOTS, new Item.Settings());
    //golden
    public static final NewexpToolItem GOLD_PICKAXE = new NewexpPickaxe(NewexpToolMaterials.GOLD, 1, -2.8f, new Item.Settings());
    public static final NewexpToolItem GOLD_AXE = new NewexpAxe(NewexpToolMaterials.GOLD, 5, -3f, new Item.Settings());
    public static final NewexpToolItem GOLD_HOE = new NewexpHoe(NewexpToolMaterials.GOLD, -2, -2f, new Item.Settings());
    public static final NewexpToolItem GOLD_SHOVEL = new NewexpShovel(NewexpToolMaterials.GOLD, 1.5f, -3f, new Item.Settings());
    public static final NewexpToolItem GOLD_SWORD = new NewexpSwordItem(NewexpToolMaterials.GOLD, 3, -2.4f, new Item.Settings());
    public static final NewexpArmorItem GOLD_HELMET = new NewexpArmorItem(NewexpArmorMaterials.GOLD, NewexpArmorItem.Type.HELMET, new Item.Settings());
    public static final NewexpArmorItem GOLD_CHESTPLATE = new NewexpArmorItem(NewexpArmorMaterials.GOLD, NewexpArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final NewexpArmorItem GOLD_LEGGINGS = new NewexpArmorItem(NewexpArmorMaterials.GOLD, NewexpArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final NewexpArmorItem GOLD_BOOTS = new NewexpArmorItem(NewexpArmorMaterials.GOLD, NewexpArmorItem.Type.BOOTS, new Item.Settings());
    //diamond
    public static final NewexpToolItem DIAMOND_PICKAXE = new NewexpPickaxe(NewexpToolMaterials.DIAMOND, 1, -2.8f, new Item.Settings());
    public static final NewexpToolItem DIAMOND_AXE = new NewexpAxe(NewexpToolMaterials.DIAMOND, 5, -3f, new Item.Settings());
    public static final NewexpToolItem DIAMOND_HOE = new NewexpHoe(NewexpToolMaterials.DIAMOND, -2, -2f, new Item.Settings());
    public static final NewexpToolItem DIAMOND_SHOVEL = new NewexpShovel(NewexpToolMaterials.DIAMOND, 1.5f, -3f, new Item.Settings());
    public static final NewexpToolItem DIAMOND_SWORD = new NewexpSwordItem(NewexpToolMaterials.DIAMOND, 3, -2.4f, new Item.Settings());
    public static final NewexpArmorItem DIAMOND_HELMET = new NewexpArmorItem(NewexpArmorMaterials.DIAMOND, NewexpArmorItem.Type.HELMET, new Item.Settings());
    public static final NewexpArmorItem DIAMOND_CHESTPLATE = new NewexpArmorItem(NewexpArmorMaterials.DIAMOND, NewexpArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final NewexpArmorItem DIAMOND_LEGGINGS = new NewexpArmorItem(NewexpArmorMaterials.DIAMOND, NewexpArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final NewexpArmorItem DIAMOND_BOOTS = new NewexpArmorItem(NewexpArmorMaterials.DIAMOND, NewexpArmorItem.Type.BOOTS, new Item.Settings());
    //netherite
    public static final NewexpToolItem NETHERITE_PICKAXE = new NewexpPickaxe(NewexpToolMaterials.NETHERITE, 1, -2.8f, new Item.Settings().fireproof());
    public static final NewexpToolItem NETHERITE_AXE = new NewexpAxe(NewexpToolMaterials.NETHERITE, 5, -3f, new Item.Settings().fireproof());
    public static final NewexpToolItem NETHERITE_HOE = new NewexpHoe(NewexpToolMaterials.NETHERITE, -2, -2f, new Item.Settings().fireproof());
    public static final NewexpToolItem NETHERITE_SHOVEL = new NewexpShovel(NewexpToolMaterials.NETHERITE, 1.5f, -3f, new Item.Settings().fireproof());
    public static final NewexpToolItem NETHERITE_SWORD = new NewexpSwordItem(NewexpToolMaterials.NETHERITE, 3, -2.4f, new Item.Settings().fireproof());
    public static final NewexpArmorItem NETHERITE_HELMET = new NewexpArmorItem(NewexpArmorMaterials.NETHERITE, NewexpArmorItem.Type.HELMET, new Item.Settings().fireproof());
    public static final NewexpArmorItem NETHERITE_CHESTPLATE = new NewexpArmorItem(NewexpArmorMaterials.NETHERITE, NewexpArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof());
    public static final NewexpArmorItem NETHERITE_LEGGINGS = new NewexpArmorItem(NewexpArmorMaterials.NETHERITE, NewexpArmorItem.Type.LEGGINGS, new Item.Settings().fireproof());
    public static final NewexpArmorItem NETHERITE_BOOTS = new NewexpArmorItem(NewexpArmorMaterials.NETHERITE, NewexpArmorItem.Type.BOOTS, new Item.Settings().fireproof());
    //endite
    public static final NewexpToolItem ENDITE_PICKAXE = new NewexpPickaxe(NewexpToolMaterials.ENDITE, 1, -2.8f, new Item.Settings());
    public static final NewexpToolItem ENDITE_AXE = new NewexpAxe(NewexpToolMaterials.ENDITE, 5, -3f, new Item.Settings());
    public static final NewexpToolItem ENDITE_HOE = new NewexpHoe(NewexpToolMaterials.ENDITE, -2, -2f, new Item.Settings());
    public static final NewexpToolItem ENDITE_SHOVEL = new NewexpShovel(NewexpToolMaterials.ENDITE, 1.5f, -3f, new Item.Settings());
    public static final NewexpToolItem ENDITE_SWORD = new NewexpSwordItem(NewexpToolMaterials.ENDITE, 3, -2.4f, new Item.Settings());
    public static final NewexpArmorItem ENDITE_HELMET = new NewexpArmorItem(NewexpArmorMaterials.ENDITE, NewexpArmorItem.Type.HELMET, new Item.Settings());
    public static final NewexpArmorItem ENDITE_CHESTPLATE = new NewexpArmorItem(NewexpArmorMaterials.ENDITE, NewexpArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final NewexpArmorItem ENDITE_LEGGINGS = new NewexpArmorItem(NewexpArmorMaterials.ENDITE, NewexpArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final NewexpArmorItem ENDITE_BOOTS = new NewexpArmorItem(NewexpArmorMaterials.ENDITE, NewexpArmorItem.Type.BOOTS, new Item.Settings());
    //turtle
    public static final NewexpArmorItem TURTLE_HELMET = new NewexpArmorItem(NewexpArmorMaterials.TURTLE, NewexpArmorItem.Type.HELMET, new Item.Settings());
    
    //bloki
    public static final Item TAB_ICON_BLOCK = new NewexpBlockItem(NewexpBlocks.TAB_ICON_BLOCK, new Item.Settings());
    //public static final BlockItem STONE_KILN = new NewexpBlockItem(NewexpBlocks.STONE_KILN, new Item.Settings());
    public static final Item MAGNETIC_RAIL = new NewexpBlockItem(NewexpBlocks.MAGNETIC_RAIL, new Item.Settings());
    
    static <V, T extends V> void register(int rawId, String id, T entry) {
        ((SimpleRegistry) Registries.ITEM).set(rawId, RegistryKey.of(((Registry<V>) Registries.ITEM).getKey(), new Identifier(id)), entry, Lifecycle.stable());
    }

    public static void RegisterItems(){
        //itemy
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "steel_handle"), STEEL_HANDLE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "blaze_handle"), BLAZE_HANDLE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "chorus_handle"), CHORUS_HANDLE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_rings"), IRON_RINGS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gears"), GEARS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gearbox"), GEARBOX);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "drill_head"), DRILL_HEAD);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "drill_handle"), DRILL_HANDLE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "ash"), ASH);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_statue"), NETHERITE_STATUE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_statue"), ENDITE_STATUE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_amulet"), NETHERITE_AMULET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_amulet"), ENDITE_AMULET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_artifact"), NETHERITE_ARTIFACT);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_artifact"), ENDITE_ARTIFACT);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_tools"), NETHERITE_TOOLS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_tools"), ENDITE_TOOLS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "health_boost"), HEALTH_BOOST);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "lucky_clover"), LUCKY_CLOVER);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gold_upgrade_smithing_tablet"), GOLD_UPGRADE_SMITHING_TABLET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "diamond_upgrade_smithing_tablet"), DIAMOND_UPGRADE_SMITHING_TABLET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_upgrade_smithing_tablet"), NETHERITE_UPGRADE_SMITHING_TABLET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_upgrade_smithing_tablet"), ENDITE_UPGRADE_SMITHING_TABLET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "coin"), COIN);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "jeweled_alloy"), JEWELED_ALLOY);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "graphene"), GRAPHENE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "elder_guardian_spike"), ELDER_GUARDIAN_SPIKE);
        //magiczne przedmioty
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "experience_necklace"), EXPERIENCE_NECKLACE);
        //rudy i pochodne
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "sulfur"), SULFUR);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "raw_nererite"), RAW_NERERITE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "refined_nererite"), REFINED_NERERITE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "raw_reneferite"), RAW_RENEFERITE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "refined_reneferite"), REFINED_RENEFERITE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_ingot"), ENDITE_INGOT);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_scrap"), ENDITE_SCRAP);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "emerald_nugget"), EMERALD_NUGGET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "diamond_nugget"), DIAMOND_NUGGET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_nugget"), IRON_NUGGET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gold_nugget"), GOLD_NUGGET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_nugget"), NETHERITE_NUGGET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_nugget"), ENDITE_NUGGET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "emerald_treasure"), EMERALD_TREASURE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "diamond_treasure"), DIAMOND_TREASURE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_treasure"), IRON_TREASURE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gold_treasure"), GOLD_TREASURE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_treasure"), NETHERITE_TREASURE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_treasure"), ENDITE_TREASURE);
        //jedzenie
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "magmato_peppers"), MAGMATO_PEPPERS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "meaty_stew"), MEATY_STEW);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "potato_salad"), POTATO_SALAD);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "fruit_mix"), FRUIT_MIX);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "stuffed_chicken"), STUFFED_CHICKEN);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "fish_soup"), FISH_SOUP);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "bone_stock"), BONE_STOCK);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "nether_salad"), NETHER_SALAD);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "porkchop_special"), PORKCHOP_SPECIAL);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "milk_icecream"), MILK_ICECREAM);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "chocolate_icecream"), CHOCOLATE_ICECREAM);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "honey_icecream"), HONEY_ICECREAM);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "supplies"), SUPPLIES);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "bug"), BUG);
        
        register(1113, "rabbit_stew", RABBIT_STEW);
        register(846, "mushroom_stew", MUSHROOM_STEW);
        register(1149, "beetroot_soup", BEETROOT_SOUP);
        //Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "rabbit_stew"), RABBIT_STEW);
        //Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "mushroom_stew"), MUSHROOM_STEW);
        //Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "beetroot_soup"), BEETROOT_SOUP);
        //leczenie
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "bandage"), BANDAGE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "syringe"), SYRINGE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "splints"), SPLINTS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "small_medkit"), SMALL_MEDKIT);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "medkit"), MEDKIT);
        //płyty
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "music_disc_the_way"), MUSIC_DISC_THE_WAY);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "music_disc_the_whisper"), MUSIC_DISC_THE_WHISPER);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "music_disc_residence_of_corruption"), MUSIC_DISC_RESIDENCE_OF_CORRUPTION);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "music_disc_tribal_thought"), MUSIC_DISC_TRIBAL_THOUGHT);
        //narzędzia
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "drill"), DRILL);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "dedalus_wings"), DEDALUS_WINGS);
        //wood and leather
        /*
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "wood_pickaxe"), WOOD_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "wood_axe"), WOOD_AXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "wood_hoe"), WOOD_HOE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "wood_shovel"), WOOD_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "wood_sword"), WOOD_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "leather_helmet"), LEATHER_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "leather_chestplate"), LEATHER_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "leather_leggings"), LEATHER_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "leather_boots"), LEATHER_BOOTS);
        */
        
        register(814, "wooden_sword", WOOD_SWORD);
        register(815, "wooden_shovel", WOOD_SHOVEL);
        register(816, "wooden_pickaxe", WOOD_PICKAXE);
        register(817, "wooden_axe", WOOD_AXE);
        register(818, "wooden_hoe", WOOD_HOE);
        register(853, "leather_helmet", LEATHER_HELMET);
        register(854, "leather_chestplate", LEATHER_CHESTPLATE);
        register(855, "leather_leggings", LEATHER_LEGGINGS);
        register(856, "leather_boots", LEATHER_BOOTS);
        //stone and chain
        /*
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "stone_pickaxe"), STONE_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "stone_axe"), STONE_AXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "stone_hoe"), STONE_HOE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "stone_shovel"), STONE_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "stone_sword"), STONE_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "chainmail_helmet"), CHAINMAIL_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "chainmail_chestplate"), CHAINMAIL_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "chainmail_leggings"), CHAINMAIL_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "chainmail_boots"), CHAINMAIL_BOOTS);
        */
        
        register(819, "stone_sword", STONE_SWORD);
        register(820, "stone_shovel", STONE_SHOVEL);
        register(821, "stone_pickaxe", STONE_PICKAXE);
        register(822, "stone_axe", STONE_AXE);
        register(823, "stone_hoe", STONE_HOE);
        register(857, "chainmail_helmet", CHAINMAIL_HELMET);
        register(858, "chainmail_chestplate", CHAINMAIL_CHESTPLATE);
        register(859, "chainmail_leggings", CHAINMAIL_LEGGINGS);
        register(860, "chainmail_boots", CHAINMAIL_BOOTS);
        //copper
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "copper_pickaxe"), COPPER_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "copper_axe"), COPPER_AXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "copper_hoe"), COPPER_HOE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "copper_shovel"), COPPER_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "copper_sword"), COPPER_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "copper_helmet"), COPPER_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "copper_chestplate"), COPPER_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "copper_leggings"), COPPER_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "copper_boots"), COPPER_BOOTS);
        //iron
        /*
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_pickaxe"), IRON_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_axe"), IRON_AXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_hoe"), IRON_HOE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_shovel"), IRON_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_sword"), IRON_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_helmet"), IRON_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_chestplate"), IRON_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_leggings"), IRON_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_boots"), IRON_BOOTS);
        */
        
        register(829, "iron_sword", IRON_SWORD);
        register(830, "iron_shovel", IRON_SHOVEL);
        register(831, "iron_pickaxe", IRON_PICKAXE);
        register(832, "iron_axe", IRON_AXE);
        register(833, "iron_hoe", IRON_HOE);
        register(861, "iron_helmet", IRON_HELMET);
        register(862, "iron_chestplate", IRON_CHESTPLATE);
        register(863, "iron_leggings", IRON_LEGGINGS);
        register(864, "iron_boots", IRON_BOOTS);
        //emerald
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "emerald_pickaxe"), EMERALD_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "emerald_axe"), EMERALD_AXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "emerald_hoe"), EMERALD_HOE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "emerald_shovel"), EMERALD_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "emerald_sword"), EMERALD_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "emerald_helmet"), EMERALD_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "emerald_chestplate"), EMERALD_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "emerald_leggings"), EMERALD_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "emerald_boots"), EMERALD_BOOTS);
        //gold
        /*
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gold_pickaxe"), GOLD_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gold_axe"), GOLD_AXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gold_hoe"), GOLD_HOE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gold_shovel"), GOLD_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gold_sword"), GOLD_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gold_helmet"), GOLD_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gold_chestplate"), GOLD_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gold_leggings"), GOLD_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "gold_boots"), GOLD_BOOTS);
        */
        
        register(824, "golden_sword", GOLD_SWORD);
        register(825, "golden_shovel", GOLD_SHOVEL);
        register(826, "golden_pickaxe", GOLD_PICKAXE);
        register(827, "golden_axe", GOLD_AXE);
        register(828, "golden_hoe", GOLD_HOE);
        register(869, "golden_helmet", GOLD_HELMET);
        register(870, "golden_chestplate", GOLD_CHESTPLATE);
        register(871, "golden_leggings", GOLD_LEGGINGS);
        register(872, "golden_boots", GOLD_BOOTS);
        //diamond
        /*
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "diamond_pickaxe"), DIAMOND_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "diamond_axe"), DIAMOND_AXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "diamond_hoe"), DIAMOND_HOE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "diamond_shovel"), DIAMOND_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "diamond_sword"), DIAMOND_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "diamond_helmet"), DIAMOND_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "diamond_chestplate"), DIAMOND_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "diamond_leggings"), DIAMOND_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "diamond_boots"), DIAMOND_BOOTS);
        */
        
        register(834, "diamond_sword", DIAMOND_SWORD);
        register(835, "diamond_shovel", DIAMOND_SHOVEL);
        register(836, "diamond_pickaxe", DIAMOND_PICKAXE);
        register(837, "diamond_axe", DIAMOND_AXE);
        register(838, "diamond_hoe", DIAMOND_HOE);
        register(865, "diamond_helmet", DIAMOND_HELMET);
        register(866, "diamond_chestplate", DIAMOND_CHESTPLATE);
        register(867, "diamond_leggings", DIAMOND_LEGGINGS);
        register(868, "diamond_boots", DIAMOND_BOOTS);
        //netherite
        /*
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_pickaxe"), NETHERITE_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_axe"), NETHERITE_AXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_hoe"), NETHERITE_HOE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_shovel"), NETHERITE_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_sword"), NETHERITE_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_helmet"), NETHERITE_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_chestplate"), NETHERITE_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_leggings"), NETHERITE_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_boots"), NETHERITE_BOOTS);
        */
        
        register(839, "netherite_sword", NETHERITE_SWORD);
        register(840, "netherite_shovel", NETHERITE_SHOVEL);
        register(841, "netherite_pickaxe", NETHERITE_PICKAXE);
        register(842, "netherite_axe", NETHERITE_AXE);
        register(843, "netherite_hoe", NETHERITE_HOE);
        register(873, "netherite_helmet", NETHERITE_HELMET);
        register(874, "netherite_chestplate", NETHERITE_CHESTPLATE);
        register(875, "netherite_leggings", NETHERITE_LEGGINGS);
        register(876, "netherite_boots", NETHERITE_BOOTS);
        //endite
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_pickaxe"), ENDITE_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_axe"), ENDITE_AXE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_hoe"), ENDITE_HOE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_shovel"), ENDITE_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_sword"), ENDITE_SWORD);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_helmet"), ENDITE_HELMET);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_chestplate"), ENDITE_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_leggings"), ENDITE_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_boots"), ENDITE_BOOTS);
        //turtle
        //Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "turtle_helmet"), TURTLE_HELMET);
        register(793, "turtle_helmet", TURTLE_HELMET);
        
        NewexpItemUtil.addEquipmentSet("gold_enhanced_gold",NewexpToolMaterials.GOLD_ENHANCEMENT_GOLD,NewexpArmorMaterials.GOLD_ENHANCEMENT_GOLD,false);
        NewexpItemUtil.addEquipmentSet("gold_enhanced_diamond",NewexpToolMaterials.GOLD_ENHANCEMENT_DIAMOND,NewexpArmorMaterials.GOLD_ENHANCEMENT_DIAMOND,false);
        NewexpItemUtil.addEquipmentSet("gold_enhanced_netherite",NewexpToolMaterials.GOLD_ENHANCEMENT_NETHERITE,NewexpArmorMaterials.GOLD_ENHANCEMENT_NETHERITE,true);
        NewexpItemUtil.addEquipmentSet("gold_enhanced_endite",NewexpToolMaterials.GOLD_ENHANCEMENT_ENDITE,NewexpArmorMaterials.GOLD_ENHANCEMENT_ENDITE,false);
        NewexpItemUtil.addEquipmentSet("diamond_enhanced_gold",NewexpToolMaterials.DIAMOND_ENHANCEMENT_GOLD,NewexpArmorMaterials.DIAMOND_ENHANCEMENT_GOLD,false);
        NewexpItemUtil.addEquipmentSet("diamond_enhanced_diamond",NewexpToolMaterials.DIAMOND_ENHANCEMENT_DIAMOND,NewexpArmorMaterials.DIAMOND_ENHANCEMENT_DIAMOND,false);
        NewexpItemUtil.addEquipmentSet("diamond_enhanced_netherite",NewexpToolMaterials.DIAMOND_ENHANCEMENT_NETHERITE,NewexpArmorMaterials.DIAMOND_ENHANCEMENT_NETHERITE,true);
        NewexpItemUtil.addEquipmentSet("diamond_enhanced_endite",NewexpToolMaterials.DIAMOND_ENHANCEMENT_ENDITE,NewexpArmorMaterials.DIAMOND_ENHANCEMENT_ENDITE,false);
        NewexpItemUtil.addEquipmentSet("netherite_enhanced_gold",NewexpToolMaterials.NETHERITE_ENHANCEMENT_GOLD,NewexpArmorMaterials.NETHERITE_ENHANCEMENT_GOLD,false);
        NewexpItemUtil.addEquipmentSet("netherite_enhanced_diamond",NewexpToolMaterials.NETHERITE_ENHANCEMENT_DIAMOND,NewexpArmorMaterials.NETHERITE_ENHANCEMENT_DIAMOND,false);
        NewexpItemUtil.addEquipmentSet("netherite_enhanced_netherite",NewexpToolMaterials.NETHERITE_ENHANCEMENT_NETHERITE,NewexpArmorMaterials.NETHERITE_ENHANCEMENT_NETHERITE,true);
        NewexpItemUtil.addEquipmentSet("netherite_enhanced_endite",NewexpToolMaterials.NETHERITE_ENHANCEMENT_ENDITE,NewexpArmorMaterials.NETHERITE_ENHANCEMENT_ENDITE,false);
        NewexpItemUtil.addEquipmentSet("endite_enhanced_gold",NewexpToolMaterials.ENDITE_ENHANCEMENT_GOLD,NewexpArmorMaterials.ENDITE_ENHANCEMENT_GOLD,false);
        NewexpItemUtil.addEquipmentSet("endite_enhanced_diamond",NewexpToolMaterials.ENDITE_ENHANCEMENT_DIAMOND,NewexpArmorMaterials.ENDITE_ENHANCEMENT_DIAMOND,false);
        NewexpItemUtil.addEquipmentSet("endite_enhanced_netherite",NewexpToolMaterials.ENDITE_ENHANCEMENT_NETHERITE,NewexpArmorMaterials.ENDITE_ENHANCEMENT_NETHERITE,true);
        NewexpItemUtil.addEquipmentSet("endite_enhanced_endite",NewexpToolMaterials.ENDITE_ENHANCEMENT_ENDITE,NewexpArmorMaterials.ENDITE_ENHANCEMENT_ENDITE,false);
        NewexpItemUtil.addEquipmentSet("jeweled",NewexpToolMaterials.JEWELED,NewexpArmorMaterials.JEWELED,false);
        //bloki
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "tab_icon_block"), TAB_ICON_BLOCK);
        //Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "stone_kiln"), STONE_KILN);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "enchanted_netherite_statue"), ENCHANTED_NETHERITE_STATUE);
        Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "magnetic_rail"), MAGNETIC_RAIL);
    }
}