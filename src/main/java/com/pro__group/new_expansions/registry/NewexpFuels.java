package com.pro__group.new_expansions.registry;

import net.fabricmc.fabric.api.registry.FuelRegistry;

public class NewexpFuels {
    public static void FuelsRegister(){
        FuelRegistry.INSTANCE.add(NewexpItems.SULFUR, 3200);
        FuelRegistry.INSTANCE.add(NewexpItems.SULFUR_BLOCK, 32000);
        FuelRegistry.INSTANCE.add(NewexpItems.BURNED_LOG, 600);
        FuelRegistry.INSTANCE.add(NewexpItems.BURNED_WOOD, 600);
        FuelRegistry.INSTANCE.add(NewexpItems.BURNED_PLANKS, 600);
    }
}
