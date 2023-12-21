package games.twinhead.morechests.datagen;

import games.twinhead.morechests.registry.BlockRegistry;
import games.twinhead.morechests.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.WOODEN_CHESTS_BLOCK).add(
                BlockRegistry.ACACIA_PLANK_CHEST,
                BlockRegistry.BIRCH_PLANK_CHEST,
                BlockRegistry.CRIMSON_PLANK_CHEST,
                BlockRegistry.DARK_OAK_PLANK_CHEST,
                BlockRegistry.JUNGLE_PLANK_CHEST,
                BlockRegistry.MANGROVE_PLANK_CHEST,
                BlockRegistry.OAK_PLANK_CHEST,
                BlockRegistry.SPRUCE_PLANK_CHEST,
                BlockRegistry.WARPED_PLANK_CHEST,
                Blocks.CHEST
        );
        getOrCreateTagBuilder(ModTags.WOOL_CHESTS_BLOCK).add(
                BlockRegistry.WHITE_WOOL_CHEST,
                BlockRegistry.ORANGE_WOOL_CHEST,
                BlockRegistry.MAGENTA_WOOL_CHEST,
                BlockRegistry.LIGHT_BLUE_WOOL_CHEST,
                BlockRegistry.YELLOW_WOOL_CHEST,
                BlockRegistry.LIME_WOOL_CHEST,
                BlockRegistry.PINK_WOOL_CHEST,
                BlockRegistry.GRAY_WOOL_CHEST,
                BlockRegistry.LIGHT_GRAY_WOOL_CHEST,
                BlockRegistry.CYAN_WOOL_CHEST,
                BlockRegistry.PURPLE_WOOL_CHEST,
                BlockRegistry.BLUE_WOOL_CHEST,
                BlockRegistry.BROWN_WOOL_CHEST,
                BlockRegistry.GREEN_WOOL_CHEST,
                BlockRegistry.RED_WOOL_CHEST,
                BlockRegistry.BLACK_WOOL_CHEST
        );

        getOrCreateTagBuilder(ModTags.COPPER_CHESTS_BLOCK).add(
                BlockRegistry.COPPER_CHEST,
                BlockRegistry.EXPOSED_COPPER_CHEST,
                BlockRegistry.OXIDIZED_COPPER_CHEST,
                BlockRegistry.WEATHERED_COPPER_CHEST,
                BlockRegistry.WAXED_COPPER_CHEST,
                BlockRegistry.WAXED_EXPOSED_COPPER_CHEST,
                BlockRegistry.WAXED_WEATHERED_COPPER_CHEST,
                BlockRegistry.WAXED_OXIDIZED_COPPER_CHEST
        );

        getOrCreateTagBuilder(ModTags.GOLD_UPGRADE_CHESTS_BLOCK)
                .addTag(ModTags.COPPER_CHESTS_BLOCK)
                .add(
                BlockRegistry.IRON_CHEST
        );

        getOrCreateTagBuilder(ModTags.UPGRADEABLE_CHESTS)
                .addTag(ModTags.WOODEN_CHESTS_BLOCK)
                .addTag(ModTags.WOOL_CHESTS_BLOCK)
                .addTag(ModTags.COPPER_CHESTS_BLOCK)
                .add(
                BlockRegistry.IRON_CHEST,
                BlockRegistry.GOLD_CHEST,
                BlockRegistry.DIAMOND_CHEST
        );


        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).addTag(ModTags.WOODEN_CHESTS_BLOCK);
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).addTag(ModTags.WOOL_CHESTS_BLOCK);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .addTag(ModTags.COPPER_CHESTS_BLOCK)
                .add(
                BlockRegistry.IRON_CHEST,
                BlockRegistry.GOLD_CHEST,
                BlockRegistry.DIAMOND_CHEST,
                BlockRegistry.NETHERITE_CHEST);
    }
}
