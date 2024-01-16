package net.new_expansions.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.new_expansions.registry.NewexpItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PiglinEntity.class)
public abstract class PiglinEntityMixin extends AbstractPiglinEntity {
	
	@Shadow protected abstract void equipAtChance(EquipmentSlot slot, ItemStack stack, Random random);
	
	public PiglinEntityMixin(EntityType<? extends AbstractPiglinEntity> entityType, World world) {
		super(entityType, world);
	}
	
	/**
	 * @author Pro__Dan
	 * @reason made mob use mod items
	 */
	@Overwrite
	private ItemStack makeInitialWeapon() {
		return (double)this.random.nextFloat() < 0.5 ? new ItemStack(Items.CROSSBOW) : new ItemStack(NewexpItems.GOLD_SWORD);
	}
	
	/**
	 * @author Pro__Dan
	 * @reason made mob use mod items
	 */
	@Overwrite
	public void initEquipment(Random random, LocalDifficulty localDifficulty) {
		if (this.isAdult()) {
			this.equipAtChance(EquipmentSlot.HEAD, new ItemStack(NewexpItems.GOLD_HELMET), random);
			this.equipAtChance(EquipmentSlot.CHEST, new ItemStack(NewexpItems.GOLD_CHESTPLATE), random);
			this.equipAtChance(EquipmentSlot.LEGS, new ItemStack(NewexpItems.GOLD_LEGGINGS), random);
			this.equipAtChance(EquipmentSlot.FEET, new ItemStack(NewexpItems.GOLD_BOOTS), random);
		}
		
	}
}
