package games.twinhead.morechests.tag;

import games.twinhead.morechests.MoreChests;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModTags {
    public static final TagKey<Item> COPPER_CHESTS = TagKey.of(RegistryKeys.ITEM, MoreChests.id("copper_chests"));
    public static final TagKey<Block> COPPER_CHESTS_BLOCK = TagKey.of(RegistryKeys.BLOCK, MoreChests.id("copper_chests"));
    public static final TagKey<Item> WOOL_CHESTS = TagKey.of(RegistryKeys.ITEM, MoreChests.id("wool_chests"));
    public static final TagKey<Block> WOOL_CHESTS_BLOCK = TagKey.of(RegistryKeys.BLOCK, MoreChests.id("wool_chests"));
    public static final TagKey<Item> GOLD_UPGRADE_CHESTS = TagKey.of(RegistryKeys.ITEM, MoreChests.id("gold_upgrade_chests"));
    public static final TagKey<Block> GOLD_UPGRADE_CHESTS_BLOCK = TagKey.of(RegistryKeys.BLOCK, MoreChests.id("gold_upgrade_chests"));
    public static final TagKey<Item> COPPER_CHEST_UPGRADE_ITEM = TagKey.of(RegistryKeys.ITEM, MoreChests.id("copper_chest_upgrade_item"));
    public static final TagKey<Item> IRON_CHEST_UPGRADE_ITEM = TagKey.of(RegistryKeys.ITEM, MoreChests.id("iron_chest_upgrade_item"));
    public static final TagKey<Item> GOLD_CHEST_UPGRADE_ITEM = TagKey.of(RegistryKeys.ITEM, MoreChests.id("gold_chest_upgrade_item"));
    public static final TagKey<Item> DIAMOND_CHEST_UPGRADE_ITEM = TagKey.of(RegistryKeys.ITEM, MoreChests.id("diamond_chest_upgrade_item"));
    public static final TagKey<Item> NETHERITE_CHEST_UPGRADE_ITEM = TagKey.of(RegistryKeys.ITEM, MoreChests.id("netherite_chest_upgrade_item"));
    public static final TagKey<Block> UPGRADEABLE_CHESTS = TagKey.of(RegistryKeys.BLOCK, MoreChests.id("upgradeable_chests"));
    public static final TagKey<Item> WOODEN_CHESTS = TagKey.of(RegistryKeys.ITEM, MoreChests.id("wooden_chests"));
    public static final TagKey<Block> WOODEN_CHESTS_BLOCK = TagKey.of(RegistryKeys.BLOCK, MoreChests.id("wooden_chests"));
}
