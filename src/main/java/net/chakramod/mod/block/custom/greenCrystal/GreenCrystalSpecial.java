package net.chakramod.mod.block.custom.greenCrystal;

import net.chakramod.mod.ChakraMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class GreenCrystalSpecial extends Block {
    public static final DirectionProperty FACING;
    protected final VoxelShape upShape;
    protected final VoxelShape downShape;


    public GreenCrystalSpecial(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState) (BlockState) this.getDefaultState().with(FACING, Direction.UP));
        this.upShape = Block.createCuboidShape(2f, 0.0f, 2f, 14f, 5f, 14f);
        this.downShape = Block.createCuboidShape(2f, 5f, 2f, 14f, 16f,14f);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction direction = (Direction) state.get(FACING);
        switch (direction) {
            case UP:
                return this.upShape;
            case DOWN:
                return this.downShape;
            default:
                return this.upShape;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if(ctx.getPlacementDirections()[0].equals(Direction.UP)){
            return this.getDefaultState().with(FACING, Direction.DOWN);
        }
        if(ctx.getPlacementDirections()[0].equals(Direction.DOWN)){
            return this.getDefaultState().with(FACING, Direction.UP);
        }

        return super.getPlacementState(ctx);
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.DESTROY;
    }

    static {
        FACING = Properties.FACING;
    }
}
