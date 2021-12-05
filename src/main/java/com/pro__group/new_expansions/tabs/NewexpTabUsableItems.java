package com.pro__group.new_expansions.tabs;

import com.pro__group.new_expansions.NewExpansions;
import com.pro__group.new_expansions.registry.NewexpBlocks;
import com.pro__group.new_expansions.registry.NewexpItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class NewexpTabUsableItems {
    public static void tabUsableItems() {
        final ItemGroup GROUP_USABLE_ITEMS = FabricItemGroupBuilder.create(
                        new Identifier(NewExpansions.MOD_ID, "usable_items"))
                .icon(() -> new ItemStack(NewexpItems.BONE_STOCK))
                .appendItems(stacks -> {
                    stacks.add(new ItemStack(NewexpItems.MEATY_STEW));
                    stacks.add(new ItemStack(NewexpItems.POTATO_SALAD));
                    stacks.add(new ItemStack(NewexpItems.FRUIT_MIX));
                    stacks.add(new ItemStack(NewexpItems.STUFFED_CHICKEN));
                    stacks.add(new ItemStack(NewexpItems.FISH_SOUP));
                    stacks.add(new ItemStack(NewexpItems.BONE_STOCK));
                    stacks.add(new ItemStack(NewexpItems.RABBIT_STEW));
                    stacks.add(new ItemStack(NewexpItems.MUSHROOM_STEW));
                    stacks.add(new ItemStack(NewexpItems.BEETROOT_SOUP));
                    stacks.add(new ItemStack(NewexpItems.MILK_ICECREAM));
                    stacks.add(new ItemStack(NewexpItems.CHOCOLATE_ICECREAM));
                    stacks.add(new ItemStack(NewexpItems.HONEY_ICECREAM));
                    stacks.add(new ItemStack(NewexpItems.SUPPLIES));
                    stacks.add(new ItemStack(NewexpItems.BUG));
                    stacks.add(new ItemStack(NewexpItems.BANDAGE));
                    stacks.add(new ItemStack(NewexpItems.SYRINGE));
                    stacks.add(new ItemStack(NewexpItems.SPLINTS));
                    stacks.add(new ItemStack(NewexpItems.SMALL_MEDKIT));
                    stacks.add(new ItemStack(NewexpItems.MEDKIT));
                    stacks.add(new ItemStack(NewexpItems.MUSIC_DISC_THE_WAY));
                    stacks.add(new ItemStack(NewexpItems.MUSIC_DISC_THE_WHISPER));
                    stacks.add(new ItemStack(NewexpItems.MUSIC_DISC_RESIDENCE_OF_CORRUPTION));
                }).build();
    }
}
