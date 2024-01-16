package net.new_expansions.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class NewexpGlintBlockItem extends BlockItem {
    public NewexpGlintBlockItem(Block block, Settings settings) {
        super(block, settings);
    }
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
