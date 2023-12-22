package games.twinhead.morechests.registry;

import games.twinhead.morechests.client.ChestEntityRenderer;
import games.twinhead.morechests.client.CopperChestEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;

public class ModBlockEntityRendererRegistry {


    public static void register(){
        BlockEntityRendererRegistry.register(BlockEntityRegistry.PLANK_CHEST, ChestEntityRenderer::new);

        BlockEntityRendererRegistry.register(BlockEntityRegistry.WOOL_CHEST, ChestEntityRenderer::new);

        BlockEntityRendererRegistry.register(BlockEntityRegistry.COPPER_CHEST, CopperChestEntityRenderer::new);

        BlockEntityRendererRegistry.register(BlockEntityRegistry.IRON_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.GOLD_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.DIAMOND_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.register(BlockEntityRegistry.NETHERITE_CHEST, ChestEntityRenderer::new);
    }
}
