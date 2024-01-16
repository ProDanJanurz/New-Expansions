package net.new_expansions.items.magic_items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NewexpXpNecklace extends Item {
	public NewexpXpNecklace(Settings settings) {
		super(settings);
	}
	
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient) {
			if(world.getTime() % 200 == 0){
				((PlayerEntity)entity).addExperience(1);
			}
		}
	}
	
	public boolean hasGlint(ItemStack stack) { return true; }
	
}
