package com.hexagon.spawners;
import org.bukkit.event.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.block.*;
import org.bukkit.Material;
public class SpawnerBreakListener implements Listener{
    Main pl;
    public SpawnerBreakListener(Main pl){
        this.pl = pl;
    }
    @EventHandler
    public void on(BlockBreakEvent e){
       Block breakedBlock = e.getBlock();
       if(breakedBlock.getType() != Material.MOB_SPAWNER) return;
       if(!pl.getConfigWrapper().getConfig().getBoolean("pickaxe-requirements.silk-touch.enable")){
           return;
       }
       int minLevel = pl.getConfigWrapper().getConfig().getInt("pickaxe-requirements.silk-touch.min-level");
       
       if(e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.SILK_TOUCH) < minLevel){
           e.setCancelled(true);
           e.getPlayer().sendMessage(pl.getConfigWrapper().getConfig().getString("pickaxe-requirements.silk-touch.message"));
       }
    }
}
