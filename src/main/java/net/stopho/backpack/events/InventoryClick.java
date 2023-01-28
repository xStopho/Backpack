package net.stopho.backpack.events;

import net.stopho.backpack.data.ItemPDC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public static void onInventoryClick(InventoryClickEvent e) {
        String title = e.getView().getTitle();

        if (e.getCurrentItem() != null) {
            if (title.contains("Backpack") && ItemPDC.hasLevel(e.getCurrentItem())) {
                e.setCancelled(true);
            }
        }
    }
}
