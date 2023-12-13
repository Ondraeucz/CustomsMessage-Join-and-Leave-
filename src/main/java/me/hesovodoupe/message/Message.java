//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.hesovodoupe.message;

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
        System.out.println("Plugin has started!");
        this.getLogger().info("---------------------------------------");
        this.getLogger().info("CustomsMessage 1.6 version - ENABLE");
        this.getLogger().info("---------------------------------------");
        instance = this;
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.getConfig().getBoolean("Plugin.Updates");
        this.saveDefaultConfig();
        int pluginId = 20470;
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> {
            return "My value";
        }));
        this.getCommand("customsmessage").setExecutor(new reload());
        this.getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        this.getServer().getPluginManager().registerEvents(new LeaveListener(this), this);
        this.getServer().getPluginManager().registerEvents(new UniqueListener(this), this);
        this.getServer().getPluginManager().registerEvents(this, this);
        //register events (Message)

        (new UpdateCheck(this, 113825)).getVersion((version) -> {
            if (this.getDescription().getVersion().equals(version)) {
                this.getLogger().info("There is not a new update available.");
            } else {
                this.getLogger().info("There is a new update available.");
            }

        });
    }

    public void onDisable() {
        this.getLogger().info("---------------------------------------");
        this.getLogger().info("CustomsMessage 1.6 version - DISABLE");
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
