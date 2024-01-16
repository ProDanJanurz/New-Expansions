package net.new_expansions.mixin;

import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.map.MapState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FilledMapItem.class)
public abstract class FilledMapItemMixin {
	
	@Shadow protected abstract BlockState getFluidStateIfVisible(World world, BlockState state, BlockPos pos);
	
	/**
	 * @author Pro__Dan
	 * @reason doubled map reveal range
	 */
	@Overwrite
	public void updateColors(World world, Entity entity, MapState state) {
		if (world.getRegistryKey() == state.dimension && entity instanceof PlayerEntity) {
			int i = 1 << state.scale;
			int j = state.centerX;
			int k = state.centerZ;
			int l = MathHelper.floor(entity.getX() - (double)j) / i + 64;
			int m = MathHelper.floor(entity.getZ() - (double)k) / i + 64;
			int n = 128 * 2 / i;
			if (world.getDimension().hasCeiling()) {
				n /= 2;
			}
			
			MapState.PlayerUpdateTracker playerUpdateTracker = state.getPlayerSyncData((PlayerEntity)entity);
			++playerUpdateTracker.field_131;
			BlockPos.Mutable mutable = new BlockPos.Mutable();
			BlockPos.Mutable mutable2 = new BlockPos.Mutable();
			boolean bl = false;
			
			for(int o = l - n + 1; o < l + n; ++o) {
				if ((o & 15) == (playerUpdateTracker.field_131 & 15) || bl) {
					bl = false;
					double d = 0.0;
					
					for(int p = m - n - 1; p < m + n; ++p) {
						if (o >= 0 && p >= -1 && o < 128 && p < 128) {
							int q = MathHelper.square(o - l) + MathHelper.square(p - m);
							boolean bl2 = q > (n - 2) * (n - 2);
							int r = (j / i + o - 64) * i;
							int s = (k / i + p - 64) * i;
							Multiset<MapColor> multiset = LinkedHashMultiset.create();
							WorldChunk worldChunk = world.getChunk(ChunkSectionPos.getSectionCoord(r), ChunkSectionPos.getSectionCoord(s));
							if (!worldChunk.isEmpty()) {
								int t = 0;
								double e = 0.0;
								int u;
								if (world.getDimension().hasCeiling()) {
									u = r + s * 231871;
									u = u * u * 31287121 + u * 11;
									if ((u >> 20 & 1) == 0) {
										multiset.add(Blocks.DIRT.getDefaultState().getMapColor(world, BlockPos.ORIGIN), 10);
									} else {
										multiset.add(Blocks.STONE.getDefaultState().getMapColor(world, BlockPos.ORIGIN), 100);
									}
									
									e = 100.0;
								} else {
									for(u = 0; u < i; ++u) {
										for(int v = 0; v < i; ++v) {
											mutable.set(r + u, 0, s + v);
											int w = worldChunk.sampleHeightmap(Heightmap.Type.WORLD_SURFACE, mutable.getX(), mutable.getZ()) + 1;
											BlockState blockState;
											if (w <= world.getBottomY() + 1) {
												blockState = Blocks.BEDROCK.getDefaultState();
											} else {
												do {
													--w;
													mutable.setY(w);
													blockState = worldChunk.getBlockState(mutable);
												} while(blockState.getMapColor(world, mutable) == MapColor.CLEAR && w > world.getBottomY());
												
												if (w > world.getBottomY() && !blockState.getFluidState().isEmpty()) {
													int x = w - 1;
													mutable2.set(mutable);
													
													BlockState blockState2;
													do {
														mutable2.setY(x--);
														blockState2 = worldChunk.getBlockState(mutable2);
														++t;
													} while(x > world.getBottomY() && !blockState2.getFluidState().isEmpty());
													
													blockState = this.getFluidStateIfVisible(world, blockState, mutable);
												}
											}
											
											state.removeBanner(world, mutable.getX(), mutable.getZ());
											e += (double)w / (double)(i * i);
											multiset.add(blockState.getMapColor(world, mutable));
										}
									}
								}
								
								t /= i * i;
								MapColor mapColor = (MapColor) Iterables.getFirst(Multisets.copyHighestCountFirst(multiset), MapColor.CLEAR);
								MapColor.Brightness brightness;
								double f;
								if (mapColor == MapColor.WATER_BLUE) {
									f = (double)t * 0.1 + (double)(o + p & 1) * 0.2;
									if (f < 0.5) {
										brightness = MapColor.Brightness.HIGH;
									} else if (f > 0.9) {
										brightness = MapColor.Brightness.LOW;
									} else {
										brightness = MapColor.Brightness.NORMAL;
									}
								} else {
									f = (e - d) * 4.0 / (double)(i + 4) + ((double)(o + p & 1) - 0.5) * 0.4;
									if (f > 0.6) {
										brightness = MapColor.Brightness.HIGH;
									} else if (f < -0.6) {
										brightness = MapColor.Brightness.LOW;
									} else {
										brightness = MapColor.Brightness.NORMAL;
									}
								}
								
								d = e;
								if (p >= 0 && q < n * n && (!bl2 || (o + p & 1) != 0)) {
									bl |= state.putColor(o, p, mapColor.getRenderColorByte(brightness));
								}
							}
						}
					}
				}
			}
			
		}
	}
}
