package games.twinhead.morechests.registry;

import games.twinhead.morechests.client.ChestEntityRenderer;
import games.twinhead.morechests.client.CopperChestEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class ModBlockEntityRendererRegistry {


    public static void register(){
        BlockEntityRendererFactories.register(BlockEntityRegistry.PLANK_CHEST, ChestEntityRenderer::new);

        BlockEntityRendererFactories.register(BlockEntityRegistry.WOOL_CHEST, ChestEntityRenderer::new);

        BlockEntityRendererFactories.register(BlockEntityRegistry.COPPER_CHEST, CopperChestEntityRenderer::new);

        BlockEntityRendererFactories.register(BlockEntityRegistry.IRON_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.GOLD_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.DIAMOND_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntityRegistry.NETHERITE_CHEST, ChestEntityRenderer::new);
    }
}
