package net.new_expansions.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.util.collection.DefaultedList;
import net.new_expansions.items.equipment.NewexpArmorItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerInventory.class)
public abstract class PlayerInventoryMixin {
	@Shadow @Final public DefaultedList<ItemStack> armor;
	
	@Shadow @Final public PlayerEntity player;
	
	/**
	 * @author
	 * Pro__Dan
	 * @reason Damage durability on mods armor
	 */
	@Overwrite
	public void damageArmor(DamageSource damageSource, float amount, int[] slots) {
		if (!(amount <= 0.0F)) {
			amount /= 4.0F;
			if (amount < 1.0F) {
				amount = 1.0F;
			}
			
			int[] var4 = slots;
			int var5 = slots.length;
			
			for(int var6 = 0; var6 < var5; ++var6) {
				int i = var4[var6];
				ItemStack itemStack = (ItemStack)this.armor.get(i);
				if ((!damageSource.isIn(DamageTypeTags.IS_FIRE) || !itemStack.getItem().isFireproof()) && (itemStack.getItem() instanceof ArmorItem || itemStack.getItem() instanceof NewexpArmorItem)) {
					itemStack.damage((int)amount, this.player, (player) -> {
						player.sendEquipmentBreakStatus(EquipmentSlot.fromTypeIndex(EquipmentSlot.Type.ARMOR, i));
					});
				}
			}
			
		}
	}
}
