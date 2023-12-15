package games.twinhead.morechests.screen;


import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.slot.Slot;

public class DoubleCopperChestScreenHandler extends AbstractChestScreenHandler {

    public DoubleCopperChestScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, new SimpleInventory(ChestTypes.COPPER.size() * 2));
    }

    public DoubleCopperChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenHandlerRegistry.DOUBLE_COPPER_CHEST_SCREEN_HANDLER, ChestTypes.COPPER, syncId, playerInventory);
        checkSize(inventory, type.size() * 2);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);


        addChestInventory(inventory, 0, 0);
        addPlayerInventoryAndHotbar(playerInventory, 27, 36 );
    }

    void addChestInventory(Inventory inventory, int xOffset, int yOffset){
        int slotCount = 0;
        for(int j = 0; j < 6; ++j) {
            for(int k = 0; k < 12; ++k) {
                this.addSlot(new Slot(inventory, slotCount++, (8 + k * 18) + xOffset , (18 + j * 18) + yOffset));
            }
        }
    }
}