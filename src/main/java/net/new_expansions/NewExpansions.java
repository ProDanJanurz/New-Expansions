package net.new_expansions;

import net.fabricmc.api.ModInitializer;
import net.new_expansions.registry.NewexpRegisters;

public class NewExpansions implements ModInitializer {
    public static final String MOD_ID = "newexp";
    
    @Override
    public void onInitialize() {
        NewexpRegisters.register();
    }
}