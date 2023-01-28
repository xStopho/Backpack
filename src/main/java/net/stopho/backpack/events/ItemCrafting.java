package net.stopho.backpack.events;

import com.jeff_media.morepersistentdatatypes.DataType;
import net.stopho.backpack.BackpackPlugin;
import net.stopho.backpack.data.ItemPDC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.HashMap;
import java.util.UUID;

public class ItemCrafting implements Listener {

    private static final HashMap<UUID, Integer> taskID = new HashMap<>();

    @EventHandler
    public static void onInventoryOpen(InventoryOpenEvent e) {
        if (e.getInventory() instanceof CraftingInventory) {
            if (!taskID.containsKey(e.getPlayer().getUniqueId())) startScheduler((Player) e.getPlayer(), (CraftingInventory) e.getInventory());
        }
    }

    @EventHandler
    public static void onCraftItem(CraftItemEvent e) {
        ItemStack result = e.getInventory().getResult();
        loadInventory((Player) e.getWhoClicked(), result);
    }

    @EventHandler
    public static void onCloseCraftingInventory(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();
        int size = e.getInventory().getSize();

        if (e.getInventory() instanceof CraftingInventory) {
            ItemStack[] ingredients = ((CraftingInventory) e.getInventory()).getMatrix();
            for (ItemStack item : ingredients) {
                if (item != null && item.getType() == Material.PLAYER_HEAD && ItemPDC.hasLevel(item)) loadInventory(p, item);
            }
            if (taskID.containsKey(p.getUniqueId())) stopSchedular(p);
        }
    }

    @EventHandler
    public static void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory() instanceof CraftingInventory) {
            ItemStack item = e.getCurrentItem();
            if (item != null && item.getType() == Material.PLAYER_HEAD && ItemPDC.hasLevel(item)) loadInventory((Player) e.getWhoClicked(), item);
        }
    }

    static void saveInventory(Player p, ItemStack item) {
        if (ItemPDC.hasInventory(item)) {
            p.getPersistentDataContainer().set(ItemPDC.KEY_INVENTORY, DataType.ITEM_STACK_ARRAY, ItemPDC.getInventory(item));
            ItemPDC.removeInventory(item);
        }
    }

    static void loadInventory(Player p, ItemStack item) {
        PersistentDataContainer pdc = p.getPersistentDataContainer();

        if (pdc.has(ItemPDC.KEY_INVENTORY, DataType.ITEM_STACK_ARRAY)) {
            ItemPDC.setInventory(item, p.getPersistentDataContainer().get(ItemPDC.KEY_INVENTORY, DataType.ITEM_STACK_ARRAY));
            p.getPersistentDataContainer().remove(ItemPDC.KEY_INVENTORY);
        }
    }

    static void startScheduler(Player p, CraftingInventory inv) {
        Integer task = Bukkit.getScheduler().scheduleSyncRepeatingTask(BackpackPlugin.getPlugin(), () -> {
            ItemStack[] ingredients = inv.getMatrix();
            for (ItemStack item : ingredients) {
                if (item != null && item.getType() == Material.PLAYER_HEAD && ItemPDC.hasLevel(item)) saveInventory(p, item);
            }
        }, 20, 20);
        if (!taskID.containsKey(p.getUniqueId())) taskID.put(p.getUniqueId(), task);
    }

    static void stopSchedular(Player p) {
        Bukkit.getScheduler().cancelTask(taskID.get(p.getUniqueId()));
        taskID.remove(p.getUniqueId());
    }
}
