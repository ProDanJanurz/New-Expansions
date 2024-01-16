package net.new_expansions.mixin;

import net.minecraft.entity.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTracker;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.new_expansions.items.equipment.NewexpArmorItem;
import net.new_expansions.registry.NewexpAttributes;
import net.new_expansions.util.NewexpDamageCalculationsUtil;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	
	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}
	
	@Shadow public abstract double getAttributeValue(EntityAttribute attribute);
	
	@Shadow public abstract float getAbsorptionAmount();
	
	@Shadow public abstract void setAbsorptionAmount(float amount);
	
	@Shadow public abstract void setHealth(float health);
	
	@Shadow public abstract float getHealth();
	
	@Shadow public abstract DamageTracker getDamageTracker();
	
	@Inject(method = "getPreferredEquipmentSlot", at = @At("HEAD"), cancellable = true)
	private static void getPreferredEquipmentSlot(ItemStack stack, CallbackInfoReturnable<EquipmentSlot> cir) {
		Item item = stack.getItem();
		if (item instanceof NewexpArmorItem) {
			cir.setReturnValue(((NewexpArmorItem)item).getSlotType());
		}
	}
	
	@Inject(method = "createLivingAttributes", at = @At("RETURN"),cancellable = true)
	private static void createLivingAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> cir) {
		cir.setReturnValue(DefaultAttributeContainer.builder().add(NewexpAttributes.TRUE_ARMOR).add(EntityAttributes.GENERIC_MAX_HEALTH).add(EntityAttributes.GENERIC_MAX_ABSORPTION).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE).add(EntityAttributes.GENERIC_MOVEMENT_SPEED).add(EntityAttributes.GENERIC_ARMOR).add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS));
	}
	
	@Redirect(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;applyDamage(Lnet/minecraft/entity/damage/DamageSource;F)V"))
	private void damageEntity(LivingEntity instance, DamageSource source, float amount) {
		if (!this.isInvulnerableTo(source)) {
			amount = NewexpDamageCalculationsUtil.applyDamageReductionToDamage(instance, source, amount, (float)this.getAttributeValue(EntityAttributes.GENERIC_ARMOR), (float)this.getAttributeValue(EntityAttributes.GENERIC_ARMOR_TOUGHNESS), (float)this.getAttributeValue(NewexpAttributes.TRUE_ARMOR));
			float f = amount;
			amount = Math.max(amount - this.getAbsorptionAmount(), 0.0F);
			this.setAbsorptionAmount(this.getAbsorptionAmount() - (f - amount));
			float g = f - amount;
			if (g > 0.0F && g < 3.4028235E37F) {
				Entity var6 = source.getAttacker();
				if (var6 instanceof ServerPlayerEntity) {
					ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)var6;
					serverPlayerEntity.increaseStat(Stats.DAMAGE_DEALT_ABSORBED, Math.round(g * 10.0F));
				}
			}
			
			if (amount != 0.0F) {
				float health = this.getHealth();
				this.getDamageTracker().onDamage(source, amount);
				this.setHealth(health - amount);
				this.setAbsorptionAmount(this.getAbsorptionAmount() - amount);
				this.emitGameEvent(GameEvent.ENTITY_DAMAGE);
			}
		}
	}
}