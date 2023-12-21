package games.twinhead.morechests.screen;


import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandlerType;

public class BasicChestScreenHandler extends AbstractChestScreenHandler {

    private BasicChestScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, int rows) {
        this(type, ChestTypes.PLANK, syncId, playerInventory, new SimpleInventory(9 * rows), rows);
    }

    public static BasicChestScreenHandler createGeneric9x3(int syncId, PlayerInventory playerInventory) {
        return new BasicChestScreenHandler(ScreenHandlerRegistry.BASIC_CHEST_SCREEN_HANDLER, syncId, playerInventory, 3);
    }

    public static BasicChestScreenHandler createGeneric9x6(int syncId, PlayerInventory playerInventory) {
        return new BasicChestScreenHandler(ScreenHandlerRegistry.DOUBLE_BASIC_CHEST_SCREEN_HANDLER, syncId, playerInventory, 6);
    }

    public static BasicChestScreenHandler createGeneric9x3(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        return new BasicChestScreenHandler(ScreenHandlerRegistry.BASIC_CHEST_SCREEN_HANDLER, ChestTypes.PLANK, syncId, playerInventory, inventory, 3);
    }

    public static BasicChestScreenHandler createGeneric9x6(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        return new BasicChestScreenHandler(ScreenHandlerRegistry.DOUBLE_BASIC_CHEST_SCREEN_HANDLER, ChestTypes.PLANK, syncId, playerInventory, inventory, 6);
    }

    public BasicChestScreenHandler(ScreenHandlerType<?> screenHandlerType, ChestTypes type, int syncId, PlayerInventory playerInventory, Inventory inventory, int rows) {
        super(screenHandlerType, type ,syncId, playerInventory);
        checkSize(inventory, rows * 9);
        this.rows = rows;
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        addChestInventory(inventory, 0, 0);
        addPlayerInventoryAndHotbar(playerInventory, 0, 0);


    }
}
