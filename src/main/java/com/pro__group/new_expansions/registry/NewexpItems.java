package com.pro__group.new_expansions.registry;

import com.pro__group.new_expansions.NewExpansions;
import com.pro__group.new_expansions.items.*;
import com.pro__group.new_expansions.materials.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class NewexpItems {
    //itemy
    public static final Item IRON_RINGS = new Item(new Item.Settings());
    public static final Item GEARS = new Item(new Item.Settings());
    public static final Item GEARBOX = new Item(new Item.Settings());
    public static final Item DRILL_HEAD = new Item(new Item.Settings());
    public static final Item DRILL_HANDLE = new Item(new Item.Settings());
    public static final Item ASH = new BoneMealItem(new Item.Settings());
    public static final Item NETHERITE_STATUE = new Item(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON));
    public static final Item ENDITE_STATUE = new Item(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON));
    public static final Item NETHERITE_AMULET = new Item(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON));
    public static final Item ENDITE_AMULET = new Item(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON));
    public static final Item NETHERITE_ARTIFACT = new Item(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON));
    public static final Item ENDITE_ARTIFACT = new Item(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON));
    public static final Item NETHERITE_TOOLS = new Item(new Item.Settings().maxCount(4).rarity(Rarity.RARE));
    public static final Item ENDITE_TOOLS = new Item(new Item.Settings().maxCount(4).rarity(Rarity.RARE));
    //itemy
    public static final NewexpGlintBlockItem ENCHANTED_NETHERITE_STATUE = new NewexpGlintBlockItem(NewexpBlocks.ENCHANTED_NETHERITE_STATUE ,new Item.Settings().maxCount(1).rarity(Rarity.RARE));
    //rudy
    public static final Item SULFUR = new Item(new Item.Settings());
    public static final Item RAW_NERERITE = new Item(new Item.Settings());
    public static final Item REFINED_NERERITE = new Item(new Item.Settings());
    public static final Item RAW_RENEFERITE = new Item(new Item.Settings());
    public static final Item REFINED_RENEFERITE = new Item(new Item.Settings());
    public static final Item ENDITE_INGOT = new Item(new Item.Settings());
    public static final Item ENDITE_SCRAP = new Item(new Item.Settings());
    //jedzenie
    public static final Item MEATY_STEW = new Item(new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(16).saturationModifier(1.2f).build()));
    public static final Item POTATO_SALAD = new Item(new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(13).saturationModifier(1.2f).build()));
    public static final Item FRUIT_MIX = new Item(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(10).saturationModifier(0.6f).build()));
    public static final Item STUFFED_CHICKEN = new Item(new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(12).saturationModifier(1.2f).build()));
    public static final Item FISH_SOUP = new Item(new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(10).saturationModifier(1.8f).build()));
    public static final Item BONE_STOCK = new Item(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(1.2f).build()));
    public static final Item RABBIT_STEW = new Item(new Item.Settings().maxCount(8).food(new FoodComponent.Builder().hunger(12).saturationModifier(1.8f).build()));
    public static final Item MUSHROOM_STEW = new Item(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(7).saturationModifier(1.8f).build()));
    public static final Item BEETROOT_SOUP = new Item(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(8).saturationModifier(1.2f).build()));
    public static final Item BUG = new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().hunger(2).saturationModifier(1.8f).snack().statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 20*20), 1f).build()));
    public static final Item MILK_ICECREAM = new Item(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(1.5f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20*60), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*60), 1f).build()));
    public static final Item CHOCOLATE_ICECREAM = new Item(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(1.5f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*60), 1f).build()));
    public static final Item HONEY_ICECREAM = new Item(new Item.Settings().maxCount(16).food(new FoodComponent.Builder().hunger(4).saturationModifier(1.5f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20*60, 1), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*60), 1f).build()));
    public static final Item SUPPLIES = new Item(new Item.Settings().maxCount(64).food(new FoodComponent.Builder().hunger(8).saturationModifier(0.5f).build()));
    //leczenie
    public static final Item BANDAGE = new NewexpBandageItem(new Item.Settings());
    public static final Item SYRINGE = new NewexpSyringeItem(new Item.Settings());
    public static final Item SPLINTS = new NewexpSplintsItem(new Item.Settings());
    public static final Item SMALL_MEDKIT = new NewexpSmallMedkitItem(new Item.Settings());
    public static final Item MEDKIT = new NewexpMedkitItem(new Item.Settings());

    //płyty
    public static final Item MUSIC_DISC_THE_WAY = new NewexpMusicDiscItem(1, NewexpSounds.MUSIC_DISC_THE_WAY_RECORD, (new Item.Settings()).maxCount(1).rarity(Rarity.RARE));
    public static final Item MUSIC_DISC_THE_WHISPER = new NewexpMusicDiscItem(2, NewexpSounds.MUSIC_DISC_THE_WHISPER_RECORD, (new Item.Settings()).maxCount(1).rarity(Rarity.RARE));
    public static final Item MUSIC_DISC_RESIDENCE_OF_CORRUPTION = new NewexpMusicDiscItem(3, NewexpSounds.MUSIC_DISC_RESIDENCE_OF_CORRUPTION_RECORD, (new Item.Settings()).maxCount(1).rarity(Rarity.RARE));
    //narzędzia
    public static final Item DEDALUS_WINGS = new Item(new Item.Settings());
    public static final ToolItem DRILL = new NewexpDrill( 1, -2.5f,NewexpToolMaterials.DRILL, NewexpTags.DRILL_MINEABLE, new Item.Settings());
    //wooden
    public static final ToolItem WPICKAXE = new NewexpPickaxe(NewexpToolMaterials.W, 1, -2.8f, new Item.Settings());
    public static final ToolItem WAXE = new NewexpAxe(NewexpToolMaterials.W, 5, -3.2f, new Item.Settings());
    public static final ToolItem WHOE = new NewexpHoe(NewexpToolMaterials.W, 0, -3f, new Item.Settings());
    public static final ToolItem WSHOVEL = new NewexpShovel(NewexpToolMaterials.W, 1.5f, -3f, new Item.Settings());
    public static final ToolItem WSWORD = new NewexpSword(NewexpToolMaterials.W, 3, -2.4f, new Item.Settings());
    //stone
    public static final ToolItem SPICKAXE = new NewexpPickaxe(NewexpToolMaterials.S, 1, -2.8f, new Item.Settings());
    public static final ToolItem SAXE = new NewexpAxe(NewexpToolMaterials.S, 5, -3.2f, new Item.Settings());
    public static final ToolItem SHOE = new NewexpHoe(NewexpToolMaterials.S, -1, -2f, new Item.Settings());
    public static final ToolItem SSHOVEL = new NewexpShovel(NewexpToolMaterials.S, 1.5f, -3f, new Item.Settings());
    public static final ToolItem SSWORD = new NewexpSword(NewexpToolMaterials.S, 3, -2.4f, new Item.Settings());
    //iron
    public static final ToolItem IPICKAXE = new NewexpPickaxe(NewexpToolMaterials.I, 1, -2.8f, new Item.Settings());
    public static final ToolItem IAXE = new NewexpAxe(NewexpToolMaterials.I, 5, -3.1f, new Item.Settings());
    public static final ToolItem IHOE = new NewexpHoe(NewexpToolMaterials.I, -2, -1f, new Item.Settings());
    public static final ToolItem ISHOVEL = new NewexpShovel(NewexpToolMaterials.I, 1.5f, -3f, new Item.Settings());
    public static final ToolItem ISWORD = new NewexpSword(NewexpToolMaterials.I, 3, -2.4f, new Item.Settings());
    //emerald
    public static final ToolItem BPICKAXE = new NewexpPickaxe(NewexpToolMaterials.B, 1, -2.8f, new Item.Settings());
    public static final ToolItem BAXE = new NewexpAxe(NewexpToolMaterials.B, 5, -3.1f, new Item.Settings());
    public static final ToolItem BHOE = new NewexpHoe(NewexpToolMaterials.B, -2, -1f, new Item.Settings());
    public static final ToolItem BSHOVEL = new NewexpShovel(NewexpToolMaterials.B, 1.5f, -3f, new Item.Settings());
    public static final ToolItem BSWORD = new NewexpSword(NewexpToolMaterials.B, 3, -2.4f, new Item.Settings());
    //golden
    public static final ToolItem GPICKAXE = new NewexpPickaxe(NewexpToolMaterials.G, 1, -2.8f, new Item.Settings());
    public static final ToolItem GAXE = new NewexpAxe(NewexpToolMaterials.G, 5, -3f, new Item.Settings());
    public static final ToolItem GHOE = new NewexpHoe(NewexpToolMaterials.G, -3, 0f, new Item.Settings());
    public static final ToolItem GSHOVEL = new NewexpShovel(NewexpToolMaterials.G, 1.5f, -3f, new Item.Settings());
    public static final ToolItem GSWORD = new NewexpSword(NewexpToolMaterials.G, 3, -2.4f, new Item.Settings());
    //diamond
    public static final ToolItem DPICKAXE = new NewexpPickaxe(NewexpToolMaterials.D, 1, -2.8f, new Item.Settings());
    public static final ToolItem DAXE = new NewexpAxe(NewexpToolMaterials.D, 5, -3f, new Item.Settings());
    public static final ToolItem DHOE = new NewexpHoe(NewexpToolMaterials.D, -3, 0f, new Item.Settings());
    public static final ToolItem DSHOVEL = new NewexpShovel(NewexpToolMaterials.D, 1.5f, -3f, new Item.Settings());
    public static final ToolItem DSWORD = new NewexpSword(NewexpToolMaterials.D, 3, -2.4f, new Item.Settings());
    //netherite
    public static final ToolItem NPICKAXE = new NewexpPickaxe(NewexpToolMaterials.N, 1, -2.8f, new Item.Settings().fireproof());
    public static final ToolItem NAXE = new NewexpAxe(NewexpToolMaterials.N, 5, -3f, new Item.Settings().fireproof());
    public static final ToolItem NHOE = new NewexpHoe(NewexpToolMaterials.N, -4, 0f, new Item.Settings().fireproof());
    public static final ToolItem NSHOVEL = new NewexpShovel(NewexpToolMaterials.N, 1.5f, -3f, new Item.Settings().fireproof());
    public static final ToolItem NSWORD = new NewexpSword(NewexpToolMaterials.N, 3, -2.4f, new Item.Settings().fireproof());
    //endite
    public static final ToolItem EPICKAXE = new NewexpPickaxe(NewexpToolMaterials.E, 1, -2.8f, new Item.Settings());
    public static final ToolItem EAXE = new NewexpAxe(NewexpToolMaterials.E, 5, -3f, new Item.Settings());
    public static final ToolItem EHOE = new NewexpHoe(NewexpToolMaterials.E, -4, 0f, new Item.Settings());
    public static final ToolItem ESHOVEL = new NewexpShovel(NewexpToolMaterials.E, 1.5f, -3f, new Item.Settings());
    public static final ToolItem ESWORD = new NewexpSword(NewexpToolMaterials.E, 3, -2.4f, new Item.Settings());
    //upgrades
    //gold
    //golden
    public static final ToolItem GGPICKAXE = new NewexpPickaxe(NewexpToolMaterials.GG, 1, -2.8f, new Item.Settings());
    public static final ToolItem GGAXE = new NewexpAxe(NewexpToolMaterials.GG, 5, -3f, new Item.Settings());
    public static final ToolItem GGHOE = new NewexpHoe(NewexpToolMaterials.GG, -3, 0f, new Item.Settings());
    public static final ToolItem GGSHOVEL = new NewexpShovel(NewexpToolMaterials.GG, 1.5f, -3f, new Item.Settings());
    public static final ToolItem GGSWORD = new NewexpSword(NewexpToolMaterials.GG, 3, -2.4f, new Item.Settings());
    //diamond
    public static final ToolItem GDPICKAXE = new NewexpPickaxe(NewexpToolMaterials.GD, 1, -2.8f, new Item.Settings());
    public static final ToolItem GDAXE = new NewexpAxe(NewexpToolMaterials.GD, 5, -3f, new Item.Settings());
    public static final ToolItem GDHOE = new NewexpHoe(NewexpToolMaterials.GD, -3, 0f, new Item.Settings());
    public static final ToolItem GDSHOVEL = new NewexpShovel(NewexpToolMaterials.GD, 1.5f, -3f, new Item.Settings());
    public static final ToolItem GDSWORD = new NewexpSword(NewexpToolMaterials.GD, 3, -2.4f, new Item.Settings());
    //netherite
    public static final ToolItem GNPICKAXE = new NewexpPickaxe(NewexpToolMaterials.GN, 1, -2.8f, new Item.Settings().fireproof());
    public static final ToolItem GNAXE = new NewexpAxe(NewexpToolMaterials.GN, 5, -3f, new Item.Settings().fireproof());
    public static final ToolItem GNHOE = new NewexpHoe(NewexpToolMaterials.GN, -4, 0f, new Item.Settings().fireproof());
    public static final ToolItem GNSHOVEL = new NewexpShovel(NewexpToolMaterials.GN, 1.5f, -3f, new Item.Settings().fireproof());
    public static final ToolItem GNSWORD = new NewexpSword(NewexpToolMaterials.GN, 3, -2.4f, new Item.Settings().fireproof());
    //endite
    public static final ToolItem GEPICKAXE = new NewexpPickaxe(NewexpToolMaterials.GE, 1, -2.8f, new Item.Settings());
    public static final ToolItem GEAXE = new NewexpAxe(NewexpToolMaterials.GE, 5, -3f, new Item.Settings());
    public static final ToolItem GEHOE = new NewexpHoe(NewexpToolMaterials.GE, -4, 0f, new Item.Settings());
    public static final ToolItem GESHOVEL = new NewexpShovel(NewexpToolMaterials.GE, 1.5f, -3f, new Item.Settings());
    public static final ToolItem GESWORD = new NewexpSword(NewexpToolMaterials.GE, 3, -2.4f, new Item.Settings());
    //diamond
    //golden
    public static final ToolItem DGPICKAXE = new NewexpPickaxe(NewexpToolMaterials.DG, 1, -2.8f, new Item.Settings());
    public static final ToolItem DGAXE = new NewexpAxe(NewexpToolMaterials.DG, 5, -3f, new Item.Settings());
    public static final ToolItem DGHOE = new NewexpHoe(NewexpToolMaterials.DG, -3, 0f, new Item.Settings());
    public static final ToolItem DGSHOVEL = new NewexpShovel(NewexpToolMaterials.DG, 1.5f, -3f, new Item.Settings());
    public static final ToolItem DGSWORD = new NewexpSword(NewexpToolMaterials.DG, 3, -2.4f, new Item.Settings());
    //diamond
    public static final ToolItem DDPICKAXE = new NewexpPickaxe(NewexpToolMaterials.DD, 1, -2.8f, new Item.Settings());
    public static final ToolItem DDAXE = new NewexpAxe(NewexpToolMaterials.DD, 5, -3f, new Item.Settings());
    public static final ToolItem DDHOE = new NewexpHoe(NewexpToolMaterials.DD, -3, 0f, new Item.Settings());
    public static final ToolItem DDSHOVEL = new NewexpShovel(NewexpToolMaterials.DD, 1.5f, -3f, new Item.Settings());
    public static final ToolItem DDSWORD = new NewexpSword(NewexpToolMaterials.DD, 3, -2.4f, new Item.Settings());
    //netherite
    public static final ToolItem DNPICKAXE = new NewexpPickaxe(NewexpToolMaterials.DN, 1, -2.8f, new Item.Settings().fireproof());
    public static final ToolItem DNAXE = new NewexpAxe(NewexpToolMaterials.DN, 5, -3f, new Item.Settings().fireproof());
    public static final ToolItem DNHOE = new NewexpHoe(NewexpToolMaterials.DN, -4, 0f, new Item.Settings().fireproof());
    public static final ToolItem DNSHOVEL = new NewexpShovel(NewexpToolMaterials.DN, 1.5f, -3f, new Item.Settings().fireproof());
    public static final ToolItem DNSWORD = new NewexpSword(NewexpToolMaterials.DN, 3, -2.4f, new Item.Settings().fireproof());
    //endite
    public static final ToolItem DEPICKAXE = new NewexpPickaxe(NewexpToolMaterials.DE, 1, -2.8f, new Item.Settings());
    public static final ToolItem DEAXE = new NewexpAxe(NewexpToolMaterials.DE, 5, -3f, new Item.Settings());
    public static final ToolItem DEHOE = new NewexpHoe(NewexpToolMaterials.DE, -4, 0f, new Item.Settings());
    public static final ToolItem DESHOVEL = new NewexpShovel(NewexpToolMaterials.DE, 1.5f, -3f, new Item.Settings());
    public static final ToolItem DESWORD = new NewexpSword(NewexpToolMaterials.DE, 3, -2.4f, new Item.Settings());
    //netherite
    //golden
    public static final ToolItem NGPICKAXE = new NewexpPickaxe(NewexpToolMaterials.NG, 1, -2.8f, new Item.Settings());
    public static final ToolItem NGAXE = new NewexpAxe(NewexpToolMaterials.NG, 5, -3f, new Item.Settings());
    public static final ToolItem NGHOE = new NewexpHoe(NewexpToolMaterials.NG, -3, 0f, new Item.Settings());
    public static final ToolItem NGSHOVEL = new NewexpShovel(NewexpToolMaterials.NG, 1.5f, -3f, new Item.Settings());
    public static final ToolItem NGSWORD = new NewexpSword(NewexpToolMaterials.NG, 3, -2.4f, new Item.Settings());
    //diamond
    public static final ToolItem NDPICKAXE = new NewexpPickaxe(NewexpToolMaterials.ND, 1, -2.8f, new Item.Settings());
    public static final ToolItem NDAXE = new NewexpAxe(NewexpToolMaterials.ND, 5, -3f, new Item.Settings());
    public static final ToolItem NDHOE = new NewexpHoe(NewexpToolMaterials.ND, -3, 0f, new Item.Settings());
    public static final ToolItem NDSHOVEL = new NewexpShovel(NewexpToolMaterials.ND, 1.5f, -3f, new Item.Settings());
    public static final ToolItem NDSWORD = new NewexpSword(NewexpToolMaterials.ND, 3, -2.4f, new Item.Settings());
    //netherite
    public static final ToolItem NNPICKAXE = new NewexpPickaxe(NewexpToolMaterials.NN, 1, -2.8f, new Item.Settings().fireproof());
    public static final ToolItem NNAXE = new NewexpAxe(NewexpToolMaterials.NN, 5, -3f, new Item.Settings().fireproof());
    public static final ToolItem NNHOE = new NewexpHoe(NewexpToolMaterials.NN, -4, 0f, new Item.Settings().fireproof());
    public static final ToolItem NNSHOVEL = new NewexpShovel(NewexpToolMaterials.NN, 1.5f, -3f, new Item.Settings().fireproof());
    public static final ToolItem NNSWORD = new NewexpSword(NewexpToolMaterials.NN, 3, -2.4f, new Item.Settings().fireproof());
    //endite
    public static final ToolItem NEPICKAXE = new NewexpPickaxe(NewexpToolMaterials.NE, 1, -2.8f, new Item.Settings());
    public static final ToolItem NEAXE = new NewexpAxe(NewexpToolMaterials.NE, 5, -3f, new Item.Settings());
    public static final ToolItem NEHOE = new NewexpHoe(NewexpToolMaterials.NE, -4, 0f, new Item.Settings());
    public static final ToolItem NESHOVEL = new NewexpShovel(NewexpToolMaterials.NE, 1.5f, -3f, new Item.Settings());
    public static final ToolItem NESWORD = new NewexpSword(NewexpToolMaterials.NE, 3, -2.4f, new Item.Settings());
    //endite
    //golden
    public static final ToolItem EGPICKAXE = new NewexpPickaxe(NewexpToolMaterials.EG, 1, -2.8f, new Item.Settings());
    public static final ToolItem EGAXE = new NewexpAxe(NewexpToolMaterials.EG, 5, -3f, new Item.Settings());
    public static final ToolItem EGHOE = new NewexpHoe(NewexpToolMaterials.EG, -3, 0f, new Item.Settings());
    public static final ToolItem EGSHOVEL = new NewexpShovel(NewexpToolMaterials.EG, 1.5f, -3f, new Item.Settings());
    public static final ToolItem EGSWORD = new NewexpSword(NewexpToolMaterials.EG, 3, -2.4f, new Item.Settings());
    //diamond
    public static final ToolItem EDPICKAXE = new NewexpPickaxe(NewexpToolMaterials.ED, 1, -2.8f, new Item.Settings());
    public static final ToolItem EDAXE = new NewexpAxe(NewexpToolMaterials.ED, 5, -3f, new Item.Settings());
    public static final ToolItem EDHOE = new NewexpHoe(NewexpToolMaterials.ED, -3, 0f, new Item.Settings());
    public static final ToolItem EDSHOVEL = new NewexpShovel(NewexpToolMaterials.ED, 1.5f, -3f, new Item.Settings());
    public static final ToolItem EDSWORD = new NewexpSword(NewexpToolMaterials.ED, 3, -2.4f, new Item.Settings());
    //netherite
    public static final ToolItem ENPICKAXE = new NewexpPickaxe(NewexpToolMaterials.EN, 1, -2.8f, new Item.Settings().fireproof());
    public static final ToolItem ENAXE = new NewexpAxe(NewexpToolMaterials.EN, 5, -3f, new Item.Settings().fireproof());
    public static final ToolItem ENHOE = new NewexpHoe(NewexpToolMaterials.EN, -4, 0f, new Item.Settings().fireproof());
    public static final ToolItem ENSHOVEL = new NewexpShovel(NewexpToolMaterials.EN, 1.5f, -3f, new Item.Settings().fireproof());
    public static final ToolItem ENSWORD = new NewexpSword(NewexpToolMaterials.EN, 3, -2.4f, new Item.Settings().fireproof());
    //endite
    public static final ToolItem EEPICKAXE = new NewexpPickaxe(NewexpToolMaterials.EE, 1, -2.8f, new Item.Settings());
    public static final ToolItem EEAXE = new NewexpAxe(NewexpToolMaterials.EE, 5, -3f, new Item.Settings());
    public static final ToolItem EEHOE = new NewexpHoe(NewexpToolMaterials.EE, -4, 0f, new Item.Settings());
    public static final ToolItem EESHOVEL = new NewexpShovel(NewexpToolMaterials.EE, 1.5f, -3f, new Item.Settings());
    public static final ToolItem EESWORD = new NewexpSword(NewexpToolMaterials.EE, 3, -2.4f, new Item.Settings());


    //zbroje
    //lether
    public static final ArmorItem LHELMET = new ArmorItem(NewexpArmorMaterials.L, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem LCHESTPALTE = new ArmorItem(NewexpArmorMaterials.L, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem LLEGGINGS = new ArmorItem(NewexpArmorMaterials.L, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem LBOOTS = new ArmorItem(NewexpArmorMaterials.L, EquipmentSlot.FEET, new Item.Settings());
    //chain
    public static final ArmorItem CHELMET = new ArmorItem(NewexpArmorMaterials.C, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem CCHESTPALTE = new ArmorItem(NewexpArmorMaterials.C, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem CLEGGINGS = new ArmorItem(NewexpArmorMaterials.C, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem CBOOTS = new ArmorItem(NewexpArmorMaterials.C, EquipmentSlot.FEET, new Item.Settings());
    //iron
    public static final ArmorItem IHELMET = new ArmorItem(NewexpArmorMaterials.I, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem ICHESTPALTE = new ArmorItem(NewexpArmorMaterials.I, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem ILEGGINGS = new ArmorItem(NewexpArmorMaterials.I, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem IBOOTS = new ArmorItem(NewexpArmorMaterials.I, EquipmentSlot.FEET, new Item.Settings());
    //emerald
    public static final ArmorItem BHELMET = new ArmorItem(NewexpArmorMaterials.B, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem BCHESTPALTE = new ArmorItem(NewexpArmorMaterials.B, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem BLEGGINGS = new ArmorItem(NewexpArmorMaterials.B, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem BBOOTS = new ArmorItem(NewexpArmorMaterials.B, EquipmentSlot.FEET, new Item.Settings());
    //golden
    public static final ArmorItem GHELMET = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem GCHESTPALTE = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem GLEGGINGS = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem GBOOTS = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.FEET, new Item.Settings());
    //diamond
    public static final ArmorItem DHELMET = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem DCHESTPALTE = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem DLEGGINGS = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem DBOOTS = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.FEET, new Item.Settings());
    //netherite
    public static final ArmorItem NHELMET = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.HEAD, new Item.Settings().fireproof());
    public static final ArmorItem NCHESTPALTE = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.CHEST, new Item.Settings().fireproof());
    public static final ArmorItem NLEGGINGS = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.LEGS, new Item.Settings().fireproof());
    public static final ArmorItem NBOOTS = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.FEET, new Item.Settings().fireproof());
    //endite
    public static final ArmorItem EHELMET = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem ECHESTPALTE = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem ELEGGINGS = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem EBOOTS = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.FEET, new Item.Settings());
    //turtle
    public static final ArmorItem THELMET = new ArmorItem(NewexpArmorMaterials.T, EquipmentSlot.HEAD, new Item.Settings());
    //upgrades
    //gold
    //golden
    public static final ArmorItem GGHELMET = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem GGCHESTPALTE = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem GGLEGGINGS = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem GGBOOTS = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.FEET, new Item.Settings());
    //diamond
    public static final ArmorItem GDHELMET = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem GDCHESTPALTE = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem GDLEGGINGS = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem GDBOOTS = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.FEET, new Item.Settings());
    //netherite
    public static final ArmorItem GNHELMET = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.HEAD, new Item.Settings().fireproof());
    public static final ArmorItem GNCHESTPALTE = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.CHEST, new Item.Settings().fireproof());
    public static final ArmorItem GNLEGGINGS = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.LEGS, new Item.Settings().fireproof());
    public static final ArmorItem GNBOOTS = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.FEET, new Item.Settings().fireproof());
    //endite
    public static final ArmorItem GEHELMET = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem GECHESTPALTE = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem GELEGGINGS = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem GEBOOTS = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.FEET, new Item.Settings());
    //diamond
    //golden
    public static final ArmorItem DGHELMET = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem DGCHESTPALTE = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem DGLEGGINGS = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem DGBOOTS = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.FEET, new Item.Settings());
    //diamond
    public static final ArmorItem DDHELMET = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem DDCHESTPALTE = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem DDLEGGINGS = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem DDBOOTS = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.FEET, new Item.Settings());
    //netherite
    public static final ArmorItem DNHELMET = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.HEAD, new Item.Settings().fireproof());
    public static final ArmorItem DNCHESTPALTE = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.CHEST, new Item.Settings().fireproof());
    public static final ArmorItem DNLEGGINGS = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.LEGS, new Item.Settings().fireproof());
    public static final ArmorItem DNBOOTS = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.FEET, new Item.Settings().fireproof());
    //endite
    public static final ArmorItem DEHELMET = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem DECHESTPALTE = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem DELEGGINGS = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem DEBOOTS = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.FEET, new Item.Settings());
    //netherite
    //golden
    public static final ArmorItem NGHELMET = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem NGCHESTPALTE = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem NGLEGGINGS = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem NGBOOTS = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.FEET, new Item.Settings());
    //diamond
    public static final ArmorItem NDHELMET = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem NDCHESTPALTE = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem NDLEGGINGS = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem NDBOOTS = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.FEET, new Item.Settings());
    //netherite
    public static final ArmorItem NNHELMET = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.HEAD, new Item.Settings().fireproof());
    public static final ArmorItem NNCHESTPALTE = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.CHEST, new Item.Settings().fireproof());
    public static final ArmorItem NNLEGGINGS = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.LEGS, new Item.Settings().fireproof());
    public static final ArmorItem NNBOOTS = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.FEET, new Item.Settings().fireproof());
    //endite
    public static final ArmorItem NEHELMET = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem NECHESTPALTE = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem NELEGGINGS = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem NEBOOTS = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.FEET, new Item.Settings());
    //endite
    //golden
    public static final ArmorItem EGHELMET = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem EGCHESTPALTE = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem EGLEGGINGS = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem EGBOOTS = new ArmorItem(NewexpArmorMaterials.G, EquipmentSlot.FEET, new Item.Settings());
    //diamond
    public static final ArmorItem EDHELMET = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem EDCHESTPALTE = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem EDLEGGINGS = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem EDBOOTS = new ArmorItem(NewexpArmorMaterials.D, EquipmentSlot.FEET, new Item.Settings());
    //netherite
    public static final ArmorItem ENHELMET = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.HEAD, new Item.Settings().fireproof());
    public static final ArmorItem ENCHESTPALTE = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.CHEST, new Item.Settings().fireproof());
    public static final ArmorItem ENLEGGINGS = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.LEGS, new Item.Settings().fireproof());
    public static final ArmorItem ENBOOTS = new ArmorItem(NewexpArmorMaterials.N, EquipmentSlot.FEET, new Item.Settings().fireproof());
    //endite
    public static final ArmorItem EEHELMET = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.HEAD, new Item.Settings());
    public static final ArmorItem EECHESTPALTE = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.CHEST, new Item.Settings());
    public static final ArmorItem EELEGGINGS = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.LEGS, new Item.Settings());
    public static final ArmorItem EEBOOTS = new ArmorItem(NewexpArmorMaterials.E, EquipmentSlot.FEET, new Item.Settings());

    //bloki
    public static final BlockItem SULFUR_ORE = new BlockItem(NewexpBlocks.SULFUR_ORE, new Item.Settings());
    public static final BlockItem SULFUR_BLOCK = new BlockItem(NewexpBlocks.SULFUR_BLOCK, new Item.Settings());
    public static final BlockItem NERERITE_ORE = new BlockItem(NewexpBlocks.NERERITE_ORE, new Item.Settings());
    public static final BlockItem RENEFERITE_ORE = new BlockItem(NewexpBlocks.RENEFERITE_ORE, new Item.Settings());
    public static final BlockItem SUPPLIES_BLOCK = new BlockItem(NewexpBlocks.SUPPLIES_BLOCK, new Item.Settings());
    public static final BlockItem ENDITE_BLOCK = new BlockItem(NewexpBlocks.ENDITE_BLOCK, new Item.Settings());
    public static final BlockItem BURNED_LOG = new BlockItem(NewexpBlocks.BURNED_LOG, new Item.Settings());
    public static final BlockItem BURNED_WOOD = new BlockItem(NewexpBlocks.BURNED_WOOD, new Item.Settings());
    public static final BlockItem BURNED_PLANKS = new BlockItem(NewexpBlocks.BURNED_PLANKS, new Item.Settings());
    public static final BlockItem BURNED_SLAB = new BlockItem(NewexpBlocks.BURNED_SLAB, new Item.Settings());
    public static final BlockItem BURNED_STAIRS = new BlockItem(NewexpBlocks.BURNED_STAIRS, new Item.Settings());
    public static final BlockItem ASH_BLOCK = new BlockItem(NewexpBlocks.ASH_BLOCK, new Item.Settings());
    public static final BlockItem STONE_KILN = new BlockItem(NewexpBlocks.STONE_KILN, new Item.Settings());

    public static void ItemsRegister(){
        //itemy
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "iron_rings"), IRON_RINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gears"), GEARS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gearbox"), GEARBOX);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "drill_head"), DRILL_HEAD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "drill_handle"), DRILL_HANDLE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ash"), ASH);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_statue"), NETHERITE_STATUE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_statue"), ENDITE_STATUE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_amulet"), NETHERITE_AMULET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_amulet"), ENDITE_AMULET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_artifact"), NETHERITE_ARTIFACT);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_artifact"), ENDITE_ARTIFACT);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "netherite_tools"), NETHERITE_TOOLS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_tools"), ENDITE_TOOLS);
        //rudy i pochodne
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "sulfur"), SULFUR);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "raw_nererite"), RAW_NERERITE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "refined_nererite"), REFINED_NERERITE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "raw_reneferite"), RAW_RENEFERITE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "refined_reneferite"), REFINED_RENEFERITE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_ingot"), ENDITE_INGOT);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_scrap"), ENDITE_SCRAP);
        //jedzenie
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "meaty_stew"), MEATY_STEW);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "potato_salad"), POTATO_SALAD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "fruit_mix"), FRUIT_MIX);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "stuffed_chicken"), STUFFED_CHICKEN);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "fish_soup"), FISH_SOUP);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "bone_stock"), BONE_STOCK);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "rabbit_stew"), RABBIT_STEW);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "mushroom_stew"), MUSHROOM_STEW);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "beetroot_soup"), BEETROOT_SOUP);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "bug"), BUG);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "milk_icecream"), MILK_ICECREAM);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "chocolate_icecream"), CHOCOLATE_ICECREAM);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "honey_icecream"), HONEY_ICECREAM);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "supplies_block"), SUPPLIES_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "supplies"), SUPPLIES);
        //leczenie
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "bandage"), BANDAGE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "syringe"), SYRINGE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "splints"), SPLINTS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "small_medkit"), SMALL_MEDKIT);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "medkit"), MEDKIT);
        //płyty
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "music_disc_the_way"), MUSIC_DISC_THE_WAY);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "music_disc_the_whisper"), MUSIC_DISC_THE_WHISPER);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "music_disc_residence_of_corruption"), MUSIC_DISC_RESIDENCE_OF_CORRUPTION);
        //narzędzia
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "drill"), DRILL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dedalus_wings"), DEDALUS_WINGS);
        //wood and lether
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "wpickaxe"), WPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "waxe"), WAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "whoe"), WHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "wshovel"), WSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "wsword"), WSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "lhelmet"), LHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "lchestplate"), LCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "lleggings"), LLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "lboots"), LBOOTS);
        //stone and chain
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "spickaxe"), SPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "saxe"), SAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "shoe"), SHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "sshovel"), SSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ssword"), SSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "chelmet"), CHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "cchestplate"), CCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "cleggings"), CLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "cboots"), CBOOTS);
        //iron
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ipickaxe"), IPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "iaxe"), IAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ihoe"), IHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ishovel"), ISHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "isword"), ISWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ihelmet"), IHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ichestplate"), ICHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ileggings"), ILEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "iboots"), IBOOTS);
        //emerald
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "bpickaxe"), BPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "baxe"), BAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "bhoe"), BHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "bshovel"), BSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "bsword"), BSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "bhelmet"), BHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "bchestplate"), BCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "bleggings"), BLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "bboots"), BBOOTS);
        //gold
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gpickaxe"), GPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gaxe"), GAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ghoe"), GHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gshovel"), GSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gsword"), GSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ghelmet"), GHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gchestplate"), GCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gleggings"), GLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gboots"), GBOOTS);
        //diamond
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dpickaxe"), DPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "daxe"), DAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dhoe"), DHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dshovel"), DSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dsword"), DSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dhelmet"), DHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dchestplate"), DCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dleggings"), DLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dboots"), DBOOTS);
        //netherite
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "npickaxe"), NPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "naxe"), NAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nhoe"), NHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nshovel"), NSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nsword"), NSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nhelmet"), NHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nchestplate"), NCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nleggings"), NLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nboots"), NBOOTS);
        //endite
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "epickaxe"), EPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eaxe"), EAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ehoe"), EHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eshovel"), ESHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "esword"), ESWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ehelmet"), EHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "echestplate"), ECHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eleggings"), ELEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eboots"), EBOOTS);
        //turtle
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "thelmet"), THELMET);
        //upgaredy
        //gold
        //gold
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ggpickaxe"), GGPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ggaxe"), GGAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gghoe"), GGHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ggshovel"), GGSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ggsword"), GGSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gghelmet"), GGHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ggchestplate"), GGCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ggleggings"), GGLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ggboots"), GGBOOTS);
        //diamond
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gdpickaxe"), GDPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gdaxe"), GDAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gdhoe"), GDHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gdshovel"), GDSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gdsword"), GDSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gdhelmet"), GDHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gdchestplate"), GDCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gdleggings"), GDLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gdboots"), GDBOOTS);
        //netherite
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gnpickaxe"), GNPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gnaxe"), GNAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gnhoe"), GNHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gnshovel"), GNSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gnsword"), GNSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gnhelmet"), GNHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gnchestplate"), GNCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gnleggings"), GNLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gnboots"), GNBOOTS);
        //endite
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gepickaxe"), GEPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "geaxe"), GEAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gehoe"), GEHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "geshovel"), GESHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gesword"), GESWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gehelmet"), GEHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "gechestplate"), GECHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "geleggings"), GELEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "geboots"), GEBOOTS);
        //diamond
        //gold
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dgpickaxe"), DGPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dgaxe"), DGAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dghoe"), DGHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dgshovel"), DGSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dgsword"), DGSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dghelmet"), DGHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dgchestplate"), DGCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dgleggings"), DGLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dgboots"), DGBOOTS);
        //diamond
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ddpickaxe"), DDPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ddaxe"), DDAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ddhoe"), DDHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ddshovel"), DDSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ddsword"), DDSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ddhelmet"), DDHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ddchestplate"), DDCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ddleggings"), DDLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ddboots"), DDBOOTS);
        //netherite
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dnpickaxe"), DNPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dnaxe"), DNAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dnhoe"), DNHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dnshovel"), DNSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dnsword"), DNSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dnhelmet"), DNHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dnchestplate"), DNCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dnleggings"), DNLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dnboots"), DNBOOTS);
        //endite
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "depickaxe"), DEPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "deaxe"), DEAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dehoe"), DEHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "deshovel"), DESHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "desword"), DESWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dehelmet"), DEHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "dechestplate"), DECHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "deleggings"), DELEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "deboots"), DEBOOTS);
        //netherite
        //gold
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ngpickaxe"), NGPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ngaxe"), NGAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nghoe"), NGHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ngshovel"), NGSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ngsword"), NGSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nghelmet"), NGHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ngchestplate"), NGCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ngleggings"), NGLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ngboots"), NGBOOTS);
        //diamond
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ndpickaxe"), NDPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ndaxe"), NDAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ndhoe"), NDHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ndshovel"), NDSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ndsword"), NDSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ndhelmet"), NDHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ndchestplate"), NDCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ndleggings"), NDLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ndboots"), NDBOOTS);
        //netherite
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nnpickaxe"), NNPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nnaxe"), NNAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nnhoe"), NNHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nnshovel"), NNSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nnsword"), NNSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nnhelmet"), NNHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nnchestplate"), NNCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nnleggings"), NNLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nnboots"), NNBOOTS);
        //endite
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nepickaxe"), NEPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "neaxe"), NEAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nehoe"), NEHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "neshovel"), NESHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nesword"), NESWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nehelmet"), NEHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nechestplate"), NECHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "neleggings"), NELEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "neboots"), NEBOOTS);
        //endite
        //gold
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "egpickaxe"), EGPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "egaxe"), EGAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eghoe"), EGHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "egshovel"), EGSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "egsword"), EGSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eghelmet"), EGHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "egchestplate"), EGCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "egleggings"), EGLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "egboots"), EGBOOTS);
        //diamond
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "edpickaxe"), EDPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "edaxe"), EDAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "edhoe"), EDHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "edshovel"), EDSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "edsword"), EDSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "edhelmet"), EDHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "edchestplate"), EDCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "edleggings"), EDLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "edboots"), EDBOOTS);
        //netherite
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "enpickaxe"), ENPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "enaxe"), ENAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "enhoe"), ENHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "enshovel"), ENSHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ensword"), ENSWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "enhelmet"), ENHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "enchestplate"), ENCHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "enleggings"), ENLEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "enboots"), ENBOOTS);
        //endite
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eepickaxe"), EEPICKAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eeaxe"), EEAXE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eehoe"), EEHOE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eeshovel"), EESHOVEL);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eesword"), EESWORD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eehelmet"), EEHELMET);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eechestplate"), EECHESTPALTE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eeleggings"), EELEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "eeboots"), EEBOOTS);
        //bloki
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "sulfur_ore"), SULFUR_ORE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "sulfur_block"), SULFUR_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "nererite_ore"), NERERITE_ORE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "reneferite_ore"), RENEFERITE_ORE);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "endite_block"), ENDITE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "burned_log"), BURNED_LOG);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "burned_wood"), BURNED_WOOD);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "burned_planks"), BURNED_PLANKS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "burned_slab"), BURNED_SLAB);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "burned_stairs"), BURNED_STAIRS);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "ash_block"), ASH_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "stone_kiln"), STONE_KILN);
        Registry.register(Registry.ITEM, new Identifier(NewExpansions.MOD_ID, "enchanted_netherite_statue"), ENCHANTED_NETHERITE_STATUE);
    }
}