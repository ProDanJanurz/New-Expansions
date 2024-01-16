package net.new_expansions.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.new_expansions.items.equipment.NewexpArmorItem;

public class NewexpArmorAndToolUtil {
	public static void repair(ItemStack stack, int speed, int regenAmount){
		/*
		while(regenAmount >= speed){
			int temp = stack.getDamage();
			if(stack.getDamage() > 1){
				temp -= 2;
				stack.setDamage(temp);
				regenAmount = 0;
			}else{
				temp -= 1;
				stack.setDamage(temp);
				regenAmount = 0;
			}
		}
		
		 */
		if(regenAmount >= speed){
			stack.setDamage(stack.getDamage() - 1);
		}
	}
	public static void repairItem(Item item, ItemStack stack, int speed, int regenAmount){
		if(item.getClass() == NewexpArmorItem.class && stack.getDamage() > 0){
			switch (((NewexpArmorItem) item).getMaterial() + "") {
				case "E", "GE", "DE", "NE" -> repair(stack, speed, regenAmount);
				case "EG", "ED", "EN" -> repair(stack, speed * 2, regenAmount);
				case "EE" -> repair(stack, speed / 2, regenAmount);
				default -> {
				}
			}
		}
		if(item.getClass() == ToolItem.class && stack.getDamage() > 0){
			switch (((ToolItem) item).getMaterial() + "") {
				case "E", "GE", "DE", "NE" -> repair(stack, speed, regenAmount);
				case "EG", "ED", "EN" -> repair(stack, speed * 2, regenAmount);
				case "EE" -> repair(stack, speed / 2, regenAmount);
				default -> {
				}
			}
		}
	}
}
