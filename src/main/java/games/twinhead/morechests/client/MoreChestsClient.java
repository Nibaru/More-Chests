package games.twinhead.morechests.client;

import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.client.screen.*;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class MoreChestsClient  {

    public static void onInitializeClient(final FMLClientSetupEvent event) {
        HandledScreens.register(ScreenHandlerRegistry.BASIC_CHEST_SCREEN_HANDLER.get(), BasicChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.IRON_CHEST_SCREEN_HANDLER.get(), IronChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.GOLD_CHEST_SCREEN_HANDLER.get(), GoldChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.DIAMOND_CHEST_SCREEN_HANDLER.get(), DiamondChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.NETHERITE_CHEST_SCREEN_HANDLER.get(), NetheriteChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.COPPER_CHEST_SCREEN_HANDLER.get(), CopperChestScreen::new);

    }

    @SubscribeEvent
    public static void onStitch(TextureStitchEvent.Pre event) {
        if (!event.getAtlas().getId().equals(TexturedRenderLayers.CHEST_ATLAS_TEXTURE)){
            return;
        }
        for (ChestTypes type: ChestTypes.values()) {
            event.addSprite(type.getTextureId());
        }
    }
}
