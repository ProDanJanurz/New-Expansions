package com.pro__group.new_expansions.recipes;

import com.pro__group.new_expansions.registry.NewexpBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;

public class NewexpMeltingRecipe extends AbstractCookingRecipe {
    public NewexpMeltingRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(RecipeType.BLASTING, id, group, input, output, experience, cookTime);
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(NewexpBlocks.STONE_KILN);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializer.BLASTING;
    }
}