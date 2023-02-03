package net.stopho.backpack.events;


import net.stopho.backpack.data.ItemPDC;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class ItemSwapHands implements Listener {

    @EventHandler
    public static void onItemSwapHands(PlayerSwapHandItemsEvent e) {
        if (e.getPlayer().getOpenInventory().getTitle().contains("Backpack")) {
            if (e.getOffHandItem().getType() == Material.PLAYER_HEAD && ItemPDC.hasLevel(e.getOffHandItem())) {
                e.setCancelled(true);
            }
        }
    }
}
