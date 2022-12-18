package games.twinhead.morechests.block;

import games.twinhead.morechests.block.entity.BasicChestBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BasicChestBlock extends ChestBlock {

    public final ChestTypes type;

    public BasicChestBlock(Settings settings, ChestTypes type) {
        super(settings, type::getBlockEntityType);
        this.type = type;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
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
