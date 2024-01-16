package net.new_expansions.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Iterator;
import java.util.List;

@Mixin(BeaconBlockEntity.class)
public abstract class BeaconBlockEntityMixin extends BlockEntity {
	public BeaconBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
		super(type, pos, state);
	}
	
	/**
	 * @author Pro__Dan
	 * @reason buffed beacon power and range
	 */
	@Overwrite
	private static void applyPlayerEffects(World world, BlockPos pos, int beaconLevel, @Nullable StatusEffect primaryEffect, @Nullable StatusEffect secondaryEffect) {
		if (!world.isClient && primaryEffect != null) {
			double size = (double)((beaconLevel + 1) * 20);
			int amplifier = 0;
			if (beaconLevel >= 4 && primaryEffect == secondaryEffect) {
				amplifier = 1;
			}
			
			int time = (10 + beaconLevel * 5) * 20;
			Box box = (new Box(pos)).expand(size).stretch(0.0, (double)-world.getHeight(), 0.0).stretch(0.0, (double)world.getHeight(), 0.0);
			List<PlayerEntity> list = world.getNonSpectatingEntities(PlayerEntity.class, box);
			Iterator var11 = list.iterator();
			
			PlayerEntity playerEntity;
			while(var11.hasNext()) {
				playerEntity = (PlayerEntity)var11.next();
				playerEntity.addStatusEffect(new StatusEffectInstance(primaryEffect, time, amplifier, true, true));
			}
			
			if (beaconLevel >= 4 && primaryEffect != secondaryEffect && secondaryEffect != null) {
				var11 = list.iterator();
				
				while(var11.hasNext()) {
					playerEntity = (PlayerEntity)var11.next();
					playerEntity.addStatusEffect(new StatusEffectInstance(secondaryEffect, time, 0, true, true));
				}
			}
			
		}
	}
}
