package net.new_expansions.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BowItem.class)
public abstract class BowItemMixin extends RangedWeaponItem implements Vanishable {
	
	public BowItemMixin(Settings settings) {
		super(settings);
	}
	
	@Shadow public abstract int getMaxUseTime(ItemStack stack);
	
	/**
	 * @author Pro__Dan
	 * @reason Nerfed Power enchant
	 */
	@Overwrite
	public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
		if (user instanceof PlayerEntity playerEntity) {
			boolean bl = playerEntity.getAbilities().creativeMode || EnchantmentHelper.getLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemStack = playerEntity.getProjectileType(stack);
			if (!itemStack.isEmpty() || bl) {
				if (itemStack.isEmpty()) {
					itemStack = new ItemStack(Items.ARROW);
				}
				
				int i = this.getMaxUseTime(stack) - remainingUseTicks;
				float f = BowItem.getPullProgress(i);
				if (!((double)f < 0.1)) {
					boolean bl2 = bl && itemStack.isOf(Items.ARROW);
					if (!world.isClient) {
						ArrowItem arrowItem = (ArrowItem)(itemStack.getItem() instanceof ArrowItem ? itemStack.getItem() : Items.ARROW);
						PersistentProjectileEntity persistentProjectileEntity = arrowItem.createArrow(world, itemStack, playerEntity);
						persistentProjectileEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, f * 3.0F, 1.0F);
						if (f == 1.0F) {
							persistentProjectileEntity.setCritical(true);
						}
						
						int j = EnchantmentHelper.getLevel(Enchantments.POWER, stack);
						if (j > 0) {
							persistentProjectileEntity.setDamage(persistentProjectileEntity.getDamage() + (double)j * 0.4);
						}
						
						int k = EnchantmentHelper.getLevel(Enchantments.PUNCH, stack);
						if (k > 0) {
							persistentProjectileEntity.setPunch(k);
						}
						
						if (EnchantmentHelper.getLevel(Enchantments.FLAME, stack) > 0) {
							persistentProjectileEntity.setOnFireFor(100);
						}
						
						stack.damage(1, playerEntity, (p) -> {
							p.sendToolBreakStatus(playerEntity.getActiveHand());
						});
						if (bl2 || playerEntity.getAbilities().creativeMode && (itemStack.isOf(Items.SPECTRAL_ARROW) || itemStack.isOf(Items.TIPPED_ARROW))) {
							persistentProjectileEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
						}
						
						world.spawnEntity(persistentProjectileEntity);
					}
					
					world.playSound((PlayerEntity)null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
					if (!bl2 && !playerEntity.getAbilities().creativeMode) {
						itemStack.decrement(1);
						if (itemStack.isEmpty()) {
							playerEntity.getInventory().removeOne(itemStack);
						}
					}
					
					playerEntity.incrementStat(Stats.USED.getOrCreateStat(((BowItemMixin)(Object)this)));
				}
			}
		}
	}
}
