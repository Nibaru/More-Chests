package games.twinhead.morechests.client;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.client.screen.*;
import games.twinhead.morechests.registry.ModBlockEntityRendererRegistry;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class MoreChestsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ScreenHandlerRegistry.BASIC_CHEST_SCREEN_HANDLER, BasicChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.IRON_CHEST_SCREEN_HANDLER, IronChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.GOLD_CHEST_SCREEN_HANDLER, GoldChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.DIAMOND_CHEST_SCREEN_HANDLER, DiamondChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.NETHERITE_CHEST_SCREEN_HANDLER, NetheriteChestScreen::new);
        HandledScreens.register(ScreenHandlerRegistry.COPPER_CHEST_SCREEN_HANDLER, CopperChestScreen::new);

        ModBlockEntityRendererRegistry.register();


        ClientSpriteRegistryCallback.event(TexturedRenderLayers.CHEST_ATLAS_TEXTURE).register((texture, registry) -> {
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/copper_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/exposed_copper_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/weathered_copper_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/oxidized_copper_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/iron_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/gold_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/diamond_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/netherite_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/oak_plank_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/birch_plank_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/spruce_plank_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/jungle_plank_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/acacia_plank_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/dark_oak_plank_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/crimson_plank_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/warped_plank_chest"));
            registry.register(new Identifier(MoreChests.MOD_ID, "entity/chest/mangrove_plank_chest"));
        });

    }
}
