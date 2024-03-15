package store.firebots.Custom;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class CustomRecipes implements Listener {

    @EventHandler @Deprecated
    public void createPickaxeEnchantmentSmelting(ServerLoadEvent s) {
        Bukkit.getConsoleSender().sendMessage("§c[SPK] >> §aCustom recipes iniciado!");

        ItemStack smeltingEnchantment = new ItemStack(Material.ENCHANTED_BOOK);
        ShapedRecipe smeltingEnchantmentRecipe = new ShapedRecipe(smeltingEnchantment);
        smeltingEnchantmentRecipe.shape("AB%","CD%","%%%");

        smeltingEnchantmentRecipe.setIngredient('A', Material.FURNACE);
        smeltingEnchantmentRecipe.setIngredient('B', Material.COAL);
        smeltingEnchantmentRecipe.setIngredient('C', Material.BOOK);
        smeltingEnchantmentRecipe.setIngredient('D', Material.IRON_PICKAXE);

        Bukkit.getServer().addRecipe(smeltingEnchantmentRecipe);
    };
}
