package com.hexagon.spawners;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class BukkitConfig {
    String filePath;
    YamlConfiguration config;
    Class<? extends JavaPlugin> plClass;
    JavaPlugin plugin;
    public YamlConfiguration getConfig() {
        return config;
    }
    @Deprecated
    public BukkitConfig(File file, Class<? extends JavaPlugin> pl){
        this(file.getPath(), pl);
    }
    @Deprecated
    public BukkitConfig(String path, Class<? extends JavaPlugin> pl) {
        filePath = path;
        plClass = pl;
        pl().saveResource(path, false);
        config = YamlConfiguration.loadConfiguration(getPath());
    }
    public BukkitConfig(String path, JavaPlugin pl){
        this.plugin = pl;
        filePath = path;
        pl().saveResource(path, false);
        config = YamlConfiguration.loadConfiguration(getPath());
    }
    public BukkitConfig(File file, JavaPlugin pl){
        this(file.getPath(), pl);
    }

    public void save() throws IOException {
        config.save(getPath());
    }

    public File getPath() {
        return new File(pl().getDataFolder(), filePath);
    }

    private JavaPlugin pl() {
        return plClass != null?JavaPlugin.getPlugin(plClass): plugin;
    }
}