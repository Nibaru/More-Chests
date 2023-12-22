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

        ClientSpriteRegistryCallback.event(TexturedRenderLayers.CHEST_ATLAS_TEXTURE).register((texture, registry) -> {
            registerDouble("copper_chest", registry);
            registerDouble("exposed_copper_chest", registry);
            registerDouble("weathered_copper_chest", registry);
            registerDouble("oxidized_copper_chest", registry);

            registerDouble("oak_plank_chest", registry);
            registerDouble("birch_plank_chest", registry);
            registerDouble("spruce_plank_chest", registry);
            registerDouble("jungle_plank_chest", registry);
            registerDouble("acacia_plank_chest", registry);
            registerDouble("dark_oak_plank_chest", registry);
            registerDouble("crimson_plank_chest", registry);
            registerDouble("warped_plank_chest", registry);

            for (DyeColor color : DyeColor.values()) {
                registerDouble(color.getName() + "_wool_chest", registry);
            }

            registerSingle("iron_chest", registry);
            registerSingle("gold_chest", registry);
            registerSingle("diamond_chest", registry);
            registerSingle("netherite_chest", registry);
        });
    }

    private void registerSingle(String name, ClientSpriteRegistryCallback.Registry registry) {
        registry.register(MoreChests.id("entity/chest/" + name));
    }

    private void registerDouble(String name, ClientSpriteRegistryCallback.Registry registry) {
        registry.register(MoreChests.id("entity/chest/" + name));
        registry.register(MoreChests.id("entity/chest/" + name + "_left"));
        registry.register(MoreChests.id("entity/chest/" + name + "_right"));
    }
}
