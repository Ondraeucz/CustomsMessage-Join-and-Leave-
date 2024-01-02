package me.hesovodoupe.message.Listener;

import me.hesovodoupe.message.Message;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListeners implements Listener {
    private final Message plugin;
    private static Message instance;

    public JoinListeners(Message plugin) {
        this.plugin = plugin;
    }

    @EventHandler(
            priority = EventPriority.HIGHEST
    )
    public void onPlayerJoin(PlayerJoinEvent e) {
        String joinMessage = this.plugin.getConfig().getString("Join-Message");
        joinMessage = joinMessage.replace("%player%", e.getPlayer().getDisplayName());
        boolean joinmessage = this.plugin.getConfig().getBoolean("Settings.Joinmessage");
        if (joinmessage) {
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', joinMessage));

        }
   }
}


