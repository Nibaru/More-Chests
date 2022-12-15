package games.twinhead.morechests.datagen;

import games.twinhead.morechests.registry.BlockRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class LangProvider extends FabricLanguageProvider {
    
    protected LangProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder tb) {
        tb.add(BlockRegistry.ACACIA_PLANK_CHEST, "Acacia Chest");
        tb.add(BlockRegistry.BIRCH_PLANK_CHEST, "Birch Chest");
        tb.add(BlockRegistry.CRIMSON_PLANK_CHEST, "Crimson Chest");
        tb.add(BlockRegistry.DARK_OAK_PLANK_CHEST, "Dark Oak Chest");
        tb.add(BlockRegistry.JUNGLE_PLANK_CHEST, "Jungle Chest");
        tb.add(BlockRegistry.MANGROVE_PLANK_CHEST, "Mangrove Chest");
        tb.add(BlockRegistry.OAK_PLANK_CHEST, "Oak Chest");
        tb.add(BlockRegistry.SPRUCE_PLANK_CHEST, "Spruce Chest");
        tb.add(BlockRegistry.WARPED_PLANK_CHEST, "Warped Chest");
        tb.add(BlockRegistry.COPPER_CHEST, "Copper Chest");
        tb.add(BlockRegistry.EXPOSED_COPPER_CHEST, "Exposed Copper Chest");
        tb.add(BlockRegistry.WEATHERED_COPPER_CHEST, "Weathered Copper Chest");
        tb.add(BlockRegistry.OXIDIZED_COPPER_CHEST, "Oxidized Copper Chest");
        tb.add(BlockRegistry.WAXED_COPPER_CHEST, "Waxed Copper Chest");
        tb.add(BlockRegistry.WAXED_EXPOSED_COPPER_CHEST, "Waxed Exposed Copper Chest");
        tb.add(BlockRegistry.WAXED_WEATHERED_COPPER_CHEST, "Waxed Weathered Copper Chest");
        tb.add(BlockRegistry.WAXED_OXIDIZED_COPPER_CHEST, "Waxed Oxidized Copper Chest");
        tb.add(BlockRegistry.IRON_CHEST, "Iron Chest");
        tb.add(BlockRegistry.GOLD_CHEST, "Gold Chest");
        tb.add(BlockRegistry.DIAMOND_CHEST, "Diamond Chest");
        tb.add(BlockRegistry.NETHERITE_CHEST, "Netherite Chest");

        tb.add("itemGroup.more_chests.more_chests_tab", "More Chests");

    }
}
