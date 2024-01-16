package net.new_expansions.util;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.new_expansions.NewExpansions;
import net.new_expansions.items.NewexpBlockItem;
import net.new_expansions.items.equipment.NewexpAxe;
import net.new_expansions.registry.NewexpItemGroups;

public class NewexpBlockUtil {
	public static void addBlock(String name,
								BlockSoundGroup blockSoundGroup,
								MapColor mapColor,
								float hardness,
								float resistance,
								int luminance,
								boolean requiresTool,
								boolean nonOpaque,
								boolean noCollision,
								boolean ticksRandomly){
		if(luminance < 0) luminance = 0;
		if(luminance > 15) luminance = 15;
		final BlockItem BLOCK_ITEM;
		final Block BLOCK = switch (requiresTool + "-" + nonOpaque + "-" + noCollision + "-" + ticksRandomly) {
			case "true-true-true-true", "true-false-true-true" -> new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.requiresTool()
					.noCollision()
					.ticksRandomly()
			);
			case "true-true-true-false", "true-false-true-false" -> new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.requiresTool()
					.noCollision()
			);
			case "true-true-false-true" -> new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.requiresTool()
					.nonOpaque()
					.ticksRandomly()
			);
			case "true-true-false-false" -> new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.requiresTool()
					.nonOpaque()
			);
			case "true-false-false-true" -> new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.requiresTool()
					.ticksRandomly()
			);
			case "true-false-false-false" -> new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.requiresTool()
			);
			case "false-true-true-true", "false-false-true-true" -> new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.noCollision()
					.ticksRandomly()
			);
			case "false-true-false-true" -> new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.nonOpaque()
					.ticksRandomly()
			);
			case "false-false-false-true" -> new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.ticksRandomly()
			);
			case "false-true-true-false", "false-false-true-false" -> new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.noCollision()
			);
			case "false-true-false-false" -> new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.nonOpaque()
			);
			default -> new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
			);
		};
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name), BLOCK);
		BLOCK_ITEM = new NewexpBlockItem(BLOCK, new Item.Settings());
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name), BLOCK_ITEM);
		ItemGroupEvents.modifyEntriesEvent(NewexpItemGroups.BLOCKS).register(content -> {
			content.add(BLOCK);
		});
		//NewexpAxe.STRIPPED_BLOCKS.put(NewexpBlocks.BURNED_LOG, NewexpBlocks.STRIPPED_BURNED_LOG);
		//NewexpHoe.TILLING_ACTIONS.put(Blocks.GRASS_BLOCK, Pair.of(HoeItem::canTillFarmland, NewexpHoe.createTillAction(Blocks.FARMLAND.getDefaultState())));
	}
	
	public static void addBlockSimple(String name, BlockSoundGroup blockSoundGroup, MapColor mapColor,
								float hardness, float resistance, int luminance, boolean requiresTool){
		if(luminance < 0) luminance = 0;
		if(luminance > 15) luminance = 15;
		final Block BLOCK;
		final BlockItem BLOCK_ITEM;
		if(requiresTool){
			BLOCK = new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.requiresTool()
			);
		}else{
			BLOCK = new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
			);
		}
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name), BLOCK);
		BLOCK_ITEM = new NewexpBlockItem(BLOCK, new Item.Settings());
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name), BLOCK_ITEM);
		ItemGroupEvents.modifyEntriesEvent(NewexpItemGroups.BLOCKS).register(content -> {
			content.add(BLOCK);
		});
	}
	
	public static void addBlockSimpleFlammable(String name, BlockSoundGroup blockSoundGroup, MapColor mapColor,
									  float hardness, float resistance, int luminance, boolean requiresTool, int fuelTime, int burnTime, int fireSpread){
		if(luminance < 0) luminance = 0;
		if(luminance > 15) luminance = 15;
		final Block BLOCK;
		final BlockItem BLOCK_ITEM;
		if(requiresTool){
			BLOCK = new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.requiresTool()
			);
		}else{
			BLOCK = new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
			);
		}
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name), BLOCK);
		BLOCK_ITEM = new NewexpBlockItem(BLOCK, new Item.Settings());
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name), BLOCK_ITEM);
		ItemGroupEvents.modifyEntriesEvent(NewexpItemGroups.BLOCKS).register(content -> {
			content.add(BLOCK);
		});
		if(fuelTime > 0){
			FuelRegistry.INSTANCE.add(BLOCK, fuelTime);
		}
		FlammableBlockRegistry fbr = FlammableBlockRegistry.getDefaultInstance();
		fbr.add(BLOCK, burnTime, fireSpread);
	}
	
	public static void addBlockSimpleNoMap(String name,
									  BlockSoundGroup blockSoundGroup,
									  float hardness,
									  float resistance,
									  int luminance,
									  boolean requiresTool){
		if(luminance < 0) luminance = 0;
		if(luminance > 15) luminance = 15;
		final Block BLOCK;
		final BlockItem BLOCK_ITEM;
		if(requiresTool){
			BLOCK = new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.strength(hardness, resistance)
					.luminance(luminance)
					.requiresTool()
			);
		}else{
			BLOCK = new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.strength(hardness, resistance)
					.luminance(luminance)
			);
		}
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name), BLOCK);
		BLOCK_ITEM = new NewexpBlockItem(BLOCK, new Item.Settings());
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name), BLOCK_ITEM);
		ItemGroupEvents.modifyEntriesEvent(NewexpItemGroups.BLOCKS).register(content -> {
			content.add(BLOCK);
		});
	}
	
	public static void addBlockPaletteStoneSimple(String name, BlockSoundGroup blockSoundGroup, MapColor mapColor,
								float hardness, float resistance, int luminance,
								boolean requiresTool, boolean addSuffix){
		if(luminance < 0) luminance = 0;
		if(luminance > 15) luminance = 15;
		final Block BLOCK ,STAIRS ,SLAB ,WALL;
		final BlockItem BLOCK_ITEM ,STAIRS_ITEM ,SLAB_ITEM ,WALL_ITEM;
		if(requiresTool){
			BLOCK = new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
					.requiresTool()
			);
		}else{
			BLOCK = new Block(FabricBlockSettings
					.create()
					.sounds(blockSoundGroup)
					.mapColor(mapColor)
					.strength(hardness, resistance)
					.luminance(luminance)
			);
		}
		STAIRS = new StairsBlock(BLOCK.getDefaultState(), AbstractBlock.Settings.copy(BLOCK));
		SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLOCK));
		WALL = new WallBlock(AbstractBlock.Settings.copy(BLOCK));
		if(addSuffix){
			Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "s"), BLOCK);
		}else{
			Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name), BLOCK);
		}
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_stairs"), STAIRS);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_slab"), SLAB);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_wall"), WALL);
		
		BLOCK_ITEM = new NewexpBlockItem(BLOCK, new Item.Settings());
		STAIRS_ITEM = new NewexpBlockItem(STAIRS, new Item.Settings());
		SLAB_ITEM = new NewexpBlockItem(SLAB, new Item.Settings());
		WALL_ITEM = new NewexpBlockItem(WALL, new Item.Settings());
		if(addSuffix){
			Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "s"), BLOCK_ITEM);
		}else{
			Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name), BLOCK_ITEM);
		}
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_stairs"), STAIRS_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_slab"), SLAB_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_wall"), WALL_ITEM);
		ItemGroupEvents.modifyEntriesEvent(NewexpItemGroups.BLOCKS).register(content -> {
			content.add(BLOCK);
			content.add(STAIRS);
			content.add(SLAB);
			content.add(WALL);
		});
	}
	public static void addBlockPaletteStoneAdvanced(String name, BlockSoundGroup blockSoundGroup, MapColor mapColor,
												  	float hardness, float resistance, int luminance,
													boolean requiresTool, boolean addPolished, boolean addBricks, boolean addTiles){
		addBlockPaletteStoneSimple(name,blockSoundGroup,mapColor,hardness,resistance,luminance,requiresTool,false);
		if(addPolished){
			addBlockPaletteStoneSimple("polished_" + name,blockSoundGroup,mapColor,hardness,resistance,luminance,requiresTool,false);
		}
		if(addBricks){
			addBlockPaletteStoneSimple(name + "_brick",blockSoundGroup,mapColor,hardness,resistance,luminance,requiresTool,true);
		}
		if(addTiles){
			addBlockPaletteStoneSimple(name + "_tile",blockSoundGroup,mapColor,hardness,resistance,luminance,requiresTool,true);
		}
	}
	
	public static void addBlockPaletteWoodSimpleFlammable(String name, BlockSoundGroup blockSoundGroup, MapColor mapColor,
												  float hardness, float resistance, int luminance, int fuelTime, int burnTime, int fireSpread) {
		if(luminance < 0) luminance = 0;
		if(luminance > 15) luminance = 15;
		if(fuelTime < 0) luminance = 0;
		final Block BLOCK, STAIRS, SLAB, LOG, LOG_STRIPPED, WOOD, WOOD_STRIPPED;
		final BlockItem BLOCK_ITEM, STAIRS_ITEM, SLAB_ITEM, LOG_ITEM, LOG_STRIPPED_ITEM, WOOD_ITEM, WOOD_STRIPPED_ITEM;
		BLOCK = new Block(FabricBlockSettings
				.create()
				.sounds(blockSoundGroup)
				.mapColor(mapColor)
				.strength(hardness, resistance)
				.luminance(luminance)
				.requiresTool()
		);
		STAIRS = new StairsBlock(BLOCK.getDefaultState(), AbstractBlock.Settings.copy(BLOCK));
		SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLOCK));
		LOG = new PillarBlock(AbstractBlock.Settings.copy(BLOCK));
		LOG_STRIPPED = new PillarBlock(AbstractBlock.Settings.copy(BLOCK));
		WOOD = new PillarBlock(AbstractBlock.Settings.copy(BLOCK));
		WOOD_STRIPPED = new PillarBlock(AbstractBlock.Settings.copy(BLOCK));
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_planks"), BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_stairs"), STAIRS);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_slab"), SLAB);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_log"), LOG);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, "stripped_" + name + "_log"), LOG_STRIPPED);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_wood"), WOOD);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, "stripped_" + name + "_wood"), WOOD_STRIPPED);
		
		NewexpAxe.STRIPPED_BLOCKS.put(LOG, LOG_STRIPPED);
		NewexpAxe.STRIPPED_BLOCKS.put(WOOD, WOOD_STRIPPED);
		
		BLOCK_ITEM = new NewexpBlockItem(BLOCK, new Item.Settings());
		STAIRS_ITEM = new NewexpBlockItem(STAIRS, new Item.Settings());
		SLAB_ITEM = new NewexpBlockItem(SLAB, new Item.Settings());
		LOG_ITEM = new NewexpBlockItem(LOG, new Item.Settings());
		LOG_STRIPPED_ITEM = new NewexpBlockItem(LOG_STRIPPED, new Item.Settings());
		WOOD_ITEM = new NewexpBlockItem(WOOD, new Item.Settings());
		WOOD_STRIPPED_ITEM = new NewexpBlockItem(WOOD_STRIPPED, new Item.Settings());
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_planks"), BLOCK_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_stairs"), STAIRS_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_slab"), SLAB_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_log"), LOG_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "stripped_" + name + "_log"), LOG_STRIPPED_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_wood"), WOOD_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "stripped_" + name + "_wood"), WOOD_STRIPPED_ITEM);
		ItemGroupEvents.modifyEntriesEvent(NewexpItemGroups.BLOCKS).register(content -> {
			content.add(LOG);
			content.add(LOG_STRIPPED);
			content.add(WOOD);
			content.add(WOOD_STRIPPED);
			content.add(BLOCK);
			content.add(STAIRS);
			content.add(SLAB);
		});
		if(fuelTime > 0){
			FuelRegistry.INSTANCE.add(BLOCK, fuelTime);
			FuelRegistry.INSTANCE.add(STAIRS, fuelTime);
			FuelRegistry.INSTANCE.add(SLAB, fuelTime / 2);
			FuelRegistry.INSTANCE.add(LOG, fuelTime);
			FuelRegistry.INSTANCE.add(LOG_STRIPPED, fuelTime);
			FuelRegistry.INSTANCE.add(WOOD, fuelTime);
			FuelRegistry.INSTANCE.add(WOOD_STRIPPED, fuelTime);
		}
		FlammableBlockRegistry fbr = FlammableBlockRegistry.getDefaultInstance();
		fbr.add(BLOCK, burnTime, fireSpread);
		fbr.add(STAIRS, burnTime, fireSpread);
		fbr.add(SLAB, burnTime, fireSpread);
		fbr.add(LOG, burnTime, fireSpread / 4);
		fbr.add(LOG_STRIPPED, burnTime, fireSpread / 4);
		fbr.add(WOOD, burnTime, fireSpread / 4);
		fbr.add(WOOD_STRIPPED, burnTime, fireSpread / 4);
	}
	
	public static void addBlockPaletteWoodSimpleNotFlammable(String name, BlockSoundGroup blockSoundGroup, MapColor mapColor,
														 float hardness, float resistance, int luminance) {
		if(luminance < 0) luminance = 0;
		if(luminance > 15) luminance = 15;
		final Block BLOCK, STAIRS, SLAB, LOG, LOG_STRIPPED, WOOD, WOOD_STRIPPED;
		final BlockItem BLOCK_ITEM, STAIRS_ITEM, SLAB_ITEM, LOG_ITEM, LOG_STRIPPED_ITEM, WOOD_ITEM, WOOD_STRIPPED_ITEM;
		BLOCK = new Block(FabricBlockSettings
				.create()
				.sounds(blockSoundGroup)
				.mapColor(mapColor)
				.strength(hardness, resistance)
				.luminance(luminance)
				.requiresTool()
		);
		STAIRS = new StairsBlock(BLOCK.getDefaultState(), AbstractBlock.Settings.copy(BLOCK));
		SLAB = new SlabBlock(AbstractBlock.Settings.copy(BLOCK));
		LOG = new PillarBlock(AbstractBlock.Settings.copy(BLOCK));
		LOG_STRIPPED = new PillarBlock(AbstractBlock.Settings.copy(BLOCK));
		WOOD = new PillarBlock(AbstractBlock.Settings.copy(BLOCK));
		WOOD_STRIPPED = new PillarBlock(AbstractBlock.Settings.copy(BLOCK));
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_planks"), BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_stairs"), STAIRS);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_slab"), SLAB);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_log"), LOG);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, "stripped_" + name + "_log"), LOG_STRIPPED);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, name + "_wood"), WOOD);
		Registry.register(Registries.BLOCK, new Identifier(NewExpansions.MOD_ID, "stripped_" + name + "_wood"), WOOD_STRIPPED);
		
		NewexpAxe.STRIPPED_BLOCKS.put(LOG, LOG_STRIPPED);
		NewexpAxe.STRIPPED_BLOCKS.put(WOOD, WOOD_STRIPPED);
		
		BLOCK_ITEM = new NewexpBlockItem(BLOCK, new Item.Settings());
		STAIRS_ITEM = new NewexpBlockItem(STAIRS, new Item.Settings());
		SLAB_ITEM = new NewexpBlockItem(SLAB, new Item.Settings());
		LOG_ITEM = new NewexpBlockItem(LOG, new Item.Settings());
		LOG_STRIPPED_ITEM = new NewexpBlockItem(LOG_STRIPPED, new Item.Settings());
		WOOD_ITEM = new NewexpBlockItem(WOOD, new Item.Settings());
		WOOD_STRIPPED_ITEM = new NewexpBlockItem(WOOD_STRIPPED, new Item.Settings());
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_planks"), BLOCK_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_stairs"), STAIRS_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_slab"), SLAB_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_log"), LOG_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "stripped_" + name + "_log"), LOG_STRIPPED_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_wood"), WOOD_ITEM);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, "stripped_" + name + "_wood"), WOOD_STRIPPED_ITEM);
		ItemGroupEvents.modifyEntriesEvent(NewexpItemGroups.BLOCKS).register(content -> {
			content.add(LOG);
			content.add(LOG_STRIPPED);
			content.add(WOOD);
			content.add(WOOD_STRIPPED);
			content.add(BLOCK);
			content.add(STAIRS);
			content.add(SLAB);
		});
	}
}
