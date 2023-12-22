package games.twinhead.morechests.block.entity;

import games.twinhead.morechests.block.ChestTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.ChestLidAnimator;
import net.minecraft.block.enums.ChestType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class CustomChestBlockEntity extends ChestBlockEntity {

    private final ChestTypes type;
    public CustomViewerCountManager stateManager;
    private final ChestLidAnimator lidAnimator;

    public CustomChestBlockEntity(BlockPos pos, BlockState state, ChestTypes type) {
        this(type.getBlockEntityType(), pos, state, type);
    }

    public CustomChestBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state, ChestTypes type) {
        super(blockEntityType, pos, state);
        this.setInvStackList(DefaultedList.ofSize(type.rows * type.columns, ItemStack.EMPTY));
        this.type = type;
        this.stateManager = initStateManager();
        lidAnimator = new ChestLidAnimator();
    }

    public ChestTypes getChestType() {
        return type;
    }

    @Override
    public int size() {
        return type.rows * type.columns;
    }

    @Nullable
    @Override
    public abstract ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory);
    public abstract CustomViewerCountManager initStateManager();

    @Override
    public Text getContainerName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }


    @Override
    public float getAnimationProgress(float tickDelta) {
        return this.lidAnimator.getProgress(tickDelta);
    }

    @Environment(EnvType.CLIENT)
    public static void clientTick(World world, BlockPos pos, BlockState state, CustomChestBlockEntity blockEntity) {
        blockEntity.lidAnimator.step();
    }

    public boolean onSyncedBlockEvent(int type, int data) {
        if (type == 1) {
            this.lidAnimator.setOpen(data > 0);
            return true;
        } else {
            return super.onSyncedBlockEvent(type, data);
        }
    }

    public void onScheduledTick(World world, BlockPos pos, BlockState state) {
        if (!this.removed) {
            stateManager.updateViewerCount(world, pos, state);
        }
    }

    public void onOpen(PlayerEntity player) {
        if (!this.removed && !player.isSpectator()) {
            stateManager.openContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
        }
    }

    public void onClose(PlayerEntity player) {
        if (!this.removed && !player.isSpectator()) {
            stateManager.closeContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
        }
    }

    @Environment(EnvType.CLIENT)
    public static void playSound(World world, BlockPos pos, BlockState state, SoundEvent soundEvent) {
        ChestType chestType = state.get(ChestBlock.CHEST_TYPE);
        if (chestType == ChestType.LEFT) {
            return;
        }
        double d = (double)pos.getX() + 0.5;
        double e = (double)pos.getY() + 0.5;
        double f = (double)pos.getZ() + 0.5;
        if (chestType == ChestType.RIGHT) {
            Direction direction = ChestBlock.getFacing(state);
            d += (double)direction.getOffsetX() * 0.5;
            f += (double)direction.getOffsetZ() * 0.5;
        }
        world.playSound(null, d, e, f, soundEvent, SoundCategory.BLOCKS, 0.5f, world.random.nextFloat() * 0.1f + 0.9f);
    }

    public void onScheduledTick() {
        if (!this.removed) {
            this.stateManager.updateViewerCount(this.getWorld(), this.getPos(), this.getCachedState());
        }

    }

    public static int getPlayersLookingInChestCount(BlockView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.hasBlockEntity()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CustomChestBlockEntity) {
                return ((CustomChestBlockEntity)blockEntity).stateManager.getViewerCount();
            }
        }

        return 0;
    }

    protected void onInvOpenOrClose(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
        Block block = state.getBlock();
        world.addSyncedBlockEvent(pos, block, 1, newViewerCount);
    }
}
