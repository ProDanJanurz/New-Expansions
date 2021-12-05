package com.pro__group.new_expansions.blocks;

import com.pro__group.new_expansions.blocks.entity.NewexpBlockEntityType;
import com.pro__group.new_expansions.blocks.entity.NewexpEnchantedStatueBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;


public class NewexpEnchantedStatue extends BlockWithEntity implements Waterloggable{
 final VoxelShape SHAPE = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 14.0D, 12.0D);
 public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
 public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

     public NewexpEnchantedStatue(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(WATERLOGGED, false)).with(FACING, Direction.NORTH));
    }
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new NewexpEnchantedStatueBlockEntity(pos, state);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, NewexpBlockEntityType.ENCHANTED_STATUE, (world1, pos, state1, be) -> NewexpEnchantedStatueBlockEntity.tick(world1, pos, state1, be));
    }
    public BlockState getPlacementState(ItemPlacementContext ctx) {
    FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
    boolean bl = fluidState.getFluid() == Fluids.WATER;
    return (BlockState)super.getPlacementState(ctx).with(WATERLOGGED, bl).with(FACING, ctx.getPlayerFacing().getOpposite());
}
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
    }
    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if ((Boolean)state.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
    public static boolean isDry(BlockState state) {
        return !(Boolean)state.get(WATERLOGGED);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING , WATERLOGGED});
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}