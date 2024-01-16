package net.new_expansions.mixin;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Arrays;
import java.util.List;

@Mixin(PersistentProjectileEntity.class)
public abstract class PersistentProjectileEntityMixin extends ProjectileEntity {
	@Shadow private double damage;
	
	@Shadow public abstract byte getPierceLevel();
	
	@Shadow @Nullable private IntOpenHashSet piercedEntities;
	
	@Shadow @Nullable private List<Entity> piercingKilledEntities;
	
	@Shadow public abstract boolean isCritical();
	
	@Shadow private int punch;
	
	@Shadow protected abstract void onHit(LivingEntity target);
	
	@Shadow public abstract boolean isShotFromCrossbow();
	
	@Shadow private SoundEvent sound;
	
	@Shadow public PersistentProjectileEntity.PickupPermission pickupType;
	
	@Shadow protected abstract ItemStack asItemStack();
	
	public PersistentProjectileEntityMixin(EntityType<? extends ProjectileEntity> entityType, World world) {
		super(entityType, world);
	}
	
	/**
	 * @author Pro__dan
	 * @reason converted damage to float
	 */
	@Overwrite
	public void onEntityHit(EntityHitResult entityHitResult) {
		super.onEntityHit(entityHitResult);
		Entity entity = entityHitResult.getEntity();
		boolean hardcore = entity.getWorld().getLevelProperties().isHardcore();
		float projectile_velocity = (float)this.getVelocity().length();
		float damage = (float)(projectile_velocity * this.damage);
		if (this.getPierceLevel() > 0) {
			if (this.piercedEntities == null) {
				this.piercedEntities = new IntOpenHashSet(5);
			}
			
			if (this.piercingKilledEntities == null) {
				this.piercingKilledEntities = Lists.newArrayListWithCapacity(5);
			}
			
			if (this.piercedEntities.size() >= this.getPierceLevel() + 1) {
				this.discard();
				return;
			}
			
			this.piercedEntities.add(entity.getId());
		}
		
		if (this.isCritical()) {
			float l = (float)this.random.nextInt((int) (damage / 2 + 2));
			damage = damage + l;
		}
		
		Entity entity2 = this.getOwner();
		DamageSource damageSource;
		if (entity2 == null) {
			damageSource = this.getDamageSources().arrow(((PersistentProjectileEntity)(Object)this), this);
		} else {
			damageSource = this.getDamageSources().arrow(((PersistentProjectileEntity)(Object)this), entity2);
			if (entity2 instanceof LivingEntity) {
				((LivingEntity)entity2).onAttacking(entity);
			}
		}
		if(entity2 != null) {
			float damage_multiplier = hardcore ? 0.66667F : 1F;
			if (entity2.getClass() == ServerPlayerEntity.class) {
				if (entity.getClass() == ServerPlayerEntity.class) {
					damage_multiplier = 1F;
				}
			} else {
				damage_multiplier = 1F;
			}
			
			damage *= damage_multiplier;
			//System.out.println("entity2: " + entity2.getClass() + " ,damage_multiplier: " + damage_multiplier + " ,damage: " + damage);
		}
		
		boolean bl = entity.getType() == EntityType.ENDERMAN;
		int j = entity.getFireTicks();
		if (this.isOnFire() && !bl) {
			entity.setOnFireFor(5);
		}
		
		if (entity.damage(damageSource, (float)damage)) {
			if (bl) {
				return;
			}
			
			if (entity instanceof LivingEntity) {
				LivingEntity livingEntity = (LivingEntity)entity;
				if (!this.getWorld().isClient && this.getPierceLevel() <= 0) {
					livingEntity.setStuckArrowCount(livingEntity.getStuckArrowCount() + 1);
				}
				
				if (this.punch > 0) {
					double d = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE));
					Vec3d vec3d = this.getVelocity().multiply(1.0, 0.0, 1.0).normalize().multiply((double)this.punch * 0.6 * d);
					if (vec3d.lengthSquared() > 0.0) {
						livingEntity.addVelocity(vec3d.x, 0.1, vec3d.z);
					}
				}
				
				if (!this.getWorld().isClient && entity2 instanceof LivingEntity) {
					EnchantmentHelper.onUserDamaged(livingEntity, entity2);
					EnchantmentHelper.onTargetDamaged((LivingEntity)entity2, livingEntity);
				}
				
				this.onHit(livingEntity);
				if (entity2 != null && livingEntity != entity2 && livingEntity instanceof PlayerEntity && entity2 instanceof ServerPlayerEntity && !this.isSilent()) {
					((ServerPlayerEntity)entity2).networkHandler.sendPacket(new GameStateChangeS2CPacket(GameStateChangeS2CPacket.PROJECTILE_HIT_PLAYER, 0.0F));
				}
				
				if (!entity.isAlive() && this.piercingKilledEntities != null) {
					this.piercingKilledEntities.add(livingEntity);
				}
				
				if (!this.getWorld().isClient && entity2 instanceof ServerPlayerEntity) {
					ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity2;
					if (this.piercingKilledEntities != null && this.isShotFromCrossbow()) {
						Criteria.KILLED_BY_CROSSBOW.trigger(serverPlayerEntity, this.piercingKilledEntities);
					} else if (!entity.isAlive() && this.isShotFromCrossbow()) {
						Criteria.KILLED_BY_CROSSBOW.trigger(serverPlayerEntity, Arrays.asList(entity));
					}
				}
			}
			
			this.playSound(this.sound, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
			if (this.getPierceLevel() <= 0) {
				this.discard();
			}
		} else {
			entity.setFireTicks(j);
			this.setVelocity(this.getVelocity().multiply(-0.1));
			this.setYaw(this.getYaw() + 180.0F);
			this.prevYaw += 180.0F;
			if (!this.getWorld().isClient && this.getVelocity().lengthSquared() < 1.0E-7) {
				if (this.pickupType == PersistentProjectileEntity.PickupPermission.ALLOWED) {
					this.dropStack(this.asItemStack(), 0.1F);
				}
				
				this.discard();
			}
		}
		
	}
}
