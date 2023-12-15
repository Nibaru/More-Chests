package games.twinhead.morechests.block;

import games.twinhead.morechests.block.entity.BasicChestBlockEntity;
import games.twinhead.morechests.block.entity.CustomChestBlockEntity;
import games.twinhead.morechests.screen.BasicChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.ChestType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

public class BasicChestBlock extends ChestBlock {

    public final ChestTypes type;
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    private static final DoubleBlockProperties.PropertyRetriever<CustomChestBlockEntity, Optional<NamedScreenHandlerFactory>> NAME_RETRIEVER;

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
    public DoubleBlockProperties.PropertySource<? extends BasicChestBlockEntity> getBlockEntitySource(BlockState state, World world, BlockPos pos, boolean ignoreBlocked) {
        BiPredicate<WorldAccess, BlockPos> biPredicate = ignoreBlocked ? (worldx, posx) -> false : BasicChestBlock::isChestBlocked;
        return DoubleBlockProperties.toPropertySource((BlockEntityType)this.entityTypeRetriever.get(), ChestBlock::getDoubleBlockType, ChestBlock::getFacing, FACING, state, world, pos, biPredicate);
    }

    public static boolean isChestBlocked(World world, BlockPos pos) {
        return hasBlockOnTop(world, pos) || hasCatOnTop(world, pos);
    }

    private static boolean hasBlockOnTop(BlockView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        return world.getBlockState(blockPos).isSolidBlock(world, blockPos);
    }

    private static boolean hasCatOnTop(WorldAccess world, BlockPos pos) {
        List<CatEntity> list = world.getNonSpectatingEntities(CatEntity.class, new Box((double)pos.getX(), (double)(pos.getY() + 1), (double)pos.getZ(), (double)(pos.getX() + 1), (double)(pos.getY() + 2), (double)(pos.getZ() + 1)));

        if (!list.isEmpty()) {
            for (CatEntity catEntity : list) {
                if (catEntity.isInSittingPose()) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof CustomChestBlockEntity) {
            ((CustomChestBlockEntity)blockEntity).onScheduledTick(world, pos, state);
        }
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient ? BasicChestBlock.validateTicker(type, this.getExpectedEntityType(), (world1, pos, state1, blockEntity) -> (blockEntity).clientTick()) : null;
    }

    public BlockEntityType<? extends CustomChestBlockEntity> getExpectedEntityType() {
        return (BlockEntityType)this.entityTypeRetriever.get();
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        ChestType chestType = ChestType.SINGLE;
        Direction direction = ctx.getHorizontalPlayerFacing().getOpposite();
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());

        boolean bl = ctx.shouldCancelInteraction();

        Direction direction2 = ctx.getSide();
        if (direction2.getAxis().isHorizontal() && !bl) {
            Direction direction3 = this.getNeighborChestDirection(ctx, direction2.getOpposite());
            if (direction3 != null && direction3.getAxis() != direction2.getAxis()) {
                direction = direction3;
                chestType = direction3.rotateYCounterclockwise() == direction2.getOpposite() ? ChestType.RIGHT : ChestType.LEFT;
            }
        }

        if (chestType == ChestType.SINGLE && !bl) {
            if (direction == this.getNeighborChestDirection(ctx, direction.rotateYClockwise())) {
                chestType = ChestType.LEFT;
            } else if (direction == this.getNeighborChestDirection(ctx, direction.rotateYCounterclockwise())) {
                chestType = ChestType.RIGHT;
            }
        }

        Direction side = ctx.getSide();

        BlockState clickedState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(side.getOpposite()));
        if (clickedState.isOf(this) && bl && clickedState.get(CHEST_TYPE) == ChestType.SINGLE) {
            if(ctx.getPlayer().isSneaking()){
                direction = clickedState.get(FACING);
                if (side == clickedState.get(FACING).rotateYClockwise()){
                    chestType = ChestType.RIGHT;
                } else if (side == clickedState.get(FACING).rotateYCounterclockwise()){
                    chestType = ChestType.LEFT;
                }
            }
        }

        return (BlockState)((BlockState)((BlockState)this.getDefaultState().with(FACING, direction)).with(CHEST_TYPE, chestType)).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    @Nullable
    private Direction getNeighborChestDirection(ItemPlacementContext ctx, Direction dir) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(dir));
        return blockState.isOf(this) && blockState.get(CHEST_TYPE) == ChestType.SINGLE ? (Direction)blockState.get(FACING) : null;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        BlockEntity blockEntity;
        if (itemStack.hasCustomName() && (blockEntity = world.getBlockEntity(pos)) instanceof CustomChestBlockEntity) {
            ((CustomChestBlockEntity)blockEntity).setCustomName(itemStack.getName());
        }
    }

    @Nullable
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return (NamedScreenHandlerFactory)((Optional)this.getBlockEntitySource(state, world, pos, false).apply(NAME_RETRIEVER)).orElse((Object)null);
    }

    static {
        NAME_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<>() {
            @Override
            public Optional<NamedScreenHandlerFactory> getFromBoth(CustomChestBlockEntity chestBlockEntity, CustomChestBlockEntity chestBlockEntity2) {
                final Inventory inventory = new DoubleInventory(chestBlockEntity, chestBlockEntity2);
                return Optional.of(new NamedScreenHandlerFactory() {
                    @Nullable
                    public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                        if (chestBlockEntity.checkUnlocked(playerEntity) && chestBlockEntity2.checkUnlocked(playerEntity)) {
                            chestBlockEntity.generateLoot(playerInventory.player);
                            chestBlockEntity2.generateLoot(playerInventory.player);
                            return BasicChestScreenHandler.createGeneric9x6(i, playerInventory, inventory);
                        } else {
                            return null;
                        }
                    }

                    public Text getDisplayName() {
                        if (chestBlockEntity.hasCustomName()) {
                            return chestBlockEntity.getDisplayName();
                        } else {
                            return (Text) (chestBlockEntity2.hasCustomName() ? chestBlockEntity2.getDisplayName() : Text.translatable("container.more_chests.chest_double", Text.translatable(chestBlockEntity2.getContainerName().getString())));
                        }
                    }
                });
            }

            @Override
            public Optional<NamedScreenHandlerFactory> getFrom(CustomChestBlockEntity single) {
                return Optional.of(single);
            }

            public Optional<NamedScreenHandlerFactory> getFallback() {
                return Optional.empty();
            }
        };
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if ((Boolean)state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        if (neighborState.isOf(this) && direction.getAxis().isHorizontal()) {
            ChestType chestType = (ChestType)neighborState.get(CHEST_TYPE);
            if (state.get(CHEST_TYPE) == ChestType.SINGLE && chestType != ChestType.SINGLE && state.get(FACING) == neighborState.get(FACING) && getFacing(neighborState) == direction.getOpposite()) {
                return (BlockState)state.with(CHEST_TYPE, chestType.getOpposite());
            }
        } else if (getFacing(state) == direction) {
            return (BlockState)state.with(CHEST_TYPE, ChestType.SINGLE);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }


}
