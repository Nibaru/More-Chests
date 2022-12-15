package games.twinhead.morechests.registry;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.screen.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ScreenHandlerRegistry {

    public static ScreenHandlerType<BasicChestScreenHandler> BASIC_CHEST_SCREEN_HANDLER;
    public static ScreenHandlerType<IronChestScreenHandler> IRON_CHEST_SCREEN_HANDLER;
    public static ScreenHandlerType<GoldChestScreenHandler> GOLD_CHEST_SCREEN_HANDLER;
    public static ScreenHandlerType<DiamondChestScreenHandler> DIAMOND_CHEST_SCREEN_HANDLER;
    public static ScreenHandlerType<NetheriteChestScreenHandler> NETHERITE_CHEST_SCREEN_HANDLER;
    public static ScreenHandlerType<CopperChestScreenHandler> COPPER_CHEST_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        BASIC_CHEST_SCREEN_HANDLER = new ScreenHandlerType<>(BasicChestScreenHandler::new);
        IRON_CHEST_SCREEN_HANDLER = new ScreenHandlerType<>(IronChestScreenHandler::new);
        GOLD_CHEST_SCREEN_HANDLER = new ScreenHandlerType<>(GoldChestScreenHandler::new);
        DIAMOND_CHEST_SCREEN_HANDLER = new ScreenHandlerType<>(DiamondChestScreenHandler::new);
        NETHERITE_CHEST_SCREEN_HANDLER = new ScreenHandlerType<>(NetheriteChestScreenHandler::new);
        COPPER_CHEST_SCREEN_HANDLER = new ScreenHandlerType<>(CopperChestScreenHandler::new);


        Registry.register(Registries.SCREEN_HANDLER, new Identifier(MoreChests.MOD_ID, "basic_chest_screen_handler"), BASIC_CHEST_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(MoreChests.MOD_ID, "iron_chest_screen_handler"), IRON_CHEST_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(MoreChests.MOD_ID, "gold_chest_screen_handler"), GOLD_CHEST_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(MoreChests.MOD_ID, "diamond_chest_screen_handler"), DIAMOND_CHEST_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(MoreChests.MOD_ID, "netherite_chest_screen_handler"), NETHERITE_CHEST_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(MoreChests.MOD_ID, "copper_chest_screen_handler"), COPPER_CHEST_SCREEN_HANDLER);
    }
}
