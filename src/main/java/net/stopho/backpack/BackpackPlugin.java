package net.stopho.backpack;

import net.stopho.backpack.events.BlockPlace;
import net.stopho.backpack.events.ItemInteract;
import net.stopho.backpack.item.Recipes;
import org.bukkit.plugin.java.JavaPlugin;

public class BackpackPlugin extends JavaPlugin {

    public static BackpackPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        registerEvents();
        registerRecipes();

        getCommand("test").setExecutor(new CmdTest());
    }

    void registerEvents() {
        getLogger().info("register events");
        getServer().getPluginManager().registerEvents(new BlockPlace(), this);
        getServer().getPluginManager().registerEvents(new ItemInteract(), this);
    }

    void registerRecipes() {
        getLogger().info("register recipes");
        Recipes.registerBaseRecipes();
    }

    public static BackpackPlugin getPlugin() {
        return plugin;
    }
}
