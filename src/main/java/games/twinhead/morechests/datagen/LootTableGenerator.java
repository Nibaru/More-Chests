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
    }
}
