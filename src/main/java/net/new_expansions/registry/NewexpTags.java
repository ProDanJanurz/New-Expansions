package net.new_expansions.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;


public class NewexpTags {
    public static final TagKey<Block> DRILL_MINEABLE = ofBlock("mineable/drill");
    public static final TagKey<Block> PERFORMANCE_ENCHANTMENT = ofBlock("performance_enchantment");
    public static final TagKey<Block> STONE_TOOL_LEVEL = ofBlock("mining_level/stone_tool_level");
    public static final TagKey<Block> COPPER_TOOL_LEVEL = ofBlock("mining_level/copper_tool_level");
    public static final TagKey<Block> IRON_TOOL_LEVEL = ofBlock("mining_level/iron_tool_level");
    public static final TagKey<Block> GOLD_TOOL_LEVEL = ofBlock("mining_level/gold_tool_level");
    public static final TagKey<Block> DIAMOND_TOOL_LEVEL = ofBlock("mining_level/diamond_tool_level");
    public static final TagKey<Block> NETHERITE_TOOL_LEVEL = ofBlock("mining_level/netherite_tool_level");
    public static final TagKey<Block> JEWELED_TOOL_LEVEL = ofBlock("mining_level/jeweled_tool_level");
    
    public static final TagKey<Item> GOLD_ARMOR_ITEM = ofItem("gold_armor_items");
    
    private static TagKey<Block> ofBlock(String id) {
        return TagKey.of(RegistryKeys.BLOCK, new Identifier("newexp", id));
    }
    private static TagKey<Item> ofItem(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier("newexp", id));
    }
}
