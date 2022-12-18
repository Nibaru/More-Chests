package games.twinhead.morechests.registry;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.block.entity.BasicChestBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistry {

    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MoreChests.MOD_ID);


    public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> ACACIA_PLANK_CHEST =
            BLOCK_ENTITIES.register("acacia_plank_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.ACACIA_PLANK), BlockRegistry.ACACIA_PLANK_CHEST.get()).build(null));
    public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> BIRCH_PLANK_CHEST =
            BLOCK_ENTITIES.register("birch_plank_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.BIRCH_PLANK), BlockRegistry.BIRCH_PLANK_CHEST.get()).build(null));
    public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> CRIMSON_PLANK_CHEST =
            BLOCK_ENTITIES.register("crimson_plank_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.CRIMSON_PLANK), BlockRegistry.CRIMSON_PLANK_CHEST.get()).build(null));
    public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> DARK_OAK_PLANK_CHEST =
            BLOCK_ENTITIES.register("dark_oak_plank_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.DARK_OAK_PLANK), BlockRegistry.DARK_OAK_PLANK_CHEST.get()).build(null));
    public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> JUNGLE_PLANK_CHEST =
            BLOCK_ENTITIES.register("jungle_plank_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.JUNGLE_PLANK), BlockRegistry.JUNGLE_PLANK_CHEST.get()).build(null));
   public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> OAK_PLANK_CHEST =
            BLOCK_ENTITIES.register("oak_plank_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.OAK_PLANK), BlockRegistry.OAK_PLANK_CHEST.get()).build(null));
    public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> SPRUCE_PLANK_CHEST =
            BLOCK_ENTITIES.register("spruce_plank_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.SPRUCE_PLANK), BlockRegistry.SPRUCE_PLANK_CHEST.get()).build(null));
    public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> WARPED_PLANK_CHEST =
            BLOCK_ENTITIES.register("warped_plank_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.WARPED_PLANK), BlockRegistry.WARPED_PLANK_CHEST.get()).build(null));



    public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> COPPER_CHEST =
            BLOCK_ENTITIES.register("copper_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.COPPER), BlockRegistry.COPPER_CHEST.get(), BlockRegistry.EXPOSED_COPPER_CHEST.get(), BlockRegistry.WEATHERED_COPPER_CHEST.get(), BlockRegistry.OXIDIZED_COPPER_CHEST.get()).build(null));
    public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> IRON_CHEST =
            BLOCK_ENTITIES.register("iron_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.IRON), BlockRegistry.IRON_CHEST.get()).build(null));
    public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> GOLD_CHEST =
            BLOCK_ENTITIES.register("gold_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.GOLD), BlockRegistry.GOLD_CHEST.get()).build(null));
    public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> DIAMOND_CHEST =
            BLOCK_ENTITIES.register("diamond_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.DIAMOND), BlockRegistry.DIAMOND_CHEST.get()).build(null));

    public static RegistryObject<BlockEntityType<BasicChestBlockEntity>> NETHERITE_CHEST =
            BLOCK_ENTITIES.register("netherite_chest", () ->  BlockEntityType.Builder.create((pos, state)-> new BasicChestBlockEntity(pos, state, ChestTypes.NETHERITE), BlockRegistry.NETHERITE_CHEST.get()).build(null));

    public static void registerBlockEntities() {
        BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
