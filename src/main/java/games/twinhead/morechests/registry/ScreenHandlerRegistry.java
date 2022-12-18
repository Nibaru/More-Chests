package games.twinhead.morechests.registry;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.screen.*;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ScreenHandlerRegistry {

    private static final DeferredRegister<ScreenHandlerType<?>> SCREEN_HANDLERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MoreChests.MOD_ID);


    public static final RegistryObject<ScreenHandlerType<BasicChestScreenHandler>> BASIC_CHEST_SCREEN_HANDLER = SCREEN_HANDLERS.register("basic_chest_screen_handler", () -> IForgeMenuType.create(BasicChestScreenHandler::new));
    public static final RegistryObject<ScreenHandlerType<IronChestScreenHandler>> IRON_CHEST_SCREEN_HANDLER = SCREEN_HANDLERS.register("iron_chest_screen_handler", () -> IForgeMenuType.create(IronChestScreenHandler::new));
    public static final RegistryObject<ScreenHandlerType<GoldChestScreenHandler>> GOLD_CHEST_SCREEN_HANDLER = SCREEN_HANDLERS.register("gold_chest_screen_handler", () -> IForgeMenuType.create(GoldChestScreenHandler::new));
    public static final RegistryObject<ScreenHandlerType<DiamondChestScreenHandler>> DIAMOND_CHEST_SCREEN_HANDLER = SCREEN_HANDLERS.register("diamond_chest_screen_handler", () -> IForgeMenuType.create(DiamondChestScreenHandler::new));
    public static final RegistryObject<ScreenHandlerType<NetheriteChestScreenHandler>> NETHERITE_CHEST_SCREEN_HANDLER = SCREEN_HANDLERS.register("netherite_chest_screen_handler", () -> IForgeMenuType.create(NetheriteChestScreenHandler::new));
    public static final RegistryObject<ScreenHandlerType<CopperChestScreenHandler>> COPPER_CHEST_SCREEN_HANDLER = SCREEN_HANDLERS.register("copper_chest_screen_handler", () -> IForgeMenuType.create(CopperChestScreenHandler::new));

    public static void registerAllScreenHandlers() {
        SCREEN_HANDLERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
