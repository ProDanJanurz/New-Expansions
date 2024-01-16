package net.new_expansions.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import net.new_expansions.registry.NewexpItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(VindicatorEntity.class)
public abstract class VindicatorEntityMixin extends IllagerEntity {
	protected VindicatorEntityMixin(EntityType<? extends IllagerEntity> entityType, World world) {
		super(entityType, world);
	}
	
	/**
	 * @author Pro__Dan
	 * @reason made mob use mod items
	 */
	@Overwrite
	public void initEquipment(Random random, LocalDifficulty localDifficulty) {
		this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(NewexpItems.IRON_AXE));
	}
}
