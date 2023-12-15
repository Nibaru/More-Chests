package games.twinhead.morechests.screen;

import games.twinhead.morechests.block.ChestTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public abstract class AbstractChestScreenHandler extends ScreenHandler {
    Inventory inventory;
    final ChestTypes type;

    public int rows, columns;

    public AbstractChestScreenHandler(ScreenHandlerType<?> handlerType, ChestTypes chestType, int syncId, PlayerInventory inventory) {
        this(handlerType, chestType, syncId, inventory, new SimpleInventory(chestType.size()));
    }

    public AbstractChestScreenHandler(ScreenHandlerType<?> type, ChestTypes chestType, int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(type, syncId);
        //checkSize(inventory, 27);
        this.type = chestType;
        this.rows = chestType.rows;
        this.columns = chestType.columns;
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = (Slot)this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot < rows * columns) {
                if (!this.insertItem(itemStack2, rows * columns, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 0, rows * columns, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }
        }

        return itemStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    @Override
    public void onClosed(PlayerEntity player){
        super.onClosed(player);
        this.inventory.onClose(player);
    }


    void addChestInventory(Inventory inventory, int xOffset, int yOffset){
        int slotCount = 0;
        for(int j = 0; j < rows; ++j) {
            for(int k = 0; k < columns; ++k) {
                this.addSlot(new Slot(inventory, slotCount++, (8 + k * 18) + xOffset , (18 + j * 18) + yOffset));
            }
        }
    }

    void addPlayerInventoryAndHotbar(PlayerInventory playerInventory, int xOffset, int yOffset){
        addPlayerHotbar(playerInventory,8 + xOffset, (rows * 18) + 31 + yOffset);
        addPlayerInventory(playerInventory, 8  + xOffset, (rows * 18) + 31 + yOffset);
    }

    private void addPlayerInventory(PlayerInventory playerInventory, int x, int y) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, x + l * 18, y + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory, int x, int y) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, x + i * 18, y + 58));
        }
    }
}
