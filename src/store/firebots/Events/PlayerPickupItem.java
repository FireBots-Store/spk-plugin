package store.firebots.Events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.Plugin;

public class PlayerPickupItem implements Listener {
    Plugin plugin = Bukkit.getPluginManager().getPlugin("SPK");

    @EventHandler
    public void onCollect(PlayerPickupItemEvent p) {
        Player player = p.getPlayer();

    };
}
