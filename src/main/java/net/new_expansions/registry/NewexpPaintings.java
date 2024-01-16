package net.new_expansions.registry;


import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.new_expansions.NewExpansions;

public class NewexpPaintings {
    public static void RegisterPaintings(){
        final PaintingVariant creator_big = new PaintingVariant(64, 64);
        Registry.register(Registries.PAINTING_VARIANT, (RegistryKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(NewExpansions.MOD_ID,"creator_big" ))), creator_big);
        final PaintingVariant creator_small = new PaintingVariant(32, 32);
        Registry.register(Registries.PAINTING_VARIANT, (RegistryKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(NewExpansions.MOD_ID,"creator_small" ))), creator_small);
        final PaintingVariant creator2_big = new PaintingVariant(64, 64);
        Registry.register(Registries.PAINTING_VARIANT, (RegistryKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(NewExpansions.MOD_ID,"creator2_big" ))), creator2_big);
        final PaintingVariant creator2_small = new PaintingVariant(32, 32);
        Registry.register(Registries.PAINTING_VARIANT, (RegistryKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(NewExpansions.MOD_ID,"creator2_small" ))), creator2_small);
        final PaintingVariant serce = new PaintingVariant(16, 16);
        Registry.register(Registries.PAINTING_VARIANT, (RegistryKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(NewExpansions.MOD_ID,"serce" ))), serce);
        final PaintingVariant drzewo = new PaintingVariant(16, 32);
        Registry.register(Registries.PAINTING_VARIANT, (RegistryKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(NewExpansions.MOD_ID,"drzewo" ))), drzewo);
        final PaintingVariant nocne_niebo = new PaintingVariant(32, 16);
        Registry.register(Registries.PAINTING_VARIANT, (RegistryKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(NewExpansions.MOD_ID,"nocne_niebo" ))), nocne_niebo);
        final PaintingVariant sunset = new PaintingVariant(16, 16);
        Registry.register(Registries.PAINTING_VARIANT, (RegistryKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(NewExpansions.MOD_ID,"sunset" ))), sunset);
        final PaintingVariant husk = new PaintingVariant(16, 16);
        Registry.register(Registries.PAINTING_VARIANT, (RegistryKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(NewExpansions.MOD_ID,"husk" ))), husk);
        final PaintingVariant mysterious_figure = new PaintingVariant(64, 32);
        Registry.register(Registries.PAINTING_VARIANT, (RegistryKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(NewExpansions.MOD_ID,"mysterious_figure" ))), mysterious_figure);
        final PaintingVariant he_is_watching_us = new PaintingVariant(32, 16);
        Registry.register(Registries.PAINTING_VARIANT, (RegistryKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(NewExpansions.MOD_ID,"he_is_watching_us" ))), he_is_watching_us);
        final PaintingVariant the_pray = new PaintingVariant(16, 16);
        Registry.register(Registries.PAINTING_VARIANT, (RegistryKey.of(RegistryKeys.PAINTING_VARIANT, new Identifier(NewExpansions.MOD_ID,"the_pray" ))), the_pray);
    }
}
