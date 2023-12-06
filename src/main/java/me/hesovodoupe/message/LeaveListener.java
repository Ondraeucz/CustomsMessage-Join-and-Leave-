package me.hesovodoupe.message;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveListener implements Listener {

    private final Message plugin;

    public LeaveListener(Message plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){

        String leaveMessage = this.plugin.getConfig().getString("leave-message");
        if (leaveMessage != null){
            leaveMessage = leaveMessage.replace("%player%", e.getPlayer().getDisplayName());
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', leaveMessage));
        }

    }
}

