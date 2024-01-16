package net.new_expansions.mixin;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.task.MultiTickTask;
import net.minecraft.entity.ai.brain.task.SonicBoomTask;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.WardenEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SonicBoomTask.class)
public class SonicBoomTaskMixin extends MultiTickTask<WardenEntity> {
	private static final int HORIZONTAL_RANGE = 15;
	private static final int VERTICAL_RANGE = 20;
	private static final double field_38852 = 0.5D;
	private static final double field_38853 = 2.5D;
	private static final int COOLDOWN = 40;
	private static final int SOUND_DELAY = MathHelper.ceil(34.0D);
	private static final int RUN_TIME = MathHelper.ceil(60.0F);
	public SonicBoomTaskMixin() {
		super(ImmutableMap.of(MemoryModuleType.ATTACK_TARGET, MemoryModuleState.VALUE_PRESENT, MemoryModuleType.SONIC_BOOM_COOLDOWN, MemoryModuleState.VALUE_ABSENT, MemoryModuleType.SONIC_BOOM_SOUND_COOLDOWN, MemoryModuleState.REGISTERED, MemoryModuleType.SONIC_BOOM_SOUND_DELAY, MemoryModuleState.REGISTERED), RUN_TIME);
	}
	@Inject(
			method = "keepRunning",
			at = @At("TAIL"),
			cancellable = true
	)
	public void keepRunning(ServerWorld serverWorld, WardenEntity wardenEntity, long l, CallbackInfo info) {
		wardenEntity.getBrain().getOptionalRegisteredMemory(MemoryModuleType.ATTACK_TARGET).ifPresent((target) -> {
			target.damage(serverWorld.getDamageSources().sonicBoom(wardenEntity), 16.0F);
			if(target.getType() == EntityType.WITHER){
				target.damage(serverWorld.getDamageSources().sonicBoom(wardenEntity), 40.0F);
			}
		});
	}
}
