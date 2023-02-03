package net.stopho.backpack.events;

import net.stopho.backpack.data.ItemPDC;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClose implements Listener {

    @EventHandler
    public static void onInventoryClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();

        if (e.getView().getTitle().contains("Backpack")) {
            if (p.getInventory().getItemInOffHand().getType() == Material.PLAYER_HEAD && ItemPDC.hasLevel(p.getInventory().getItemInOffHand())) {
                ItemPDC.setInventory(p.getInventory().getItemInOffHand(), e.getInventory().getContents());

            } else if (p.getInventory().getItemInMainHand().getType() == Material.PLAYER_HEAD && ItemPDC.hasLevel(p.getInventory().getItemInMainHand())) {
                ItemPDC.setInventory(p.getInventory().getItemInMainHand(), e.getInventory().getContents());
            }
        }
    }
}
