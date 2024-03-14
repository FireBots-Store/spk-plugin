package store.firebots.Commands;

import org.bukkit.Sound;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

public class Chapeu implements CommandExecutor {
    final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("SPK");

    public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {

        if (!(s instanceof Player)) return false;

        Player p = (Player) s;
        PlayerInventory i = p.getInventory();
        ItemStack hand = p.getItemInHand();
        ItemStack helmet = i.getHelmet();

        if (hand != null && hand.getType().name().contains("HELMET") || hand.getType() != Material.AIR && hand.getType().getMaxDurability() == 0) {
            i.setHelmet(hand);
            i.setItemInHand(helmet);
            Player player = ((Player) s).getPlayer();
            p.sendMessage(plugin.getConfig().getString("PLACED_HELMET").replace("&", "§"));
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
        } else {
            p.sendMessage(plugin.getConfig().getString("INVALID_ITEM").replace("&", "§"));
        }
        return true;
    }
}
