package com.pro__group.new_expansions.items;

import net.minecraft.block.Block;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.Tag;

public class NewexpDrill extends MiningToolItem {
    public NewexpDrill(float attackDamage, float attackSpeed, ToolMaterial material, Tag<Block> effectiveBlocks, Settings settings) {
        super(attackDamage, attackSpeed, material, effectiveBlocks, settings);
    }

}