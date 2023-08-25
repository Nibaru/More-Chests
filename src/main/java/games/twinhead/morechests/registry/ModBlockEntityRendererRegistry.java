package games.twinhead.morechests.registry;

import games.twinhead.morechests.client.ChestEntityRenderer;
import games.twinhead.morechests.client.CopperChestEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ModBlockEntityRendererRegistry {


    public static void register(){
        BlockEntityRendererFactories.register(BlockEntityRegistry.ACACIA_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.BIRCH_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.CRIMSON_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.DARK_OAK_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.JUNGLE_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.MANGROVE_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.OAK_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.SPRUCE_PLANK_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.WARPED_PLANK_CHEST, ChestEntityRenderer::new);

        BlockEntityRendererFactories.register(BlockEntityRegistry.COPPER_CHEST, CopperChestEntityRenderer::new);

        BlockEntityRendererFactories.register(BlockEntityRegistry.IRON_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.GOLD_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.DIAMOND_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.NETHERITE_CHEST, ChestEntityRenderer::new);
    }
}
