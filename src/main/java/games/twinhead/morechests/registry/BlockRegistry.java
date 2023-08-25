package games.twinhead.morechests.registry;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.block.BasicChestBlock;
import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.block.CopperChestBlock;
import games.twinhead.morechests.block.WaxedCopperChestBlock;
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
import net.minecraft.util.Identifier;

public class BlockRegistry {

    public static final BasicChestBlock ACACIA_PLANK_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS), ChestTypes.ACACIA_PLANK);
    public static final BasicChestBlock BIRCH_PLANK_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS), ChestTypes.BIRCH_PLANK);
    public static final BasicChestBlock CRIMSON_PLANK_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS), ChestTypes.CRIMSON_PLANK);
    public static final BasicChestBlock DARK_OAK_PLANK_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS), ChestTypes.DARK_OAK_PLANK);
    public static final BasicChestBlock JUNGLE_PLANK_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS), ChestTypes.JUNGLE_PLANK);
    public static final BasicChestBlock MANGROVE_PLANK_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.MANGROVE_PLANKS), ChestTypes.MANGROVE_PLANK);
    public static final BasicChestBlock OAK_PLANK_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS), ChestTypes.OAK_PLANK);
    public static final BasicChestBlock SPRUCE_PLANK_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS), ChestTypes.SPRUCE_PLANK);
    public static final BasicChestBlock WARPED_PLANK_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS), ChestTypes.WARPED_PLANK);

    public static final BasicChestBlock COPPER_CHEST = new CopperChestBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.UNAFFECTED);
    public static final BasicChestBlock EXPOSED_COPPER_CHEST = new CopperChestBlock(FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.EXPOSED);
    public static final BasicChestBlock WEATHERED_COPPER_CHEST = new CopperChestBlock(FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.WEATHERED);
    public static final BasicChestBlock OXIDIZED_COPPER_CHEST = new CopperChestBlock(FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.OXIDIZED);

    public static final BasicChestBlock WAXED_COPPER_CHEST = new WaxedCopperChestBlock(FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.UNAFFECTED);
    public static final BasicChestBlock WAXED_EXPOSED_COPPER_CHEST = new WaxedCopperChestBlock(FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.EXPOSED);
    public static final BasicChestBlock WAXED_WEATHERED_COPPER_CHEST = new WaxedCopperChestBlock(FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.WEATHERED);
    public static final BasicChestBlock WAXED_OXIDIZED_COPPER_CHEST = new WaxedCopperChestBlock(FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.OXIDIZED);

    public static final BasicChestBlock IRON_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(5.0F, 8.0F), ChestTypes.IRON);
    public static final BasicChestBlock GOLD_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).strength(6.0F, 8.0F), ChestTypes.GOLD);
    public static final BasicChestBlock DIAMOND_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK).strength(8.0F, 8.0F), ChestTypes.DIAMOND);
    public static final BasicChestBlock NETHERITE_CHEST = new BasicChestBlock(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK), ChestTypes.NETHERITE);

    public static void register(){
        registerBlock(ChestTypes.ACACIA_PLANK.getId(), ACACIA_PLANK_CHEST);
        registerBlock(ChestTypes.BIRCH_PLANK.getId(), BIRCH_PLANK_CHEST);
        registerBlock(ChestTypes.CRIMSON_PLANK.getId(), CRIMSON_PLANK_CHEST);
        registerBlock(ChestTypes.DARK_OAK_PLANK.getId(), DARK_OAK_PLANK_CHEST);
        registerBlock(ChestTypes.JUNGLE_PLANK.getId(), JUNGLE_PLANK_CHEST);
        registerBlock(ChestTypes.MANGROVE_PLANK.getId(), MANGROVE_PLANK_CHEST);
        registerBlock(ChestTypes.OAK_PLANK.getId(), OAK_PLANK_CHEST);
        registerBlock(ChestTypes.SPRUCE_PLANK.getId(), SPRUCE_PLANK_CHEST);
        registerBlock(ChestTypes.WARPED_PLANK.getId(), WARPED_PLANK_CHEST);



        registerBlock(ChestTypes.COPPER.getId(), COPPER_CHEST);
        registerBlock(new Identifier(MoreChests.MOD_ID, "weathered_copper_chest"), WEATHERED_COPPER_CHEST);
        registerBlock(new Identifier(MoreChests.MOD_ID, "exposed_copper_chest"), EXPOSED_COPPER_CHEST);
        registerBlock(new Identifier(MoreChests.MOD_ID, "oxidized_copper_chest"), OXIDIZED_COPPER_CHEST);

        registerBlock(new Identifier(MoreChests.MOD_ID, "waxed_copper_chest"), WAXED_COPPER_CHEST);
        registerBlock(new Identifier(MoreChests.MOD_ID, "waxed_weathered_copper_chest"), WAXED_WEATHERED_COPPER_CHEST);
        registerBlock(new Identifier(MoreChests.MOD_ID, "waxed_exposed_copper_chest"), WAXED_EXPOSED_COPPER_CHEST);
        registerBlock(new Identifier(MoreChests.MOD_ID, "waxed_oxidized_copper_chest"), WAXED_OXIDIZED_COPPER_CHEST);

        registerBlock(ChestTypes.IRON.getId(), IRON_CHEST);
        registerBlock(ChestTypes.GOLD.getId(), GOLD_CHEST);
        registerBlock(ChestTypes.DIAMOND.getId(), DIAMOND_CHEST);
        registerBlock(ChestTypes.NETHERITE.getId(), NETHERITE_CHEST);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_CHEST, EXPOSED_COPPER_CHEST);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_CHEST, WEATHERED_COPPER_CHEST);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_CHEST, OXIDIZED_COPPER_CHEST);

        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_CHEST, WAXED_COPPER_CHEST);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_CHEST, WAXED_WEATHERED_COPPER_CHEST);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_CHEST, WAXED_EXPOSED_COPPER_CHEST);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_CHEST, WAXED_OXIDIZED_COPPER_CHEST);

    }



    public static void registerBlock(Identifier id, Block block){
        Registry.register(Registries.BLOCK, id, block);
        registerBlockItem(id, block);
    }



     public static void registerBlockItem(Identifier id, Block block){
         Item item = Registry.register(Registries.ITEM, id, new BlockItem(block, (id.equals(ChestTypes.NETHERITE.getId()) ? new Item.Settings().fireproof() :new Item.Settings() )));
         ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(item));
     }

}
