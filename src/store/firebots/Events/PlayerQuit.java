package store.firebots.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class PlayerQuit implements Listener {
    final Plugin plugin = Bukkit.getPluginManager().getPlugin("SPK");
    @EventHandler
    public void onLeave(PlayerQuitEvent p) {
        String msg = plugin.getConfig().getString("PLAYER_QUIT_MESSAGE").replace("&", "§").replace("%player%", p.getPlayer().getDisplayName());
        Bukkit.broadcastMessage(msg);
        p.setQuitMessage("");
    };

};