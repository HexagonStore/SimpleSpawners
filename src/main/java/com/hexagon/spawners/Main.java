package com.hexagon.spawners;


import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public class Main extends JavaPlugin
{
    @Override
    public void onEnable(){
        
        Bukkit.getConsoleSender().sendMessage("Plugin iniciado com sucesso!");
    }

}
