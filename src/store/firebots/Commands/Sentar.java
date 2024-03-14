package store.firebots.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class Sentar implements CommandExecutor {
    final Plugin plugin = Bukkit.getPluginManager().getPlugin("SPK");
    public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
        return true;
    };
}
