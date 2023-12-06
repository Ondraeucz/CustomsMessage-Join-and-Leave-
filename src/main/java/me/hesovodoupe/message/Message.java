package me.hesovodoupe.message;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Message extends JavaPlugin {
    private static Message instance;

    @Override
    public void onEnable() {

        System.out.println("Plugin has started!");
        System.out.println("[WARN] There is a new configuration on version 1.3, to update remove the old config");
        //start plugin

        this.getLogger().info("---------------------------------------");
        this.getLogger().info("CustomsMessage 1.3 version");
        this.getLogger().info("---------------------------------------");
        //annoucement console

        instance = this;
        this.saveDefaultConfig();

        this.getCommand("customsmessage").setExecutor(new reload());
        //commands

        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new LeaveListener(this), this);
        //register Join and Leave

    }

    @Override
    public void onDisable() {
        System.out.println("Plugin has stopped!");
        //disable plugin

        this.getLogger().info("---------------------------------------");
        this.getLogger().info("CustomsMessage 1.3 version");
        this.getLogger().info("---------------------------------------");
        //annoucement console {
    }

    public static Message getInstance() {
        return instance;
    }
}
