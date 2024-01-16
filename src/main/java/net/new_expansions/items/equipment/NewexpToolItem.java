package net.new_expansions.items.equipment;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class NewexpToolItem extends Item {
	private final ToolMaterial material;
	
	public NewexpToolItem(ToolMaterial material, Item.Settings settings) {
		super(settings.maxDamageIfAbsent(material.getDurability()));
		this.material = material;
	}
	
	public ToolMaterial getMaterial() {
		return this.material;
	}
	
	public int getEnchantability() {
		return this.material.getEnchantability();
	}
	
	public boolean canRepair(ItemStack stack, ItemStack ingredient) {
		return this.material.getRepairIngredient().test(ingredient) || super.canRepair(stack, ingredient);
	}
	
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient) {
			if(stack.getDamage() > 0 && world.getTime() % 400 == 0 && !(((PlayerEntity)entity).getEquippedStack(EquipmentSlot.MAINHAND) == stack)){
				switch (this.getMaterial().toString()) {
					case "ENDITE", "GOLD_ENHANCEMENT_ENDITE", "DIAMOND_ENHANCEMENT_ENDITE", "NETHERITE_ENHANCEMENT_ENDITE" -> stack.setDamage(Math.max(stack.getDamage() - 2, 0));
					case "ENDITE_ENHANCEMENT_GOLD", "ENDITE_ENHANCEMENT_DIAMOND", "ENDITE_ENHANCEMENT_NETHERITE" -> stack.setDamage(Math.max(stack.getDamage() - 1, 0));
					case "ENDITE_ENHANCEMENT_ENDITE" -> stack.setDamage(Math.max(stack.getDamage() - 4, 0));
					default -> {
					}
				}
			}
			if(stack.getDamage() > stack.getMaxDamage()){
				stack.setDamage(stack.getMaxDamage() - 1);
			}
		}
	}
}