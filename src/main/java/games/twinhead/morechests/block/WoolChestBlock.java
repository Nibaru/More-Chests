package games.twinhead.morechests.block;

import games.twinhead.morechests.block.entity.CustomChestBlockEntity;
import games.twinhead.morechests.block.entity.WoolChestBlockEntity;
import games.twinhead.morechests.screen.WoolChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.BiPredicate;

public class WoolChestBlock extends CustomChestBlock {

    public DyeColor color;

    private static final DoubleBlockProperties.PropertyRetriever<WoolChestBlockEntity, Optional<NamedScreenHandlerFactory>> NAME_RETRIEVER;

    public WoolChestBlock(Settings settings, ChestTypes type, DyeColor color) {
        super(settings, type);
        this.color= color;
    }

    public DyeColor getColor(){
        return this.color;
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return world.isClient ? CustomChestBlock.checkType(type, this.getExpectedEntityType(), CustomChestBlockEntity::clientTick) : null;
    }

    @Nullable
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return (NamedScreenHandlerFactory)((Optional)this.getBlockEntitySource(state, world, pos, false).apply(NAME_RETRIEVER)).orElse((Object)null);
    }

    @SuppressWarnings("rawtypes")
    public DoubleBlockProperties.PropertySource<? extends WoolChestBlockEntity> getBlockEntitySource(BlockState state, World world, BlockPos pos, boolean ignoreBlocked) {
        BiPredicate<WorldAccess, BlockPos> biPredicate;
        if (ignoreBlocked) {
            biPredicate = (worldX, posX) -> false;
        } else {
            biPredicate = (worldX, posX) -> CustomChestBlock.isChestBlocked(world, pos);
        }
        return DoubleBlockProperties.toPropertySource((BlockEntityType)this.entityTypeRetriever.get(), ChestBlock::getDoubleBlockType, ChestBlock::getFacing, FACING, state, world, pos, biPredicate);
    }

    static {
        NAME_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<>() {
            @Override
            public Optional<NamedScreenHandlerFactory> getFromBoth(WoolChestBlockEntity chestBlockEntity, WoolChestBlockEntity chestBlockEntity2) {
                final Inventory inventory = new DoubleInventory(chestBlockEntity, chestBlockEntity2);
                return Optional.of(new NamedScreenHandlerFactory() {
                    @Nullable
                    public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                        if (chestBlockEntity.checkUnlocked(playerEntity) && chestBlockEntity2.checkUnlocked(playerEntity)) {
                            chestBlockEntity.checkLootInteraction(playerInventory.player);
                            chestBlockEntity2.checkLootInteraction(playerInventory.player);

                            return WoolChestScreenHandler.create9x6(i, playerInventory, inventory, ((WoolChestBlock) chestBlockEntity.getCachedState().getBlock()).getColor());
                        } else {
                            return null;
                        }
                    }

                    public Text getDisplayName() {
                        if (chestBlockEntity.hasCustomName()) {
                            return chestBlockEntity.getDisplayName();
                        } else {
                            return chestBlockEntity2.hasCustomName() ? chestBlockEntity2.getDisplayName() : new TranslatableText("container.more_chests.chest_double", new TranslatableText(chestBlockEntity2.getContainerName().getString()));
                        }
                    }
                });
            }

            @Override
            public Optional<NamedScreenHandlerFactory> getFrom(WoolChestBlockEntity single) {
                return Optional.of(single);
            }

            public Optional<NamedScreenHandlerFactory> getFallback() {
                return Optional.empty();
            }
        };
    }
}
