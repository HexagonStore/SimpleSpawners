package com.hexagon.spawners;


import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

public class Main extends JavaPlugin
{
    BukkitConfig config;
    BukkitConfig getConfigWrapper(){
        return config;
    }
    @Override
    public void onEnable(){
        this.config = new BukkitConfig("spawners.yml", this);
        getCommand("givespawner").setExecutor(new GiveCommand(this));
        Bukkit.getPluginManager().registerEvents(new EventListener(this), this);
        Bukkit.getConsoleSender().sendMessage("Plugin iniciado com sucesso!");
        Bukkit.getPluginManager().registerEvents(new SpawnerBreakListener(this), this);
    }
    public List<String> getLore(String mob){
        ArrayList<String> result = new ArrayList<>(config.getConfig().getStringList("spawner.lore"));
        int i = 0;
        for(String line : result){
            result.set(i, line.replace("<mob>", mob));
            i++;
        }
        return new ArrayList<>(result);
    }
    public String getSpawnerName(String mob){
        return config.getConfig().getString("spawner.name").replace("<mob>", mob);
    }
}
