package net.chakramod.mod.block.custom.glowstoneCrystal;

import it.unimi.dsi.fastutil.booleans.BooleanPredicate;
import net.chakramod.mod.ChakraMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.particle.BlockLeakParticle;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class GlowstoneCrystalSpecial extends Block {
    public static final DirectionProperty FACING;
    protected final VoxelShape upShape;
    protected final VoxelShape downShape;


    public GlowstoneCrystalSpecial(Settings settings) {
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
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        double d = (double) i + random.nextDouble();
        double e = (double) j + 0.7D;
        double f = (double) k + random.nextDouble();
        world.addParticle(ChakraMod.GLOWSTONE_CRYSTAL_PARTICLE, d, e, f, 0.0D, 0.0D, 0.0D);

        super.randomDisplayTick(state, world, pos, random);
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
