package games.twinhead.morechests.item;

import games.twinhead.morechests.block.ChestTypes;
import games.twinhead.morechests.block.CustomChestBlock;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class CustomChestBlockItem extends BlockItem {

    private final ChestTypes type;

    public CustomChestBlockItem(CustomChestBlock block, Settings settings) {
        super(block, settings);
        this.type = block.type;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext context) {
        if(!Screen.hasShiftDown()){
            tooltip.add(Text.translatable("item.more_chests.chest_item.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("item.more_chests.chest_item.tooltip.chest_variants", "§7§nsingle§r" + (isDouble(type) ? " §7and §ndouble" : "")));
            if (upgradesInto(type).size() > 0){
                List<Text> texts = new ArrayList<>();
                upgradesInto(type).forEach((upgrade) -> texts.add(Text.literal(" " + upgrade.nameFormatted()).withColor(getColor(upgrade))));

                tooltip.add(Text.translatable("item.more_chests.chest_item.tooltip.upgrades_into").append(texts.get(0)).append(upgradesInto(type).size() > 1 ? Text.literal("," + texts.get(1).getString()).withColor(getColor(upgradesInto(type).get(1))) :  Text.literal("")));
                if (upgradeItem(type).size() > 1){
                    tooltip.add(Text.translatable("item.more_chests.chest_item.tooltip.upgrades_ingredients", upgradeItemCount(type) + "x" ,  Text.translatable(upgradeItem(type).get(0).getTranslationKey()).withColor(getColor(upgradesInto(type).get(0))), upgradeItemCount(type) + "x", (upgradeItem(type).size() > 0 ? Text.translatable(upgradeItem(type).get(1).getTranslationKey()).withColor(getColor(upgradesInto(type).get(1))) : "")));
                } else {
                    tooltip.add(Text.translatable("item.more_chests.chest_item.tooltip.upgrades_ingredient", upgradeItemCount(type) + "x", Text.translatable(upgradeItem(type).get(0).getTranslationKey()).withColor(getColor(upgradesInto(type).get(0)))));
                }

            }
        }
    }

    private List<ChestTypes> upgradesInto(ChestTypes type){
        return switch (type){
            case PLANK -> List.of(ChestTypes.COPPER, ChestTypes.IRON);
            case WOOL -> List.of(ChestTypes.COPPER, ChestTypes.IRON);
            case COPPER -> List.of(ChestTypes.GOLD);
            case IRON -> List.of(ChestTypes.GOLD);
            case GOLD -> List.of(ChestTypes.DIAMOND);
            case DIAMOND -> List.of(ChestTypes.NETHERITE);
            case NETHERITE -> new ArrayList<>();
        };
    }

    private List<Item> upgradeItem(ChestTypes type){
        return switch (type){
            case PLANK -> List.of(Items.COPPER_INGOT, Items.IRON_INGOT);
            case WOOL -> List.of(Items.COPPER_INGOT, Items.IRON_INGOT);
            case COPPER -> List.of(Items.GOLD_INGOT);
            case IRON -> List.of(Items.GOLD_INGOT);
            case GOLD -> List.of(Items.DIAMOND);
            case DIAMOND -> List.of(Items.NETHERITE_INGOT);
            case NETHERITE -> new ArrayList<>();
        };
    }

    private Integer upgradeItemCount(ChestTypes type){
        return type.equals(ChestTypes.DIAMOND) ? 1 : 8;
    }

    private boolean isDouble(ChestTypes type){
        return switch (type){
            case PLANK, COPPER, WOOL -> true;
            default -> false;
        };
    }

    private int getColor(ChestTypes type){
        return switch (type){
            case PLANK -> 0xAD8D54;
            case WOOL -> 0xFFFFFF;
            case COPPER -> 0xD37A5A;
            case IRON -> 0xE3E3E3;
            case GOLD -> 0xF2CA27;
            case DIAMOND -> 0x64F2E0;
            case NETHERITE -> 0x4C484C;
            default -> 0xFFFFFF;
        };
    }
}
