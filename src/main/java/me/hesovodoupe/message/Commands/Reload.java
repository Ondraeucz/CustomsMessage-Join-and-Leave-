package me.hesovodoupe.message.Commands;

import me.hesovodoupe.message.Message;
import me.hesovodoupe.message.Util.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class Reload implements CommandExecutor {

    public Reload() {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("message.reload") && args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            Message.getInstance().reloadConfig();
            sender.sendMessage(Util.getString("Reload"));
        }

        return false;
    }

}
