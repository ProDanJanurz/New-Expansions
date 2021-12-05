package com.pro__group.new_expansions.registry;


import com.pro__group.new_expansions.NewExpansions;
import com.pro__group.new_expansions.blocks.NewexpStoneKiln;
import com.pro__group.new_expansions.blocks.NewexpStairs;
import com.pro__group.new_expansions.blocks.NewexpEnchantedStatue;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class NewexpBlocks {
    public static final Block SULFUR_ORE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .requiresTool()
            .strength(2.0f, 10.0f)
            .sounds(BlockSoundGroup.STONE)
            );
    public static final Block SULFUR_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .requiresTool()
            .strength(3.0f, 20.0f)
            .sounds(BlockSoundGroup.METAL)
    );
    public static final Block NERERITE_ORE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .requiresTool()
            .strength(100.0f, 1000.0f)
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block RENEFERITE_ORE = new Block(FabricBlockSettings
            .of(Material.STONE)
            .requiresTool()
            .strength(40.0f, 400.0f)
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block SUPPLIES_BLOCK = new Block(FabricBlockSettings
            .of(Material.WOOD)
            .requiresTool()
            .strength(2.0f, 5.0f)
            .sounds(BlockSoundGroup.WOOD)
    );
    public static final Block ENDITE_BLOCK = new Block(FabricBlockSettings
            .of(Material.METAL)
            .requiresTool()
            .strength(20.0f, 50.0f)
            .sounds(BlockSoundGroup.NETHERITE)
    );
    public static final Block BURNED_LOG = new PillarBlock(FabricBlockSettings
            .of(Material.WOOD)
            .requiresTool()
            .strength(2.0f, 5.0f)
            .sounds(BlockSoundGroup.WOOD)
    );
    public static final Block BURNED_WOOD = new PillarBlock(FabricBlockSettings
            .of(Material.WOOD)
            .requiresTool()
            .strength(2.0f, 5.0f)
            .sounds(BlockSoundGroup.WOOD)
    );
    public static final Block BURNED_PLANKS = new Block(FabricBlockSettings
            .of(Material.WOOD)
            .requiresTool()
            .strength(2.0f, 5.0f)
            .sounds(BlockSoundGroup.WOOD)
    );
    public static final Block BURNED_SLAB = new SlabBlock(FabricBlockSettings
            .of(Material.WOOD)
            .requiresTool()
            .strength(2.0f, 5.0f)
            .sounds(BlockSoundGroup.WOOD)
    );
    public static final Block BURNED_STAIRS = new NewexpStairs(NewexpBlocks.BURNED_PLANKS.getDefaultState(), FabricBlockSettings
            .of(Material.WOOD)
            .requiresTool()
            .strength(2.0f, 5.0f)
            .sounds(BlockSoundGroup.WOOD)
    );
    public static final Block ASH_BLOCK = new Block(FabricBlockSettings
            .of(Material.SOIL)
            .requiresTool()
            .strength(0.5f, 1.0f)
            .sounds(BlockSoundGroup.SAND)
    );
    public static final Block STONE_KILN = new NewexpStoneKiln(FabricBlockSettings
            .of(Material.STONE)
            .requiresTool()
            .strength(1f, 3.0f)
            .sounds(BlockSoundGroup.STONE)
    );
    public static final Block ENCHANTED_NETHERITE_STATUE = new NewexpEnchantedStatue(FabricBlockSettings
            .of(Material.METAL)
            .requiresTool()
            .strength(20f, 200f)
            .sounds(BlockSoundGroup.NETHERITE)
            .luminance(15)
    );
    public static void BloksRegister(){
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "sulfur_ore"), SULFUR_ORE);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "sulfur_block"), SULFUR_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "nererite_ore"), NERERITE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "reneferite_ore"), RENEFERITE_ORE);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "supplies_block"), SUPPLIES_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "endite_block"), ENDITE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "burned_log"), BURNED_LOG);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "burned_wood"), BURNED_WOOD);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "burned_planks"), BURNED_PLANKS);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "burned_slab"), BURNED_SLAB);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "burned_stairs"), BURNED_STAIRS);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "ash_block"), ASH_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "stone_kiln"), STONE_KILN);
        Registry.register(Registry.BLOCK, new Identifier(NewExpansions.MOD_ID, "enchanted_netherite_statue"), ENCHANTED_NETHERITE_STATUE);
    }
}
