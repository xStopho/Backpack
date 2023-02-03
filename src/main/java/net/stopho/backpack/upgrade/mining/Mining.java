package net.stopho.backpack.upgrade.mining;


import net.stopho.backpack.BackpackPlugin;
import net.stopho.backpack.upgrade.mining.item.MiningRecipes;

public class Mining {

    public static void registerUpgrades() {
        if (BackpackPlugin.getPlugin().getConfig().getBoolean("Backpack.upgrades.mining")) {
            BackpackPlugin.getPlugin().getLogger().info("register mining upgrades");
            registerEvents();
            MiningRecipes.registerRecipes();
        }
    }

    static void registerEvents() {

    }
}
