package net.new_expansions.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class NewexpStewItem extends Item {
	public NewexpStewItem(Settings settings) {
		super(settings);
	}
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity)user : null;
		
		if (!world.isClient) {
			super.finishUsing(stack, world, user);
		}
		
		if (playerEntity == null || !playerEntity.getAbilities().creativeMode) {
			if (stack.isEmpty()) {
				return new ItemStack(Items.BOWL);
			}
			
			if (playerEntity != null) {
				playerEntity.getInventory().insertStack(new ItemStack(Items.BOWL));
			}
		}
		return stack;
	}
}
