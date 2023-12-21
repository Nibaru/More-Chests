package games.twinhead.morechests.datagen;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.block.CustomChestBlock;
import games.twinhead.morechests.block.WoolChestBlock;
import games.twinhead.morechests.registry.BlockRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModelGenerator extends FabricModelProvider {

    public ModelGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockRegistry.CHEST_BLOCKS.forEach((id, chestBlock) -> {
            blockStateModelGenerator.registerBuiltin(id.withPrefixedPath("block/"), getParticleBlock(id, chestBlock));
            blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(chestBlock, id.withPrefixedPath("block/")));
        });
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        BlockRegistry.CHEST_BLOCKS.forEach((id, chestBlock) -> new Model(
                Optional.of(
                        MoreChests.id("block/chest_template")),
                Optional.empty(),
                TextureKey.LAYER0
        ).upload(
                id.withPrefixedPath("item/"),
                TextureMap.of(
                        TextureKey.LAYER0,
                        MoreChests.id("chest/"+ ((id.toString().contains("waxed_") ? id.getPath().substring(6, id.getPath().length()) : id.getPath())))),
                itemModelGenerator.writer));
    }

    private Block getParticleBlock(Identifier id, CustomChestBlock chestBlock){
        return switch (chestBlock.getType()) {
            case PLANK -> switch (id.getPath().substring(0, id.getPath().indexOf('_'))){
                case "acacia" -> Blocks.ACACIA_PLANKS;
                case "birch" -> Blocks.BIRCH_PLANKS;
                case "crimson" -> Blocks.CRIMSON_PLANKS;
                case "dark_oak" -> Blocks.DARK_OAK_PLANKS;
                case "jungle" -> Blocks.JUNGLE_PLANKS;
                case "mangrove" -> Blocks.MANGROVE_PLANKS;
                case "oak" -> Blocks.OAK_PLANKS;
                case "spruce" -> Blocks.SPRUCE_PLANKS;
                case "warped" -> Blocks.WARPED_PLANKS;
                default -> Blocks.OAK_PLANKS;
            };
            case WOOL -> {
                DyeColor color =( (WoolChestBlock) chestBlock).getColor();
                yield switch (color){
                    case WHITE -> Blocks.WHITE_WOOL;
                    case ORANGE -> Blocks.ORANGE_WOOL;
                    case MAGENTA -> Blocks.MAGENTA_WOOL;
                    case LIGHT_BLUE -> Blocks.LIGHT_BLUE_WOOL;
                    case YELLOW -> Blocks.YELLOW_WOOL;
                    case LIME -> Blocks.LIME_WOOL;
                    case PINK -> Blocks.PINK_WOOL;
                    case GRAY -> Blocks.GRAY_WOOL;
                    case LIGHT_GRAY -> Blocks.LIGHT_GRAY_WOOL;
                    case CYAN -> Blocks.CYAN_WOOL;
                    case PURPLE -> Blocks.PURPLE_WOOL;
                    case BLUE -> Blocks.BLUE_WOOL;
                    case BROWN -> Blocks.BROWN_WOOL;
                    case GREEN -> Blocks.GREEN_WOOL;
                    case RED -> Blocks.RED_WOOL;
                    case BLACK -> Blocks.BLACK_WOOL;
                };
            }

            case COPPER -> switch (id.getPath()) {
                case "copper_chest", "waxed_copper_chest" -> Blocks.COPPER_BLOCK;
                case "exposed_copper_chest", "waxed_exposed_copper_chest" -> Blocks.EXPOSED_COPPER;
                case "weathered_copper_chest", "waxed_weathered_copper_chest" -> Blocks.WEATHERED_COPPER;
                case "oxidized_copper_chest", "waxed_oxidized_copper_chest" -> Blocks.OXIDIZED_COPPER;
                default -> Blocks.COPPER_BLOCK;
            };

            case IRON -> Blocks.IRON_BLOCK;
            case GOLD -> Blocks.GOLD_BLOCK;
            case DIAMOND -> Blocks.DIAMOND_BLOCK;
            case NETHERITE -> Blocks.NETHERITE_BLOCK;
        };
    }


}
