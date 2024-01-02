package me.hesovodoupe.message;

import me.hesovodoupe.message.Commands.Reload;
import me.hesovodoupe.message.Listener.JoinListeners;
import me.hesovodoupe.message.Listener.LeaveListeners;
import me.hesovodoupe.message.Updates.CheckUpdates;
import me.hesovodoupe.message.org.bstats.bukkit.Metrics;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Message extends JavaPlugin implements Listener {
    private static Message instance;

    public Message() {
    }

    public void onEnable() {
        this.getLogger().info("---------------------------------------");
        this.getLogger().info("CustomsMessage 2.1 version - ENABLE");
        this.getLogger().info("---------------------------------------");
        instance = this;
        this.saveDefaultConfig();
            int pluginId = 20470;
            Metrics metrics = new Metrics(this, pluginId);
            metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> {
                return "My value";
            }));
            this.getCommand("customsmessage").setExecutor(new Reload());
            this.getServer().getPluginManager().registerEvents(new JoinListeners(this), this);
            this.getServer().getPluginManager().registerEvents(new LeaveListeners(this), this);
            this.getServer().getPluginManager().registerEvents(this, this);
            (new CheckUpdates(this, 113825)).getVersion((version) -> {
                if (this.getDescription().getVersion().equals(version)) {
                    this.getLogger().warning("You have the latest version of the plugin!");
                } else {
                    this.getLogger().warning("You are using an outdated version!");

                }

            });
    }

    public void onDisable() {
        this.getLogger().info("---------------------------------------");
        this.getLogger().info("CustomsMessage 2.1 version - DISABLE");
        this.getLogger().info("---------------------------------------");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage("");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage("");
    }
    public static Message getInstance() {
        return instance;
    }

}

