package me.hesovodoupe.message;

import org.bukkit.ChatColor;

public class Util {
    public Util() {
    }

    public static String getString(String path) {
        return ChatColor.translateAlternateColorCodes('&', Message.getInstance().getConfig().getString("Prefix") + " " + Message.getInstance().getConfig().getString(path));
    }
}
