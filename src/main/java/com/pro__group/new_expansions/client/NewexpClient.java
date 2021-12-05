package com.pro__group.new_expansions.client;

import com.pro__group.new_expansions.NewExpansions;
import com.pro__group.new_expansions.client.screen.NewexpStoneKilnScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class NewexpClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(NewExpansions.STONE_KILN_SCREEN_HANDLER, NewexpStoneKilnScreen::new);
    }
}