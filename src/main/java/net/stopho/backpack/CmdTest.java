package net.stopho.backpack;

import com.jeff_media.morepersistentdatatypes.DataType;
import net.stopho.backpack.data.ItemPDC;
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

        if (args[0].equalsIgnoreCase("item")) {
            p.getInventory().addItem(Backpack.BP_LEATHER);
            p.getInventory().addItem(Backpack.BP_COPPER);
            p.getInventory().addItem(Backpack.BP_IRON);
            p.getInventory().addItem(Backpack.BP_GOLD);
            p.getInventory().addItem(Backpack.BP_DIAMOND);
            p.getInventory().addItem(Backpack.BP_NETHERITE);
        }

        if (args[0].equalsIgnoreCase("pdc")) {
            p.sendMessage(p.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().getKeys().toString());
            p.sendMessage(ItemPDC.getLevel(p.getInventory().getItemInMainHand()));
        }

        if (args[0].equalsIgnoreCase("inv")) {
            p.sendMessage(p.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().get(ItemPDC.KEY_INVENTORY, DataType.ITEM_STACK_ARRAY).toString());
        }

        return true;
    }
}
