package games.twinhead.morechests.screen;


import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.slot.Slot;

public class BasicChestScreenHandler extends AbstractChestScreenHandler {

    public BasicChestScreenHandler(int syncId, PlayerInventory inventory) {
        this(ChestTypes.ACACIA_PLANK, syncId, inventory, new SimpleInventory(27));
    }

    public BasicChestScreenHandler(ChestTypes type, int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenHandlerRegistry.BASIC_CHEST_SCREEN_HANDLER, type ,syncId, playerInventory);
        checkSize(inventory, 27);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        addChestInventory(inventory, 0, 0);
        addPlayerInventoryAndHotbar(playerInventory, 0, 0);
    }
}
