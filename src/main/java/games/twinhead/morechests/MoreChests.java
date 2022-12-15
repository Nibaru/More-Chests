package games.twinhead.morechests;

import games.twinhead.morechests.block.BasicChestBlock;
import games.twinhead.morechests.registry.BlockEntityRegistry;
import games.twinhead.morechests.registry.BlockRegistry;
import games.twinhead.morechests.registry.ScreenHandlerRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class MoreChests implements ModInitializer {

    public static final String MOD_ID = "more_chests";

    public static final TagKey<Item> WOODEN_CHESTS = TagKey.of(RegistryKeys.ITEM, new Identifier(MoreChests.MOD_ID, "wooden_chests"));
    public static final TagKey<Block> WOODEN_CHESTS_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(MoreChests.MOD_ID, "wooden_chests"));
    public static final TagKey<Item> GOLD_UPGRADE_CHESTS = TagKey.of(RegistryKeys.ITEM, new Identifier(MoreChests.MOD_ID, "gold_upgrade_chests"));
    public static final TagKey<Block> GOLD_UPGRADE_CHESTS_BLOCK = TagKey.of(RegistryKeys.BLOCK, new Identifier(MoreChests.MOD_ID, "gold_upgrade_chests"));
    public static final TagKey<Block> CHESTS = TagKey.of(RegistryKeys.BLOCK, new Identifier(MoreChests.MOD_ID, "chests"));
    public static final TagKey<Item> COPPER_CHEST_UPGRADE_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(MoreChests.MOD_ID, "copper_chest_upgrade_item"));
    public static final TagKey<Item> IRON_CHEST_UPGRADE_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(MoreChests.MOD_ID, "iron_chest_upgrade_item"));
    public static final TagKey<Item> GOLD_CHEST_UPGRADE_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(MoreChests.MOD_ID, "gold_chest_upgrade_item"));
    public static final TagKey<Item> DIAMOND_CHEST_UPGRADE_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(MoreChests.MOD_ID, "diamond_chest_upgrade_item"));
    public static final TagKey<Item> NETHERITE_CHEST_UPGRADE_ITEM = TagKey.of(RegistryKeys.ITEM, new Identifier(MoreChests.MOD_ID, "netherite_chest_upgrade_item"));

    public static ItemGroup MOD_GROUP  = FabricItemGroup.builder(new Identifier(MoreChests.MOD_ID, "more_chests_tab"))
            .icon(()-> new ItemStack(BlockRegistry.DIAMOND_CHEST))
            .build();

    @Override
    public void onInitialize() {

        BlockRegistry.register();
        BlockEntityRegistry.registerBlockEntities();
        ScreenHandlerRegistry.registerAllScreenHandlers();


        UseBlockCallback.EVENT.register((player, world, hand, hitResult)-> {
            if(!player.isSneaking()) return ActionResult.PASS;
            if(!world.getBlockState(hitResult.getBlockPos()).isIn(CHESTS)) return ActionResult.PASS;

            BlockPos hitPos = hitResult.getBlockPos();
            BlockState hitState = world.getBlockState(hitPos);
            ItemStack mainHand = player.getInventory().getMainHandStack();
            BlockEntity blockEntity = world.getBlockEntity(hitPos);

            if (blockEntity == null) return ActionResult.PASS;

            ChestBlockEntity chest = (ChestBlockEntity) blockEntity;

            if (ChestBlockEntity.getPlayersLookingInChestCount(world, hitPos) > 0) { return ActionResult.PASS; }



            if(hitState.isIn(WOODEN_CHESTS_BLOCK)){
                if(mainHand.isIn(IRON_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 8){
                    upgradeChest(BlockRegistry.IRON_CHEST, chest, world, hitPos, player, 8);
                }
                if(mainHand.isIn(COPPER_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 8){
                    upgradeChest(BlockRegistry.COPPER_CHEST, chest, world, hitPos, player, 8);
                }
            } else if(hitState.isIn(GOLD_UPGRADE_CHESTS_BLOCK)){
                if(mainHand.isIn(GOLD_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 8){
                    upgradeChest(BlockRegistry.GOLD_CHEST, chest, world, hitPos, player, 8);
                }
            } else if(hitState.isOf(BlockRegistry.GOLD_CHEST) && mainHand.getCount() >= 8){
                if(mainHand.isIn(DIAMOND_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 8){
                    upgradeChest(BlockRegistry.DIAMOND_CHEST, chest, world, hitPos, player, 8);
                }
            }else if(hitState.isOf(BlockRegistry.DIAMOND_CHEST) && mainHand.getCount() >= 1){
                if(mainHand.isIn(NETHERITE_CHEST_UPGRADE_ITEM) && mainHand.getCount() >= 1){
                    upgradeChest(BlockRegistry.NETHERITE_CHEST, chest, world, hitPos, player, 1);
                }
            }



            return ActionResult.PASS;
        });
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
