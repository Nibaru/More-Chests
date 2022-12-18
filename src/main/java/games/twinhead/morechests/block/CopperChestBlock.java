package games.twinhead.morechests.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class CopperChestBlock extends BasicChestBlock implements Oxidizable {

    private final Oxidizable.OxidationLevel oxidationLevel;

    public CopperChestBlock(Settings settings, ChestTypes type, Oxidizable.OxidationLevel oxidationLevel) {
        super(settings, type);
        this.oxidationLevel = oxidationLevel;
    }

    @SuppressWarnings("deprecation")
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
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
