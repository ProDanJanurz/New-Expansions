package net.new_expansions.materials;

import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.Util;
import net.new_expansions.items.equipment.NewexpArmorItem;
import net.new_expansions.registry.NewexpItems;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum NewexpArmorMaterials implements StringIdentifiable, NewexpArmorMaterial {

    LEATHER("leather", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 54);
        map.put(NewexpArmorItem.Type.LEGGINGS, 60);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 64);
        map.put(NewexpArmorItem.Type.HELMET, 48);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1);
        map.put(NewexpArmorItem.Type.LEGGINGS, 2);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 2);
        map.put(NewexpArmorItem.Type.HELMET, 1);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, () -> {
        return Ingredient.ofItems(Items.LEATHER);
    }),
    CHAINMAIL("chainmail", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 108);
        map.put(NewexpArmorItem.Type.LEGGINGS, 120);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 128);
        map.put(NewexpArmorItem.Type.HELMET, 96);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1);
        map.put(NewexpArmorItem.Type.LEGGINGS, 3);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 3);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }),(EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> {
        return Ingredient.ofItems(NewexpItems.IRON_RINGS);
    }),
    COPPER("copper", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 81);
        map.put(NewexpArmorItem.Type.LEGGINGS, 90);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 96);
        map.put(NewexpArmorItem.Type.HELMET, 72);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1);
        map.put(NewexpArmorItem.Type.LEGGINGS, 3);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 4);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }),(EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }),
    IRON("iron", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 135);
        map.put(NewexpArmorItem.Type.LEGGINGS, 150);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 160);
        map.put(NewexpArmorItem.Type.HELMET, 120);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2);
        map.put(NewexpArmorItem.Type.LEGGINGS, 4);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 5);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    EMERALD("emerald", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 216);
        map.put(NewexpArmorItem.Type.LEGGINGS, 240);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 256);
        map.put(NewexpArmorItem.Type.HELMET, 192);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2);
        map.put(NewexpArmorItem.Type.LEGGINGS, 5);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 6);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 5, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> {
        return Ingredient.ofItems(Items.EMERALD);
    }),
    GOLD("gold", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 216);
        map.put(NewexpArmorItem.Type.LEGGINGS, 240);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 256);
        map.put(NewexpArmorItem.Type.HELMET, 192);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2);
        map.put(NewexpArmorItem.Type.LEGGINGS, 5);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 7);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2);
        map.put(NewexpArmorItem.Type.LEGGINGS, 3);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 5);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }),(EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    DIAMOND("diamond", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 864);
        map.put(NewexpArmorItem.Type.LEGGINGS, 960);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1024);
        map.put(NewexpArmorItem.Type.HELMET, 768);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 2.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 2.0F);
        map.put(NewexpArmorItem.Type.HELMET, 2.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    NETHERITE("netherite", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1728);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1920);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 2048);
        map.put(NewexpArmorItem.Type.HELMET, 1536);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1);
        map.put(NewexpArmorItem.Type.HELMET, 1);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 3.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 3.0F);
        map.put(NewexpArmorItem.Type.HELMET, 3.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.1F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.1F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.1F);
        map.put(NewexpArmorItem.Type.HELMET, 0.1F);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    ENDITE("endite", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 432);
        map.put(NewexpArmorItem.Type.LEGGINGS, 480);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 512);
        map.put(NewexpArmorItem.Type.HELMET, 384);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1.0F);
        map.put(NewexpArmorItem.Type.HELMET, 1.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.1F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.1F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.1F);
        map.put(NewexpArmorItem.Type.HELMET, 0.1F);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    TURTLE("turtle", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 240);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 1.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 10, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, () -> {
        return Ingredient.ofItems(Items.SCUTE);
    }),
    JEWELED("jeweled", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1728);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1920);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 2048);
        map.put(NewexpArmorItem.Type.HELMET, 1536);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 4);
        map.put(NewexpArmorItem.Type.LEGGINGS, 5);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 7);
        map.put(NewexpArmorItem.Type.HELMET, 4);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 5.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 5.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 5.0F);
        map.put(NewexpArmorItem.Type.HELMET, 5.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.2F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.2F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.2F);
        map.put(NewexpArmorItem.Type.HELMET, 0.2F);
    }), 100, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> {
        return Ingredient.ofItems(NewexpItems.JEWELED_ALLOY);
    }),
    //upgrades
    //gold
    GOLD_ENHANCEMENT_GOLD("gold_enhancement_gold", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 216);
        map.put(NewexpArmorItem.Type.LEGGINGS, 240);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 256);
        map.put(NewexpArmorItem.Type.HELMET, 192);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2);
        map.put(NewexpArmorItem.Type.LEGGINGS, 5);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 7);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 4);
        map.put(NewexpArmorItem.Type.LEGGINGS, 5);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 7);
        map.put(NewexpArmorItem.Type.HELMET, 4);
    }),(EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 40, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    GOLD_ENHANCEMENT_DIAMOND("gold_enhancement_diamond", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 864);
        map.put(NewexpArmorItem.Type.LEGGINGS, 960);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1024);
        map.put(NewexpArmorItem.Type.HELMET, 768);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1);
        map.put(NewexpArmorItem.Type.HELMET, 1);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 2.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 2.0F);
        map.put(NewexpArmorItem.Type.HELMET, 2.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    GOLD_ENHANCEMENT_NETHERITE("gold_enhancement_netherite", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1728);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1920);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 2048);
        map.put(NewexpArmorItem.Type.HELMET, 1536);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2);
        map.put(NewexpArmorItem.Type.LEGGINGS, 2);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 2);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 3.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 3.0F);
        map.put(NewexpArmorItem.Type.HELMET, 3.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.1F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.1F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.1F);
        map.put(NewexpArmorItem.Type.HELMET, 0.1F);
    }), 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    GOLD_ENHANCEMENT_ENDITE("gold_enhancement_endite", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 432);
        map.put(NewexpArmorItem.Type.LEGGINGS, 480);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 512);
        map.put(NewexpArmorItem.Type.HELMET, 384);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1);
        map.put(NewexpArmorItem.Type.HELMET, 1);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1.0F);
        map.put(NewexpArmorItem.Type.HELMET, 1.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.1F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.1F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.1F);
        map.put(NewexpArmorItem.Type.HELMET, 0.1F);
    }), 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    //diamond
    DIAMOND_ENHANCEMENT_GOLD("diamond_enhancement_gold", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 270);
        map.put(NewexpArmorItem.Type.LEGGINGS, 300);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 320);
        map.put(NewexpArmorItem.Type.HELMET, 240);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2);
        map.put(NewexpArmorItem.Type.LEGGINGS, 5);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 7);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2);
        map.put(NewexpArmorItem.Type.LEGGINGS, 3);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 5);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }),(EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    DIAMOND_ENHANCEMENT_DIAMOND("diamond_enhancement_diamond", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1080);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1200);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1280);
        map.put(NewexpArmorItem.Type.HELMET, 960);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 2.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 2.0F);
        map.put(NewexpArmorItem.Type.HELMET, 2.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    DIAMOND_ENHANCEMENT_NETHERITE("diamond_enhancement_netherite", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2160);
        map.put(NewexpArmorItem.Type.LEGGINGS, 2040);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1560);
        map.put(NewexpArmorItem.Type.HELMET, 1920);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1);
        map.put(NewexpArmorItem.Type.HELMET, 1);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 3.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 3.0F);
        map.put(NewexpArmorItem.Type.HELMET, 3.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.1F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.1F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.1F);
        map.put(NewexpArmorItem.Type.HELMET, 0.1F);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    DIAMOND_ENHANCEMENT_ENDITE("diamond_enhancement_endite", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 540);
        map.put(NewexpArmorItem.Type.LEGGINGS, 600);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 640);
        map.put(NewexpArmorItem.Type.HELMET, 480);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1.0F);
        map.put(NewexpArmorItem.Type.HELMET, 1.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.1F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.1F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.1F);
        map.put(NewexpArmorItem.Type.HELMET, 0.1F);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    //netherite
    NETHERITE_ENHANCEMENT_GOLD("netherite_enhancement_gold", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 324);
        map.put(NewexpArmorItem.Type.LEGGINGS, 360);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 384);
        map.put(NewexpArmorItem.Type.HELMET, 378);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2);
        map.put(NewexpArmorItem.Type.LEGGINGS, 5);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 7);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2);
        map.put(NewexpArmorItem.Type.LEGGINGS, 3);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 5);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }),(EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 35, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    NETHERITE_ENHANCEMENT_DIAMOND("netherite_enhancement_diamond", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1296);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1440);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1536);
        map.put(NewexpArmorItem.Type.HELMET, 1152);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 2.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 2.0F);
        map.put(NewexpArmorItem.Type.HELMET, 2.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    NETHERITE_ENHANCEMENT_NETHERITE("netherite_enhancement_netherite", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2592);
        map.put(NewexpArmorItem.Type.LEGGINGS, 2880);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 3072);
        map.put(NewexpArmorItem.Type.HELMET, 2304);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1);
        map.put(NewexpArmorItem.Type.HELMET, 1);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 3.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 3.0F);
        map.put(NewexpArmorItem.Type.HELMET, 3.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.1F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.1F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.1F);
        map.put(NewexpArmorItem.Type.HELMET, 0.1F);
    }), 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    NETHERITE_ENHANCEMENT_ENDITE("netherite_enhancement_endite", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 648);
        map.put(NewexpArmorItem.Type.LEGGINGS, 720);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 768);
        map.put(NewexpArmorItem.Type.HELMET, 576);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1.0F);
        map.put(NewexpArmorItem.Type.HELMET, 1.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.1F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.1F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.1F);
        map.put(NewexpArmorItem.Type.HELMET, 0.1F);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    //endite
    ENDITE_ENHANCEMENT_GOLD("endite_enhancement_gold", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 216);
        map.put(NewexpArmorItem.Type.LEGGINGS, 240);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 256);
        map.put(NewexpArmorItem.Type.HELMET, 192);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2);
        map.put(NewexpArmorItem.Type.LEGGINGS, 5);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 7);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2);
        map.put(NewexpArmorItem.Type.LEGGINGS, 3);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 5);
        map.put(NewexpArmorItem.Type.HELMET, 2);
    }),(EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    ENDITE_ENHANCEMENT_DIAMOND("endite_enhancement_diamond", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 864);
        map.put(NewexpArmorItem.Type.LEGGINGS, 960);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1024);
        map.put(NewexpArmorItem.Type.HELMET, 768);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 2.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 2.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 2.0F);
        map.put(NewexpArmorItem.Type.HELMET, 2.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.0F);
        map.put(NewexpArmorItem.Type.HELMET, 0.0F);
    }), 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    ENDITE_ENHANCEMENT_NETHERITE("endite_enhancement_netherite", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1728);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1920);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 2048);
        map.put(NewexpArmorItem.Type.HELMET, 1536);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1);
        map.put(NewexpArmorItem.Type.HELMET, 1);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 3.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 3.0F);
        map.put(NewexpArmorItem.Type.HELMET, 3.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.1F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.1F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.1F);
        map.put(NewexpArmorItem.Type.HELMET, 0.1F);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    ENDITE_ENHANCEMENT_ENDITE("endite_enhancement_endite", (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 432);
        map.put(NewexpArmorItem.Type.LEGGINGS, 480);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 512);
        map.put(NewexpArmorItem.Type.HELMET, 384);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 3);
        map.put(NewexpArmorItem.Type.LEGGINGS, 6);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 8);
        map.put(NewexpArmorItem.Type.HELMET, 3);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0);
        map.put(NewexpArmorItem.Type.HELMET, 0);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 1.0F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 1.0F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 1.0F);
        map.put(NewexpArmorItem.Type.HELMET, 1.0F);
    }), (EnumMap) Util.make(new EnumMap(NewexpArmorItem.Type.class), (map) -> {
        map.put(NewexpArmorItem.Type.BOOTS, 0.1F);
        map.put(NewexpArmorItem.Type.LEGGINGS, 0.1F);
        map.put(NewexpArmorItem.Type.CHESTPLATE, 0.1F);
        map.put(NewexpArmorItem.Type.HELMET, 0.1F);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    });
    
    public static final EnumCodec<NewexpArmorMaterials> CODEC = StringIdentifiable.createCodec(NewexpArmorMaterials::values);
    
    private final String name;
    private final EnumMap<NewexpArmorItem.Type, Integer> durability;
    private final EnumMap<NewexpArmorItem.Type, Integer> protection;
    private final EnumMap<NewexpArmorItem.Type, Integer> trueProtection;
    private final EnumMap<NewexpArmorItem.Type, Float> toughness;
    private final EnumMap<NewexpArmorItem.Type, Float> knockbackResistance;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final Lazy<Ingredient> repairIngredientSupplier;

    NewexpArmorMaterials(String name, EnumMap durability, EnumMap protection, EnumMap trueProtection, EnumMap toughness, EnumMap knockbackResistance, int enchantability, SoundEvent equipSound, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durability = durability;
        this.protection = protection;
        this.trueProtection = trueProtection;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String asString() {
        return this.name;
    }
    
    public int getDurability(NewexpArmorItem.Type type) {
        return (Integer)this.durability.get(type);
    }
    
    public int getProtection(NewexpArmorItem.Type type) {
        return (Integer)this.protection.get(type);
    }
    
    public int getTrueProtection(NewexpArmorItem.Type type) {
        return (Integer)this.trueProtection.get(type);
    }
    
    public float getToughness(NewexpArmorItem.Type type) {
        return (Float) this.toughness.get(type);
    }
    
    public float getKnockbackResistance(NewexpArmorItem.Type type) {
        return (Float) this.knockbackResistance.get(type);
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient) this.repairIngredientSupplier.get();
    }
}