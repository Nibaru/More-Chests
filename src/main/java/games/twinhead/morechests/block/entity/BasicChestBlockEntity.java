package games.twinhead.morechests.block.entity;

import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.screen.BasicChestScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BasicChestBlockEntity extends ChestBlockEntity {

    private final ChestTypes type;
    private int viewers = 0;
    private float angle, last;
    private final ViewerCountManager stateManager;

    public BasicChestBlockEntity(BlockPos pos, BlockState state, ChestTypes type) {
        this(type.getBlockEntityType(), pos, state, type);
    }

    public BasicChestBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state, ChestTypes type) {
        super(blockEntityType, pos, state);
        this.setInvStackList(DefaultedList.ofSize(type.rows * type.columns, ItemStack.EMPTY));
        this.type = type;
        this.stateManager = new ViewerCountManager() {
            protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
                BasicChestBlockEntity.playSound(world, pos, state, SoundEvents.BLOCK_CHEST_OPEN);
            }

            protected void onContainerClose(World world, BlockPos pos, BlockState state) {
                BasicChestBlockEntity.playSound(world, pos, state, SoundEvents.BLOCK_CHEST_CLOSE);
            }

            protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
                BasicChestBlockEntity.this.onInvOpenOrClose(world, pos, state, oldViewerCount, newViewerCount);
                viewers = newViewerCount;

            }

            protected boolean isPlayerViewing(PlayerEntity player) {
                if (!(player.currentScreenHandler instanceof BasicChestScreenHandler)) {
                    return false;
                } else {
                    Inventory inventory = ((BasicChestScreenHandler)player.currentScreenHandler).getInventory();
                    return inventory == BasicChestBlockEntity.this;
                }
            }
        };
    }

    @Override
    public int size() {
        return type.rows * type.columns;
    }

    @Override
    public Text getContainerName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    public void onOpen(PlayerEntity player) {
        if (!this.removed && !player.isSpectator()) {
            this.stateManager.openContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
            markDirty();
        }
    }

    public void onClose(PlayerEntity player) {
        if (!this.removed && !player.isSpectator()) {
            this.stateManager.closeContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
            markDirty();
        }
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    @Nullable
    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return this.type.createMenu(syncId, playerInventory, this);
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        this.viewers = tag.getInt("viewers");
    }

    @Override
    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        tag.putInt("viewers", viewers);
    }

    @Override
    public void markDirty() {
        super.markDirty();

        if (!this.getWorld().isClient() && this.getWorld() != null &&  this.getWorld() instanceof ServerWorld w) w.getChunkManager().markForUpdate(getPos());

    }

    @Environment(EnvType.CLIENT)
    public int countViewers() {
        return viewers;
    }




    @Override
    @Environment(EnvType.CLIENT)
    public float getAnimationProgress(float f) {
        return MathHelper.lerp(f, last, angle);
    }

    @Environment(EnvType.CLIENT)
    public void clientTick() {
        progressAnimation();
    }



    private void progressAnimation(){
        if (world != null && world.isClient) {
            last = angle;

            int viewers = countViewers();

            if (viewers > 0 && angle == 0.0F)
                playSound(world, pos, this.getCachedState(), SoundEvents.BLOCK_CHEST_OPEN);

            if (viewers == 0 && angle > 0.0F || viewers > 0 && angle < 0.89F) {
                float f = angle;
                if (viewers > 0) angle += 0.1F;
                else angle -= 0.1F;
                angle = MathHelper.clamp(angle, 0, 1);
                if (angle < 0.5F && f >= 0.5F)
                    playSound(world, pos, this.getCachedState(), SoundEvents.BLOCK_CHEST_CLOSE);


            }
        }
    }

    @Environment(EnvType.CLIENT)
    private static void playSound(World world, BlockPos pos, BlockState state, SoundEvent soundEvent) {
        assert world != null;
        world.playSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, soundEvent, SoundCategory.BLOCKS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F, false);
    }
}
