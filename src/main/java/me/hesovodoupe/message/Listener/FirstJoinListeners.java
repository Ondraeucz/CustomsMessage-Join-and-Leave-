package me.hesovodoupe.message.Listener;

import me.hesovodoupe.message.Message;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstJoinListeners implements Listener {
    private final Message plugin;

    public FirstJoinListeners(Message plugin) {
        this.plugin = plugin;
    }

    @EventHandler(
            priority = EventPriority.HIGHEST
    )
    public void onPlayerLogin(PlayerJoinEvent e) {
        if (!e.getPlayer().hasPlayedBefore()) {
            String firstjoin  = this.plugin.getConfig().getString("First-Join");
                firstjoin  = firstjoin .replace("%player%", e.getPlayer().getDisplayName());
                boolean firstmessage = this.plugin.getConfig().getBoolean("Settings.Firstmessage");
                if (firstmessage) {
                e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', firstjoin));
            }
        }

    }

}

