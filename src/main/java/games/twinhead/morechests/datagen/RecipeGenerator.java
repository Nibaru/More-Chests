package games.twinhead.morechests.datagen;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.registry.BlockRegistry;
import games.twinhead.morechests.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;

public class RecipeGenerator extends FabricRecipeProvider {


    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        generateWoodenChestRecipes(Blocks.ACACIA_PLANKS, ItemTags.ACACIA_LOGS, BlockRegistry.ACACIA_PLANK_CHEST, "acacia", exporter);
        generateWoodenChestRecipes(Blocks.BIRCH_PLANKS, ItemTags.BIRCH_LOGS, BlockRegistry.BIRCH_PLANK_CHEST, "birch", exporter);
        generateWoodenChestRecipes(Blocks.CRIMSON_PLANKS, ItemTags.CRIMSON_STEMS, BlockRegistry.CRIMSON_PLANK_CHEST, "crimson", exporter);
        generateWoodenChestRecipes(Blocks.DARK_OAK_PLANKS, ItemTags.DARK_OAK_LOGS, BlockRegistry.DARK_OAK_PLANK_CHEST, "dark_oak", exporter);
        generateWoodenChestRecipes(Blocks.JUNGLE_PLANKS, ItemTags.JUNGLE_LOGS, BlockRegistry.JUNGLE_PLANK_CHEST, "jungle", exporter);
        generateWoodenChestRecipes(Blocks.MANGROVE_PLANKS, ItemTags.MANGROVE_LOGS, BlockRegistry.MANGROVE_PLANK_CHEST, "mangrove", exporter);
        generateWoodenChestRecipes(Blocks.OAK_PLANKS, ItemTags.OAK_LOGS, BlockRegistry.OAK_PLANK_CHEST, "oak", exporter);
        generateWoodenChestRecipes(Blocks.SPRUCE_PLANKS, ItemTags.SPRUCE_LOGS, BlockRegistry.SPRUCE_PLANK_CHEST, "spruce", exporter);
        generateWoodenChestRecipes(Blocks.WARPED_PLANKS, ItemTags.WARPED_STEMS, BlockRegistry.WARPED_PLANK_CHEST, "warped", exporter);
        generateWoodenChestRecipes(Blocks.BAMBOO_PLANKS, ItemTags.BAMBOO_BLOCKS, BlockRegistry.BAMBOO_PLANK_CHEST, "bamboo", exporter);
        generateWoodenChestRecipes(Blocks.CHERRY_PLANKS, ItemTags.CHERRY_LOGS, BlockRegistry.CHERRY_PLANK_CHEST, "cherry", exporter);

        generateWoolChestRecipes(Blocks.WHITE_WOOL, BlockRegistry.WHITE_WOOL_CHEST, "white", exporter);
        generateWoolChestRecipes(Blocks.ORANGE_WOOL, BlockRegistry.ORANGE_WOOL_CHEST, "orange", exporter);
        generateWoolChestRecipes(Blocks.MAGENTA_WOOL, BlockRegistry.MAGENTA_WOOL_CHEST, "magenta", exporter);
        generateWoolChestRecipes(Blocks.LIGHT_BLUE_WOOL, BlockRegistry.LIGHT_BLUE_WOOL_CHEST, "light_blue", exporter);
        generateWoolChestRecipes(Blocks.YELLOW_WOOL, BlockRegistry.YELLOW_WOOL_CHEST, "yellow", exporter);
        generateWoolChestRecipes(Blocks.LIME_WOOL, BlockRegistry.LIME_WOOL_CHEST, "lime", exporter);
        generateWoolChestRecipes(Blocks.PINK_WOOL, BlockRegistry.PINK_WOOL_CHEST, "pink", exporter);
        generateWoolChestRecipes(Blocks.GRAY_WOOL, BlockRegistry.GRAY_WOOL_CHEST, "gray", exporter);
        generateWoolChestRecipes(Blocks.LIGHT_GRAY_WOOL, BlockRegistry.LIGHT_GRAY_WOOL_CHEST, "light_gray", exporter);
        generateWoolChestRecipes(Blocks.CYAN_WOOL, BlockRegistry.CYAN_WOOL_CHEST, "cyan", exporter);
        generateWoolChestRecipes(Blocks.PURPLE_WOOL, BlockRegistry.PURPLE_WOOL_CHEST, "purple", exporter);
        generateWoolChestRecipes(Blocks.BLUE_WOOL, BlockRegistry.BLUE_WOOL_CHEST, "blue", exporter);
        generateWoolChestRecipes(Blocks.BROWN_WOOL, BlockRegistry.BROWN_WOOL_CHEST, "brown", exporter);
        generateWoolChestRecipes(Blocks.GREEN_WOOL, BlockRegistry.GREEN_WOOL_CHEST, "green", exporter);
        generateWoolChestRecipes(Blocks.RED_WOOL, BlockRegistry.RED_WOOL_CHEST, "red", exporter);
        generateWoolChestRecipes(Blocks.BLACK_WOOL, BlockRegistry.BLACK_WOOL_CHEST, "black", exporter);

        //TODO generate otehr recipes

        offerCustomDyeableRecipes(exporter,
                List.of(new Identifier("c", "black_dyes"),
                        new Identifier("c", "blue_dyes"),
                        new Identifier("c", "brown_dyes"),
                        new Identifier("c", "cyan_dyes"),
                        new Identifier("c", "gray_dyes"),
                        new Identifier("c", "green_dyes"),
                        new Identifier("c", "light_blue_dyes"),
                        new Identifier("c", "light_gray_dyes"),
                        new Identifier("c", "lime_dyes"),
                        new Identifier("c", "magenta_dyes"),
                        new Identifier("c", "orange_dyes"),
                        new Identifier("c", "pink_dyes"),
                        new Identifier("c", "purple_dyes"),
                        new Identifier("c", "red_dyes"),
                        new Identifier("c", "yellow_dyes"),
                        new Identifier("c", "white_dyes")),
                List.of(
                        BlockRegistry.BLACK_WOOL_CHEST.asItem(),
                        BlockRegistry.BLUE_WOOL_CHEST.asItem(),
                        BlockRegistry.BROWN_WOOL_CHEST.asItem(),
                        BlockRegistry.CYAN_WOOL_CHEST.asItem(),
                        BlockRegistry.GRAY_WOOL_CHEST.asItem(),
                        BlockRegistry.GREEN_WOOL_CHEST.asItem(),
                        BlockRegistry.LIGHT_BLUE_WOOL_CHEST.asItem(),
                        BlockRegistry.LIGHT_GRAY_WOOL_CHEST.asItem(),
                        BlockRegistry.LIME_WOOL_CHEST.asItem(),
                        BlockRegistry.MAGENTA_WOOL_CHEST.asItem(),
                        BlockRegistry.ORANGE_WOOL_CHEST.asItem(),
                        BlockRegistry.PINK_WOOL_CHEST.asItem(),
                        BlockRegistry.PURPLE_WOOL_CHEST.asItem(),
                        BlockRegistry.RED_WOOL_CHEST.asItem(),
                        BlockRegistry.YELLOW_WOOL_CHEST.asItem(),
                        BlockRegistry.WHITE_WOOL_CHEST.asItem()),
                "wool_chests");

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockRegistry.COPPER_CHEST, 1).group("copper_chests").criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).criterion(hasItem(BlockRegistry.COPPER_CHEST), conditionsFromItem(BlockRegistry.COPPER_CHEST)).criterion("has_wooden_chest", conditionsFromTag(ModTags.WOODEN_CHESTS)).input('#', Items.COPPER_INGOT).input('C', ModTags.WOODEN_CHESTS).pattern("###").pattern("#C#").pattern("###").offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockRegistry.IRON_CHEST, 1).group("iron_chests").criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT)).criterion(hasItem(BlockRegistry.IRON_CHEST), conditionsFromItem(BlockRegistry.IRON_CHEST)).criterion("has_wooden_chest", conditionsFromTag(ModTags.WOODEN_CHESTS)).input('#', Items.IRON_INGOT).input('C', ModTags.WOODEN_CHESTS).pattern("###").pattern("#C#").pattern("###").offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockRegistry.GOLD_CHEST, 1).group("gold_chests").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).criterion(hasItem(BlockRegistry.GOLD_CHEST), conditionsFromItem(BlockRegistry.GOLD_CHEST)).criterion("has_upgrade_chest", conditionsFromTag(ModTags.GOLD_UPGRADE_CHESTS)).input('#', Items.GOLD_INGOT).input('C', ModTags.GOLD_UPGRADE_CHESTS).pattern("###").pattern("#C#").pattern("###").offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockRegistry.DIAMOND_CHEST, 1).group("diamond_chests").criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).criterion(hasItem(BlockRegistry.DIAMOND_CHEST), conditionsFromItem(BlockRegistry.DIAMOND_CHEST)).criterion(hasItem(BlockRegistry.GOLD_CHEST), conditionsFromItem(BlockRegistry.GOLD_CHEST)).input('#', Items.DIAMOND).input('C', BlockRegistry.GOLD_CHEST).pattern("###").pattern("#C#").pattern("###").offerTo(exporter);



        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.CHEST, 1).group("wooden_chests").criterion(hasItem(Items.CHEST), conditionsFromItem(Items.CHEST)).input('#', ItemTags.PLANKS).pattern("###").pattern("# #").pattern("###").offerTo(exporter);


    }

    public void generateWoodenChestRecipes(ItemConvertible plank, TagKey<Item> log, ItemConvertible chest, String name, RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, chest, 1).group("wooden_chests").criterion(hasItem(plank), conditionsFromItem(plank)).criterion(hasItem(chest), conditionsFromItem(chest)).input('#', plank).pattern("###").pattern("# #").pattern("###").offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, chest, 4).group("wooden_chests").criterion("has_log", conditionsFromTag(log)).criterion(hasItem(chest), conditionsFromItem(chest)).input('#', log).pattern("###").pattern("# #").pattern("###").offerTo(exporter, new Identifier(MoreChests.MOD_ID, name + "_plank_chest_log"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, chest, 1).input(ModTags.WOODEN_CHESTS).input(plank).group("wooden_chests").criterion(hasItem(chest), conditionsFromItem(chest)).offerTo(exporter, new Identifier(MoreChests.MOD_ID, name + "_plank_chest_planks"));
    }

    public void generateWoolChestRecipes(ItemConvertible wool,  ItemConvertible craftedChest, String name, RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, craftedChest, 1).group("wool_chests").criterion(hasItem(wool), conditionsFromItem(wool)).criterion(hasItem(craftedChest), conditionsFromItem(craftedChest)).input('#', wool).pattern("###").pattern("# #").pattern("###").offerTo(exporter);
        //ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, craftedChest, 1).input(MoreChests.WOOL_CHESTS).input(TagKey.of(RegistryKeys.ITEM, new Identifier("c:" + name +"_dyes"))).group("wool_chests").criterion(hasItem(craftedChest), conditionsFromItem(craftedChest)).offerTo(exporter, new Identifier(MoreChests.MOD_ID, name + "_from_dye"));
    }

    public void offerCustomDyeableRecipes(RecipeExporter exporter, List<Identifier> dyeTags, List<Item> dyeables, String group) {
        for (int i = 0; i < dyeTags.size(); ++i) {
            Identifier item = dyeTags.get(i);
            Item item2 = dyeables.get(i);
            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, item2).input(TagKey.of(RegistryKeys.ITEM,item)).input(Ingredient.ofStacks(dyeables.stream().filter(dyeable -> !dyeable.equals(item2)).map(ItemStack::new))).group(group).criterion("has_needed_dye", (AdvancementCriterion)RecipeProvider.conditionsFromTag(TagKey.of(RegistryKeys.ITEM,item))).offerTo(exporter, "dye_" + RecipeProvider.getItemPath(item2));
        }
    }
}
