package net.new_expansions.registry;


import net.minecraft.registry.Registries;
import net.new_expansions.NewExpansions;
import net.new_expansions.blocks.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.new_expansions.util.NewexpBlockUtil;

public class NewexpBlocks {
    public static final Block TAB_ICON_BLOCK = new NewexpBlock(FabricBlockSettings.create());
//    public static final Block STONE_KILN = new NewexpStoneKiln(FabricBlockSettings
//            .of(Material.STONE)
//            .requiresTool()
//            .strength(1f, 3.0f)
//            .sounds(BlockSoundGroup.STONE)
//    );
    public static final Block ENCHANTED_NETHERITE_STATUE = new NewexpEnchantedStatue(FabricBlockSettings
            .create()
            .requiresTool()
            .strength(20f, 200f)
            .sounds(BlockSoundGroup.NETHERITE)
            .luminance(15)
    );
    public static final Block MAGMATO_BUSH = new NewexpMagmatoBushBlock(FabricBlockSettings
            .create()
            .ticksRandomly()
            .noCollision()
            .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
    );
    public static final Block MAGNETIC_RAIL = new PoweredRailBlock(FabricBlockSettings
            .create()
            .noCollision()
            .strength(0.7F)
            .sounds(BlockSoundGroup.METAL)
    );

    public static void RegisterBlocks(){
        Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, "tab_icon_block"), TAB_ICON_BLOCK);
//        Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, "stone_kiln"), STONE_KILN);
        NewexpBlockUtil.addBlockPaletteStoneAdvanced("gilded_polished_blackstone",
                BlockSoundGroup.GILDED_BLACKSTONE,MapColor.BLACK,3.0F,12.0F,0,true,false,true,false);
        NewexpBlockUtil.addBlockSimple("gilded_chiseled_polished_blackstone",
                BlockSoundGroup.GILDED_BLACKSTONE,MapColor.BLACK,3.0F,12.0F,0,true);
        NewexpBlockUtil.addBlockPaletteWoodSimpleFlammable("burned",
                BlockSoundGroup.WOOD,MapColor.TERRACOTTA_BROWN,2.0F,3.0F,0, 600, 10,40);
        NewexpBlockUtil.addBlockSimple("sulfur_ore",
                BlockSoundGroup.STONE,MapColor.STONE_GRAY,3.0F,3.0F,0,true);
        NewexpBlockUtil.addBlockSimpleFlammable("sulfur_block",
                BlockSoundGroup.METAL,MapColor.TERRACOTTA_YELLOW,4.0F,5.0F,0,true, 32000, 2, 2);
        NewexpBlockUtil.addBlockSimple("nererite_ore",
                BlockSoundGroup.NETHERITE,MapColor.GRAY,100.0F,1000.0F,0,true);
        NewexpBlockUtil.addBlockSimple("reneferite_ore",
                BlockSoundGroup.STONE,MapColor.PALE_YELLOW,40.0F,400.0F,0,true);
        NewexpBlockUtil.addBlockSimpleNoMap("supplies_block",
                BlockSoundGroup.WOOD,2.0F,5.0F,0,true);
        NewexpBlockUtil.addBlockSimple("endite_block",
                BlockSoundGroup.METAL,MapColor.TERRACOTTA_BLUE,20.0F,50.0F,0,true);
        NewexpBlockUtil.addBlockSimple("ash_block",
                BlockSoundGroup.SAND,MapColor.LIGHT_GRAY,0.5F,1.0F,0,true);
                
         
        Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, "enchanted_netherite_statue"), ENCHANTED_NETHERITE_STATUE);
        Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, "magmato_bush"), MAGMATO_BUSH);
        Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, "magnetic_rail"), MAGNETIC_RAIL);
    }
}
