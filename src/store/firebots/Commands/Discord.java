package store.firebots.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class Discord implements CommandExecutor {
    final Plugin plugin = Bukkit.getPluginManager().getPlugin("SPK");

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(plugin.getConfig().getString("DISCORD_INVITE").replace("&", "§"));
        return true;
    }
}
