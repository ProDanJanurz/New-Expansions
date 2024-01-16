package net.new_expansions.util;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.new_expansions.NewExpansions;
import net.new_expansions.items.equipment.*;
import net.new_expansions.materials.NewexpArmorMaterial;
import net.new_expansions.registry.NewexpItemGroups;
import net.new_expansions.registry.NewexpItems;


public class NewexpItemUtil {
	public static void addToolSet(String name, ToolMaterial material, boolean isFireproof){
		final NewexpToolItem PICKAXE, SHOVEL, AXE, HOE, SWORD;
		if(isFireproof) {
			PICKAXE = new NewexpPickaxe(material, 1f, -2.8f, new Item.Settings().fireproof());
			SHOVEL = new NewexpShovel(material, 1.5f, -3f, new Item.Settings().fireproof());
			AXE = new NewexpAxe(material, 5f, -3.0f, new Item.Settings().fireproof());
			HOE = new NewexpHoe(material, -2, -2f, new Item.Settings().fireproof());
			SWORD = new NewexpSwordItem(material, 3, -2.4f, new Item.Settings().fireproof());
		}else{
			PICKAXE = new NewexpPickaxe(material, 1f, -2.8f, new Item.Settings());
			SHOVEL = new NewexpShovel(material, 1.5f, -3f, new Item.Settings());
			AXE = new NewexpAxe(material, 5f, -3.0f, new Item.Settings());
			HOE = new NewexpHoe(material, -2, -2f, new Item.Settings());
			SWORD = new NewexpSwordItem(material, 3, -2.4f, new Item.Settings());
		}
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_pickaxe"), PICKAXE);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_axe"), AXE);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_hoe"), HOE);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_shovel"), SHOVEL);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_sword"), SWORD);
		
		ItemGroupEvents.modifyEntriesEvent(NewexpItemGroups.TOOLS).register(content -> {
			content.addBefore(NewexpItems.TURTLE_HELMET, PICKAXE);
			content.addBefore(NewexpItems.TURTLE_HELMET, AXE);
			content.addBefore(NewexpItems.TURTLE_HELMET, HOE);
			content.addBefore(NewexpItems.TURTLE_HELMET, SHOVEL);
			content.addBefore(NewexpItems.TURTLE_HELMET, SWORD);
		});
	}
	public static void addArmorSet(String name, NewexpArmorMaterial material, boolean isFireproof){
		NewexpArmorItem HELMET, CHESTPLATE, LEGGINGS, BOOTS;
		if(isFireproof) {
			HELMET = new NewexpArmorItem(material, NewexpArmorItem.Type.HELMET, new Item.Settings().fireproof());
			CHESTPLATE = new NewexpArmorItem(material, NewexpArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof());
			LEGGINGS = new NewexpArmorItem(material, NewexpArmorItem.Type.LEGGINGS, new Item.Settings().fireproof());
			BOOTS = new NewexpArmorItem(material, NewexpArmorItem.Type.BOOTS, new Item.Settings().fireproof());
		}else{
			HELMET = new NewexpArmorItem(material, NewexpArmorItem.Type.HELMET, new Item.Settings());
			CHESTPLATE = new NewexpArmorItem(material, NewexpArmorItem.Type.CHESTPLATE, new Item.Settings());
			LEGGINGS = new NewexpArmorItem(material, NewexpArmorItem.Type.LEGGINGS, new Item.Settings());
			BOOTS = new NewexpArmorItem(material, NewexpArmorItem.Type.BOOTS, new Item.Settings());
		}
		
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_helmet"), HELMET);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_chestplate"), CHESTPLATE);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_leggings"), LEGGINGS);
		Registry.register(Registries.ITEM, new Identifier(NewExpansions.MOD_ID, name + "_boots"), BOOTS);
		
		ItemGroupEvents.modifyEntriesEvent(NewexpItemGroups.TOOLS).register(content -> {
			content.addBefore(NewexpItems.TURTLE_HELMET, HELMET);
			content.addBefore(NewexpItems.TURTLE_HELMET, CHESTPLATE);
			content.addBefore(NewexpItems.TURTLE_HELMET, LEGGINGS);
			content.addBefore(NewexpItems.TURTLE_HELMET, BOOTS);
		});
	}
	public static void addEquipmentSet(String name,ToolMaterial materialTool, NewexpArmorMaterial materialArmor, boolean isFireproof){
		addToolSet(name, materialTool, isFireproof);
		addArmorSet(name, materialArmor, isFireproof);
	}
}
