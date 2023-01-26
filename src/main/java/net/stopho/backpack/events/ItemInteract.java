package net.stopho.backpack.events;

import net.stopho.backpack.data.ItemPDC;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemInteract implements Listener {

    @EventHandler
    public static void onItemInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null && e.getItem().getType() == Material.PLAYER_HEAD && ItemPDC.hasLevel(e.getItem())) {
                openInventory(p, e.getItem());
            }
        }
    }

    static void openInventory(Player p, ItemStack item) {
        switch (ItemPDC.getLevel(item)) {
            case "leather": createInventory(p, 9, item); break;
            case "copper": createInventory(p, 18, item); break;
            case "iron": createInventory(p, 27, item); break;
            case "gold": createInventory(p, 36, item); break;
            case "diamond": createInventory(p, 45, item); break;
            case "netherite": createInventory(p, 54, item); break;
        }
    }

    static void createInventory(Player p, Integer size, ItemStack item) {
        Inventory inv = p.getServer().createInventory(p, size, "Backpack");
        if (ItemPDC.hasInventory(item)) {
            inv.setContents(ItemPDC.getInventory(item));
        }
        p.openInventory(inv);
    }
}
