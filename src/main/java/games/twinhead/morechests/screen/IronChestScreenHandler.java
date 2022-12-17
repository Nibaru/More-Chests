package games.twinhead.morechests.screen;


import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;

public class IronChestScreenHandler extends AbstractChestScreenHandler {

    public IronChestScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, new SimpleInventory(ChestTypes.IRON.size()));
    }

    public IronChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenHandlerRegistry.IRON_CHEST_SCREEN_HANDLER, ChestTypes.IRON ,syncId, playerInventory);
        checkSize(inventory, 54);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        addChestInventory(inventory, 0, 0);
        addPlayerInventoryAndHotbar(playerInventory, 0, 0);
    }
}
