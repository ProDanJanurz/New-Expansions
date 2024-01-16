package net.new_expansions.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity {
	
	public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
		super(world, pos, yaw, gameProfile);
	}
	@Inject(method = "copyFrom", at = @At("HEAD"))
	public void copyFrom(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo ci){
		/*
		for (StatusEffectInstance statusEffectInstance : oldPlayer.getStatusEffects()) {
			this.addStatusEffect(statusEffectInstance);
		}
		*/
		Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH)).setBaseValue(oldPlayer.getMaxHealth());
		this.setHealth(oldPlayer.getMaxHealth());
	}
}
