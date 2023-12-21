package games.twinhead.morechests.client;

import games.twinhead.morechests.client.screen.*;
import games.twinhead.morechests.registry.ModBlockEntityRendererRegistry;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.util.DyeColor;

@Environment(EnvType.CLIENT)
public class MoreChestsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ScreenHandlerRegistry.BASIC_CHEST_SCREEN_HANDLER, BasicChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.DOUBLE_BASIC_CHEST_SCREEN_HANDLER, BasicChestScreen::new);

        HandledScreens.register(ScreenHandlerRegistry.IRON_CHEST_SCREEN_HANDLER, IronChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.GOLD_CHEST_SCREEN_HANDLER, GoldChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.DIAMOND_CHEST_SCREEN_HANDLER, DiamondChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.NETHERITE_CHEST_SCREEN_HANDLER, NetheriteChestScreen::new);

        HandledScreens.register(ScreenHandlerRegistry.COPPER_CHEST_SCREEN_HANDLER, CopperChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.DOUBLE_COPPER_CHEST_SCREEN_HANDLER, DoubleCopperChestScreen::new);

        for (DyeColor color : DyeColor.values()) {
            HandledScreens.register(ScreenHandlerRegistry.WOOL_CHEST_SCREEN_HANDLERS.get(color), WoolChestScreen::new);
            HandledScreens.register(ScreenHandlerRegistry.DOUBLE_WOOL_CHEST_SCREEN_HANDLERS.get(color), WoolChestScreen::new);
       }


        ModBlockEntityRendererRegistry.register();
    }
}
