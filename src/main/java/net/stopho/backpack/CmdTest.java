package net.stopho.backpack;

import net.stopho.backpack.item.Backpack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CmdTest implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull  Command command,@NotNull  String label, String[] args) {
        Player p = (Player) sender;

        p.getInventory().addItem(Backpack.BP_LEATHER);
        p.getInventory().addItem(Backpack.BP_COPPER);
        p.getInventory().addItem(Backpack.BP_IRON);
        p.getInventory().addItem(Backpack.BP_GOLD);
        p.getInventory().addItem(Backpack.BP_DIAMOND);
        p.getInventory().addItem(Backpack.BP_NETHERITE);

        return true;
    }
}
