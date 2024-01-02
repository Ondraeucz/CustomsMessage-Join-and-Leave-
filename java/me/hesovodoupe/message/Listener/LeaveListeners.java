package me.hesovodoupe.message.Listener;

import me.hesovodoupe.message.Message;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListeners implements Listener {
    private final Message plugin;

    public LeaveListeners(Message plugin) {
        this.plugin = plugin;
    }

    @EventHandler(
            priority = EventPriority.HIGHEST
    )
    public void onPlayerLeave(PlayerQuitEvent e) {
        String leaveMessage = this.plugin.getConfig().getString("Leave-Message");
        leaveMessage = leaveMessage.replace("%player%", e.getPlayer().getDisplayName());
        boolean leavemessage = this.plugin.getConfig().getBoolean("Settings.Leavemessage");
        if (leavemessage) {
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', leaveMessage));
    }

}
}

