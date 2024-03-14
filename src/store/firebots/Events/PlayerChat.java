package store.firebots.Events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class PlayerChat implements Listener {
    Plugin plugin = Bukkit.getPluginManager().getPlugin("SPK");

    @EventHandler
    public void onSendMessage(PlayerChatEvent p) {
          String message = plugin.getConfig().getString("MESSAGE_CHAT_FORMAT")
                  .replace("%nickname%", p.getPlayer().getDisplayName())
                          .replace("%message%", p.getMessage())
                                  .replace("&", "§");

        p.setCancelled(true);
        Bukkit.broadcastMessage(message);
    };
}
