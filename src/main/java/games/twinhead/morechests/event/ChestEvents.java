package games.twinhead.morechests.event;

import com.google.common.collect.BiMap;
import games.twinhead.morechests.block.CustomChestBlock;
import games.twinhead.morechests.block.CopperChestBlock;
import games.twinhead.morechests.block.WaxedCopperChestBlock;
import games.twinhead.morechests.registry.BlockRegistry;
import games.twinhead.morechests.tag.ModTags;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.HoneycombItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ChestEvents {

    public ChestEvents() {}
    public void register(){
        UseBlockCallback.EVENT.register(this::upgradeChestEvent);
        UseBlockCallback.EVENT.register((player, world, hand, hitResult)-> {
            if(!player.isSneaking()) return ActionResult.PASS;
            if(!(world.getBlockState(hitResult.getBlockPos()).getBlock() instanceof CopperChestBlock) && !(world.getBlockState(hitResult.getBlockPos()).getBlock() instanceof WaxedCopperChestBlock)) return ActionResult.PASS;

            if (player.getStackInHand(hand).isOf(Items.HONEYCOMB)){
                return waxChest(player, world, hand, hitResult, world.getBlockState(hitResult.getBlockPos()).get(ChestBlock.CHEST_TYPE));
            }

            if (player.getStackInHand(hand).isIn(ItemTags.AXES)){
                return scrapeChest(player, world, hand, hitResult, world.getBlockState(hitResult.getBlockPos()).get(ChestBlock.CHEST_TYPE));
            }

            return ActionResult.PASS;
        });
    }

    private ActionResult waxChest(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult, ChestType chestType){
        BlockState state = world.getBlockState(hitResult.getBlockPos());
        BlockPos pos = hitResult.getBlockPos();

        Optional<BlockState> optional = HoneycombItem.getWaxedState(state);

        optional.ifPresent(blockState -> {
            addWax(player, world, blockState, pos, hand, chestType);
            if (!player.isCreative())
                player.getStackInHand(hand).decrement(1);
            if (!state.get(ChestBlock.CHEST_TYPE).equals(ChestType.SINGLE))
                HoneycombItem.getWaxedState(world.getBlockState(getNeighborChestPos(pos, state, chestType)))
                        .ifPresent(blockState2 -> addWax(player, world, blockState2, getNeighborChestPos(pos, state, chestType), hand, chestType.getOpposite()));
        });

        if (optional.isEmpty()) {
            return ActionResult.PASS;
        } else {
            return ActionResult.success(world.isClient);
        }
    }

    private ActionResult scrapeChest(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult, ChestType chestType){
        BlockState state = world.getBlockState(hitResult.getBlockPos());
        BlockPos pos = hitResult.getBlockPos();

        Optional<BlockState> optional = tryStrip(world, pos, player, state);

        optional.ifPresent(blockState -> {
            updateBlock(player, world, blockState, pos, hand, chestType);
            if (!state.get(ChestBlock.CHEST_TYPE).equals(ChestType.SINGLE))
                tryStrip(world, getNeighborChestPos(pos, state, chestType), player, world.getBlockState(getNeighborChestPos(pos, state, chestType)))
                    .ifPresent(blockState2 -> updateBlock(player, world, blockState2, getNeighborChestPos(pos, state, chestType), hand, chestType.getOpposite()));
        });

        if (optional.isEmpty()) {
            return ActionResult.PASS;
        } else {
            return ActionResult.success(world.isClient);
        }
    }

    private void updateBlock(PlayerEntity player, World world, BlockState state, BlockPos pos, Hand hand, ChestType chestType){
        if (player instanceof ServerPlayerEntity) Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)player, pos, player.getStackInHand(hand));
        world.setBlockState(pos, state.with(ChestBlock.CHEST_TYPE, chestType), Block.NOTIFY_ALL_AND_REDRAW);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, state));
        if (!player.isCreative())
            player.getStackInHand(hand).damage(1, player, (p) -> p.sendToolBreakStatus(hand));
    }

    public BlockPos getNeighborChestPos(BlockPos pos, BlockState state, ChestType chestType){
        return switch (chestType) {
            case LEFT -> pos.offset(state.get(ChestBlock.FACING).rotateYClockwise(), 1);
            case RIGHT -> pos.offset(state.get(ChestBlock.FACING).rotateYCounterclockwise(), 1);
            default -> pos;
        };
    }

    public ActionResult upgradeChestEvent(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult){
        if(!player.isSneaking()) return ActionResult.PASS;
        if(!world.getBlockState(hitResult.getBlockPos()).isIn(ModTags.UPGRADEABLE_CHESTS)) return ActionResult.PASS;

        BlockPos hitPos = hitResult.getBlockPos();
        BlockState hitState = world.getBlockState(hitPos);
        ItemStack mainHand = player.getInventory().getMainHandStack();
        BlockEntity blockEntity = world.getBlockEntity(hitPos);

        if (blockEntity == null) return ActionResult.PASS;

        ChestBlockEntity chest = (ChestBlockEntity) blockEntity;

        if (ChestBlockEntity.getPlayersLookingInChestCount(world, hitPos) > 0) { return ActionResult.PASS; }



        if(hitState.isIn(ModTags.WOODEN_CHESTS_BLOCK) || hitState.isIn(ModTags.WOOL_CHESTS_BLOCK)){
            if(mainHand.isIn(ModTags.IRON_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 8){
                upgradeChest(BlockRegistry.IRON_CHEST, chest, world, hitPos, player, 8);
                return ActionResult.SUCCESS;
            }
            if(mainHand.isIn(ModTags.COPPER_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 8){
                if (hitState.get(ChestBlock.CHEST_TYPE) != ChestType.SINGLE && mainHand.getCount() >= 16){
                    upgradeDoubleChest(BlockRegistry.COPPER_CHEST, player, hitState, world, hitPos, hitState.get(ChestBlock.CHEST_TYPE), 16);
                    return ActionResult.SUCCESS;
                } else {
                    upgradeChest(BlockRegistry.COPPER_CHEST, chest, world, hitPos, player, 8);
                    return ActionResult.SUCCESS;
                }
            }
        } else if(hitState.isIn(ModTags.GOLD_UPGRADE_CHESTS_BLOCK)){
            if(mainHand.isIn(ModTags.GOLD_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 8){
                upgradeChest(BlockRegistry.GOLD_CHEST, chest, world, hitPos, player, 8);
                return ActionResult.SUCCESS;
            }
        } else if(hitState.isOf(BlockRegistry.GOLD_CHEST) && mainHand.getCount() >= 8){
            if(mainHand.isIn(ModTags.DIAMOND_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 8){
                upgradeChest(BlockRegistry.DIAMOND_CHEST, chest, world, hitPos, player, 8);
                return ActionResult.SUCCESS;
            }
        }else if(hitState.isOf(BlockRegistry.DIAMOND_CHEST) && mainHand.getCount() >= 1){
            if(mainHand.isIn(ModTags.NETHERITE_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 1){
                upgradeChest(BlockRegistry.NETHERITE_CHEST, chest, world, hitPos, player, 1);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    public void upgradeDoubleChest(CustomChestBlock newChest, PlayerEntity player, BlockState state, World world, BlockPos pos, ChestType type, int itemsToRemove){
        ChestBlockEntity chest = (ChestBlockEntity) world.getBlockEntity(pos);
        ChestBlockEntity chest2 = (ChestBlockEntity) world.getBlockEntity(getNeighborChestPos(pos, state, type));
        Text customName = chest.getCustomName();
        Direction chestFacing = world.getBlockState(pos).get(ChestBlock.FACING);

        world.removeBlockEntity(pos);
        world.removeBlock(pos, false);
        world.removeBlockEntity(getNeighborChestPos(pos, state, type));
        world.removeBlock(getNeighborChestPos(pos, state, type), false);

        BlockState blockState = newChest.getDefaultState().with(ChestBlock.FACING, chestFacing).with(ChestBlock.WATERLOGGED, world.getFluidState(pos).isOf(Fluids.WATER));

        NbtCompound oldChestTag = chest.createNbt();
        NbtCompound oldChest2Tag = chest2.createNbt();

        world.setBlockState(pos, blockState.with(ChestBlock.CHEST_TYPE, type));
        world.setBlockState(getNeighborChestPos(pos, state, type), blockState.with(ChestBlock.CHEST_TYPE, type.getOpposite()));
        world.updateListeners(pos, blockState, blockState, 3);

        world.getBlockEntity(pos).readNbt(oldChestTag);
        world.getBlockEntity(getNeighborChestPos(pos, state, type)).readNbt(oldChest2Tag);

        if (customName != null) {
            ((ChestBlockEntity) world.getBlockEntity(pos)).setCustomName(customName);
        }

        if (world.isClient){
            world.syncWorldEvent(player, WorldEvents.WAX_REMOVED, pos, 0);
            world.syncWorldEvent(player, WorldEvents.WAX_REMOVED, getNeighborChestPos(pos, state, type), 0);
            world.playSound(player, pos, SoundEvents.BLOCK_WOOL_PLACE, SoundCategory.BLOCKS, 2.0F, 0.4F);
        }
        if (!player.isCreative())
            player.getInventory().getMainHandStack().decrement(itemsToRemove);
    }


    public static void upgradeChest(CustomChestBlock newChest, ChestBlockEntity chest, World world, BlockPos pos, PlayerEntity player, int itemsToRemove){
        Text customName = chest.getCustomName();
        Direction chestFacing = world.getBlockState(pos).get(ChestBlock.FACING);

        world.removeBlockEntity(pos);
        world.removeBlock(pos, false);

        BlockState blockState = newChest.getDefaultState().with(ChestBlock.FACING, chestFacing).with(ChestBlock.WATERLOGGED, world.getFluidState(pos).isOf(Fluids.WATER));
        NbtCompound oldChestTag = chest.createNbt();

        world.setBlockState(pos, blockState, 3);
        world.updateListeners(pos, blockState, blockState, 3);
        world.getBlockEntity(pos).readNbt(oldChestTag);

        if (customName != null) {
            ((ChestBlockEntity) world.getBlockEntity(pos)).setCustomName(customName);
        }

        if (world.isClient){
            world.syncWorldEvent(player, WorldEvents.WAX_REMOVED, pos, 0);
            world.playSound(player, pos, SoundEvents.BLOCK_WOOL_PLACE, SoundCategory.BLOCKS, 2.0F, 0.4F);
        }
        if (!player.isCreative())
            player.getInventory().getMainHandStack().decrement(itemsToRemove);
    }

    private Optional<BlockState> tryStrip(World world, BlockPos pos, @Nullable PlayerEntity player, BlockState state) {
        Optional<BlockState> optional = Oxidizable.getDecreasedOxidationState(state);
        if (optional.isPresent()) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.syncWorldEvent(player, WorldEvents.BLOCK_SCRAPED, pos, 0);
            return optional;
        } else {
            Optional<BlockState> optional2 = Optional.ofNullable((Block)((BiMap)HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get()).get(state.getBlock())).map((block) -> block.getStateWithProperties(state));
            if (optional2.isPresent()) {
                world.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.syncWorldEvent(player, WorldEvents.WAX_REMOVED, pos, 0);
                return optional2;
            } else {
                return Optional.empty();
            }
        }
    }

    private void addWax(PlayerEntity player, World world, BlockState state, BlockPos pos, Hand hand, ChestType chestType){
        if (player instanceof ServerPlayerEntity) Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)player, pos, player.getStackInHand(hand));
        world.setBlockState(pos, state.with(ChestBlock.CHEST_TYPE, chestType), Block.NOTIFY_ALL_AND_REDRAW);
        world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, state));
        world.syncWorldEvent(player, WorldEvents.BLOCK_WAXED, pos, 0);
    }

}
