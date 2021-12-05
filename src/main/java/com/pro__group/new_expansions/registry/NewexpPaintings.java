package com.pro__group.new_expansions.registry;


import net.minecraft.entity.decoration.painting.PaintingMotive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NewexpPaintings {
    public static void PaintingsRegister(){
        final PaintingMotive creator_big = new PaintingMotive(64, 64);
        Registry.register(Registry.PAINTING_MOTIVE, new Identifier("newexp","creator_big" ), creator_big);
        final PaintingMotive creator_small = new PaintingMotive(32, 32);
        Registry.register(Registry.PAINTING_MOTIVE, new Identifier("newexp","creator_small" ), creator_small);
        final PaintingMotive creator2_big = new PaintingMotive(64, 64);
        Registry.register(Registry.PAINTING_MOTIVE, new Identifier("newexp","creator2_big" ), creator2_big);
        final PaintingMotive creator2_small = new PaintingMotive(32, 32);
        Registry.register(Registry.PAINTING_MOTIVE, new Identifier("newexp","creator2_small" ), creator2_small);
        final PaintingMotive serce = new PaintingMotive(16, 16);
        Registry.register(Registry.PAINTING_MOTIVE, new Identifier("newexp","serce" ), serce);
        final PaintingMotive drzewo = new PaintingMotive(16, 32);
        Registry.register(Registry.PAINTING_MOTIVE, new Identifier("newexp","drzewo" ), drzewo);
        final PaintingMotive nocne_niebo = new PaintingMotive(32, 16);
        Registry.register(Registry.PAINTING_MOTIVE, new Identifier("newexp","nocne_niebo" ), nocne_niebo);
        final PaintingMotive sunset = new PaintingMotive(16, 16);
        Registry.register(Registry.PAINTING_MOTIVE, new Identifier("newexp","sunset" ), sunset);
        final PaintingMotive husk = new PaintingMotive(16, 16);
        Registry.register(Registry.PAINTING_MOTIVE, new Identifier("newexp","husk" ), husk);
        final PaintingMotive mysterious_figure = new PaintingMotive(64, 32);
        Registry.register(Registry.PAINTING_MOTIVE, new Identifier("newexp","mysterious_figure" ), mysterious_figure);
        final PaintingMotive he_is_watching_us = new PaintingMotive(32, 16);
        Registry.register(Registry.PAINTING_MOTIVE, new Identifier("newexp","he_is_watching_us" ), he_is_watching_us);
        final PaintingMotive the_pray = new PaintingMotive(16, 16);
        Registry.register(Registry.PAINTING_MOTIVE, new Identifier("newexp","the_pray" ), the_pray);
    }
}
