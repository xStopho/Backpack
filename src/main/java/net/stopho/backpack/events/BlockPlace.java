package net.stopho.backpack.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace implements Listener {

    @EventHandler
    public static void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();

        if (e.getItemInHand().getType() == Material.PLAYER_HEAD) {
            e.setCancelled(true);
        }
    }
}
