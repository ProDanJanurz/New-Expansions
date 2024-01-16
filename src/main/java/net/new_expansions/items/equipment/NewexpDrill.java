package net.new_expansions.items.equipment;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.new_expansions.registry.NewexpTags;

public class NewexpDrill extends NewexpMiningToolItem {
    public NewexpDrill(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(attackDamage, attackSpeed, material, NewexpTags.DRILL_MINEABLE, settings);
    }
}