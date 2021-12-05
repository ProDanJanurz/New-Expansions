package com.pro__group.new_expansions.tabs;

import com.pro__group.new_expansions.NewExpansions;
import com.pro__group.new_expansions.registry.NewexpBlocks;
import com.pro__group.new_expansions.registry.NewexpItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class NewexpTabItems {
    public static void tabItems() {
        final ItemGroup GROUP_ITEMS = FabricItemGroupBuilder.create(
                        new Identifier(NewExpansions.MOD_ID, "items"))
                .icon(() -> new ItemStack(NewexpItems.GEARS))
                .appendItems(stacks -> {
                    stacks.add(new ItemStack(NewexpItems.SULFUR));
                    stacks.add(new ItemStack(NewexpItems.RAW_NERERITE));
                    stacks.add(new ItemStack(NewexpItems.REFINED_NERERITE));
                    stacks.add(new ItemStack(NewexpItems.RAW_RENEFERITE));
                    stacks.add(new ItemStack(NewexpItems.REFINED_RENEFERITE));
                    stacks.add(new ItemStack(NewexpItems.ENDITE_INGOT));
                    stacks.add(new ItemStack(NewexpItems.ENDITE_SCRAP));
                    stacks.add(new ItemStack(NewexpItems.IRON_RINGS));
                    stacks.add(new ItemStack(NewexpItems.GEARS));
                    stacks.add(new ItemStack(NewexpItems.GEARBOX));
                    stacks.add(new ItemStack(NewexpItems.DRILL_HEAD));
                    stacks.add(new ItemStack(NewexpItems.DRILL_HANDLE));
                    stacks.add(new ItemStack(NewexpItems.ASH));
                    stacks.add(new ItemStack(NewexpItems.NETHERITE_STATUE));
                    stacks.add(new ItemStack(NewexpItems.ENDITE_STATUE));
                    stacks.add(new ItemStack(NewexpItems.NETHERITE_AMULET));
                    stacks.add(new ItemStack(NewexpItems.ENDITE_AMULET));
                    stacks.add(new ItemStack(NewexpItems.NETHERITE_ARTIFACT));
                    stacks.add(new ItemStack(NewexpItems.ENDITE_ARTIFACT));
                    stacks.add(new ItemStack(NewexpItems.NETHERITE_TOOLS));
                    stacks.add(new ItemStack(NewexpItems.ENDITE_TOOLS));
                }).build();
    }
}
