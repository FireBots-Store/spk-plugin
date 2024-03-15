package store.firebots.Events;

import org.bukkit.Bukkit;
import org.bukkit.MinecraftExperimental;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

public class BlockBreak implements Listener {
    final Plugin plugin = Bukkit.getPluginManager().getPlugin("SPK");
    @EventHandler
    public void onBreak(BlockBreakEvent b) {
        if (b.isDropItems()) {
            Player player = b.getPlayer();
            String breakItem = b.getBlock().getType().name().toLowerCase();

            //ENVIA O ITEM DIRETAMENTE PARA O INVENTARIO DO PLAYER
            if (plugin.getConfig().getString("AUTO_PICKUP").equals("true")) {
                if (player.getGameMode().name().equals("SURVIVAL")) {
                    if (player.getInventory().firstEmpty() > -1) {
                        b.setCancelled(false);
                        b.setDropItems(false);
                        player.getInventory().addItem(b.getBlock().getDrops().toArray(new ItemStack[0]));
                    };
                };
            };

            //ENVIA UMA MENSAGEM QUANDO O MEMBRO QUEBRA UM MENÉRIO DE DIAMANTE
            if (breakItem.contains("diamond")) {
                player.sendMessage(plugin.getConfig().getString("BREAK_DIAMOND").replace("&", "§"));
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            };
        };
    };
};
