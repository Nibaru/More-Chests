package games.twinhead.morechests.datagen;

import games.twinhead.morechests.registry.BlockRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.data.server.BlockLootTableGenerator;

public class LootTableGenerator extends FabricBlockLootTableProvider {

    protected LootTableGenerator(FabricDataGenerator dataOutput) {
        super(dataOutput);
    }

    @Override
    protected void generateBlockLootTables() {
        BlockRegistry.CHEST_BLOCKS.forEach((id, block) ->  this.addDrop(block, BlockLootTableGenerator::nameableContainerDrops));

    }

}
