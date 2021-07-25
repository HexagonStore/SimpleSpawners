package com.hexagon.spawners;


import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public class Main extends JavaPlugin
{
    BukkitConfig config;
    @Override
    public void onEnable(){
        this.config = new BukkitConfig("spawners.yml", this);
        
        Bukkit.getConsoleSender().sendMessage("[HexagonSpawners] Plugin iniciado com sucesso!");
    }
}
