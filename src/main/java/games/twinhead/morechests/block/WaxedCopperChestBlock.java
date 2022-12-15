package games.twinhead.morechests.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WaxedCopperChestBlock extends BasicChestBlock implements Oxidizable{

    private final Oxidizable.OxidationLevel oxidationLevel;

    public WaxedCopperChestBlock(Settings settings, ChestTypes type, Oxidizable.OxidationLevel oxidationLevel) {
        super(settings, type);
        this.oxidationLevel = oxidationLevel;
    }

    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }

    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock()) ) {

            if(newState.getBlock() instanceof WaxedCopperChestBlock || newState.getBlock() instanceof CopperChestBlock){

            } else {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                if (blockEntity instanceof Inventory) {
                    ItemScatterer.spawn(world, pos, (Inventory)blockEntity);
                    world.updateComparators(pos, this);
                }
                super.onStateReplaced(state, world, pos, newState, moved);
            }
        }
    }
}
