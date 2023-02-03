package net.stopho.backpack;

import net.stopho.backpack.events.*;
import net.stopho.backpack.item.Recipes;
import net.stopho.backpack.upgrade.mining.Mining;
import org.bukkit.plugin.java.JavaPlugin;

public class BackpackPlugin extends JavaPlugin {

    public static BackpackPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        registerEvents();
        registerRecipes();

        if (getConfig().getBoolean("Backpack.upgrades.enabled")) {
            Mining.registerUpgrades();
        }

        getCommand("test").setExecutor(new cmdTest());
    }

    void registerEvents() {
        getLogger().info("register events");
        getServer().getPluginManager().registerEvents(new BlockPlace(), this);
        getServer().getPluginManager().registerEvents(new ItemInteract(), this);
        getServer().getPluginManager().registerEvents(new InventoryClose(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new ItemCrafting(), this);
        getServer().getPluginManager().registerEvents(new ItemSwapHands(), this);
    }

    void registerRecipes() {
        getLogger().info("register recipes");
        Recipes.registerBaseRecipes();
    }

    public static BackpackPlugin getPlugin() {
        return plugin;
    }

}
