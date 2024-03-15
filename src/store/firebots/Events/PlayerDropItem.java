package store.firebots.Events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.plugin.Plugin;

public class PlayerDropItem implements Listener {
    final Plugin plugin = Bukkit.getPluginManager().getPlugin("SPK");

    @EventHandler
    public void onDrop(PlayerDropItemEvent p) {

        Player player = p.getPlayer();

        //ENVIA UMA MENSAGEM QUANDO O PLAYER DROPA DIAMENTE NO CHÃO
        if (p.getItemDrop().getName().toLowerCase().contains("diamond")) {
              player.sendMessage(plugin.getConfig().getString("DROPPED_DIAMOND").replace("&", "§"));
              player.getPlayer().playSound(p.getPlayer().getLocation(), Sound.BLOCK_ANVIL_PLACE, 1, 1);
        };
    };
};