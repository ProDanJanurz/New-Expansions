package com.pro__group.new_expansions.client.screen;

import com.pro__group.new_expansions.NewExpansions;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class NewexpStoneKilnScreenHandler extends AbstractFurnaceScreenHandler {
    public NewexpStoneKilnScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(NewExpansions.STONE_KILN_SCREEN_HANDLER, RecipeType.BLASTING, RecipeBookCategory.BLAST_FURNACE, syncId, playerInventory);
    }

    public NewexpStoneKilnScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(NewExpansions.STONE_KILN_SCREEN_HANDLER, RecipeType.BLASTING, RecipeBookCategory.BLAST_FURNACE, syncId, playerInventory, inventory, propertyDelegate);
    }
}