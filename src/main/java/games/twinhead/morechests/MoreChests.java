package games.twinhead.morechests;

import games.twinhead.morechests.event.ChestEvents;
import games.twinhead.morechests.registry.BlockEntityRegistry;
import games.twinhead.morechests.registry.BlockRegistry;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MoreChests implements ModInitializer {

    public static final String MOD_ID = "more_chests";

    public static ItemGroup MOD_GROUP  = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BlockRegistry.DIAMOND_CHEST))
            .displayName(Text.translatable("item_group.more_chests.more_chests_mod_group"))
            .entries((collector, entries) -> {
                    entries.add(BlockRegistry.ACACIA_PLANK_CHEST.asItem());
                    entries.add(BlockRegistry.BIRCH_PLANK_CHEST.asItem());
                    entries.add(BlockRegistry.CRIMSON_PLANK_CHEST.asItem());
                    entries.add(BlockRegistry.DARK_OAK_PLANK_CHEST.asItem());
                    entries.add(BlockRegistry.JUNGLE_PLANK_CHEST.asItem());
                    entries.add(BlockRegistry.MANGROVE_PLANK_CHEST.asItem());
                    entries.add(BlockRegistry.OAK_PLANK_CHEST.asItem());
                    entries.add(BlockRegistry.SPRUCE_PLANK_CHEST.asItem());
                    entries.add(BlockRegistry.WARPED_PLANK_CHEST.asItem());
                    entries.add(BlockRegistry.BAMBOO_PLANK_CHEST.asItem());
                    entries.add(BlockRegistry.CHERRY_PLANK_CHEST.asItem());

                    entries.add(BlockRegistry.WHITE_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.ORANGE_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.MAGENTA_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.LIGHT_BLUE_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.YELLOW_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.LIME_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.PINK_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.GRAY_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.LIGHT_GRAY_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.CYAN_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.PURPLE_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.BLUE_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.BROWN_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.GREEN_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.RED_WOOL_CHEST.asItem());
                    entries.add(BlockRegistry.BLACK_WOOL_CHEST.asItem());


                    entries.add(BlockRegistry.COPPER_CHEST.asItem());
                    entries.add(BlockRegistry.IRON_CHEST.asItem());
                    entries.add(BlockRegistry.GOLD_CHEST.asItem());
                    entries.add(BlockRegistry.DIAMOND_CHEST.asItem());
                    entries.add(BlockRegistry.NETHERITE_CHEST.asItem());
            }).build();

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }
    @Override
    public void onInitialize() {

        BlockRegistry.register();
        BlockEntityRegistry.registerBlockEntities();
        ScreenHandlerRegistry.registerAllScreenHandlers();
        new ChestEvents().register();

        Registry.register(Registries.ITEM_GROUP, id("group"), MOD_GROUP);
    }




}
