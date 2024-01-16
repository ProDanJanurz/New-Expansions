package net.new_expansions.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TridentEntity.class)
public abstract class TridentEntityMixin extends PersistentProjectileEntity {
	@Shadow private boolean dealtDamage;
	
	protected TridentEntityMixin(EntityType<? extends PersistentProjectileEntity> type, World world, ItemStack stack) {
		super(type, world, stack);
	}
	
	@Shadow public abstract boolean hasChanneling();

	
	/**
	 * @author
	 * @reason
	 */
	@Overwrite
	public void onEntityHit(EntityHitResult entityHitResult) {
		Entity entity = entityHitResult.getEntity();
		boolean hardcore = entity.getWorld().getLevelProperties().isHardcore();
		float damage = 8.0F;
		if (entity instanceof LivingEntity livingEntity) {
			damage += EnchantmentHelper.getAttackDamage(this.getItemStack(), livingEntity.getGroup());
		}
		Entity entity2 = this.getOwner();
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
		DamageSource damageSource = this.getDamageSources().trident(this, (Entity)(entity2 == null ? this : entity2));
		this.dealtDamage = true;
		SoundEvent soundEvent = SoundEvents.ITEM_TRIDENT_HIT;
		if (entity.damage(damageSource, damage)) {
			if (entity.getType() == EntityType.ENDERMAN) {
				return;
			}
			
			if (entity instanceof LivingEntity) {
				LivingEntity livingEntity2 = (LivingEntity)entity;
				if (entity2 instanceof LivingEntity) {
					EnchantmentHelper.onUserDamaged(livingEntity2, entity2);
					EnchantmentHelper.onTargetDamaged((LivingEntity)entity2, livingEntity2);
				}
				
				this.onHit(livingEntity2);
			}
		}
		
		this.setVelocity(this.getVelocity().multiply(-0.01, -0.1, -0.01));
		float g = 1.0F;
		if (this.getWorld() instanceof ServerWorld && this.getWorld().isThundering() && this.hasChanneling()) {
			BlockPos blockPos = entity.getBlockPos();
			if (this.getWorld().isSkyVisible(blockPos)) {
				LightningEntity lightningEntity = (LightningEntity)EntityType.LIGHTNING_BOLT.create(this.getWorld());
				if (lightningEntity != null) {
					lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockPos));
					lightningEntity.setChanneler(entity2 instanceof ServerPlayerEntity ? (ServerPlayerEntity)entity2 : null);
					this.getWorld().spawnEntity(lightningEntity);
					soundEvent = SoundEvents.ITEM_TRIDENT_THUNDER;
					g = 5.0F;
				}
			}
		}
		
		this.playSound(soundEvent, g, 1.0F);
	}
}
