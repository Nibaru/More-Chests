package games.twinhead.morechests;

import games.twinhead.morechests.event.ChestEvents;
import games.twinhead.morechests.registry.BlockEntityRegistry;
import games.twinhead.morechests.registry.BlockRegistry;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class MoreChests implements ModInitializer {

    public static final String MOD_ID = "more_chests";

    public static ItemGroup MOD_GROUP  = FabricItemGroupBuilder.build(id("more_chests_mod_group"), () -> new ItemStack(BlockRegistry.DIAMOND_CHEST));

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
    @Override
    public void onInitialize() {
        BlockRegistry.register();
        BlockEntityRegistry.registerBlockEntities();
        ScreenHandlerRegistry.registerAllScreenHandlers();
        new ChestEvents().register();

        //Registry.register(Registries.ITEM, id("group"), MOD_GROUP);
    }




}
