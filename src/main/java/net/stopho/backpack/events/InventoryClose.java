package net.stopho.backpack.events;

import net.stopho.backpack.data.ItemPDC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClose implements Listener {

    @EventHandler
    public static void onInventoryClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();

        if (e.getView().getTitle().contains("Backpack")) {
            ItemPDC.setInventory(p.getInventory().getItemInMainHand(), e.getInventory().getContents());
        }
    }
}
