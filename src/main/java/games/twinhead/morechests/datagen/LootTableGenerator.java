package games.twinhead.morechests.datagen;

import games.twinhead.morechests.registry.BlockRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class LootTableGenerator extends FabricBlockLootTableProvider {

    protected LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        BlockRegistry.CHEST_BLOCKS.forEach((id, block) ->  this.addDrop(block, this::nameableContainerDrops));

//        this.addDrop(BlockRegistry.ACACIA_PLANK_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.BIRCH_PLANK_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.CRIMSON_PLANK_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.DARK_OAK_PLANK_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.JUNGLE_PLANK_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.MANGROVE_PLANK_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.OAK_PLANK_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.SPRUCE_PLANK_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.WARPED_PLANK_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.BAMBOO_PLANK_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.CHERRY_PLANK_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.COPPER_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.EXPOSED_COPPER_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.WEATHERED_COPPER_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.OXIDIZED_COPPER_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.WAXED_COPPER_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.WAXED_EXPOSED_COPPER_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.WAXED_WEATHERED_COPPER_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.WAXED_OXIDIZED_COPPER_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.IRON_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.GOLD_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.DIAMOND_CHEST, this::nameableContainerDrops);
//        this.addDrop(BlockRegistry.NETHERITE_CHEST, this::nameableContainerDrops);
    }
}
