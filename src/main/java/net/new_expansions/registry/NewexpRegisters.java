package net.new_expansions.registry;

import net.new_expansions.blocks.entity.NewexpBlockEntityType;
import net.new_expansions.items.trim.NewexpArmorTrimMaterials;
import net.new_expansions.items.trim.NewexpArmorTrimPatterns;

public class NewexpRegisters {
    static public void register()
    {
        NewexpItems.RegisterItems();
        NewexpBlocks.RegisterBlocks();
        NewexpFuels.RegisterFuels();
        NewexpPaintings.RegisterPaintings();
        NewexpTradeOffers.RegisterTradeOffers();
        NewexpPotions.RegisterPotions();
        NewexpPotions.RegisterPotionRecipes();
        //NewexpStructures.RegisterStructures();
        NewexpGamerules.RegisterGamerules();
        NewexpBlockEntityType.RegisterEntityType();
        NewexpEnchantments.RegisterEnchantments();
        new NewexpAttributes();
        NewexpItemGroups.registerItemGroups();
        new NewexpRegistryKeys();
        new NewexpArmorTrimMaterials();
        new NewexpArmorTrimPatterns();
    }
}
