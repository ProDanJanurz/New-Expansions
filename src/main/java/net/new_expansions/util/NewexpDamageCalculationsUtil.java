package net.new_expansions.util;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.DamageUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.MathHelper;

public class NewexpDamageCalculationsUtil {
	public static float applyDamageReductionToDamage(LivingEntity instance, DamageSource source, float damage, float armor, float armorToughness, float trueArmor) {
		if (!source.isIn(DamageTypeTags.BYPASSES_ARMOR)) {
			instance.damageArmor(source, damage);
			float maxArmor = MathHelper.clamp(armor, 0.0F, 20.0F);
			float armorReductionResistance = 2.0F + armorToughness / 4.0F;
			float reducedArmor = MathHelper.clamp(maxArmor - damage / armorReductionResistance, maxArmor * 0.2F, 20.0F);
			damage *= (1.0F - (reducedArmor / 25.0F));
		}
		
		damage *= (1.0F - (trueArmor / 50.0F));
		
		if(!source.isIn(DamageTypeTags.BYPASSES_ENCHANTMENTS)){
			int enchantmentProtection;
			enchantmentProtection = EnchantmentHelper.getProtectionAmount(instance.getArmorItems(), source);
			if (enchantmentProtection > 0) {
				float maxProtection = MathHelper.clamp(enchantmentProtection, 0.0F, 80.0F);
				damage *= (1.0F - (maxProtection / 100.0F));
			}
		}
		
		if(!source.isIn(DamageTypeTags.BYPASSES_EFFECTS)){
			int effectProtection;
			if (instance.hasStatusEffect(StatusEffects.RESISTANCE) && !source.isIn(DamageTypeTags.BYPASSES_RESISTANCE)) {
				effectProtection = (instance.getStatusEffect(StatusEffects.RESISTANCE).getAmplifier() + 1) * 5;
				int j = 25 - effectProtection;
				float f = damage * (float)j;
				float g = damage;
				damage = Math.max(f / 25.0F, 0.0F);
				float h = g - damage;
				if (h > 0.0F && h < 3.4028235E37F) {
					if (instance instanceof ServerPlayerEntity) {
						((ServerPlayerEntity)instance).increaseStat(Stats.DAMAGE_RESISTED, Math.round(h * 10.0F));
					} else if (source.getAttacker() instanceof ServerPlayerEntity) {
						((ServerPlayerEntity)source.getAttacker()).increaseStat(Stats.DAMAGE_DEALT_RESISTED, Math.round(h * 10.0F));
					}
				}
			}
		}
		
		return Math.max(damage, 0.0F);
	}
	/*
	public static float applyArmorReductionToDamage(LivingEntity instance, DamageSource source, float damage, float armor, float armorToughness, float trueArmor) {
		if (!source.isIn(DamageTypeTags.BYPASSES_ARMOR)) {
			instance.damageArmor(source, damage);
			float maxArmor = MathHelper.clamp(armor, 0.0F, 20.0F);
			float armorReductionResistance = 2.0F + armorToughness / 4.0F;
			float reducedArmor = MathHelper.clamp(maxArmor - damage / armorReductionResistance, maxArmor * 0.2F, 20.0F);
			damage *= (1.0F - reducedArmor / 25.0F);
		}
		return damage - (damage * (trueArmor / 50.0F));
	}
	 */
}
