package net.new_expansions.registry;

import net.fabricmc.fabric.api.registry.FuelRegistry;

public class NewexpFuels {
    public static void RegisterFuels(){
        FuelRegistry.INSTANCE.add(NewexpItems.SULFUR, 3200);
        /*
        FuelRegistry.INSTANCE.add(NewexpItems.SULFUR_BLOCK, 32000);
        
         */
    }
}
