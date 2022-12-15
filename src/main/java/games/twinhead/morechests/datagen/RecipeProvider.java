package games.twinhead.morechests.datagen;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.registry.BlockRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class RecipeProvider extends FabricRecipeProvider {


    public RecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        generateWoodenChestRecipes(Blocks.ACACIA_PLANKS, ItemTags.ACACIA_LOGS, BlockRegistry.ACACIA_PLANK_CHEST, "acacia", exporter);
        generateWoodenChestRecipes(Blocks.BIRCH_PLANKS, ItemTags.BIRCH_LOGS, BlockRegistry.BIRCH_PLANK_CHEST, "birch", exporter);
        generateWoodenChestRecipes(Blocks.CRIMSON_PLANKS, ItemTags.CRIMSON_STEMS, BlockRegistry.CRIMSON_PLANK_CHEST, "crimson", exporter);
        generateWoodenChestRecipes(Blocks.DARK_OAK_PLANKS, ItemTags.DARK_OAK_LOGS, BlockRegistry.DARK_OAK_PLANK_CHEST, "dark_oak", exporter);
        generateWoodenChestRecipes(Blocks.JUNGLE_PLANKS, ItemTags.JUNGLE_LOGS, BlockRegistry.JUNGLE_PLANK_CHEST, "jungle", exporter);
        generateWoodenChestRecipes(Blocks.MANGROVE_PLANKS, ItemTags.MANGROVE_LOGS, BlockRegistry.MANGROVE_PLANK_CHEST, "mangrove", exporter);
        generateWoodenChestRecipes(Blocks.OAK_PLANKS, ItemTags.OAK_LOGS, BlockRegistry.OAK_PLANK_CHEST, "oak", exporter);
        generateWoodenChestRecipes(Blocks.SPRUCE_PLANKS, ItemTags.SPRUCE_LOGS, BlockRegistry.SPRUCE_PLANK_CHEST, "spruce", exporter);
        generateWoodenChestRecipes(Blocks.WARPED_PLANKS, ItemTags.WARPED_STEMS, BlockRegistry.WARPED_PLANK_CHEST, "warped", exporter);

        //TODO generate otehr recipes

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockRegistry.COPPER_CHEST, 1).group("metal_chests").criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT)).criterion(hasItem(BlockRegistry.COPPER_CHEST), conditionsFromItem(BlockRegistry.COPPER_CHEST)).criterion("has_wooden_chest", conditionsFromTag(MoreChests.WOODEN_CHESTS)).input('#', Items.COPPER_INGOT).input('C', MoreChests.WOODEN_CHESTS).pattern("###").pattern("#C#").pattern("###").offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockRegistry.IRON_CHEST, 1).group("metal_chests").criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT)).criterion(hasItem(BlockRegistry.IRON_CHEST), conditionsFromItem(BlockRegistry.IRON_CHEST)).criterion("has_wooden_chest", conditionsFromTag(MoreChests.WOODEN_CHESTS)).input('#', Items.IRON_INGOT).input('C', MoreChests.WOODEN_CHESTS).pattern("###").pattern("#C#").pattern("###").offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockRegistry.GOLD_CHEST, 1).group("metal_chests").criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT)).criterion(hasItem(BlockRegistry.GOLD_CHEST), conditionsFromItem(BlockRegistry.GOLD_CHEST)).criterion("has_upgrade_chest", conditionsFromTag(MoreChests.GOLD_UPGRADE_CHESTS)).input('#', Items.GOLD_INGOT).input('C', MoreChests.GOLD_UPGRADE_CHESTS).pattern("###").pattern("#C#").pattern("###").offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, BlockRegistry.DIAMOND_CHEST, 1).group("metal_chests").criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).criterion(hasItem(BlockRegistry.DIAMOND_CHEST), conditionsFromItem(BlockRegistry.DIAMOND_CHEST)).criterion(hasItem(BlockRegistry.GOLD_CHEST), conditionsFromItem(BlockRegistry.GOLD_CHEST)).input('#', Items.DIAMOND).input('C', BlockRegistry.GOLD_CHEST).pattern("###").pattern("#C#").pattern("###").offerTo(exporter);
        SmithingRecipeJsonBuilder.create(Ingredient.ofItems(BlockRegistry.DIAMOND_CHEST), Ingredient.ofItems(Items.NETHERITE_INGOT), RecipeCategory.DECORATIONS, BlockRegistry.NETHERITE_CHEST.asItem()).criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT)).criterion(hasItem(BlockRegistry.DIAMOND_CHEST), conditionsFromItem(BlockRegistry.DIAMOND_CHEST)).offerTo(exporter,"netherite_chest");
    }

    public void generateWoodenChestRecipes(ItemConvertible plank, TagKey<Item> log, ItemConvertible chest, String name, Consumer<RecipeJsonProvider> exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, chest, 1).group("wooden_chests").criterion(hasItem(plank), conditionsFromItem(plank)).criterion(hasItem(chest), conditionsFromItem(chest)).input('#', plank).pattern("###").pattern("# #").pattern("###").offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, chest, 4).group("wooden_chests").criterion("has_log", conditionsFromTag(log)).criterion(hasItem(chest), conditionsFromItem(chest)).input('#', log).pattern("###").pattern("# #").pattern("###").offerTo(exporter, new Identifier(MoreChests.MOD_ID, name + "_plank_chest_log"));
    }
}
