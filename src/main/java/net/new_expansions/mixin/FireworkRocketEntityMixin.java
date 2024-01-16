package net.new_expansions.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Iterator;
import java.util.List;

@Mixin(FireworkRocketEntity.class)
public abstract class FireworkRocketEntityMixin extends ProjectileEntity implements FlyingItemEntity {
	@Shadow @Final private static TrackedData<ItemStack> ITEM;
	
	@Shadow @Nullable private LivingEntity shooter;
	
	public FireworkRocketEntityMixin(EntityType<? extends ProjectileEntity> entityType, World world) {
		super(entityType, world);
	}
	
	/**
	 * @author
	 * @reason
	 */
	@Overwrite
	private void explode() {
		float damage = 0.0F;
		ItemStack itemStack = (ItemStack)this.dataTracker.get(ITEM);
		NbtCompound nbtCompound = itemStack.isEmpty() ? null : itemStack.getSubNbt("Fireworks");
		NbtList nbtList = nbtCompound != null ? nbtCompound.getList("Explosions", 10) : null;
		if (nbtList != null && !nbtList.isEmpty()) {
			damage = 4.0F + (float)(nbtList.size() * 3);
		}
		if(this.getOwner() != null) {
			boolean hardcore = this.getOwner().getWorld().getLevelProperties().isHardcore();
			float damage_multiplier = hardcore ? 0.66667F : 1F;
			damage *= damage_multiplier;
			//System.out.println("entity2: " + entity2.getClass() + " ,damage_multiplier: " + damage_multiplier + " ,damage: " + damage);
		}
		
		if (damage > 0.0F) {
			if (this.shooter != null) {
				this.shooter.damage(this.getDamageSources().fireworks(((FireworkRocketEntity)(Object)this), this.getOwner()), 4.0F + (float)(nbtList.size() * 3));
			}
			
			double d = 5.0;
			Vec3d vec3d = this.getPos();
			List<LivingEntity> list = this.getWorld().getNonSpectatingEntities(LivingEntity.class, this.getBoundingBox().expand( (3.0 + (float)(nbtList.size())) ));
			//System.out.println("radius " + (3.0 + (float)(nbtList.size())));
			Iterator var9 = list.iterator();
			
			while(true) {
				LivingEntity livingEntity;
				do {
					do {
						if (!var9.hasNext()) {
							return;
						}
						
						livingEntity = (LivingEntity)var9.next();
					} while(livingEntity == this.shooter);
				} while(this.squaredDistanceTo(livingEntity) > Math.pow((3.0 + (float)(nbtList.size())), 2));
				
				boolean bl = false;
				
				for(int i = 0; i < 2; ++i) {
					Vec3d vec3d2 = new Vec3d(livingEntity.getX(), livingEntity.getBodyY(0.5 * (double)i), livingEntity.getZ());
					HitResult hitResult = this.getWorld().raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this));
					if (hitResult.getType() == HitResult.Type.MISS) {
						bl = true;
						break;
					}
				}
				
				if (bl) {
					float aoeDamage = damage * (float)Math.sqrt(((3.0 + (float)(nbtList.size())) - (double)this.distanceTo(livingEntity)) / (3.0 + (float)(nbtList.size())));
					livingEntity.damage(this.getDamageSources().fireworks(((FireworkRocketEntity)(Object)this), this.getOwner()), aoeDamage);
				}
			}
		}
	}
}
