package net.new_expansions.mixin;

import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.registry.tag.DamageTypeTags;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ProtectionEnchantment.class)
public abstract class ProtectionEnchantmentMixin {
	@Shadow @Final public ProtectionEnchantment.Type protectionType;
	
	@Shadow public abstract int getMaxLevel();
	
	/**
	 * @author Pro__Dan
	 * @reason Reworked protection
	 */
	@Overwrite
	public int getProtectionAmount(int level, DamageSource source) {
		if (source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
			return 0;
		} else if (this.protectionType == ProtectionEnchantment.Type.ALL) {
			if(source.isIn(DamageTypeTags.IS_FIRE) || source.isIn(DamageTypeTags.IS_FALL) || source.isIn(DamageTypeTags.IS_EXPLOSION) || source.isIn(DamageTypeTags.IS_PROJECTILE)){
				return level * 2;
			}
			return level * 4;
		} else if (this.protectionType == ProtectionEnchantment.Type.FIRE && source.isIn(DamageTypeTags.IS_FIRE)) {
			return level * 8;
		} else if (this.protectionType == ProtectionEnchantment.Type.FALL && source.isIn(DamageTypeTags.IS_FALL)) {
			return level * 12;
		} else if (this.protectionType == ProtectionEnchantment.Type.EXPLOSION && source.isIn(DamageTypeTags.IS_EXPLOSION)) {
			return level * 8;
		} else {
			return this.protectionType == ProtectionEnchantment.Type.PROJECTILE && source.isIn(DamageTypeTags.IS_PROJECTILE) ? level * 8 : 0;
		}
	}
	
	@Inject(method = "getMaxLevel", at = @At("HEAD"), cancellable = true)
	public void level(CallbackInfoReturnable<Integer> cir){
		cir.setReturnValue(5);
	};
}
