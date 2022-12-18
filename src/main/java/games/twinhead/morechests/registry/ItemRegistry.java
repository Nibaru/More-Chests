package games.twinhead.morechests.registry;

import games.twinhead.morechests.MoreChests;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreChests.MOD_ID);

    public static final RegistryObject<Item> ACACIA_PLANK_CHEST = ITEMS.register("acacia_plank_chest", () -> new BlockItem(BlockRegistry.ACACIA_PLANK_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> BIRCH_PLANK_CHEST = ITEMS.register("birch_plank_chest", () -> new BlockItem(BlockRegistry.BIRCH_PLANK_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> CRIMSON_PLANK_CHEST = ITEMS.register("crimson_plank_chest", () -> new BlockItem(BlockRegistry.CRIMSON_PLANK_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> DARK_OAK_PLANK_CHEST = ITEMS.register("dark_oak_plank_chest", () -> new BlockItem(BlockRegistry.DARK_OAK_PLANK_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> JUNGLE_PLANK_CHEST = ITEMS.register("jungle_plank_chest", () -> new BlockItem(BlockRegistry.JUNGLE_PLANK_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> MANGROVE_PLANK_CHEST = ITEMS.register("mangrove_plank_chest", () -> new BlockItem(BlockRegistry.MANGROVE_PLANK_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> OAK_PLANK_CHEST = ITEMS.register("oak_plank_chest", () -> new BlockItem(BlockRegistry.OAK_PLANK_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> SPRUCE_PLANK_CHEST = ITEMS.register("spruce_plank_chest", () -> new BlockItem(BlockRegistry.SPRUCE_PLANK_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> WARPED_PLANK_CHEST = ITEMS.register("warped_plank_chest", () -> new BlockItem(BlockRegistry.WARPED_PLANK_CHEST.get(), new Item.Settings()));

    public static final RegistryObject<Item> COPPER_CHEST = ITEMS.register("copper_chest", () -> new BlockItem(BlockRegistry.COPPER_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> EXPOSED_COPPER_CHEST = ITEMS.register("exposed_copper_chest", () -> new BlockItem(BlockRegistry.EXPOSED_COPPER_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> WEATHERED_COPPER_CHEST = ITEMS.register("weathered_copper_chest", () -> new BlockItem(BlockRegistry.WEATHERED_COPPER_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> OXIDIZED_COPPER_CHEST = ITEMS.register("oxidized_copper_chest", () -> new BlockItem(BlockRegistry.OXIDIZED_COPPER_CHEST.get(), new Item.Settings()));

    public static final RegistryObject<Item> WAXED_COPPER_CHEST = ITEMS.register("waxed_copper_chest", () -> new BlockItem(BlockRegistry.WAXED_COPPER_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> WAXED_EXPOSED_COPPER_CHEST = ITEMS.register("waxed_exposed_copper_chest", () -> new BlockItem(BlockRegistry.WAXED_EXPOSED_COPPER_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> WAXED_WEATHERED_COPPER_CHEST = ITEMS.register("waxed_weathered_copper_chest", () -> new BlockItem(BlockRegistry.WAXED_WEATHERED_COPPER_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> WAXED_OXIDIZED_COPPER_CHEST = ITEMS.register("waxed_oxidized_copper_chest", () -> new BlockItem(BlockRegistry.WAXED_OXIDIZED_COPPER_CHEST.get(), new Item.Settings()));

    public static final RegistryObject<Item> IRON_CHEST = ITEMS.register("iron_chest", () -> new BlockItem(BlockRegistry.IRON_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> GOLD_CHEST = ITEMS.register("gold_chest", () -> new BlockItem(BlockRegistry.GOLD_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> DIAMOND_CHEST = ITEMS.register("diamond_chest", () -> new BlockItem(BlockRegistry.DIAMOND_CHEST.get(), new Item.Settings()));
    public static final RegistryObject<Item> NETHERITE_CHEST = ITEMS.register("netherite_chest", () -> new BlockItem(BlockRegistry.NETHERITE_CHEST.get(), new Item.Settings()));

    public static void register(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
