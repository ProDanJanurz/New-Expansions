package net.new_expansions.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.new_expansions.registry.NewexpAttributes;
import org.spongepowered.asm.mixin.*;

import java.util.function.Predicate;

@Mixin(WolfEntity.class)
public abstract class WolfEntityMixin extends TameableEntity implements Angerable {
	
	@Shadow @Final public static final Predicate<LivingEntity> FOLLOW_TAMED_PREDICATE = (entity) -> {
		EntityType<?> entityType = entity.getType();
		return entityType == EntityType.SHEEP || entityType == EntityType.RABBIT || entityType == EntityType.FOX || entityType == EntityType.CHICKEN || entityType == EntityType.COW || entityType == EntityType.PIG;
	};
	
	protected WolfEntityMixin(EntityType<? extends TameableEntity> entityType, World world) {
		super(entityType, world);
	}
	
	/**
	 * @author Pro__Dan
	 * @reason added attribute and modifying base values
	 */
	@Overwrite
	public static DefaultAttributeContainer.Builder createWolfAttributes() {
		return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896).add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0).add(NewexpAttributes.KILLS, 0.0).add(NewexpAttributes.TAMED, 0.0);
	}
	
	/**
	 * @author Pro__Dan
	 * @reason setting attributes
	 */
	@Overwrite
	public void setTamed(boolean tamed) {
		super.setTamed(tamed);
		if (tamed && this.getAttributeValue(NewexpAttributes.TAMED) == 0) {
			this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(this.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH) * 2);
			this.setHealth((float) (this.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH) * 2));
			this.getAttributeInstance(NewexpAttributes.TAMED).setBaseValue(1F);
		}
	}
	
	/**
	 * @author Pro__Dan
	 * @reason added wolf leveling
	 */
	@Overwrite
	public boolean tryAttack(Entity target) {
		float damage = (float) this.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE);
		float health = (float) this.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH);
		float speed = (float) this.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED);
		float kills = (float) this.getAttributeValue(NewexpAttributes.KILLS);
		boolean bl = target.damage(this.getDamageSources().mobAttack(this), damage);
		if (bl) {
			this.applyDamageEffects(this, target);
		}
		boolean dead = !target.isAlive();
		if(dead && kills < 250.0F){
			this.getAttributeInstance(NewexpAttributes.KILLS).setBaseValue(kills + 1.0F);
			kills = (float) this.getAttributeValue(NewexpAttributes.KILLS);
			if(kills % 50 == 0.0){
				this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(damage + 1F);
				this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(speed + 0.03F);
				if(this.isTamed()){
					this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(health + 4F);
					this.setHealth(health + 4F);
				}else{
					this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(health + 2F);
					this.setHealth(health + 2F);
				}
				this.getWorld().playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.MASTER, 0.5F, 1.0F);
				((ServerWorld) this.getWorld()).spawnParticles(ParticleTypes.HAPPY_VILLAGER, this.getX(), this.getBodyY(0.5), this.getZ(), 30, 0.3, 0.3, 0.3, 0.4);
			}
		}
		return bl;
	}
	
	/**
	 * @author Pro__Dan
	 * @reason fixed tail angle at high max healths and low healths
	 */
	@Overwrite
	public float getTailAngle() {
		if (this.hasAngerTime()) {
			return 1.5393804F;
		} else {
			return this.isTamed() ? (0.55F - ( ((this.getMaxHealth() - this.getHealth()) / this.getMaxHealth()) * 20 ) * 0.02F) * 3.1415927F : 0.62831855F;
		}
	}
}
