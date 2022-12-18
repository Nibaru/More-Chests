package games.twinhead.morechests.registry;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.block.BasicChestBlock;
import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.block.CopperChestBlock;
import games.twinhead.morechests.block.WaxedCopperChestBlock;
import net.minecraft.block.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreChests.MOD_ID);

    public static final RegistryObject<Block> ACACIA_PLANK_CHEST = BLOCKS.register("acacia_plank_chest", () -> new BasicChestBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS), ChestTypes.ACACIA_PLANK));
    public static final RegistryObject<Block> BIRCH_PLANK_CHEST = BLOCKS.register("birch_plank_chest", () -> new BasicChestBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS), ChestTypes.BIRCH_PLANK));
    public static final RegistryObject<Block> CRIMSON_PLANK_CHEST = BLOCKS.register("crimson_plank_chest", () -> new BasicChestBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS), ChestTypes.CRIMSON_PLANK));
    public static final RegistryObject<Block> DARK_OAK_PLANK_CHEST = BLOCKS.register("dark_oak_plank_chest", () -> new BasicChestBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS), ChestTypes.DARK_OAK_PLANK));
    public static final RegistryObject<Block> JUNGLE_PLANK_CHEST = BLOCKS.register("jungle_plank_chest", () -> new BasicChestBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS), ChestTypes.JUNGLE_PLANK));
    public static final RegistryObject<Block> OAK_PLANK_CHEST = BLOCKS.register("oak_plank_chest", () -> new BasicChestBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS), ChestTypes.OAK_PLANK));
    public static final RegistryObject<Block> SPRUCE_PLANK_CHEST = BLOCKS.register("spruce_plank_chest", () -> new BasicChestBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS), ChestTypes.SPRUCE_PLANK));
    public static final RegistryObject<Block> WARPED_PLANK_CHEST = BLOCKS.register("warped_plank_chest", () -> new BasicChestBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS), ChestTypes.WARPED_PLANK));

    public static final RegistryObject<Block> COPPER_CHEST = BLOCKS.register("copper_chest", () -> new CopperChestBlock(AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.UNAFFECTED));
    public static final RegistryObject<Block> EXPOSED_COPPER_CHEST = BLOCKS.register("exposed_copper_chest", () -> new CopperChestBlock(AbstractBlock.Settings.copy(Blocks.EXPOSED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.EXPOSED));
    public static final RegistryObject<Block> WEATHERED_COPPER_CHEST = BLOCKS.register("weathered_copper_chest", () -> new CopperChestBlock(AbstractBlock.Settings.copy(Blocks.WEATHERED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.WEATHERED));
    public static final RegistryObject<Block> OXIDIZED_COPPER_CHEST = BLOCKS.register("oxidized_copper_chest", () -> new CopperChestBlock(AbstractBlock.Settings.copy(Blocks.OXIDIZED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.OXIDIZED));

    public static final RegistryObject<Block> WAXED_COPPER_CHEST = BLOCKS.register("waxed_copper_chest", () -> new WaxedCopperChestBlock(AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.UNAFFECTED));
    public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_CHEST = BLOCKS.register("waxed_exposed_copper_chest", () -> new WaxedCopperChestBlock(AbstractBlock.Settings.copy(Blocks.EXPOSED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.EXPOSED));
    public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_CHEST = BLOCKS.register("waxed_weathered_copper_chest", () -> new WaxedCopperChestBlock(AbstractBlock.Settings.copy(Blocks.WEATHERED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.WEATHERED));
    public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_CHEST = BLOCKS.register("waxed_oxidized_copper_chest", () -> new WaxedCopperChestBlock(AbstractBlock.Settings.copy(Blocks.OXIDIZED_COPPER).strength(5.0F, 8.0F), ChestTypes.COPPER, Oxidizable.OxidationLevel.OXIDIZED));

    public static final RegistryObject<Block> IRON_CHEST = BLOCKS.register("iron_chest", () -> new BasicChestBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).strength(5.0F, 8.0F), ChestTypes.IRON));
    public static final RegistryObject<Block> GOLD_CHEST = BLOCKS.register("gold_chest", () -> new BasicChestBlock(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK).strength(6.0F, 8.0F), ChestTypes.GOLD));
    public static final RegistryObject<Block> DIAMOND_CHEST = BLOCKS.register("diamond_chest", () -> new BasicChestBlock(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK).strength(8.0F, 8.0F), ChestTypes.DIAMOND));
    public static final RegistryObject<Block> NETHERITE_CHEST = BLOCKS.register("netherite_chest", () -> new BasicChestBlock(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK), ChestTypes.NETHERITE));

    public static void register(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
