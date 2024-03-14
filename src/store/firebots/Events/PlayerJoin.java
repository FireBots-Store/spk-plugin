package store.firebots.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoin implements Listener {
    final Plugin plugin = Bukkit.getPluginManager().getPlugin("SPK");
    String username;
    @EventHandler
    public void onJoin(PlayerJoinEvent p) {
        this.username = p.getPlayer().getDisplayName();
        String msg = plugin.getConfig().getString("PLAYER_JOIN_MESSAGE").replace("&", "§").replace("%player%", p.getPlayer().getDisplayName());
        Bukkit.broadcastMessage(msg);
        p.setJoinMessage("");
    };
};