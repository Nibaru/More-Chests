package games.twinhead.morechests;


import games.twinhead.morechests.block.BasicChestBlock;
import games.twinhead.morechests.registry.BlockRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static games.twinhead.morechests.MoreChests.*;

@Mod.EventBusSubscriber(modid = MoreChests.MOD_ID)
public class UpgradeChestsEvent {

    @SubscribeEvent
    public void clickChestEvent(PlayerInteractEvent event) {
        if(!event.getEntity().isSneaking()) event.setCancellationResult(ActionResult.PASS);
        if(!event.getLevel().getBlockState(event.getPos()).isIn(CHESTS)) event.setCancellationResult(ActionResult.PASS);

        PlayerEntity player = event.getEntity();
        BlockPos hitPos = event.getPos();
        BlockState hitState = event.getLevel().getBlockState(hitPos);
        ItemStack mainHand = event.getEntity().getInventory().getMainHandStack();
        BlockEntity blockEntity = event.getLevel().getBlockEntity(hitPos);
        World world = event.getLevel();

        if (blockEntity == null) event.setCancellationResult(ActionResult.PASS);
        if(!(blockEntity instanceof ChestBlockEntity)){
            event.setCancellationResult(ActionResult.PASS);
        } else {
            ChestBlockEntity chest = (ChestBlockEntity) blockEntity;

            if (ChestBlockEntity.getPlayersLookingInChestCount(world, hitPos) > 0) { event.setCancellationResult(ActionResult.PASS); }

            if(hitState.isIn(COPPER_CHESTS)){
                if(mainHand.getItem() instanceof BlockItem blockItem){
                    if(blockItem.getBlock() instanceof Oxidizable oxidizable) {
                        switch (oxidizable.getDegradationLevel()) {
                            case UNAFFECTED -> upgradeChest((BasicChestBlock) BlockRegistry.COPPER_CHEST.get(), chest, world, hitPos, player, 0);
                            case EXPOSED -> upgradeChest((BasicChestBlock) BlockRegistry.EXPOSED_COPPER_CHEST.get(), chest, world, hitPos, player, 0);
                            case WEATHERED -> upgradeChest((BasicChestBlock) BlockRegistry.WEATHERED_COPPER_CHEST.get(), chest, world, hitPos, player, 0);
                            case OXIDIZED -> upgradeChest((BasicChestBlock) BlockRegistry.OXIDIZED_COPPER_CHEST.get(), chest, world, hitPos, player, 0);
                        }
                        event.setCanceled(true);
                        event.setCancellationResult(ActionResult.SUCCESS);
                    }
                }
            }

            if(hitState.isIn(WOODEN_CHESTS_BLOCK)){
                if(mainHand.isIn(IRON_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 8){
                    upgradeChest((BasicChestBlock) BlockRegistry.IRON_CHEST.get(), chest, world, hitPos, player, 8);
                }
                if(mainHand.isIn(COPPER_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 8){
                    upgradeChest((BasicChestBlock) BlockRegistry.COPPER_CHEST.get(), chest, world, hitPos, player, 8);
                }
            } else if(hitState.isIn(GOLD_UPGRADE_CHESTS_BLOCK)){
                if(mainHand.isIn(GOLD_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 8){
                    upgradeChest((BasicChestBlock) BlockRegistry.GOLD_CHEST.get(), chest, world, hitPos, player, 8);
                }
            } else if(hitState.isOf(BlockRegistry.GOLD_CHEST.get()) && mainHand.getCount() >= 8){
                if(mainHand.isIn(DIAMOND_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 8){
                    upgradeChest((BasicChestBlock) BlockRegistry.DIAMOND_CHEST.get(), chest, world, hitPos, player, 8);
                }
            }else if(hitState.isOf(BlockRegistry.DIAMOND_CHEST.get()) && mainHand.getCount() >= 1){
                if(mainHand.isIn(NETHERITE_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 1){
                    upgradeChest((BasicChestBlock) BlockRegistry.NETHERITE_CHEST.get(), chest, world, hitPos, player, 1);
                }
            }
        }
    }


    public void upgradeChest(BasicChestBlock newChest, ChestBlockEntity chest, World world, BlockPos pos, PlayerEntity player, int itemsToRemove){
        Text customName = chest.getCustomName();
        Direction chestFacing = world.getBlockState(pos).get(ChestBlock.FACING);

        world.removeBlockEntity(pos);
        world.removeBlock(pos, false);

        BlockState blockState = newChest.getDefaultState().with(ChestBlock.FACING, chestFacing).with(ChestBlock.WATERLOGGED, false);
        NbtCompound oldChestTag = chest.createNbt();

        world.setBlockState(pos, blockState, 3);
        world.updateListeners(pos, blockState, blockState, 3);
        world.getBlockEntity(pos).readNbt(oldChestTag);

        if (customName != null) {
            ((ChestBlockEntity) world.getBlockEntity(pos)).setCustomName(customName);
        }

        player.getInventory().getMainHandStack().decrement(itemsToRemove);
    }
}
