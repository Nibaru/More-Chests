package games.twinhead.morechests.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.enums.ChestType;
import net.minecraft.item.ItemPlacementContext;

public class SingleChestBlock extends CustomChestBlock {

    public SingleChestBlock(Settings settings, ChestTypes type) {
        super(settings, type);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(CHEST_TYPE, ChestType.SINGLE);
    }
}
