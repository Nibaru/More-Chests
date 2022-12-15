package games.twinhead.morechests.registry;

import games.twinhead.morechests.client.ChestEntityRenderer;
import games.twinhead.morechests.client.CopperChestEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;

public class ModBlockEntityRendererRegistry {


    public static void register(){
        BlockEntityRendererRegistry.register(BlockEntityRegistry.ACACIA_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.BIRCH_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.CRIMSON_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.DARK_OAK_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.JUNGLE_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.MANGROVE_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.OAK_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.SPRUCE_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.WARPED_PLANK_CHEST, ChestEntityRenderer::new);

        BlockEntityRendererRegistry.register(BlockEntityRegistry.COPPER_CHEST, CopperChestEntityRenderer::new);

        BlockEntityRendererRegistry.register(BlockEntityRegistry.IRON_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.GOLD_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.DIAMOND_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.NETHERITE_CHEST, ChestEntityRenderer::new);
    }
}
