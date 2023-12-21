package games.twinhead.morechests.screen;


import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;

public class NetheriteChestScreenHandler extends AbstractChestScreenHandler {

    public NetheriteChestScreenHandler(int syncId, PlayerInventory inventory) {
        this(syncId, inventory, new SimpleInventory(ChestTypes.NETHERITE.size()));
    }

    public NetheriteChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenHandlerRegistry.NETHERITE_CHEST_SCREEN_HANDLER, ChestTypes.NETHERITE, syncId, playerInventory);
        checkSize(inventory, ChestTypes.NETHERITE.rows * ChestTypes.NETHERITE.columns);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);


        addChestInventory(inventory, 0, 0);
        addPlayerInventoryAndHotbar(playerInventory, 81, 0);
    }
}
