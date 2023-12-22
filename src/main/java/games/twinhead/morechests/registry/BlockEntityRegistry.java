package games.twinhead.morechests.registry;

import games.twinhead.morechests.block.CustomChestBlock;
import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.block.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class BlockEntityRegistry {

    public static BlockEntityType<BasicChestBlockEntity> PLANK_CHEST;
    public static BlockEntityType<WoolChestBlockEntity> WOOL_CHEST;
    public static BlockEntityType<CopperChestBlockEntity> COPPER_CHEST;
    public static BlockEntityType<IronChestBlockEntity> IRON_CHEST;
    public static BlockEntityType<GoldChestBlockEntity> GOLD_CHEST;
    public static BlockEntityType<DiamondChestBlockEntity> DIAMOND_CHEST;
    public static BlockEntityType<NetheriteChestBlockEntity> NETHERITE_CHEST;

    public static void registerBlockEntities() {


        PLANK_CHEST = registerBasic(ChestTypes.PLANK, BlockRegistry.ACACIA_PLANK_CHEST,
                BlockRegistry.BIRCH_PLANK_CHEST,
                BlockRegistry.CRIMSON_PLANK_CHEST,
                BlockRegistry.DARK_OAK_PLANK_CHEST,
                BlockRegistry.JUNGLE_PLANK_CHEST,
                BlockRegistry.OAK_PLANK_CHEST,
                BlockRegistry.SPRUCE_PLANK_CHEST,
                BlockRegistry.WARPED_PLANK_CHEST);

        WOOL_CHEST = registerWool(ChestTypes.WOOL, BlockRegistry.WHITE_WOOL_CHEST, BlockRegistry.ORANGE_WOOL_CHEST,
                BlockRegistry.MAGENTA_WOOL_CHEST, BlockRegistry.LIGHT_BLUE_WOOL_CHEST, BlockRegistry.YELLOW_WOOL_CHEST,
                BlockRegistry.LIME_WOOL_CHEST, BlockRegistry.PINK_WOOL_CHEST, BlockRegistry.GRAY_WOOL_CHEST,
                BlockRegistry.LIGHT_GRAY_WOOL_CHEST, BlockRegistry.CYAN_WOOL_CHEST, BlockRegistry.PURPLE_WOOL_CHEST,
                BlockRegistry.BLUE_WOOL_CHEST, BlockRegistry.BROWN_WOOL_CHEST, BlockRegistry.GREEN_WOOL_CHEST,
                BlockRegistry.RED_WOOL_CHEST, BlockRegistry.BLACK_WOOL_CHEST);

        COPPER_CHEST = registerCopper(ChestTypes.COPPER,  BlockRegistry.COPPER_CHEST,
                BlockRegistry.EXPOSED_COPPER_CHEST,
                BlockRegistry.OXIDIZED_COPPER_CHEST,
                BlockRegistry.WEATHERED_COPPER_CHEST,
                BlockRegistry.WAXED_COPPER_CHEST,
                BlockRegistry.WAXED_EXPOSED_COPPER_CHEST,
                BlockRegistry.WAXED_WEATHERED_COPPER_CHEST,
                BlockRegistry.WAXED_OXIDIZED_COPPER_CHEST
        );

        IRON_CHEST = Registry.register(Registry.BLOCK_ENTITY_TYPE, ChestTypes.IRON.getId(),
                FabricBlockEntityTypeBuilder.create((pos, state)-> new IronChestBlockEntity(pos, state, ChestTypes.IRON),
                        BlockRegistry.IRON_CHEST).build(null));
        GOLD_CHEST = Registry.register(Registry.BLOCK_ENTITY_TYPE, ChestTypes.GOLD.getId(),
                FabricBlockEntityTypeBuilder.create((pos, state)-> new GoldChestBlockEntity(pos, state, ChestTypes.GOLD),
                        BlockRegistry.GOLD_CHEST).build(null));
        DIAMOND_CHEST = Registry.register(Registry.BLOCK_ENTITY_TYPE, ChestTypes.DIAMOND.getId(),
                FabricBlockEntityTypeBuilder.create((pos, state)-> new DiamondChestBlockEntity(pos, state, ChestTypes.DIAMOND),
                        BlockRegistry.DIAMOND_CHEST).build(null));
        NETHERITE_CHEST = Registry.register(Registry.BLOCK_ENTITY_TYPE, ChestTypes.NETHERITE.getId(),
                FabricBlockEntityTypeBuilder.create((pos, state)-> new NetheriteChestBlockEntity(pos, state, ChestTypes.NETHERITE),
                        BlockRegistry.NETHERITE_CHEST).build(null));
    }


    private static BlockEntityType<BasicChestBlockEntity> registerBasic(ChestTypes type, CustomChestBlock... block){
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, type.getId(),
                FabricBlockEntityTypeBuilder.create((pos, state)-> new BasicChestBlockEntity(pos, state, type),
                        block).build(null));
    }

    private static BlockEntityType<WoolChestBlockEntity> registerWool(ChestTypes type, CustomChestBlock... block){
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, type.getId(),
                FabricBlockEntityTypeBuilder.create((pos, state)-> new WoolChestBlockEntity(pos, state, type),
                        block).build(null));
    }

    private static BlockEntityType<CopperChestBlockEntity> registerCopper(ChestTypes type, CustomChestBlock... block){
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, type.getId(),
                FabricBlockEntityTypeBuilder.create((pos, state)-> new CopperChestBlockEntity(pos, state, type),
                        block).build(null));
    }
}
