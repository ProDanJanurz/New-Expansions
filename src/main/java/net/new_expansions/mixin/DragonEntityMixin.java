package net.new_expansions.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonFight;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EnderDragonEntity.class)
public abstract class DragonEntityMixin extends MobEntity implements Monster {
	@Shadow @Nullable public abstract EnderDragonFight getFight();
	
	@Shadow public int ticksSinceDeath;
	
	@Shadow @Final @Nullable private EnderDragonFight fight;
	
	protected DragonEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Inject(
			method = "updatePostDeath",
			at = @At("TAIL"),
			cancellable = true
	)
	public void updatePostDeath(CallbackInfo info) {
		if (this.ticksSinceDeath == 199 && this.getWorld() instanceof ServerWorld) {
			ExperienceOrbEntity.spawn((ServerWorld) this.getWorld(), this.getPos(), MathHelper.floor((float)2500));
		}
		if (this.ticksSinceDeath == 199 && this.fight != null && !this.fight.hasPreviouslyKilled() && this.getWorld() instanceof ServerWorld) {
			ExperienceOrbEntity.spawn((ServerWorld) this.getWorld(), this.getPos(), MathHelper.floor((float)2500));
			ExperienceOrbEntity.spawn((ServerWorld)this.getWorld(), this.getPos(), MathHelper.floor((float)2500));
			ExperienceOrbEntity.spawn((ServerWorld)this.getWorld(), this.getPos(), MathHelper.floor((float)1000));
			ExperienceOrbEntity.spawn((ServerWorld)this.getWorld(), this.getPos(), MathHelper.floor((float)1000));
			ExperienceOrbEntity.spawn((ServerWorld)this.getWorld(), this.getPos(), MathHelper.floor((float)1000));
			ExperienceOrbEntity.spawn((ServerWorld)this.getWorld(), this.getPos(), MathHelper.floor((float)1000));
			ExperienceOrbEntity.spawn((ServerWorld)this.getWorld(), this.getPos(), MathHelper.floor((float)1000));
			ExperienceOrbEntity.spawn((ServerWorld)this.getWorld(), this.getPos(), MathHelper.floor((float)500));
		}
	}
}
