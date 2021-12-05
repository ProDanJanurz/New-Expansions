package com.pro__group.new_expansions.materials;

import com.pro__group.new_expansions.registry.NewexpItems;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum NewexpToolMaterials implements ToolMaterial {

    W(0, 64, 1.0F, 0.0F, 20, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }),
    S(1, 128, 2.0F, 1.0F, 5, () -> {
        return Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS);
    }),
    I(2, 512, 4.0F, 2.0F, 15, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    B(2, 512, 6.0F, 2.0F, 5, () -> {
        return Ingredient.ofItems(Items.EMERALD);
    }),
    G(2, 256, 20.0F, 3.0F, 30, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    D(3, 1536, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    N(4, 4096, 12.0F, 4.0F, 20, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    E(3, 1024, 10.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    DRILL(1, 16384, 15.0F, 4.0F, 0, () -> {
        return Ingredient.ofItems(NewexpItems.GEARBOX);
    }),
    //upgrades
    //gold
    GG(2, 256, 25.0F, 3.0F, 40, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    GD(3, 1536, 10.0F, 3.0F, 20, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    GN(4, 4096, 15.0F, 4.0F, 30, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    GE(3, 1024, 12.0F, 4.0F, 25, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    //diamond
    DG(2, 288, 20.0F, 3.0F, 30, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    DD(3, 1728, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    DN(4, 4608, 12.0F, 4.0F, 20, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    DE(3, 1152, 10.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    //netherite
    NG(2, 320, 20.0F, 3.0F, 35, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    ND(3, 1920, 8.0F, 3.0F, 15, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    NN(4, 5120, 12.0F, 4.0F, 25, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    NE(3, 1280, 10.0F, 4.0F, 20, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    //endite
    EG(2, 256, 20.0F, 3.0F, 30, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    ED(3, 1536, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    EN(4, 4096, 12.0F, 4.0F, 20, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    EE(3, 1024, 10.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private NewexpToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
