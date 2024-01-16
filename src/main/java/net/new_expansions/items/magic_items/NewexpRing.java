package net.new_expansions.items.magic_items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class NewexpRing extends Item {
	public boolean active = false;
	public NewexpRing(Settings settings) {
		super(settings);
	}
	
	public static boolean getActive(ItemStack stack) {
		NbtCompound nbtCompound = stack.getNbt();
		assert nbtCompound != null;
		if(nbtCompound == null){
			return false;
		}else{
			return nbtCompound.getBoolean("Active");
		}
	}
	
	public static void setActive(ItemStack stack, boolean act) {
		NbtCompound nbtCompound = stack.getOrCreateNbt();
		nbtCompound.putBoolean("Active", act);
	}
	
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient) {
			if(getActive(stack)){
				((PlayerEntity)entity).addExperience(1);
			}
		}
	}
	
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		if (!world.isClient()) {
			setActive(itemStack, !getActive(itemStack));
			return TypedActionResult.success(itemStack, world.isClient());
		} else {
			return TypedActionResult.fail(itemStack);
		}
	}
	
	public boolean hasGlint(ItemStack stack) {
		if(!stack.hasNbt()){
			setActive(stack, active);
		}
		return getActive(stack);
	}
}