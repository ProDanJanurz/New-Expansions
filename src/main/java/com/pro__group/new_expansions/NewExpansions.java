package com.pro__group.new_expansions;

import com.pro__group.new_expansions.client.screen.NewexpStoneKilnScreenHandler;
import com.pro__group.new_expansions.registry.*;
import com.pro__group.new_expansions.tabs.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;

public class NewExpansions implements ModInitializer {
    public static final String MOD_ID = "newexp";

    public static final ScreenHandlerType<NewexpStoneKilnScreenHandler> STONE_KILN_SCREEN_HANDLER;

    static {
        STONE_KILN_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MOD_ID, "stone_kiln"), NewexpStoneKilnScreenHandler::new);
    }

    @Override
    public void onInitialize() {
        NewexpRegisters.register();
        NewexpTabs.tab();
    }
}

