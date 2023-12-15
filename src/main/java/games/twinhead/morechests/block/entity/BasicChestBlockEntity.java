package games.twinhead.morechests.block.entity;

import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.screen.AbstractChestScreenHandler;
import games.twinhead.morechests.screen.BasicChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BasicChestBlockEntity extends CustomChestBlockEntity {

    public BasicChestBlockEntity(BlockPos pos, BlockState state, ChestTypes type) {
        this(type.getBlockEntityType(), pos, state, type);
    }

    public BasicChestBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state, ChestTypes type) {
        super(blockEntityType, pos, state, type);
        this.setInvStackList(DefaultedList.ofSize(type.rows * type.columns, ItemStack.EMPTY));
    }

//    @Override
//    public NbtCompound toInitialChunkDataNbt() {
//        return this.createNbt();
//    }

    @Nullable
    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return BasicChestScreenHandler.createGeneric9x3(syncId, playerInventory, this);
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
                BasicChestBlockEntity.this.onViewerCountUpdate(world, pos, state, oldViewerCount, newViewerCount);
            }

            @Override
            protected boolean isPlayerViewing(PlayerEntity player) {
                if (player.currentScreenHandler instanceof BasicChestScreenHandler) {
                    Inventory inventory = ((AbstractChestScreenHandler)player.currentScreenHandler).getInventory();
                    return inventory == BasicChestBlockEntity.this || inventory instanceof DoubleInventory && ((DoubleInventory)inventory).isPart(BasicChestBlockEntity.this);
                }
                return false;
            }
        };
    }
}
