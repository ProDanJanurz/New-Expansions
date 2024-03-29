package net.new_expansions.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.*;
import net.minecraft.text.Text;
import net.new_expansions.items.equipment.*;
import net.new_expansions.registry.NewexpEnchantments;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Iterator;
import java.util.Map;

import static net.minecraft.enchantment.EnchantmentTarget.*;
import static net.minecraft.enchantment.EnchantmentTarget.WEAPON;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin extends ForgingScreenHandler {
	@Shadow @Final private Property levelCost;
	
	@Shadow private int repairItemUsage;
	
	@Shadow private String newItemName;
	
	public AnvilScreenHandlerMixin(@Nullable ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
		super(type, syncId, playerInventory, context);
	}
	
	@Shadow
	public static int getNextCost(int cost) {
		return cost * 2 + 1;
	}

	
	/**
	 * @author
	 * @reason
	 */
	@Overwrite
	public void updateResult() {
		ItemStack itemStack = this.input.getStack(0);
		this.levelCost.set(1);
		int i = 0;
		int j = 0;
		int k = 0;
		if (itemStack.isEmpty()) {
			this.output.setStack(0, ItemStack.EMPTY);
			this.levelCost.set(0);
		} else {
			ItemStack itemStack2 = itemStack.copy();
			ItemStack itemStack3 = this.input.getStack(1);
			Map<Enchantment, Integer> map = EnchantmentHelper.get(itemStack2);
			j += itemStack.getRepairCost() + (itemStack3.isEmpty() ? 0 : itemStack3.getRepairCost());
			this.repairItemUsage = 0;
			if (!itemStack3.isEmpty()) {
				boolean bl = itemStack3.isOf(Items.ENCHANTED_BOOK) && !EnchantedBookItem.getEnchantmentNbt(itemStack3).isEmpty();
				int l;
				int m;
				int n;
				if (itemStack2.isDamageable() && itemStack2.getItem().canRepair(itemStack, itemStack3)) {
					l = Math.min(itemStack2.getDamage(), itemStack2.getMaxDamage() / 4);
					if (l <= 0) {
						this.output.setStack(0, ItemStack.EMPTY);
						this.levelCost.set(0);
						return;
					}
					
					for(m = 0; l > 0 && m < itemStack3.getCount(); ++m) {
						n = itemStack2.getDamage() - l;
						itemStack2.setDamage(n);
						++i;
						l = Math.min(itemStack2.getDamage(), itemStack2.getMaxDamage() / 4);
					}
					
					this.repairItemUsage = m;
				} else {
					if (!bl && (!itemStack2.isOf(itemStack3.getItem()) || !itemStack2.isDamageable())) {
						this.output.setStack(0, ItemStack.EMPTY);
						this.levelCost.set(0);
						return;
					}
					
					if (itemStack2.isDamageable() && !bl) {
						l = itemStack.getMaxDamage() - itemStack.getDamage();
						m = itemStack3.getMaxDamage() - itemStack3.getDamage();
						n = m + itemStack2.getMaxDamage() * 12 / 100;
						int o = l + n;
						int p = itemStack2.getMaxDamage() - o;
						if (p < 0) {
							p = 0;
						}
						
						if (p < itemStack2.getDamage()) {
							itemStack2.setDamage(p);
							i += 2;
						}
					}
					
					Map<Enchantment, Integer> map2 = EnchantmentHelper.get(itemStack3);
					boolean bl2 = false;
					boolean bl3 = false;
					Iterator var23 = map2.keySet().iterator();
					
					label155:
					while(true) {
						Enchantment enchantment;
						do {
							if (!var23.hasNext()) {
								if (bl3 && !bl2) {
									this.output.setStack(0, ItemStack.EMPTY);
									this.levelCost.set(0);
									return;
								}
								break label155;
							}
							
							enchantment = (Enchantment)var23.next();
						} while(enchantment == null);
						
						int q = (Integer)map.getOrDefault(enchantment, 0);
						int r = (Integer)map2.get(enchantment);
						r = q == r ? r + 1 : Math.max(r, q);
						boolean bl4 = enchantment.isAcceptableItem(itemStack);
						if(itemStack.getItem() instanceof NewexpArmorItem){
							if(((NewexpArmorItem) itemStack.getItem()).getSlotType() == EquipmentSlot.FEET){
								bl4 = enchantment.target == BREAKABLE || enchantment.target == VANISHABLE || enchantment.target == WEARABLE || enchantment.target == ARMOR || enchantment.target == ARMOR_FEET;
							}
							if(((NewexpArmorItem) itemStack.getItem()).getSlotType() == EquipmentSlot.LEGS){
								bl4 = enchantment.target == BREAKABLE || enchantment.target == VANISHABLE || enchantment.target == WEARABLE || enchantment.target == ARMOR || enchantment.target == ARMOR_LEGS;
							}
							if(((NewexpArmorItem) itemStack.getItem()).getSlotType() == EquipmentSlot.CHEST){
								bl4 = enchantment.target == BREAKABLE || enchantment.target == VANISHABLE || enchantment.target == WEARABLE || enchantment.target == ARMOR || enchantment.target == ARMOR_CHEST;
							}
							if(((NewexpArmorItem) itemStack.getItem()).getSlotType() == EquipmentSlot.HEAD){
								bl4 = enchantment.target == BREAKABLE || enchantment.target == VANISHABLE || enchantment.target == WEARABLE || enchantment.target == ARMOR || enchantment.target == ARMOR_HEAD;
							}
						}
						
						if(itemStack.getItem() instanceof NewexpToolItem){
							if(itemStack.getItem() instanceof NewexpMiningToolItem && !(itemStack.getItem() instanceof NewexpDrill)){
								if(itemStack.getItem() instanceof NewexpShovel || itemStack.getItem() instanceof NewexpHoe){
									bl4 = enchantment.target == BREAKABLE || enchantment.target == VANISHABLE || (enchantment.target == DIGGER && enchantment != NewexpEnchantments.PERFORMANCE && enchantment != NewexpEnchantments.MINERAL_EXTRACTION);
								}else if(itemStack.getItem() instanceof NewexpAxe){
									bl4 = enchantment.target == BREAKABLE || enchantment.target == VANISHABLE || (enchantment.target == DIGGER && enchantment != NewexpEnchantments.MINERAL_EXTRACTION);
								}else{
									bl4 = enchantment.target == BREAKABLE || enchantment.target == VANISHABLE || enchantment.target == DIGGER;
								}
							}
							if(itemStack.getItem() instanceof NewexpSwordItem){
								bl4 = enchantment.target == BREAKABLE || enchantment.target == VANISHABLE || enchantment.target == WEAPON;
							}
						}
						if (this.player.getAbilities().creativeMode || itemStack.isOf(Items.ENCHANTED_BOOK)) {
							bl4 = true;
						}
						
						Iterator var17 = map.keySet().iterator();
						
						while(var17.hasNext()) {
							Enchantment enchantment2 = (Enchantment)var17.next();
							if (enchantment2 != enchantment && !enchantment.canCombine(enchantment2)) {
								bl4 = false;
								++i;
							}
						}
						
						if (!bl4) {
							bl3 = true;
						} else {
							bl2 = true;
							if (r > enchantment.getMaxLevel()) {
								r = enchantment.getMaxLevel();
							}
							
							map.put(enchantment, r);
							int s = 0;
							switch (enchantment.getRarity()) {
								case COMMON:
									s = 1;
									break;
								case UNCOMMON:
									s = 2;
									break;
								case RARE:
									s = 4;
									break;
								case VERY_RARE:
									s = 8;
							}
							
							if (bl) {
								s = Math.max(1, s / 2);
							}
							
							i += s * r;
							if (itemStack.getCount() > 1) {
								i = 40;
							}
						}
					}
				}
			}
			
			if (StringUtils.isBlank(this.newItemName)) {
				if (itemStack.hasCustomName()) {
					k = 1;
					i += k;
					itemStack2.removeCustomName();
				}
			} else if (!this.newItemName.equals(itemStack.getName().getString())) {
				k = 1;
				i += k;
				itemStack2.setCustomName(Text.literal(this.newItemName));
			}
			
			this.levelCost.set(j + i);
			if (i <= 0) {
				itemStack2 = ItemStack.EMPTY;
			}
			/*
			if (k == i && k > 0 && this.levelCost.get() >= 40) {
				this.levelCost.set(39);
			}
			
			if (this.levelCost.get() >= 40 && !this.player.getAbilities().creativeMode) {
				itemStack2 = ItemStack.EMPTY;
			}
			*/
			if (!itemStack2.isEmpty()) {
				int t = itemStack2.getRepairCost();
				if (!itemStack3.isEmpty() && t < itemStack3.getRepairCost()) {
					t = itemStack3.getRepairCost();
				}
				
				if (k != i || k == 0) {
					t = getNextCost(t);
				}
				
				itemStack2.setRepairCost(t);
				EnchantmentHelper.set(map, itemStack2);
			}
			
			this.output.setStack(0, itemStack2);
			this.sendContentUpdates();
		}
	}
}
