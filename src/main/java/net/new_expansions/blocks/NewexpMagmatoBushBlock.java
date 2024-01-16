package net.new_expansions.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.new_expansions.registry.NewexpItems;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.util.math.random.Random;

public class NewexpMagmatoBushBlock extends PlantBlock implements Fertilizable {
    private static final float field_31260 = 0.003F;
    public static final int MAX_AGE = 5;
    public static final IntProperty AGE;
    private static final VoxelShape AGE0_SHAPE;
    private static final VoxelShape AGE1_SHAPE;
    private static final VoxelShape AGE2_SHAPE;
    private static final VoxelShape AGE34_SHAPE;
    private static final VoxelShape AGE5_SHAPE;

    public NewexpMagmatoBushBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0));
    }

    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(NewexpItems.MAGMATO_PEPPERS);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if ((Integer)state.get(AGE) == 0) {
            return AGE0_SHAPE;
        } else if ((Integer)state.get(AGE) == 1) {
            return AGE1_SHAPE;
        } else if ((Integer)state.get(AGE) == 2) {
            return AGE2_SHAPE;
        } else if ((Integer)state.get(AGE) == 3 || (Integer)state.get(AGE) == 4) {
            return AGE34_SHAPE;
        } else{
            return AGE5_SHAPE;
        }
    }

    public boolean hasRandomTicks(BlockState state) {
        return (Integer)state.get(AGE) < 5;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = (Integer)state.get(AGE);
        if (i < 5 && random.nextInt(5) == 0) {
            BlockState blockState = (BlockState)state.with(AGE, i + 1);
            world.setBlockState(pos, blockState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
        }

    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
            entity.slowMovement(state, new Vec3d(0.9D, 0.75D, 0.9D));
        }
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int i = (Integer)state.get(AGE);
        boolean bl = i == 5;
        if (!bl && (player.getStackInHand(hand).isOf(Items.BONE_MEAL) || player.getStackInHand(hand).isOf(NewexpItems.ASH))) {
            return ActionResult.PASS;
        } else if (i > 4) {
            dropStack(world, pos, new ItemStack(NewexpItems.MAGMATO_PEPPERS, 2));
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            world.setBlockState(pos, (BlockState)state.with(AGE, 3), 2);
            return ActionResult.success(world.isClient);
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AGE});
    }
    
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return (Integer)state.get(AGE) < 5;
    }
    
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }
    
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int i = Math.min(5, (Integer)state.get(AGE) + 1);
        world.setBlockState(pos, (BlockState)state.with(AGE, i), 2);
    }
    public boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.NYLIUM) || floor.isOf(Blocks.NETHERRACK);
    }
    
    public static final MapCodec<NewexpMagmatoBushBlock> CODEC = createCodec(NewexpMagmatoBushBlock::new);
    
    public MapCodec<NewexpMagmatoBushBlock> getCodec() {
        return CODEC;
    }

    static {
        AGE = Properties.AGE_5;
        AGE0_SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 4.0D, 11.0D);
        AGE1_SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);
        AGE2_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
        AGE34_SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);
        AGE5_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);
    }
}