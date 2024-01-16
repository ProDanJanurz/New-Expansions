package net.new_expansions.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.CrossbowUser;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.new_expansions.registry.NewexpEnchantments;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import static net.minecraft.item.CrossbowItem.hasProjectile;

@Mixin(CrossbowItem.class)
public abstract class CrossbowItemMixin {
	@Shadow private boolean charged;
	
	@Shadow private boolean loaded;
	
	/**
	 * @author
	 * @reason
	 */
	@Overwrite
	private static float getSpeed(ItemStack stack) {
		int slipstream = EnchantmentHelper.getLevel(NewexpEnchantments.SLIPSTREAM, stack);
		if(slipstream > 0){
			return hasProjectile(stack, Items.FIREWORK_ROCKET) ? 3F : 10F;
		}else{
			return hasProjectile(stack, Items.FIREWORK_ROCKET) ? 2F : 5F;
		}
	}
	/**
	 * @author
	 * @reason
	 */
	@Overwrite
	private static PersistentProjectileEntity createArrow(World world, LivingEntity entity, ItemStack crossbow, ItemStack arrow) {
		ArrowItem arrowItem = (ArrowItem)(arrow.getItem() instanceof ArrowItem ? arrow.getItem() : Items.ARROW);
		PersistentProjectileEntity persistentProjectileEntity = arrowItem.createArrow(world, arrow, entity);
		
		persistentProjectileEntity.setSound(SoundEvents.ITEM_CROSSBOW_HIT);
		persistentProjectileEntity.setShotFromCrossbow(true);
		int i = EnchantmentHelper.getLevel(Enchantments.PIERCING, crossbow);
		if (i > 0) {
			persistentProjectileEntity.setPierceLevel((byte)i);
		}
		
		return persistentProjectileEntity;
	}
	/**
	 * @author
	 * @reason
	 */
	@Overwrite
	private static void shoot(World world, LivingEntity shooter, Hand hand, ItemStack crossbow, ItemStack projectile, float soundPitch, boolean creative, float speed, float divergence, float simulated) {
		if (!world.isClient) {
			boolean bl = projectile.isOf(Items.FIREWORK_ROCKET);
			Object projectileEntity;
			if (bl) {
				projectileEntity = new FireworkRocketEntity(world, projectile, shooter, shooter.getX(), shooter.getEyeY() - 0.15000000596046448, shooter.getZ(), true);
			} else {
				projectileEntity = createArrow(world, shooter, crossbow, projectile);
				if (creative || simulated != 0.0F) {
					((PersistentProjectileEntity)projectileEntity).pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
				}
			}
			
			if (shooter instanceof CrossbowUser) {
				CrossbowUser crossbowUser = (CrossbowUser)shooter;
				crossbowUser.shoot(shooter, crossbowUser.getTarget(), (ProjectileEntity)projectileEntity, simulated, getSpeed(crossbow));
			} else {
				Vec3d vec3d = shooter.getOppositeRotationVector(1.0F);
				Quaternionf quaternionf = (new Quaternionf()).setAngleAxis((double)(simulated * 0.017453292F), vec3d.x, vec3d.y, vec3d.z);
				Vec3d vec3d2 = shooter.getRotationVec(1.0F);
				Vector3f vector3f = vec3d2.toVector3f().rotate(quaternionf);
				((ProjectileEntity)projectileEntity).setVelocity((double)vector3f.x(), (double)vector3f.y(), (double)vector3f.z(), speed, divergence);
			}
			
			crossbow.damage(bl ? 3 : 1, shooter, (e) -> {
				e.sendToolBreakStatus(hand);
			});
			world.spawnEntity((Entity)projectileEntity);
			world.playSound((PlayerEntity)null, shooter.getX(), shooter.getY(), shooter.getZ(), SoundEvents.ITEM_CROSSBOW_SHOOT, SoundCategory.PLAYERS, 1.0F, soundPitch);
		}
	}
	/**
	 * @author
	 * @reason
	 */
	@Overwrite
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		if (CrossbowItem.isCharged(itemStack)) {
			CrossbowItem.shootAll(world, user, hand, itemStack, getSpeed(itemStack), 0.1F);
			CrossbowItem.setCharged(itemStack, false);
			return TypedActionResult.consume(itemStack);
		} else if (!user.getProjectileType(itemStack).isEmpty()) {
			if (!CrossbowItem.isCharged(itemStack)) {
				this.charged = false;
				this.loaded = false;
				user.setCurrentHand(hand);
			}
			
			return TypedActionResult.consume(itemStack);
		} else {
			return TypedActionResult.fail(itemStack);
		}
	}
}
