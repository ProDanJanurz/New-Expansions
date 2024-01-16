package net.new_expansions.mixin;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherEntity.class)
public abstract class WitherEntityMixin extends HostileEntity{
	@Shadow public abstract boolean shouldRenderOverlay();
	
	protected WitherEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}
	int spawn = 0;
	int repeat = 3;
	
	@Inject(
			method = "dropEquipment",
			at = @At("TAIL"),
			cancellable = true
	)
	public void dropEquipment(CallbackInfo info) {
		this.experiencePoints = 5000;
	}
	
	@Inject(
			method = "mobTick",
			at = @At("TAIL"),
			cancellable = true
	)
	public void mobTick(CallbackInfo ci) {
		if(this.shouldRenderOverlay() && spawn == 1){
			for(int i = 0; i < 5; ++i) {
				this.getAttributeInstance(EntityAttributes.GENERIC_ARMOR).setBaseValue(20);
				
				ServerWorld serverWorld = (ServerWorld) this.getWorld();
				
				BlockPos blockPos = this.getBlockPos().add(-5 + this.random.nextInt(10), -3, -5 + this.random.nextInt(10));
				WitherSkeletonEntity WitherSkeletonEntity = (WitherSkeletonEntity)EntityType.WITHER_SKELETON.create(this.getWorld());
				WitherSkeletonEntity.refreshPositionAndAngles(blockPos, 0.0F, 0.0F);
				WitherSkeletonEntity.setHealth(40);
				WitherSkeletonEntity.getAttributeInstance(EntityAttributes.GENERIC_ARMOR).setBaseValue(10);
				WitherSkeletonEntity.initialize(serverWorld, this.getWorld().getLocalDifficulty(blockPos), SpawnReason.MOB_SUMMONED, (EntityData)null, (NbtCompound)null);
				WitherSkeletonEntity.setTarget(this.getTarget());
				serverWorld.spawnEntityAndPassengers(WitherSkeletonEntity);
			}
			spawn--;
		}
		if(spawn == 0 && repeat > 0 && !this.shouldRenderOverlay()){
			spawn++;
			repeat--;
			this.getAttributeInstance(EntityAttributes.GENERIC_ARMOR).setBaseValue(4);
		}
		if(repeat == 0 && !this.shouldRenderOverlay()){
			this.getAttributeInstance(EntityAttributes.GENERIC_ARMOR).setBaseValue(4);
		}
	}
}
