package games.twinhead.morechests.screen;


import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.DyeColor;

public class WoolChestScreenHandler extends AbstractChestScreenHandler {

    private final DyeColor dyeColor;

    private WoolChestScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, DyeColor color, int rows) {
        this(type, ChestTypes.WOOL, syncId, playerInventory, new SimpleInventory(9 * rows), color, rows);
    }

    public static WoolChestScreenHandler create9x3(int syncId, PlayerInventory playerInventory, DyeColor color) {
        return new WoolChestScreenHandler(getScreenHandlerFromColor(color, 3), syncId, playerInventory, color, 3);
    }

    public static WoolChestScreenHandler create9x6(int syncId, PlayerInventory playerInventory, DyeColor color) {
        return new WoolChestScreenHandler(getScreenHandlerFromColor(color, 6), syncId, playerInventory, color, 6);
    }

    public static WoolChestScreenHandler create9x3(int syncId, PlayerInventory playerInventory, Inventory inventory, DyeColor color) {
        return new WoolChestScreenHandler(getScreenHandlerFromColor(color, 3), ChestTypes.WOOL, syncId, playerInventory, inventory, color, 3);
    }

    public static WoolChestScreenHandler create9x6(int syncId, PlayerInventory playerInventory, Inventory inventory, DyeColor color) {
        return new WoolChestScreenHandler(getScreenHandlerFromColor(color, 6), ChestTypes.WOOL, syncId, playerInventory, inventory, color, 6);
    }

    public WoolChestScreenHandler(ScreenHandlerType<?> screenHandlerType, ChestTypes type, int syncId, PlayerInventory playerInventory, Inventory inventory, DyeColor color, int rows) {
        super(screenHandlerType, type ,syncId, playerInventory);
        checkSize(inventory, rows * 9);
        this.rows = rows;
        this.inventory = inventory;
        this.dyeColor = color;
        inventory.onOpen(playerInventory.player);

        addChestInventory(inventory, 0, 0);
        addPlayerInventoryAndHotbar(playerInventory, 0, 4);
    }


    public DyeColor getColor(){
        return this.dyeColor;
    }

    public static ScreenHandlerType<?> getScreenHandlerFromColor(DyeColor color, int rows){
        if (rows > 3)
            return ScreenHandlerRegistry.DOUBLE_WOOL_CHEST_SCREEN_HANDLERS.get(color);
        else
            return ScreenHandlerRegistry.WOOL_CHEST_SCREEN_HANDLERS.get(color);
    }
}
