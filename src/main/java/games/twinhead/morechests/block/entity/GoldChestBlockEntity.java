package games.twinhead.morechests.block.entity;

import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.BlockEntityRegistry;
import games.twinhead.morechests.screen.GoldChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class GoldChestBlockEntity extends BasicChestBlockEntity{
    public GoldChestBlockEntity(BlockPos pos, BlockState state, ChestTypes type) {
        super(BlockEntityRegistry.GOLD_CHEST.get(), pos, state, type);

    }

    @Nullable
    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new GoldChestScreenHandler(syncId, playerInventory, this);
    }
}
