package store.firebots;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import store.firebots.Commands.Chapeu;
import store.firebots.Commands.Discord;
import store.firebots.Commands.Lixeira;
import store.firebots.Events.*;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {

    private File customConfigFile;

    private FileConfiguration customConfig;
    private static Plugin plugin;
    private static Main main;

    @Override
    public void onEnable() {
        plugin = this;

        getServer().getConsoleSender().sendMessage("§c[SPK] >> §aPlugin iniciado com sucesso!");

        getServer().getPluginManager().registerEvents(new PlayerJoin(),this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
        getServer().getPluginManager().registerEvents(new PlayerDropItem(), this);
        getServer().getPluginManager().registerEvents(new BlockBreak(), this);
        getServer().getPluginManager().registerEvents(new PlayerPickupItem(), this);
        getServer().getPluginManager().registerEvents(new PlayerChat(), this);


        this.getCommand("lixeira").setExecutor(new Lixeira());
        this.getCommand("chapeu").setExecutor(new Chapeu());
        this.getCommand("discord").setExecutor(new Discord());

        createCustomConfig();
    };

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§c[SPK] >> §4Plugin encerrado com segurança!");
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "config.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    };



}
