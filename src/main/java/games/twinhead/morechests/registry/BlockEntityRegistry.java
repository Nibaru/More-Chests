package games.twinhead.morechests.registry;

import games.twinhead.morechests.block.BasicChestBlock;
import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.block.entity.BasicChestBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BlockEntityRegistry {

    public static BlockEntityType<BasicChestBlockEntity> ACACIA_PLANK_CHEST;
    public static BlockEntityType<BasicChestBlockEntity> BIRCH_PLANK_CHEST;
    public static BlockEntityType<BasicChestBlockEntity> CRIMSON_PLANK_CHEST;
    public static BlockEntityType<BasicChestBlockEntity> DARK_OAK_PLANK_CHEST;
    public static BlockEntityType<BasicChestBlockEntity> JUNGLE_PLANK_CHEST;
    public static BlockEntityType<BasicChestBlockEntity> MANGROVE_PLANK_CHEST;
    public static BlockEntityType<BasicChestBlockEntity> OAK_PLANK_CHEST;
    public static BlockEntityType<BasicChestBlockEntity> SPRUCE_PLANK_CHEST;
    public static BlockEntityType<BasicChestBlockEntity> WARPED_PLANK_CHEST;


    public static BlockEntityType<BasicChestBlockEntity> COPPER_CHEST;
    public static BlockEntityType<BasicChestBlockEntity> IRON_CHEST;
    public static BlockEntityType<BasicChestBlockEntity> GOLD_CHEST;
    public static BlockEntityType<BasicChestBlockEntity> DIAMOND_CHEST;
    public static BlockEntityType<BasicChestBlockEntity> NETHERITE_CHEST;

    public static void registerBlockEntities() {


        ACACIA_PLANK_CHEST = register(ChestTypes.ACACIA_PLANK, BlockRegistry.ACACIA_PLANK_CHEST);
        BIRCH_PLANK_CHEST = register(ChestTypes.BIRCH_PLANK, BlockRegistry.BIRCH_PLANK_CHEST);
        CRIMSON_PLANK_CHEST = register(ChestTypes.CRIMSON_PLANK, BlockRegistry.CRIMSON_PLANK_CHEST);
        DARK_OAK_PLANK_CHEST = register(ChestTypes.DARK_OAK_PLANK, BlockRegistry.DARK_OAK_PLANK_CHEST);
        JUNGLE_PLANK_CHEST = register(ChestTypes.JUNGLE_PLANK, BlockRegistry.JUNGLE_PLANK_CHEST);
        MANGROVE_PLANK_CHEST = register(ChestTypes.MANGROVE_PLANK, BlockRegistry.MANGROVE_PLANK_CHEST);
        OAK_PLANK_CHEST = register(ChestTypes.OAK_PLANK, BlockRegistry.OAK_PLANK_CHEST);
        SPRUCE_PLANK_CHEST = register(ChestTypes.SPRUCE_PLANK, BlockRegistry.SPRUCE_PLANK_CHEST);
        WARPED_PLANK_CHEST = register(ChestTypes.WARPED_PLANK, BlockRegistry.WARPED_PLANK_CHEST);

        COPPER_CHEST = register(ChestTypes.COPPER,  BlockRegistry.COPPER_CHEST,
                BlockRegistry.EXPOSED_COPPER_CHEST,
                BlockRegistry.OXIDIZED_COPPER_CHEST,
                BlockRegistry.WEATHERED_COPPER_CHEST,
                BlockRegistry.WAXED_COPPER_CHEST,
                BlockRegistry.WAXED_EXPOSED_COPPER_CHEST,
                BlockRegistry.WAXED_WEATHERED_COPPER_CHEST,
                BlockRegistry.WAXED_OXIDIZED_COPPER_CHEST
        );

        IRON_CHEST = register(ChestTypes.IRON,  BlockRegistry.IRON_CHEST);
        GOLD_CHEST = register(ChestTypes.GOLD,  BlockRegistry.GOLD_CHEST);
        DIAMOND_CHEST = register(ChestTypes.DIAMOND,  BlockRegistry.DIAMOND_CHEST);
        NETHERITE_CHEST = register(ChestTypes.NETHERITE,  BlockRegistry.NETHERITE_CHEST);
    }


    private static BlockEntityType<BasicChestBlockEntity> register(ChestTypes type, BasicChestBlock... block){
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, type.getId(),
                FabricBlockEntityTypeBuilder.create((pos, state)-> new BasicChestBlockEntity(pos, state, type),
                        block).build(null));
    }
}
