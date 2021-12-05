package com.pro__group.new_expansions.generation;

import com.pro__group.new_expansions.registry.NewexpBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class NewexpOres {
    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModfier) {
        return modifiers(CountPlacementModifier.of(count), heightModfier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
    private static PlacedFeature SULFUR_ORE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreConfiguredFeatures.BASE_STONE_OVERWORLD,
                    NewexpBlocks.SULFUR_ORE.getDefaultState(),
                    5, 0.2F))
            .withPlacement(modifiersWithCount(8, HeightRangePlacementModifier.uniform(YOffset.fixed(8), YOffset.fixed(64))));

    private static PlacedFeature EMERALD_ORE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreConfiguredFeatures.BASE_STONE_OVERWORLD,
                    Blocks.DEEPSLATE_EMERALD_ORE.getDefaultState(),
                    4,0F))
            .withPlacement(modifiersWithCount(5, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-40), YOffset.aboveBottom(40))));

    private static PlacedFeature NERERITE_ORE_NETHER = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreConfiguredFeatures.BASE_STONE_NETHER,
                    NewexpBlocks.NERERITE_ORE.getDefaultState(),
                    3, 0F))
        .withPlacement(modifiersWithCount(1, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(16))));

    private static PlacedFeature ANCIENT_ORE_BOTTOM_NETHER = Feature.SCATTERED_ORE
            .configure(new OreFeatureConfig(
                    OreConfiguredFeatures.BASE_STONE_NETHER,
                    Blocks.ANCIENT_DEBRIS.getDefaultState(),
                    5, 0.5F))
            .withPlacement(modifiersWithCount(2, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(24))));

    private static PlacedFeature ANCIENT_ORE_ALL_NETHER = Feature.SCATTERED_ORE
            .configure(new OreFeatureConfig(
                    OreConfiguredFeatures.BASE_STONE_NETHER,
                    Blocks.ANCIENT_DEBRIS.getDefaultState(),
                    6, 1F))
            .withPlacement(modifiersWithRarity(4, HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(128))));

    private static PlacedFeature RENEFERITE_ORE_END = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE),
                    NewexpBlocks.RENEFERITE_ORE.getDefaultState(),
                    4, 0.1F))
            .withPlacement(modifiersWithCount(2, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(20))));
    public static void OreRegister(){
        RegistryKey<PlacedFeature> sulfurOreOverworld = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("newexp", "sulfur_ore_overworld"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, sulfurOreOverworld.getValue(), SULFUR_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, sulfurOreOverworld);

        RegistryKey<PlacedFeature> emeraldOreOverworld = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("newexp", "emerald_ore_overworld"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, emeraldOreOverworld.getValue(), EMERALD_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, emeraldOreOverworld);

        RegistryKey<PlacedFeature>  nereriteOreNether = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("newexp", "nererite_ore_nether"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, nereriteOreNether.getValue(), NERERITE_ORE_NETHER);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, nereriteOreNether);

        RegistryKey<PlacedFeature>  ancientOreBottomNether = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("newexp", "ancient_ore_bottom_nether"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, ancientOreBottomNether.getValue(), ANCIENT_ORE_BOTTOM_NETHER);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, ancientOreBottomNether);

        RegistryKey<PlacedFeature>  ancientOreAllNether = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("newexp", "ancient_ore_all_nether"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, ancientOreAllNether.getValue(), ANCIENT_ORE_ALL_NETHER);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, ancientOreAllNether);

        RegistryKey<PlacedFeature>  reneferiteOreEnd = RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                new Identifier("newexp", "reneferite_ore_end"));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, reneferiteOreEnd.getValue(), RENEFERITE_ORE_END);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, reneferiteOreEnd);
    }
}
