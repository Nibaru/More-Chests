package games.twinhead.morechests.block.entity;

import games.twinhead.morechests.block.ChestTypes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.ChestLidAnimator;
import net.minecraft.block.enums.ChestType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public abstract class CustomChestBlockEntity extends ChestBlockEntity {

    private final ChestTypes type;
    public CustomViewerCountManager stateManager;
    private final ChestLidAnimator lidAnimator = new ChestLidAnimator();

    public CustomChestBlockEntity(BlockPos pos, BlockState state, ChestTypes type) {
        this(type.getBlockEntityType(), pos, state, type);
    }

    public CustomChestBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state, ChestTypes type) {
        super(blockEntityType, pos, state);
        this.setInvStackList(DefaultedList.ofSize(type.rows * type.columns, ItemStack.EMPTY));
        this.type = type;
        this.stateManager = initStateManager();
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
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }


    @Override
    public float getAnimationProgress(float tickDelta) {
        return this.lidAnimator.getProgress(tickDelta);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }


    @Environment(EnvType.CLIENT)
    public void clientTick() {
        lidAnimator.step();
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
}
