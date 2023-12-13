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
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {
    private final Message plugin;

    public LeaveListener(Message plugin) {
        this.plugin = plugin;
    }

    @EventHandler(
            priority = EventPriority.HIGHEST
    )
    public void onPlayerLeave(PlayerQuitEvent e) {
        if (this.plugin.getConfig().getBoolean("Leave-Message")) {
            String leaveMessage = this.plugin.getConfig().getString("Leave-Message");
            leaveMessage = ChatColor.translateAlternateColorCodes('&', leaveMessage);
            leaveMessage = leaveMessage.replace("%Player", e.getPlayer().getDisplayName());
            e.setQuitMessage(leaveMessage);
        }

    }
}
