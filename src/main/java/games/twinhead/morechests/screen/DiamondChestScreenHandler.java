package games.twinhead.morechests.screen;


import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.network.PacketByteBuf;

public class DiamondChestScreenHandler extends AbstractChestScreenHandler {

    public DiamondChestScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf packetByteBuf) {
        this(syncId, inventory, new SimpleInventory(ChestTypes.DIAMOND.size()));
    }

    public DiamondChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenHandlerRegistry.DIAMOND_CHEST_SCREEN_HANDLER.get(), ChestTypes.DIAMOND, syncId, playerInventory);
        checkSize(inventory, type.size());
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);


        addChestInventory(inventory, 0, 0);
        addPlayerInventoryAndHotbar(playerInventory, 27, 1);

    }

}
