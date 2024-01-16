package net.new_expansions.mixin;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.new_expansions.registry.NewexpGamerules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(HungerManager.class)
public abstract class HungerManagerMixin {
	
	@Shadow private int prevFoodLevel;
	
	@Shadow private int foodLevel;
	
	@Shadow private float exhaustion;
	
	@Shadow private float saturationLevel;
	
	@Shadow private int foodTickTimer;
	
	@Shadow public abstract void addExhaustion(float exhaustion);
	
	/**
	 * @author Pro__Dan
	 * @reason added gamerules
	 */
	@Overwrite
	public void update(PlayerEntity player) {
		Difficulty difficulty = player.getWorld().getDifficulty();
		this.prevFoodLevel = this.foodLevel;
		if (this.exhaustion > 4.0F) {
			this.exhaustion -= 4.0F;
			if (this.saturationLevel > 0.0F) {
				this.saturationLevel = Math.max(this.saturationLevel - 1.0F, 0.0F);
			} else if (difficulty != Difficulty.PEACEFUL) {
				this.foodLevel = Math.max(this.foodLevel - 1, 0);
			}
		}
		
		boolean doNaturalRegeneration = player.getWorld().getGameRules().getBoolean(GameRules.NATURAL_REGENERATION);
		boolean doSaturationRegeneration = player.getWorld().getGameRules().getBoolean(NewexpGamerules.DO_SATURATION_REGENERATION);
		boolean doHungerRegeneration = player.getWorld().getGameRules().getBoolean(NewexpGamerules.DO_HUNGER_REGENERATION);
		int doSaturationRegenerationSpeed = player.getWorld().getGameRules().getInt(NewexpGamerules.SATURATION_REGENERATION_SPEED);
		int doHungerRegenerationSpeed = player.getWorld().getGameRules().getInt(NewexpGamerules.HUNGER_REGENERATION_SPEED);
		int SaturationRegenerationLevel = player.getWorld().getGameRules().getInt(NewexpGamerules.SATURATION_REGENERATION_LEVEL);
		int SaturationRegenerationHungerLevel = player.getWorld().getGameRules().getInt(NewexpGamerules.SATURATION_REGENERATION_HUNGER_LEVEL);
		int HungerRegenerationLevel = player.getWorld().getGameRules().getInt(NewexpGamerules.HUNGER_REGENERATION_LEVEL);
		int doSaturationRegenerationCost = player.getWorld().getGameRules().getInt(NewexpGamerules.SATURATION_REGENERATION_COST);
		int doHungerRegenerationCost = player.getWorld().getGameRules().getInt(NewexpGamerules.HUNGER_REGENERATION_COST);
		if (doNaturalRegeneration && doSaturationRegeneration && this.saturationLevel > (float)SaturationRegenerationLevel && player.canFoodHeal() && this.foodLevel >= SaturationRegenerationHungerLevel) {
			++this.foodTickTimer;
			if (this.foodTickTimer >= doSaturationRegenerationSpeed) {
				player.heal(1);
				this.addExhaustion((float) doSaturationRegenerationCost / 100.0F);
				this.foodTickTimer = 0;
			}
		} else if (doNaturalRegeneration && doHungerRegeneration && this.foodLevel >= HungerRegenerationLevel && player.canFoodHeal()) {
			++this.foodTickTimer;
			if (this.foodTickTimer >= doHungerRegenerationSpeed) {
				player.heal(1.0F);
				this.addExhaustion((float) doHungerRegenerationCost / 100.0F);
				this.foodTickTimer = 0;
			}
		} else if (this.foodLevel <= 0) {
			++this.foodTickTimer;
			if (this.foodTickTimer >= 80) {
				if (player.getHealth() > 10.0F || difficulty == Difficulty.HARD || player.getHealth() > 1.0F && difficulty == Difficulty.NORMAL) {
					player.damage(player.getDamageSources().starve(), 1.0F);
				}
				
				this.foodTickTimer = 0;
			}
		} else {
			this.foodTickTimer = 0;
		}
		
	}
}
