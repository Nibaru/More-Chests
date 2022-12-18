package games.twinhead.morechests.block;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.block.entity.*;
import games.twinhead.morechests.registry.BlockEntityRegistry;
import games.twinhead.morechests.screen.*;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public enum ChestTypes {
    ACACIA_PLANK,
    BIRCH_PLANK,
    CRIMSON_PLANK,
    DARK_OAK_PLANK,
    JUNGLE_PLANK,
    OAK_PLANK,
    SPRUCE_PLANK,
    WARPED_PLANK,
    COPPER(5, 9),
    IRON(6, 9),
    GOLD(6, 12),
    DIAMOND(9, 12),
    NETHERITE(9, 18),
    ;

    public final int columns, rows;
    public final boolean isBasic;

    ChestTypes(){
        this.columns = 9;
        this.rows = 3;
        this.isBasic = true;
    }

    ChestTypes(int rows, int columns){
        this.columns = columns;
        this.rows = rows;
        this.isBasic = false;
    }


    //returns chest type inventory size
    public int size(){
        return this.columns * this.rows;
    }

    public Identifier getId(){
        return new Identifier(MoreChests.MOD_ID, this.name().toLowerCase() + "_chest");
    }

    public BlockEntityType<? extends BasicChestBlockEntity> getBlockEntityType() {
        return switch (this) {
            case COPPER -> BlockEntityRegistry.COPPER_CHEST;
            case IRON -> BlockEntityRegistry.IRON_CHEST;
            case GOLD -> BlockEntityRegistry.GOLD_CHEST;
            case DIAMOND -> BlockEntityRegistry.DIAMOND_CHEST;
            case NETHERITE -> BlockEntityRegistry.NETHERITE_CHEST;
            case ACACIA_PLANK -> BlockEntityRegistry.ACACIA_PLANK_CHEST;
            case BIRCH_PLANK -> BlockEntityRegistry.BIRCH_PLANK_CHEST;
            case CRIMSON_PLANK -> BlockEntityRegistry.CRIMSON_PLANK_CHEST;
            case DARK_OAK_PLANK -> BlockEntityRegistry.DARK_OAK_PLANK_CHEST;
            case JUNGLE_PLANK -> BlockEntityRegistry.JUNGLE_PLANK_CHEST;
            case OAK_PLANK -> BlockEntityRegistry.OAK_PLANK_CHEST;
            case SPRUCE_PLANK -> BlockEntityRegistry.SPRUCE_PLANK_CHEST;
            case WARPED_PLANK -> BlockEntityRegistry.WARPED_PLANK_CHEST;

        };
    }

    public BasicChestBlockEntity getBlockEntity(BlockPos pos, BlockState state) {
        return switch (this) {
            case IRON -> new IronChestBlockEntity(pos, state, this);
            case GOLD -> new GoldChestBlockEntity(pos, state, this);
            case DIAMOND -> new DiamondChestBlockEntity(pos, state, this);
            case NETHERITE -> new NetheriteChestBlockEntity(pos, state, this);
            case COPPER -> new CopperChestBlockEntity(pos, state, this);
            default -> new BasicChestBlockEntity(pos, state, this);
        };
    }


    public Identifier getTextureId(){
        return new Identifier(MoreChests.MOD_ID, "entity/chest/" + this.name().toLowerCase() + "_chest");
    }

    public ScreenHandler createMenu(int syncId, PlayerInventory inv, Inventory inventory) {
        return switch (this){
            case IRON -> new IronChestScreenHandler(syncId, inv, inventory);
            case GOLD -> new GoldChestScreenHandler(syncId, inv, inventory);
            case DIAMOND -> new DiamondChestScreenHandler(syncId, inv, inventory);
            case NETHERITE -> new NetheriteChestScreenHandler(syncId, inv, inventory);
            case COPPER -> new CopperChestScreenHandler(syncId, inv, inventory);
            default -> new BasicChestScreenHandler(this, syncId, inv, inventory);
        };
    }
}
