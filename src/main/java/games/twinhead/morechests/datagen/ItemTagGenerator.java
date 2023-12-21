package games.twinhead.morechests.datagen;

import games.twinhead.morechests.registry.BlockRegistry;
import games.twinhead.morechests.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {

    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.WOODEN_CHESTS).add(
                BlockRegistry.ACACIA_PLANK_CHEST.asItem(),
                BlockRegistry.BIRCH_PLANK_CHEST.asItem(),
                BlockRegistry.CRIMSON_PLANK_CHEST.asItem(),
                BlockRegistry.DARK_OAK_PLANK_CHEST.asItem(),
                BlockRegistry.JUNGLE_PLANK_CHEST.asItem(),
                BlockRegistry.MANGROVE_PLANK_CHEST.asItem(),
                BlockRegistry.OAK_PLANK_CHEST.asItem(),
                BlockRegistry.SPRUCE_PLANK_CHEST.asItem(),
                BlockRegistry.WARPED_PLANK_CHEST.asItem(),
                BlockRegistry.BAMBOO_PLANK_CHEST.asItem(),
                BlockRegistry.CHERRY_PLANK_CHEST.asItem(),
                Items.CHEST
        );
        getOrCreateTagBuilder(ModTags.WOOL_CHESTS).add(
                BlockRegistry.WHITE_WOOL_CHEST.asItem(),
                BlockRegistry.ORANGE_WOOL_CHEST.asItem(),
                BlockRegistry.MAGENTA_WOOL_CHEST.asItem(),
                BlockRegistry.LIGHT_BLUE_WOOL_CHEST.asItem(),
                BlockRegistry.YELLOW_WOOL_CHEST.asItem(),
                BlockRegistry.LIME_WOOL_CHEST.asItem(),
                BlockRegistry.PINK_WOOL_CHEST.asItem(),
                BlockRegistry.GRAY_WOOL_CHEST.asItem(),
                BlockRegistry.LIGHT_GRAY_WOOL_CHEST.asItem(),
                BlockRegistry.CYAN_WOOL_CHEST.asItem(),
                BlockRegistry.PURPLE_WOOL_CHEST.asItem(),
                BlockRegistry.BLUE_WOOL_CHEST.asItem(),
                BlockRegistry.BROWN_WOOL_CHEST.asItem(),
                BlockRegistry.GREEN_WOOL_CHEST.asItem(),
                BlockRegistry.RED_WOOL_CHEST.asItem(),
                BlockRegistry.BLACK_WOOL_CHEST.asItem()
        );

        getOrCreateTagBuilder(ModTags.COPPER_CHESTS).add(
                BlockRegistry.COPPER_CHEST.asItem(),
                BlockRegistry.EXPOSED_COPPER_CHEST.asItem(),
                BlockRegistry.OXIDIZED_COPPER_CHEST.asItem(),
                BlockRegistry.WEATHERED_COPPER_CHEST.asItem(),
                BlockRegistry.WAXED_COPPER_CHEST.asItem(),
                BlockRegistry.WAXED_EXPOSED_COPPER_CHEST.asItem(),
                BlockRegistry.WAXED_WEATHERED_COPPER_CHEST.asItem(),
                BlockRegistry.WAXED_OXIDIZED_COPPER_CHEST.asItem()
        );

        getOrCreateTagBuilder(ModTags.COPPER_CHEST_UPGRADE_ITEM).add(Items.COPPER_INGOT);
        getOrCreateTagBuilder(ModTags.IRON_CHEST_UPGRADE_ITEM).add(Items.IRON_INGOT);
        getOrCreateTagBuilder(ModTags.GOLD_CHEST_UPGRADE_ITEM).add(Items.GOLD_INGOT);
        getOrCreateTagBuilder(ModTags.DIAMOND_CHEST_UPGRADE_ITEM).add(Items.DIAMOND);
        getOrCreateTagBuilder(ModTags.NETHERITE_CHEST_UPGRADE_ITEM).add(Items.NETHERITE_INGOT);

        getOrCreateTagBuilder(ModTags.GOLD_UPGRADE_CHESTS)
                .addTag(ModTags.COPPER_CHESTS)
                .add(BlockRegistry.IRON_CHEST.asItem()

        );

    }
}
