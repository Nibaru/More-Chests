package games.twinhead.morechests.block.entity;

import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.BlockEntityRegistry;
import games.twinhead.morechests.screen.AbstractChestScreenHandler;
import games.twinhead.morechests.screen.DiamondChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DiamondChestBlockEntity extends CustomChestBlockEntity{
    public DiamondChestBlockEntity(BlockPos pos, BlockState state, ChestTypes type) {
        super(BlockEntityRegistry.DIAMOND_CHEST, pos, state, type);

    }

    @Nullable
    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new DiamondChestScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public CustomViewerCountManager initStateManager() {
        return new CustomViewerCountManager(){
            @Override
            protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
                CustomChestBlockEntity.playSound(world, pos, state, SoundEvents.BLOCK_CHEST_OPEN);
            }

            @Override
            protected void onContainerClose(World world, BlockPos pos, BlockState state) {
                CustomChestBlockEntity.playSound(world, pos, state, SoundEvents.BLOCK_CHEST_CLOSE);
            }

            @Override
            protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
                DiamondChestBlockEntity.this.onViewerCountUpdate(world, pos, state, oldViewerCount, newViewerCount);
            }

            @Override
            protected boolean isPlayerViewing(PlayerEntity player) {
                if (player.currentScreenHandler instanceof DiamondChestScreenHandler) {
                    Inventory inventory = ((AbstractChestScreenHandler)player.currentScreenHandler).getInventory();
                    return inventory == DiamondChestBlockEntity.this || inventory instanceof DoubleInventory && ((DoubleInventory)inventory).isPart(DiamondChestBlockEntity.this);
                }
                return false;
            }
        };
    }
}
