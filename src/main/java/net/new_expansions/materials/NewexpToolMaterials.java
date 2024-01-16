package net.new_expansions.materials;

import net.new_expansions.registry.NewexpItems;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum NewexpToolMaterials implements ToolMaterial {

    WOOD(0, 32, 1.05F, 0.0F, 0, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }),
    STONE(1, 32, 2.0F, 0.0F, 5, () -> {
        return Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS);
    }),
    COPPER(2, 96, 4.0F, 1.0F, 10, () -> {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }),
    IRON(3, 160, 5.0F, 2.0F, 15, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),
    EMERALD(3, 256, 6.0F, 2.0F, 5, () -> {
        return Ingredient.ofItems(Items.EMERALD);
    }),
    GOLD(4, 256, 20.0F, 3.0F, 30, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    DIAMOND(5, 2048, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    NETHERITE(6, 4096, 12.0F, 4.0F, 20, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    ENDITE(5, 1024, 10.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    DRILL(3, 16384, 15.0F, 4.0F, -1, () -> {
        return Ingredient.ofItems(NewexpItems.GEARBOX);
    }),
    JEWELED(7, 4096, 100.0F, 20.0F, 100, () -> {
        return Ingredient.ofItems(NewexpItems.JEWELED_ALLOY);
    }),
    //upgrades
    //gold
    GOLD_ENHANCEMENT_GOLD(4, 256, 25.0F, 3.0F, 40, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    GOLD_ENHANCEMENT_DIAMOND(5, 2048, 10.0F, 3.0F, 20, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    GOLD_ENHANCEMENT_NETHERITE(6, 4096, 15.0F, 4.0F, 30, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    GOLD_ENHANCEMENT_ENDITE(5, 1024, 12.0F, 4.0F, 25, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    //diamond
    DIAMOND_ENHANCEMENT_GOLD(4, 320, 20.0F, 3.0F, 30, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    DIAMOND_ENHANCEMENT_DIAMOND(5, 2560, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    DIAMOND_ENHANCEMENT_NETHERITE(6, 5120, 12.0F, 4.0F, 20, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    DIAMOND_ENHANCEMENT_ENDITE(5, 1280, 10.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    //netherite
    NETHERITE_ENHANCEMENT_GOLD(4, 384, 20.0F, 3.0F, 35, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    NETHERITE_ENHANCEMENT_DIAMOND(5, 3072, 8.0F, 3.0F, 15, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    NETHERITE_ENHANCEMENT_NETHERITE(6, 6144, 12.0F, 4.0F, 25, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    NETHERITE_ENHANCEMENT_ENDITE(5, 1536, 10.0F, 4.0F, 20, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    }),
    //endite
    ENDITE_ENHANCEMENT_GOLD(4, 256, 20.0F, 3.0F, 30, () -> {
        return Ingredient.ofItems(Items.GOLD_INGOT);
    }),
    ENDITE_ENHANCEMENT_DIAMOND(5, 2048, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(Items.DIAMOND);
    }),
    ENDITE_ENHANCEMENT_NETHERITE(6, 4096, 12.0F, 4.0F, 20, () -> {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }),
    ENDITE_ENHANCEMENT_ENDITE(5, 1024, 10.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(NewexpItems.ENDITE_INGOT);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    NewexpToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
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
