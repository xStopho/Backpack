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
    public static NamespacedKey KEY_MINING = new NamespacedKey(BackpackPlugin.getPlugin(), "mining");
    public static NamespacedKey KEY_FARMING = new NamespacedKey(BackpackPlugin.getPlugin(), "farming");
    public static NamespacedKey KEY_LOOTING = new NamespacedKey(BackpackPlugin.getPlugin(), "looting");
    public static NamespacedKey KEY_FISHING = new NamespacedKey(BackpackPlugin.getPlugin(), "fishing");

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

    public static void setUpgradeDefault(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        getPDC(meta).set(KEY_MINING, DataType.BOOLEAN, false);
        getPDC(meta).set(KEY_FARMING, DataType.BOOLEAN, false);
        getPDC(meta).set(KEY_LOOTING, DataType.BOOLEAN, false);
        getPDC(meta).set(KEY_FISHING, DataType.BOOLEAN, false);
        item.setItemMeta(meta);
    }
    public static void activateUpgrade(ItemStack item, NamespacedKey key) {
        ItemMeta meta = item.getItemMeta();
        getPDC(meta).set(key, DataType.BOOLEAN, true);
        item.setItemMeta(meta);
    }

    public static boolean hasUpgrade(ItemStack item, NamespacedKey key) {
        return getPDC(item.getItemMeta()).has(key, DataType.BOOLEAN);
    }

    public static void removeUpgrade(ItemStack item, NamespacedKey key) {
        ItemMeta meta = item.getItemMeta();
        getPDC(meta).set(key, DataType.BOOLEAN, false);
        item.setItemMeta(meta);
    }
}
