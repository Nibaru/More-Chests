package games.twinhead.morechests.block;

import games.twinhead.morechests.MoreChests;
import games.twinhead.morechests.block.entity.*;
import games.twinhead.morechests.registry.BlockEntityRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public enum ChestTypes {

    PLANK,
    WOOL,
    COPPER(4, 9),
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
        return MoreChests.id( this.name().toLowerCase() + "_chest");
    }

    public BlockEntityType<? extends CustomChestBlockEntity> getBlockEntityType() {
        return switch (this) {
            case PLANK -> BlockEntityRegistry.PLANK_CHEST;
            case WOOL -> BlockEntityRegistry.WOOL_CHEST;
            case COPPER -> BlockEntityRegistry.COPPER_CHEST;
            case IRON -> BlockEntityRegistry.IRON_CHEST;
            case GOLD -> BlockEntityRegistry.GOLD_CHEST;
            case DIAMOND -> BlockEntityRegistry.DIAMOND_CHEST;
            case NETHERITE -> BlockEntityRegistry.NETHERITE_CHEST;
        };
    }

    public CustomChestBlockEntity getBlockEntity(BlockPos pos, BlockState state) {
        return switch (this) {
            case IRON -> new IronChestBlockEntity(pos, state, this);
            case GOLD -> new GoldChestBlockEntity(pos, state, this);
            case DIAMOND -> new DiamondChestBlockEntity(pos, state, this);
            case NETHERITE -> new NetheriteChestBlockEntity(pos, state, this);
            case COPPER -> new CopperChestBlockEntity(pos, state, this);
            case WOOL -> new WoolChestBlockEntity(pos, state, this);
            default -> new BasicChestBlockEntity(pos, state, this);
        };
    }

    public Identifier getSuffixedTextureId(String suffix){
        return MoreChests.id("entity/chest/" + suffix + "_" + this.name().toLowerCase() + "_chest");
    }

    public Identifier getTextureId(){
        return MoreChests.id("entity/chest/" + this.name().toLowerCase() + "_chest");
    }

    public Identifier getTextureId(DyeColor color){
        return MoreChests.id("entity/chest/" + color + "_" + this.name().toLowerCase() + "_chest");
    }

    public String nameFormatted(){
        return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase();
    }

}
