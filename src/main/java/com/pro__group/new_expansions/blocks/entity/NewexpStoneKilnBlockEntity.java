package com.pro__group.new_expansions.blocks.entity;

import com.pro__group.new_expansions.client.screen.NewexpStoneKilnScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class NewexpStoneKilnBlockEntity extends AbstractFurnaceBlockEntity {
    public NewexpStoneKilnBlockEntity(BlockPos pos, BlockState state) {
        super(NewexpBlockEntityType.STONE_KILN, pos, state, RecipeType.BLASTING);
    }

    protected Text getContainerName() {
        return new TranslatableText("container.stone_kiln");
    }

    protected int getFuelTime(ItemStack fuel) {
        return super.getFuelTime(fuel) / 2;
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new NewexpStoneKilnScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}