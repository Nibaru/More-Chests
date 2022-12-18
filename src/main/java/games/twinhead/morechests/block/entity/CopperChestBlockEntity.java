package games.twinhead.morechests.block.entity;

import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.BlockEntityRegistry;
import games.twinhead.morechests.screen.CopperChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class CopperChestBlockEntity extends BasicChestBlockEntity{
    public CopperChestBlockEntity(BlockPos pos, BlockState state, ChestTypes type) {
        super(BlockEntityRegistry.COPPER_CHEST.get(), pos, state, type);
    }

    @Nullable
    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new CopperChestScreenHandler(syncId, playerInventory, this);
    }
}
