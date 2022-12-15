package games.twinhead.morechests.screen;


import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class GoldChestScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    public final ChestTypes type = ChestTypes.GOLD;

    public GoldChestScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, new SimpleInventory(ChestTypes.GOLD.rows * ChestTypes.GOLD.columns));
    }

    public GoldChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenHandlerRegistry.GOLD_CHEST_SCREEN_HANDLER, syncId);
        checkSize(inventory, ChestTypes.GOLD.rows * ChestTypes.GOLD.columns);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);


        int i = (type.rows - 4) * 18;

        int slotCount = 0;

        int j;
        int k;
        for(j = 0; j < type.rows; ++j) {
            for(k = 0; k < type.columns; ++k) {
                this.addSlot(new Slot(inventory, slotCount++, 8 + k * 18, 18 + j * 18));
            }
        }

        int space = 35;

        for(j = 0; j < 3; ++j) {
            for(k = 0; k < 9; ++k) {
                this.addSlot(new Slot(playerInventory, k + j * 9 + 9, space + k * 18, 103 + j * 18 + i));
            }
        }

        for(j = 0; j < 9; ++j) {
            this.addSlot(new Slot(playerInventory, j, space + j * 18, 161 + i));
        }

    }


    @Override
    public ItemStack transferSlot(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = (Slot)this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot < type.rows * type.columns) {
                if (!this.insertItem(itemStack2, type.rows * type.columns, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 0, type.rows * type.columns, false)) {
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

    @Override
    public void close(PlayerEntity player){
        super.close(player);
        this.inventory.onClose(player);
    }
}
