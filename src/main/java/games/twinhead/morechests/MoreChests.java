package games.twinhead.morechests;

import games.twinhead.morechests.client.ChestEntityRenderer;
import games.twinhead.morechests.client.CopperChestEntityRenderer;
import games.twinhead.morechests.client.MoreChestsClient;
import games.twinhead.morechests.registry.BlockEntityRegistry;
import games.twinhead.morechests.registry.BlockRegistry;
import games.twinhead.morechests.registry.ItemRegistry;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(MoreChests.MOD_ID)
@Mod.EventBusSubscriber
public class MoreChests {

    public static final String MOD_ID = "more_chests";

    public static final TagKey<Item> WOODEN_CHESTS = TagKey.of(Registry.ITEM_KEY, new Identifier(MOD_ID, "wooden_chests"));
    public static final TagKey<Block> WOODEN_CHESTS_BLOCK = TagKey.of(Registry.BLOCK_KEY, new Identifier(MOD_ID, "wooden_chests"));
    public static final TagKey<Item> GOLD_UPGRADE_CHESTS = TagKey.of(Registry.ITEM_KEY, new Identifier(MOD_ID, "gold_upgrade_chests"));
    public static final TagKey<Block> GOLD_UPGRADE_CHESTS_BLOCK = TagKey.of(Registry.BLOCK_KEY, new Identifier(MOD_ID, "gold_upgrade_chests"));
    public static final TagKey<Block> CHESTS = TagKey.of(Registry.BLOCK_KEY, new Identifier(MOD_ID, "chests"));
    public static final TagKey<Item> COPPER_CHEST_UPGRADE_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier(MOD_ID, "copper_chest_upgrade_item"));
    public static final TagKey<Item> IRON_CHEST_UPGRADE_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier(MOD_ID, "iron_chest_upgrade_item"));
    public static final TagKey<Item> GOLD_CHEST_UPGRADE_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier(MOD_ID, "gold_chest_upgrade_item"));
    public static final TagKey<Item> DIAMOND_CHEST_UPGRADE_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier(MOD_ID, "diamond_chest_upgrade_item"));
    public static final TagKey<Item> NETHERITE_CHEST_UPGRADE_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier(MOD_ID, "netherite_chest_upgrade_item"));
    public static final TagKey<Block> COPPER_CHESTS = TagKey.of(Registry.BLOCK_KEY, new Identifier(MOD_ID, "copper_chests"));

    public MoreChests() {
        IEventBus MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        BlockRegistry.register();
        ItemRegistry.register();
        BlockEntityRegistry.registerBlockEntities();
        ScreenHandlerRegistry.registerAllScreenHandlers();


        MOD_BUS.addListener(MoreChestsClient::onInitializeClient);
        MOD_BUS.addListener(this::registerChestEntityRenders);
        MOD_BUS.addListener(MoreChestsClient::onStitch);

        MinecraftForge.EVENT_BUS.register(new UpgradeChestsEvent());
    }

    @SubscribeEvent
    public void registerChestEntityRenders(EntityRenderersEvent.RegisterRenderers  event) {
        event.registerBlockEntityRenderer(BlockEntityRegistry.ACACIA_PLANK_CHEST.get(), ChestEntityRenderer::new);

        event.registerBlockEntityRenderer(BlockEntityRegistry.ACACIA_PLANK_CHEST.get(), ChestEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.BIRCH_PLANK_CHEST.get(), ChestEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.CRIMSON_PLANK_CHEST.get(), ChestEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.DARK_OAK_PLANK_CHEST.get(), ChestEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.JUNGLE_PLANK_CHEST.get(), ChestEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.OAK_PLANK_CHEST.get(), ChestEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.SPRUCE_PLANK_CHEST.get(), ChestEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.WARPED_PLANK_CHEST.get(), ChestEntityRenderer::new);

        event.registerBlockEntityRenderer(BlockEntityRegistry.COPPER_CHEST.get(), CopperChestEntityRenderer::new);

        event.registerBlockEntityRenderer(BlockEntityRegistry.IRON_CHEST.get(), ChestEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.GOLD_CHEST.get(), ChestEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.DIAMOND_CHEST.get(), ChestEntityRenderer::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.NETHERITE_CHEST.get(), ChestEntityRenderer::new);

    }


}
