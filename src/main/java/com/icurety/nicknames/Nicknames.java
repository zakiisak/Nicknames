package com.icurety.nicknames;

import org.bukkit.plugin.java.JavaPlugin;

public final class Nicknames extends JavaPlugin {

    @Override
    public void onEnable() {

        FileHandler.load(getDataFolder());

        // Plugin startup logic
        getCommand("setname").setExecutor(new CommandSetName());
        getCommand("clearname").setExecutor(new CommandClearName());

        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        FileHandler.save(getDataFolder());
    }
}
