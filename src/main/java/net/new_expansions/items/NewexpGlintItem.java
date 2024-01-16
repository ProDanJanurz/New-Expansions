package net.new_expansions.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NewexpGlintItem extends Item {
    public NewexpGlintItem(Settings settings) {
        super(settings);
    }
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}

