package games.twinhead.morechests.block;

import games.twinhead.morechests.block.entity.CopperChestBlockEntity;
import games.twinhead.morechests.screen.DoubleCopperChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.BiPredicate;

public class WaxedCopperChestBlock extends CustomChestBlock implements Oxidizable{

    private final Oxidizable.OxidationLevel oxidationLevel;

    private static final DoubleBlockProperties.PropertyRetriever<CopperChestBlockEntity, Optional<NamedScreenHandlerFactory>> NAME_RETRIEVER;

    public WaxedCopperChestBlock(Settings settings, ChestTypes type, Oxidizable.OxidationLevel oxidationLevel) {
        super(settings, type);
        this.oxidationLevel = oxidationLevel;
    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CopperChestBlockEntity(pos, state, ChestTypes.COPPER);
    }

    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }

    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock()) ) {
            if(!(newState.getBlock() instanceof WaxedCopperChestBlock || newState.getBlock() instanceof CopperChestBlock)){
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof Inventory) {
                    ItemScatterer.spawn(world, pos, (Inventory)blockEntity);
                    world.updateComparators(pos, this);
                }
                super.onStateReplaced(state, world, pos, newState, moved);
            }
        }
    }

    public DoubleBlockProperties.PropertySource<? extends CopperChestBlockEntity> getBlockEntitySource(BlockState state, World world, BlockPos pos, boolean ignoreBlocked) {
        BiPredicate<WorldAccess, BlockPos> biPredicate;
        if (ignoreBlocked) {
            biPredicate = (worldX, posX) -> false;
        } else {
            biPredicate = (worldX, posX) -> isChestBlocked(world, pos);
        }

        return DoubleBlockProperties.toPropertySource((BlockEntityType)this.entityTypeRetriever.get(), ChestBlock::getDoubleBlockType, ChestBlock::getFacing, FACING, state, world, pos, biPredicate);
    }

    @Nullable
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return (NamedScreenHandlerFactory)((Optional)this.getBlockEntitySource(state, world, pos, false).apply(NAME_RETRIEVER)).orElse(null);
    }

    static {
        NAME_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<CopperChestBlockEntity, Optional<NamedScreenHandlerFactory>>() {

            @Override
            public Optional<NamedScreenHandlerFactory> getFromBoth(CopperChestBlockEntity chestBlockEntity, CopperChestBlockEntity chestBlockEntity2) {
                final Inventory inventory = new DoubleInventory(chestBlockEntity, chestBlockEntity2);
                return Optional.of(new NamedScreenHandlerFactory() {
                    @Nullable
                    public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                        if (chestBlockEntity.checkUnlocked(playerEntity) && chestBlockEntity2.checkUnlocked(playerEntity)) {
                            chestBlockEntity.checkLootInteraction(playerInventory.player);
                            chestBlockEntity2.checkLootInteraction(playerInventory.player);
                            return new DoubleCopperChestScreenHandler(i, playerInventory, inventory);
                        } else {
                            return null;
                        }
                    }

                    public Text getDisplayName() {
                        if (chestBlockEntity.hasCustomName()) {
                            return chestBlockEntity.getDisplayName();
                        } else {
                            return (Text)(chestBlockEntity2.hasCustomName() ? chestBlockEntity2.getDisplayName() : Text.translatable("container.more_chests.chest_double", Text.translatable(chestBlockEntity2.getContainerName().getString())));
                        }
                    }
                });
            }

            @Override
            public Optional<NamedScreenHandlerFactory> getFrom(CopperChestBlockEntity single) {
                return Optional.of(single);
            }

            public Optional<NamedScreenHandlerFactory> getFallback() {
                return Optional.empty();
            }
        };
    }
}
