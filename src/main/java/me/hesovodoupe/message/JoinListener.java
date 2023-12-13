//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.hesovodoupe.message;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    private final Message plugin;

    public JoinListener(Message plugin) {
        this.plugin = plugin;
    }

    @EventHandler(
            priority = EventPriority.HIGHEST
    )
    public void onPlayerJoin(PlayerJoinEvent e) {
            String joinMessage = this.plugin.getConfig().getString("Join-Message");
            joinMessage = ChatColor.translateAlternateColorCodes('&', joinMessage);
            joinMessage = joinMessage.replace("%Player%", e.getPlayer().getDisplayName());
            e.setJoinMessage(joinMessage);
        }

    }
