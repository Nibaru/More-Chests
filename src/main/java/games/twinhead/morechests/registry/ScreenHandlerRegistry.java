package games.twinhead.morechests.registry;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.screen.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
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
        BASIC_CHEST_SCREEN_HANDLER = new ScreenHandlerType<>(BasicChestScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
        IRON_CHEST_SCREEN_HANDLER = new ScreenHandlerType<>(IronChestScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
        GOLD_CHEST_SCREEN_HANDLER = new ScreenHandlerType<>(GoldChestScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
        DIAMOND_CHEST_SCREEN_HANDLER = new ScreenHandlerType<>(DiamondChestScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
        NETHERITE_CHEST_SCREEN_HANDLER = new ScreenHandlerType<>(NetheriteChestScreenHandler::new, FeatureFlags.VANILLA_FEATURES);
        COPPER_CHEST_SCREEN_HANDLER = new ScreenHandlerType<>(CopperChestScreenHandler::new, FeatureFlags.VANILLA_FEATURES);


        Registry.register(Registries.SCREEN_HANDLER, id("basic_chest_screen_handler"), BASIC_CHEST_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, id("iron_chest_screen_handler"), IRON_CHEST_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, id("gold_chest_screen_handler"), GOLD_CHEST_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, id("diamond_chest_screen_handler"), DIAMOND_CHEST_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, id("netherite_chest_screen_handler"), NETHERITE_CHEST_SCREEN_HANDLER);
        Registry.register(Registries.SCREEN_HANDLER, id("copper_chest_screen_handler"), COPPER_CHEST_SCREEN_HANDLER);
    }

    private static Identifier id(String path){
        return new Identifier(MoreChests.MOD_ID, path);
    }
}
