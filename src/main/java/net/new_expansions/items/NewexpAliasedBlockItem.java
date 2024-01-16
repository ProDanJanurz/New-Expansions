package net.new_expansions.items;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class NewexpAliasedBlockItem extends BlockItem {
    public NewexpAliasedBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    public String getTranslationKey() {
        return this.getOrCreateTranslationKey();
    }
}