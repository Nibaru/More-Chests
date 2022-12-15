package games.twinhead.morechests.block;

import games.twinhead.morechests.block.entity.BasicChestBlockEntity;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraft.block.*;
import net.minecraft.block.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class BasicChestBlock extends ChestBlock {

    public final ChestTypes type;

    public BasicChestBlock(Settings settings, ChestTypes type) {
        super(settings, type::getBlockEntityType);
        this.type = type;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return this.type.getBlockEntity(pos, state);
    }

    public ChestTypes getType(){return type;}


        @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        Direction direction = context.getPlayerFacing().getOpposite();
        FluidState fluidState = context.getWorld().getFluidState(context.getBlockPos());
        return this.getDefaultState().with(FACING, direction).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {

        return world.isClient  & type == this.type.getBlockEntityType() ? (world1, pos, state1, blockEntity) -> ((BasicChestBlockEntity)blockEntity).clientTick() : null;
    }


}
