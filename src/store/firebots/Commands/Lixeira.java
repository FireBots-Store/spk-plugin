package store.firebots.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

public class Lixeira implements CommandExecutor {
    final Plugin plugin = Bukkit.getPluginManager().getPlugin("SPK");
    public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;
        int rows = Integer.parseInt(plugin.getConfig().getString("TRASH_ROWS")) * 9;
        Inventory inv = Bukkit.createInventory(p, rows, plugin.getConfig().getString("TRASH_TITLE").replace("&", "§"));
        s.sendMessage(plugin.getConfig().getString("TRASH_MESSAGE").replace("&", "§"));
        p.openInventory(inv);
        return true;
    };
}
