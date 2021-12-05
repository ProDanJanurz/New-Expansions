package com.pro__group.new_expansions.client.screen;

import com.pro__group.new_expansions.client.screen.NewexpStoneKilnScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.recipebook.FurnaceRecipeBookScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class NewexpStoneKilnScreen extends AbstractFurnaceScreen<NewexpStoneKilnScreenHandler> {
    private static final Identifier BACKGROUND = new Identifier("textures/gui/container/furnace.png");

    public NewexpStoneKilnScreen(NewexpStoneKilnScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, new FurnaceRecipeBookScreen(), inventory, title, BACKGROUND);
    }
}