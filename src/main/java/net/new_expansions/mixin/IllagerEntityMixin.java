package net.new_expansions.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.raid.Raid;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.new_expansions.entity.ai.goal.CallForHelpGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IllagerEntity.class)
public abstract class IllagerEntityMixin extends RaiderEntity {
	
	protected IllagerEntityMixin(EntityType<? extends RaiderEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Inject(
			method = "initGoals",
			at = @At("HEAD"),
			cancellable = true
	)
	public void initGoals(CallbackInfo info) {
		this.targetSelector.add(0, (new CallForHelpGoal(this, new Class[]{RaiderEntity.class})).setGroupRevenge(new Class[0]));
		this.targetSelector.add(3, new ActiveTargetGoal(this, AbstractPiglinEntity.class, true));
	}
}
