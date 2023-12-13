//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.hesovodoupe.message;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UniqueListener implements Listener {
    private final Message plugin;

    public UniqueListener(Message plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent e) {
        if (!e.getPlayer().hasPlayedBefore()) {
            int Unique = this.plugin.getConfig().getInt("Unique");
            Player player = e.getPlayer();
            this.plugin.saveConfig();
            String unique = this.plugin.getConfig().getString("first-join");
            if (unique != null) {
                unique = unique.replace("%player%", e.getPlayer().getDisplayName());
                e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', unique));
            }
        }

    }
}
