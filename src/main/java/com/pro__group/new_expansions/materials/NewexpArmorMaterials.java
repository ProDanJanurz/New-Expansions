package com.pro__group.new_expansions.materials;

import com.pro__group.new_expansions.registry.NewexpItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum NewexpArmorMaterials implements ArmorMaterial {

    L("leather", 2, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.LEATHER);
    }),
    C("chainmail", 4, new int[]{1, 3, 4, 2}, 5, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(NewexpItems.IRON_RINGS);
    }),
    I("iron", 12, new int[]{2, 4, 5, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    B("emerald", 12, new int[]{2, 5, 6, 2}, 5, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.EMERALD);
    }),
    G("gold", 6, new int[]{2, 5, 7, 2}, 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F, 0.2F, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    D("diamond", 24, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    N("netherite", 64, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    E("endite", 16, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1.0F, 0.1F, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    T("turtle", 10, new int[]{2, 5, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 1.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.SCUTE);
    }),
    //upgrades
    //gold
    GG("gold", 6, new int[]{2, 5, 7, 2}, 40, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F, 0.3F, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    GD("diamond", 24, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.1F, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    GN("netherite", 64, new int[]{3, 6, 8, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.2F, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    GE("endite", 16, new int[]{3, 6, 8, 3}, 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1.0F, 0.2F, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    //diamond
    DG("gold", 7, new int[]{2, 5, 7, 2}, 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F, 0.2F, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    DD("diamond", 27, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    DN("netherite", 72, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    DE("endite", 18, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1.0F, 0.1F, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    //netherite
    NG("gold", 8, new int[]{2, 5, 7, 2}, 35, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F, 0.2F, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    ND("diamond", 30, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    NN("netherite", 80, new int[]{3, 6, 8, 3}, 25, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    NE("endite", 20, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1.0F, 0.1F, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    //endite
    EG("gold", 6, new int[]{2, 5, 7, 2}, 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.0F, 0.2F, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    ED("diamond", 24, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    EN("netherite", 64, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    EE("endite", 16, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 1.0F, 0.1F, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    });

    private static final int[] BASE_DURABILITY = new int[]{27, 30, 32, 24};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private NewexpArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy(repairIngredientSupplier);
    }

    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
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

    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

}
