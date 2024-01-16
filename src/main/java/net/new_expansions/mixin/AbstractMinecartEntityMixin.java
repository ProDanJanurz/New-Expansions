package net.new_expansions.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.block.AbstractRailBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PoweredRailBlock;
import net.minecraft.block.enums.RailShape;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.new_expansions.blocks.NewexpMagneticRailBlock;
import net.new_expansions.registry.NewexpBlocks;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(AbstractMinecartEntity.class)
public abstract class AbstractMinecartEntityMixin extends Entity {
	
	@Shadow @Nullable public abstract Vec3d snapPositionToRail(double x, double y, double z);
	
	@Shadow
	protected static Pair<Vec3i, Vec3i> getAdjacentRailPositionsByShape(RailShape shape) {
		return ADJACENT_RAIL_POSITIONS_BY_SHAPE.get(shape);
	}
	
	@Shadow protected abstract void applySlowdown();
	
	@Shadow protected abstract boolean willHitBlockAt(BlockPos pos);
	
	@Shadow protected abstract double getMaxSpeed();
	
	@Shadow @Final private static Map<RailShape, Pair<Vec3i, Vec3i>> ADJACENT_RAIL_POSITIONS_BY_SHAPE;
	
	public AbstractMinecartEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}
	
	@Inject(method = "getMaxSpeed", at = @At("RETURN"), cancellable = true)
	public void getMaxSpeedInject(CallbackInfoReturnable<Double> cir) {
		double speed = ((this.isTouchingWater() ? 4.0 : 8.0) / 20.0) * 0.125;
		int i = MathHelper.floor(this.getX());
		int j = MathHelper.floor(this.getY());
		int k = MathHelper.floor(this.getZ());
		if (this.getWorld().getBlockState(new BlockPos(i, j - 1, k)).isIn(BlockTags.RAILS)) {
			--j;
		}
		
		BlockPos blockPos = new BlockPos(i, j, k);
		BlockState blockState = this.getWorld().getBlockState(blockPos);
		if (AbstractRailBlock.isRail(blockState)) {
			if (blockState.isOf(NewexpBlocks.MAGNETIC_RAIL)) {
				if(blockState.get(NewexpMagneticRailBlock.POWERED)){
					speed = (((this.isTouchingWater() ? 4.0 : 8.0) / 20.0) * 1.25) * 1.5;
				}
			}
		}
		cir.setReturnValue(speed);
	}
	/**
	 * @author Pro__Dan
	 * @reason Increased max speed
	 */
	@Redirect(
			method = "tick()V",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/entity/vehicle/AbstractMinecartEntity;moveOnRail(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)V"
			),
			require = 0
	)
	private void moveMinecart(AbstractMinecartEntity instance, BlockPos pos, BlockState state) {
		this.moveOnRail(pos, state);
		this.moveOnRail(pos, state);
		this.moveOnRail(pos, state);
		this.moveOnRail(pos, state);
		this.moveOnRail(pos, state);
		this.moveOnRail(pos, state);
		this.moveOnRail(pos, state);
		this.moveOnRail(pos, state);
		this.moveOnRail(pos, state);
		this.moveOnRail(pos, state);
	}
	/**
	 * @author Pro__Dan
	 * @reason added magnetic rail to acceleration check
	 */
	@Overwrite
	public void moveOnRail(BlockPos pos, BlockState state) {
		this.onLanding();
		double d = this.getX();
		double e = this.getY();
		double f = this.getZ();
		Vec3d vec3d = this.snapPositionToRail(d, e, f);
		e = pos.getY();
		boolean bl = false;
		boolean bl2 = false;
		if (state.isOf(Blocks.POWERED_RAIL)) {
			bl = state.get(PoweredRailBlock.POWERED);
			bl2 = !bl;
		}
		if (state.isOf(NewexpBlocks.MAGNETIC_RAIL)) {
			bl = state.get(NewexpMagneticRailBlock.POWERED);
			bl2 = !bl;
		}
		
		double g = 0.0078125;
		if (this.isTouchingWater()) {
			g *= 0.2;
		}
		
		Vec3d vec3d2 = this.getVelocity();
		RailShape railShape = state.get(((AbstractRailBlock)state.getBlock()).getShapeProperty());
		switch (railShape) {
			case ASCENDING_EAST:
				this.setVelocity(vec3d2.add(-g, 0.0, 0.0));
				++e;
				break;
			case ASCENDING_WEST:
				this.setVelocity(vec3d2.add(g, 0.0, 0.0));
				++e;
				break;
			case ASCENDING_NORTH:
				this.setVelocity(vec3d2.add(0.0, 0.0, g));
				++e;
				break;
			case ASCENDING_SOUTH:
				this.setVelocity(vec3d2.add(0.0, 0.0, -g));
				++e;
		}
		
		vec3d2 = this.getVelocity();
		Pair<Vec3i, Vec3i> pair = getAdjacentRailPositionsByShape(railShape);
		Vec3i vec3i = pair.getFirst();
		Vec3i vec3i2 = pair.getSecond();
		double h = vec3i2.getX() - vec3i.getX();
		double i = vec3i2.getZ() - vec3i.getZ();
		double j = Math.sqrt(h * h + i * i);
		double k = vec3d2.x * h + vec3d2.z * i;
		if (k < 0.0) {
			h = -h;
			i = -i;
		}
		
		double l = Math.min(2.0, vec3d2.horizontalLength());
		vec3d2 = new Vec3d(l * h / j, vec3d2.y, l * i / j);
		this.setVelocity(vec3d2);
		Entity entity = this.getFirstPassenger();
		if (entity instanceof PlayerEntity) {
			Vec3d vec3d3 = entity.getVelocity();
			double m = vec3d3.horizontalLengthSquared();
			double n = this.getVelocity().horizontalLengthSquared();
			if (m > 1.0E-4 && n < 0.01) {
				this.setVelocity(this.getVelocity().add(vec3d3.x * 0.1, 0.0, vec3d3.z * 0.1));
				bl2 = false;
			}
		}
		
		double o;
		if (bl2) {
			o = this.getVelocity().horizontalLength();
			if (o < 0.03) {
				this.setVelocity(Vec3d.ZERO);
			} else {
				this.setVelocity(this.getVelocity().multiply(0.5, 0.0, 0.5));
			}
		}
		
		o = (double)pos.getX() + 0.5 + (double)vec3i.getX() * 0.5;
		double p = (double)pos.getZ() + 0.5 + (double)vec3i.getZ() * 0.5;
		double q = (double)pos.getX() + 0.5 + (double)vec3i2.getX() * 0.5;
		double r = (double)pos.getZ() + 0.5 + (double)vec3i2.getZ() * 0.5;
		h = q - o;
		i = r - p;
		double s;
		double t;
		double u;
		if (h == 0.0) {
			s = f - (double)pos.getZ();
		} else if (i == 0.0) {
			s = d - (double)pos.getX();
		} else {
			t = d - o;
			u = f - p;
			s = (t * h + u * i) * 2.0;
		}
		
		d = o + h * s;
		f = p + i * s;
		this.setPosition(d, e, f);
		t = this.hasPassengers() ? 0.75 : 1.0;
		u = this.getMaxSpeed();
		vec3d2 = this.getVelocity();
		this.move(MovementType.SELF, new Vec3d(MathHelper.clamp(t * vec3d2.x, -u, u), 0.0, MathHelper.clamp(t * vec3d2.z, -u, u)));
		if (vec3i.getY() != 0 && MathHelper.floor(this.getX()) - pos.getX() == vec3i.getX() && MathHelper.floor(this.getZ()) - pos.getZ() == vec3i.getZ()) {
			this.setPosition(this.getX(), this.getY() + (double)vec3i.getY(), this.getZ());
		} else if (vec3i2.getY() != 0 && MathHelper.floor(this.getX()) - pos.getX() == vec3i2.getX() && MathHelper.floor(this.getZ()) - pos.getZ() == vec3i2.getZ()) {
			this.setPosition(this.getX(), this.getY() + (double)vec3i2.getY(), this.getZ());
		}
		
		this.applySlowdown();
		Vec3d vec3d4 = this.snapPositionToRail(this.getX(), this.getY(), this.getZ());
		Vec3d vec3d5;
		double w;
		if (vec3d4 != null && vec3d != null) {
			double v = (vec3d.y - vec3d4.y) * 0.05;
			vec3d5 = this.getVelocity();
			w = vec3d5.horizontalLength();
			if (w > 0.0) {
				this.setVelocity(vec3d5.multiply((w + v) / w, 1.0, (w + v) / w));
			}
			
			this.setPosition(this.getX(), vec3d4.y, this.getZ());
		}
		
		int x = MathHelper.floor(this.getX());
		int y = MathHelper.floor(this.getZ());
		if (x != pos.getX() || y != pos.getZ()) {
			vec3d5 = this.getVelocity();
			w = vec3d5.horizontalLength();
			this.setVelocity(w * (double)(x - pos.getX()), vec3d5.y, w * (double)(y - pos.getZ()));
		}
		
		if (bl) {
			vec3d5 = this.getVelocity();
			w = vec3d5.horizontalLength();
			if (w > 0.01) {
				double z = 0.06;
				this.setVelocity(vec3d5.add(vec3d5.x / w * 0.06, 0.0, vec3d5.z / w * 0.06));
			} else {
				Vec3d vec3d6 = this.getVelocity();
				double aa = vec3d6.x;
				double ab = vec3d6.z;
				if (railShape == RailShape.EAST_WEST) {
					if (this.willHitBlockAt(pos.west())) {
						aa = 0.02;
					} else if (this.willHitBlockAt(pos.east())) {
						aa = -0.02;
					}
				} else {
					if (railShape != RailShape.NORTH_SOUTH) {
						return;
					}
					
					if (this.willHitBlockAt(pos.north())) {
						ab = 0.02;
					} else if (this.willHitBlockAt(pos.south())) {
						ab = -0.02;
					}
				}
				
				this.setVelocity(aa, vec3d6.y, ab);
			}
		}
		
	}
}
