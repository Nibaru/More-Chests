package games.twinhead.morechests.registry;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.screen.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class ScreenHandlerRegistry {

    public static ScreenHandlerType<BasicChestScreenHandler> BASIC_CHEST_SCREEN_HANDLER;
    public static ScreenHandlerType<BasicChestScreenHandler> DOUBLE_BASIC_CHEST_SCREEN_HANDLER;

    public static ScreenHandlerType<IronChestScreenHandler> IRON_CHEST_SCREEN_HANDLER;
    public static ScreenHandlerType<GoldChestScreenHandler> GOLD_CHEST_SCREEN_HANDLER;
    public static ScreenHandlerType<DiamondChestScreenHandler> DIAMOND_CHEST_SCREEN_HANDLER;
    public static ScreenHandlerType<NetheriteChestScreenHandler> NETHERITE_CHEST_SCREEN_HANDLER;
    public static ScreenHandlerType<CopperChestScreenHandler> COPPER_CHEST_SCREEN_HANDLER;
    public static ScreenHandlerType<DoubleCopperChestScreenHandler> DOUBLE_COPPER_CHEST_SCREEN_HANDLER;

    public static HashMap<DyeColor, ScreenHandlerType<WoolChestScreenHandler>> WOOL_CHEST_SCREEN_HANDLERS = new HashMap<>();
    public static HashMap<DyeColor, ScreenHandlerType<WoolChestScreenHandler>> DOUBLE_WOOL_CHEST_SCREEN_HANDLERS = new HashMap<>();

    public static void registerAllScreenHandlers() {
        BASIC_CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.register(MoreChests.id("basic_chest_screen_handler"), BasicChestScreenHandler::createGeneric9x3);
        DOUBLE_BASIC_CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.register(MoreChests.id("double_basic_chest_screen_handler"), BasicChestScreenHandler::createGeneric9x6);

        for (DyeColor color : DyeColor.values()) {
            WOOL_CHEST_SCREEN_HANDLERS.put(color, ScreenHandlerRegistry.register(MoreChests.id(color.name().toLowerCase() + "_wool_chest_screen_handler"), (id, inventory) -> WoolChestScreenHandler.create9x3(id, inventory, color)));
            DOUBLE_WOOL_CHEST_SCREEN_HANDLERS.put(color, ScreenHandlerRegistry.register(MoreChests.id("double_" + color.name().toLowerCase() + "_wool_chest_screen_handler"), (id, inventory) -> WoolChestScreenHandler.create9x6(id, inventory, color)));
        }

        IRON_CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.register(MoreChests.id("iron_chest_screen_handler"), IronChestScreenHandler::new);
        GOLD_CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.register(MoreChests.id("gold_chest_screen_handler"), GoldChestScreenHandler::new);
        DIAMOND_CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.register(MoreChests.id("diamond_chest_screen_handler"), DiamondChestScreenHandler::new);
        NETHERITE_CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.register(MoreChests.id("netherite_chest_screen_handler"), NetheriteChestScreenHandler::new);
        COPPER_CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.register(MoreChests.id("copper_chest_screen_handler"), CopperChestScreenHandler::new);
        DOUBLE_COPPER_CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.register(MoreChests.id("double_copper_chest_screen_handler"), DoubleCopperChestScreenHandler::new);
    }

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(Identifier id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, id, new ScreenHandlerType<>(factory, FeatureFlags.VANILLA_FEATURES));
    }
}
