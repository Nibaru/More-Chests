package games.twinhead.morechests.datagen;

import games.twinhead.morechests.registry.BlockRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class LanguageGenerator extends FabricLanguageProvider {
    
    protected LanguageGenerator(FabricDataOutput dataOutput) {
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
        tb.add(BlockRegistry.BAMBOO_PLANK_CHEST, "Bamboo Chest");
        tb.add(BlockRegistry.CHERRY_PLANK_CHEST, "Cherry Chest");
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

        tb.add(BlockRegistry.WHITE_WOOL_CHEST, "White Wool Chest");
        tb.add(BlockRegistry.ORANGE_WOOL_CHEST, "Orange Wool Chest");
        tb.add(BlockRegistry.MAGENTA_WOOL_CHEST, "Magenta Wool Chest");
        tb.add(BlockRegistry.LIGHT_BLUE_WOOL_CHEST, "Light Blue Wool Chest");
        tb.add(BlockRegistry.YELLOW_WOOL_CHEST, "Yellow Wool Chest");
        tb.add(BlockRegistry.LIME_WOOL_CHEST, "Lime Wool Chest");
        tb.add(BlockRegistry.PINK_WOOL_CHEST, "Pink Wool Chest");
        tb.add(BlockRegistry.GRAY_WOOL_CHEST, "Gray Wool Chest");
        tb.add(BlockRegistry.LIGHT_GRAY_WOOL_CHEST, "Light Gray Wool Chest");
        tb.add(BlockRegistry.CYAN_WOOL_CHEST, "Cyan Wool Chest");
        tb.add(BlockRegistry.PURPLE_WOOL_CHEST, "Purple Wool Chest");
        tb.add(BlockRegistry.BLUE_WOOL_CHEST, "Blue Wool Chest");
        tb.add(BlockRegistry.BROWN_WOOL_CHEST, "Brown Wool Chest");
        tb.add(BlockRegistry.GREEN_WOOL_CHEST, "Green Wool Chest");
        tb.add(BlockRegistry.RED_WOOL_CHEST, "Red Wool Chest");
        tb.add(BlockRegistry.BLACK_WOOL_CHEST, "Black Wool Chest");

        tb.add("container.more_chests.chest_double", "Large %d");
        tb.add("item_group.more_chests.more_chests_mod_group", "More Chests");

        tb.add("item.more_chests.chest_item.tooltip.shift", "§7Hold§7 §eShift§7");
        tb.add("item.more_chests.chest_item.tooltip.upgrades_into", "§7Upgrades into:§r");
        tb.add("item.more_chests.chest_item.tooltip.upgrades_ingredient", "§7Sneak and interact while holding %s %s §7to upgrade.");
        tb.add("item.more_chests.chest_item.tooltip.upgrades_ingredients", "§7Sneak and interact while holding %s §a%s §7or %s §a%s §7to upgrade.");
        tb.add("item.more_chests.chest_item.tooltip.chest_variants", "§7Available in §n%s §7chest variants");
    }
}
