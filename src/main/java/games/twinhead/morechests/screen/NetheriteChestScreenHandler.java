package games.twinhead.morechests.screen;


import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;

public class NetheriteChestScreenHandler extends AbstractChestScreenHandler {

    public NetheriteChestScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf packetByteBuf) {
        this(syncId, inventory, new SimpleInventory(ChestTypes.NETHERITE.size()));
    }

    public NetheriteChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenHandlerRegistry.NETHERITE_CHEST_SCREEN_HANDLER.get(), ChestTypes.NETHERITE, syncId, playerInventory);
        checkSize(inventory, ChestTypes.NETHERITE.rows * ChestTypes.NETHERITE.columns);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);


        addChestInventory(inventory, - 27, 0);
        addPlayerInventoryAndHotbar(playerInventory, 54, 0);

    }
}
