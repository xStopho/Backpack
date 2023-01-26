package net.stopho.backpack.data;

import com.jeff_media.morepersistentdatatypes.DataType;
import net.stopho.backpack.BackpackPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class ItemPDC {

    public static NamespacedKey KEY_LEVEL = new NamespacedKey(BackpackPlugin.getPlugin(), "level");
    public static NamespacedKey KEY_INVENTORY = new NamespacedKey(BackpackPlugin.getPlugin(), "inventory");
    public static NamespacedKey KEY_ADDON = new NamespacedKey(BackpackPlugin.getPlugin(), "addon");

    static PersistentDataContainer getPDC(ItemMeta meta) {
        return meta.getPersistentDataContainer();
    }

    public static void setLevel(ItemStack item, String level) {
        ItemMeta meta = item.getItemMeta();
        getPDC(meta).set(KEY_LEVEL, PersistentDataType.STRING, level);
        item.setItemMeta(meta);
    }

    public static String getLevel(ItemStack item) {
        return getPDC(item.getItemMeta()).get(KEY_LEVEL, PersistentDataType.STRING);
    }

    public static boolean hasLevel(ItemStack item) {
        return getPDC(item.getItemMeta()).has(KEY_LEVEL, PersistentDataType.STRING);
    }

    public static void removeLevel(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        getPDC(meta).remove(KEY_LEVEL);
        item.setItemMeta(meta);
    }

    public static void setInventory(ItemStack item, ItemStack[] invContent) {
        ItemMeta meta = item.getItemMeta();
        getPDC(meta).set(KEY_INVENTORY, DataType.ITEM_STACK_ARRAY, invContent);
        item.setItemMeta(meta);
    }

    public static ItemStack[] getInventory(ItemStack item) {
        return getPDC(item.getItemMeta()).get(KEY_INVENTORY, DataType.ITEM_STACK_ARRAY);
    }

    public static boolean hasInventory(ItemStack item) {
        return getPDC(item.getItemMeta()).has(KEY_INVENTORY, DataType.ITEM_STACK_ARRAY);
    }

    public static void removeInventory(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        getPDC(meta).remove(KEY_INVENTORY);
        item.setItemMeta(meta);
    }

    public static void setAddon(ItemStack item, String addon) {
        ItemMeta meta = item.getItemMeta();
        getPDC(meta).set(KEY_ADDON, PersistentDataType.STRING, addon);
        item.setItemMeta(meta);
    }

    public static String getAddon(ItemStack item) {
        return getPDC(item.getItemMeta()).get(KEY_ADDON, PersistentDataType.STRING);
    }

    public static boolean hasAddon(ItemStack item) {
        return getPDC(item.getItemMeta()).has(KEY_INVENTORY, PersistentDataType.STRING);
    }

    public static void removeAddon(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        getPDC(meta).remove(KEY_ADDON);
        item.setItemMeta(meta);
    }
}
