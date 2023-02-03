package net.stopho.backpack;

import net.stopho.backpack.upgrade.mining.item.MiningBackpack;
import net.stopho.backpack.item.Backpack;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class cmdTest implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player p = (Player) commandSender;

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("clear")) {
                p.getInventory().clear();
            }
            if (args[0].equalsIgnoreCase("mats")) {
                p.getInventory().addItem(new ItemStack(Material.LEATHER, 64));
                p.getInventory().addItem(new ItemStack(Material.STRING, 64));
                p.getInventory().addItem(new ItemStack(Material.COPPER_INGOT, 64));
                p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 64));
                p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 64));
                p.getInventory().addItem(new ItemStack(Material.DIAMOND, 64));
                p.getInventory().addItem(new ItemStack(Material.NETHERITE_SCRAP, 64));
            }
            if (args[0].equalsIgnoreCase("base")) {
                p.getInventory().addItem(Backpack.BP_LEATHER);
                p.getInventory().addItem(Backpack.BP_COPPER);
                p.getInventory().addItem(Backpack.BP_IRON);
                p.getInventory().addItem(Backpack.BP_GOLD);
                p.getInventory().addItem(Backpack.BP_DIAMOND);
                p.getInventory().addItem(Backpack.BP_NETHERITE);
            }
            if (args[0].equalsIgnoreCase("mining")) {
                p.getInventory().addItem(MiningBackpack.BP_LEATHER_MINING);
                p.getInventory().addItem(MiningBackpack.BP_COPPER_MINING);
                p.getInventory().addItem(MiningBackpack.BP_IRON_MINING);
                p.getInventory().addItem(MiningBackpack.BP_GOLD_MINING);
                p.getInventory().addItem(MiningBackpack.BP_DIAMOND_MINING);
                p.getInventory().addItem(MiningBackpack.BP_NETHERITE_MINING);
            }
            if (args[0].equalsIgnoreCase("farming")) {
                p.sendMessage("not implemented yet");
            }
            if (args[0].equalsIgnoreCase("looting")) {
                p.sendMessage("not implemented yet");
            }
            if (args[0].equalsIgnoreCase("fishing")) {
                p.sendMessage("not implemented yet");
            }
            if (args[0].equalsIgnoreCase("pdc")) {
                p.sendMessage(p.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().getKeys().toString());
            }
        }

        return true;
    }
}
