package games.twinhead.morechests.screen;


import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.slot.Slot;

public class CopperChestScreenHandler extends AbstractChestScreenHandler {

    public CopperChestScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, new SimpleInventory(ChestTypes.COPPER.size()));
    }

    public CopperChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenHandlerRegistry.COPPER_CHEST_SCREEN_HANDLER, ChestTypes.COPPER, syncId, playerInventory);
        checkSize(inventory, type.size());
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        int i = (type.rows - 4) * 18;

        int j;
        int k;
        for(j = 0; j < type.rows; ++j) {
            for(k = 0; k < type.columns; ++k) {
                this.addSlot(new Slot(inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        addPlayerInventoryAndHotbar(playerInventory, 0, 0);
    }
}
