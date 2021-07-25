package com.hexagon.spawners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventListener implements Listener {
    Main pl;
    public EventListener(Main plInstance){
        pl = plInstance;
    }
    @EventHandler
    public void on(PlayerInteractEvent e){
        Mobs mob = Mobs.getByItemName(pl, e.getItem().getItemMeta().getDisplayName());
        if(mob == null){
            return;
        }
        e.setCancelled(true);
        Block blockToSetSpawner = e.getClickedBlock().getRelative(e.getBlockFace());
        blockToSetSpawner.setType(Material.MOB_SPAWNER);
        CreatureSpawner spawnerState = (CreatureSpawner) blockToSetSpawner.getState();
        spawnerState.setSpawnedType(mob.getBukkitType());
        
    }
}