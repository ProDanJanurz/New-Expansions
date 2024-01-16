package net.new_expansions.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.new_expansions.registry.NewexpItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {
	protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}
	
	/**
	 * @author Pro__Dan
	 * @reason made mob use mod items
	 */
	@Overwrite
	public static Item getEquipmentForSlot(EquipmentSlot equipmentSlot, int equipmentLevel) {
		switch (equipmentSlot) {
			case HEAD:
				if (equipmentLevel == 0) {
					return NewexpItems.LEATHER_HELMET;
				} else if (equipmentLevel == 1) {
					return NewexpItems.CHAINMAIL_HELMET;
				} else if (equipmentLevel == 2) {
					return NewexpItems.IRON_HELMET;
				} else if (equipmentLevel == 3) {
					return NewexpItems.GOLD_HELMET;
				} else if (equipmentLevel == 4) {
					return NewexpItems.DIAMOND_HELMET;
				}
			case CHEST:
				if (equipmentLevel == 0) {
					return NewexpItems.LEATHER_CHESTPLATE;
				} else if (equipmentLevel == 1) {
					return NewexpItems.CHAINMAIL_CHESTPLATE;
				} else if (equipmentLevel == 2) {
					return NewexpItems.IRON_CHESTPLATE;
				} else if (equipmentLevel == 3) {
					return NewexpItems.GOLD_CHESTPLATE;
				} else if (equipmentLevel == 4) {
					return NewexpItems.DIAMOND_CHESTPLATE;
				}
			case LEGS:
				if (equipmentLevel == 0) {
					return NewexpItems.LEATHER_LEGGINGS;
				} else if (equipmentLevel == 1) {
					return NewexpItems.CHAINMAIL_LEGGINGS;
				} else if (equipmentLevel == 2) {
					return NewexpItems.IRON_LEGGINGS;
				} else if (equipmentLevel == 3) {
					return NewexpItems.GOLD_LEGGINGS;
				} else if (equipmentLevel == 4) {
					return NewexpItems.DIAMOND_LEGGINGS;
				}
			case FEET:
				if (equipmentLevel == 0) {
					return NewexpItems.LEATHER_BOOTS;
				} else if (equipmentLevel == 1) {
					return NewexpItems.CHAINMAIL_BOOTS;
				} else if (equipmentLevel == 2) {
					return NewexpItems.IRON_BOOTS;
				} else if (equipmentLevel == 3) {
					return NewexpItems.GOLD_BOOTS;
				} else if (equipmentLevel == 4) {
					return NewexpItems.DIAMOND_BOOTS;
				}
			default:
				return null;
		}
	}
}
