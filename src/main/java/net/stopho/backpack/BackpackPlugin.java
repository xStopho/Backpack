package net.stopho.backpack;

import org.bukkit.plugin.java.JavaPlugin;

public class BackpackPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        registerEvents();
        registerRecipes();

        getCommand("test").setExecutor(new CmdTest());
    }

    void registerEvents() {
        getLogger().info("register events");
    }

    void registerRecipes() {
        getLogger().info("register recipes");
    }
}
