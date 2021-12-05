package com.pro__group.new_expansions.tabs;

import com.pro__group.new_expansions.NewExpansions;
import com.pro__group.new_expansions.registry.NewexpBlocks;
import com.pro__group.new_expansions.registry.NewexpItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class NewexpTabBlocks {
    public static void tabBlocks() {
        final ItemGroup GROUP_BLOCKS = FabricItemGroupBuilder.create(
                        new Identifier(NewExpansions.MOD_ID, "blocks"))
                .icon(() -> new ItemStack(NewexpItems.SULFUR_BLOCK))
                .appendItems(stacks -> {
                    stacks.add(new ItemStack(NewexpBlocks.SULFUR_ORE));
                    stacks.add(new ItemStack(NewexpBlocks.SULFUR_BLOCK));
                    stacks.add(new ItemStack(NewexpItems.NERERITE_ORE));
                    stacks.add(new ItemStack(NewexpItems.RENEFERITE_ORE));
                    stacks.add(new ItemStack(NewexpItems.SUPPLIES_BLOCK));
                    stacks.add(new ItemStack(NewexpBlocks.ENDITE_BLOCK));
                    stacks.add(new ItemStack(NewexpBlocks.BURNED_LOG));
                    stacks.add(new ItemStack(NewexpBlocks.BURNED_WOOD));
                    stacks.add(new ItemStack(NewexpBlocks.BURNED_PLANKS));
                    stacks.add(new ItemStack(NewexpBlocks.BURNED_SLAB));
                    stacks.add(new ItemStack(NewexpBlocks.BURNED_STAIRS));
                    stacks.add(new ItemStack(NewexpBlocks.ASH_BLOCK));
                    stacks.add(new ItemStack(NewexpBlocks.STONE_KILN));
                    stacks.add(new ItemStack(NewexpItems.ENCHANTED_NETHERITE_STATUE));
                }).build();
    }
}
