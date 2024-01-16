package net.new_expansions.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.projectile.thrown.ExperienceBottleEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExperienceBottleEntity.class)
public abstract class ExperienceBottleEntityMixin extends ThrownItemEntity {
	public ExperienceBottleEntityMixin(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Inject(
			method = "onCollision",
			at = @At("TAIL"),
			cancellable = true
	)
	public void updatePostDeath(CallbackInfo info) {
		if (this.getWorld() instanceof ServerWorld) {
			float xp = 50 + this.getWorld().random.nextInt(25) + this.getWorld().random.nextInt(25) + this.getWorld().random.nextInt(25) + this.getWorld().random.nextInt(25);
			ExperienceOrbEntity.spawn((ServerWorld) this.getWorld(), this.getPos(), MathHelper.floor((float)xp));
		}
	}
}
