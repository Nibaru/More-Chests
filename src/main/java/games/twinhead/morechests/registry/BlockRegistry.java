package games.twinhead.morechests.registry;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.block.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Oxidizable;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class BlockRegistry {

    public static final HashMap< Identifier, BasicChestBlock> CHEST_BLOCKS = new HashMap<>();
    public static final BasicChestBlock ACACIA_PLANK_CHEST = new PlankChestBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS), ChestTypes.PLANK);
    public static final BasicChestBlock BIRCH_PLANK_CHEST = new PlankChestBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS), ChestTypes.PLANK);
    public static final BasicChestBlock CRIMSON_PLANK_CHEST = new PlankChestBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS), ChestTypes.PLANK);
    public static final BasicChestBlock DARK_OAK_PLANK_CHEST = new PlankChestBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS), ChestTypes.PLANK);
    public static final BasicChestBlock JUNGLE_PLANK_CHEST = new PlankChestBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS), ChestTypes.PLANK);
    public static final BasicChestBlock MANGROVE_PLANK_CHEST = new PlankChestBlock(FabricBlockSettings.copyOf(Blocks.MANGROVE_PLANKS), ChestTypes.PLANK);
    public static final BasicChestBlock OAK_PLANK_CHEST = new PlankChestBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), ChestTypes.PLANK);
    public static final BasicChestBlock SPRUCE_PLANK_CHEST = new PlankChestBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS), ChestTypes.PLANK);
    public static final BasicChestBlock WARPED_PLANK_CHEST = new PlankChestBlock(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS), ChestTypes.PLANK);
    public static final BasicChestBlock BAMBOO_PLANK_CHEST = new PlankChestBlock(FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS), ChestTypes.PLANK);
    public static final BasicChestBlock CHERRY_PLANK_CHEST = new PlankChestBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS), ChestTypes.PLANK);

    public static final BasicChestBlock WHITE_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL), ChestTypes.WOOL, DyeColor.WHITE);
    public static final BasicChestBlock ORANGE_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.ORANGE_WOOL), ChestTypes.WOOL, DyeColor.ORANGE);
    public static final BasicChestBlock MAGENTA_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.MAGENTA_WOOL), ChestTypes.WOOL, DyeColor.MAGENTA);
    public static final BasicChestBlock LIGHT_BLUE_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_WOOL), ChestTypes.WOOL, DyeColor.LIGHT_BLUE);
    public static final BasicChestBlock YELLOW_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.YELLOW_WOOL), ChestTypes.WOOL, DyeColor.YELLOW);
    public static final BasicChestBlock LIME_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.LIME_WOOL), ChestTypes.WOOL, DyeColor.LIME);
    public static final BasicChestBlock PINK_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.PINK_WOOL), ChestTypes.WOOL, DyeColor.PINK);
    public static final BasicChestBlock GRAY_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.GRAY_WOOL), ChestTypes.WOOL, DyeColor.GRAY);
    public static final BasicChestBlock LIGHT_GRAY_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_WOOL), ChestTypes.WOOL, DyeColor.LIGHT_GRAY);
    public static final BasicChestBlock CYAN_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.CYAN_WOOL), ChestTypes.WOOL, DyeColor.CYAN);
    public static final BasicChestBlock PURPLE_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.PURPLE_WOOL), ChestTypes.WOOL, DyeColor.PURPLE);
    public static final BasicChestBlock BLUE_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.BLUE_WOOL), ChestTypes.WOOL, DyeColor.BLUE);
    public static final BasicChestBlock BROWN_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.BROWN_WOOL), ChestTypes.WOOL, DyeColor.BROWN);
    public static final BasicChestBlock GREEN_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.GREEN_WOOL), ChestTypes.WOOL, DyeColor.GREEN);
    public static final BasicChestBlock RED_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.RED_WOOL), ChestTypes.WOOL, DyeColor.RED);
    public static final BasicChestBlock BLACK_WOOL_CHEST = new WoolChestBlock(FabricBlockSettings.copyOf(Blocks.BLACK_WOOL), ChestTypes.WOOL, DyeColor.BLACK);


    public static final BasicChestBlock COPPER_CHEST = new CopperChestBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.UNAFFECTED);
    public static final BasicChestBlock EXPOSED_COPPER_CHEST = new CopperChestBlock(FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.EXPOSED);
    public static final BasicChestBlock WEATHERED_COPPER_CHEST = new CopperChestBlock(FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.WEATHERED);
    public static final BasicChestBlock OXIDIZED_COPPER_CHEST = new CopperChestBlock(FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.OXIDIZED);

    public static final BasicChestBlock WAXED_COPPER_CHEST = new WaxedCopperChestBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.UNAFFECTED);
    public static final BasicChestBlock WAXED_EXPOSED_COPPER_CHEST = new WaxedCopperChestBlock(FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.EXPOSED);
    public static final BasicChestBlock WAXED_WEATHERED_COPPER_CHEST = new WaxedCopperChestBlock(FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.WEATHERED);
    public static final BasicChestBlock WAXED_OXIDIZED_COPPER_CHEST = new WaxedCopperChestBlock(FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.OXIDIZED);

    public static final BasicChestBlock IRON_CHEST = new SingleChestBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5.0F, 8.0F), ChestTypes.IRON);
    public static final BasicChestBlock GOLD_CHEST = new SingleChestBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).strength(6.0F, 8.0F), ChestTypes.GOLD);
    public static final BasicChestBlock DIAMOND_CHEST = new SingleChestBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).strength(8.0F, 8.0F), ChestTypes.DIAMOND);
    public static final BasicChestBlock NETHERITE_CHEST = new SingleChestBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK), ChestTypes.NETHERITE);

    public static void register(){
        registerBlock(ChestTypes.PLANK.getId().withPrefixedPath("acacia_"), ACACIA_PLANK_CHEST);
        registerBlock(ChestTypes.PLANK.getId().withPrefixedPath("birch_"), BIRCH_PLANK_CHEST);
        registerBlock(ChestTypes.PLANK.getId().withPrefixedPath("crimson_"), CRIMSON_PLANK_CHEST);
        registerBlock(ChestTypes.PLANK.getId().withPrefixedPath("dark_oak_"), DARK_OAK_PLANK_CHEST);
        registerBlock(ChestTypes.PLANK.getId().withPrefixedPath("jungle_"), JUNGLE_PLANK_CHEST);
        registerBlock(ChestTypes.PLANK.getId().withPrefixedPath("mangrove_"), MANGROVE_PLANK_CHEST);
        registerBlock(ChestTypes.PLANK.getId().withPrefixedPath("oak_"), OAK_PLANK_CHEST);
        registerBlock(ChestTypes.PLANK.getId().withPrefixedPath("spruce_"), SPRUCE_PLANK_CHEST);
        registerBlock(ChestTypes.PLANK.getId().withPrefixedPath("warped_"), WARPED_PLANK_CHEST);
        registerBlock(ChestTypes.PLANK.getId().withPrefixedPath("bamboo_"), BAMBOO_PLANK_CHEST);
        registerBlock(ChestTypes.PLANK.getId().withPrefixedPath("cherry_"), CHERRY_PLANK_CHEST);

        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("white_"), WHITE_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("orange_"), ORANGE_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("magenta_"), MAGENTA_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("light_blue_"), LIGHT_BLUE_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("yellow_"), YELLOW_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("lime_"), LIME_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("pink_"), PINK_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("gray_"), GRAY_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("light_gray_"), LIGHT_GRAY_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("cyan_"), CYAN_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("purple_"), PURPLE_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("blue_"), BLUE_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("brown_"), BROWN_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("green_"), GREEN_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("red_"), RED_WOOL_CHEST);
        registerBlock(ChestTypes.WOOL.getId().withPrefixedPath("black_"), BLACK_WOOL_CHEST);

        registerBlock(ChestTypes.COPPER.getId(), COPPER_CHEST);
        registerBlock(new Identifier(MoreChests.MOD_ID, "exposed_copper_chest"), EXPOSED_COPPER_CHEST);
        registerBlock(new Identifier(MoreChests.MOD_ID, "weathered_copper_chest"), WEATHERED_COPPER_CHEST);
        registerBlock(new Identifier(MoreChests.MOD_ID, "oxidized_copper_chest"), OXIDIZED_COPPER_CHEST);

        registerBlock(new Identifier(MoreChests.MOD_ID, "waxed_copper_chest"), WAXED_COPPER_CHEST);
        registerBlock(new Identifier(MoreChests.MOD_ID, "waxed_exposed_copper_chest"), WAXED_EXPOSED_COPPER_CHEST);
        registerBlock(new Identifier(MoreChests.MOD_ID, "waxed_weathered_copper_chest"), WAXED_WEATHERED_COPPER_CHEST);
        registerBlock(new Identifier(MoreChests.MOD_ID, "waxed_oxidized_copper_chest"), WAXED_OXIDIZED_COPPER_CHEST);

        registerBlock(ChestTypes.IRON.getId(), IRON_CHEST);
        registerBlock(ChestTypes.GOLD.getId(), GOLD_CHEST);
        registerBlock(ChestTypes.DIAMOND.getId(), DIAMOND_CHEST);
        registerBlock(ChestTypes.NETHERITE.getId(), NETHERITE_CHEST);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_CHEST, EXPOSED_COPPER_CHEST);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_CHEST, WEATHERED_COPPER_CHEST);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_CHEST, OXIDIZED_COPPER_CHEST);

        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_CHEST, WAXED_COPPER_CHEST);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_CHEST, WAXED_WEATHERED_COPPER_CHEST);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_CHEST, WAXED_EXPOSED_COPPER_CHEST);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_CHEST, WAXED_OXIDIZED_COPPER_CHEST);

    }



    public static void registerBlock(Identifier id, BasicChestBlock block){
        Registry.register(Registries.BLOCK, id, block);
        CHEST_BLOCKS.put(id, block);
        registerBlockItem(id, block);
    }



     public static void registerBlockItem(Identifier id, Block block){
         Item item = Registry.register(Registries.ITEM, id, new BlockItem(block, (id.equals(ChestTypes.NETHERITE.getId()) ? new Item.Settings().fireproof() :new Item.Settings() )));
         ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(item));
     }

}
