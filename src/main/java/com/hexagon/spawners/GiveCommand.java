package com.hexagon.spawners;

import java.util.Arrays;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class GiveCommand implements CommandExecutor {
    Main plugin;
    public GiveCommand(Main pl){
        plugin = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            sender.sendMessage("§cUso: /givespawner <Mob> (Player)");
            return false;
        }
        String mobname = args[0];
        String playerName = sender.getName();
        if(args.length >= 2){
            playerName = args[1];
            if(args.length != 2){
                sender.sendMessage("§eAviso! Estes argumentos vão ser ignorados: '"+String.join(" ", Arrays.copyOfRange(args, 0, args.length))+"'");
            }
        }
        Mobs mob = Mobs.valueOfSafe(mobname);
        if(mob == null){
            
            StringBuilder availableMobsBuilder = new StringBuilder();
            boolean white = false;
	    for(Mobs iMob: Mobs.values()){
                white = !white;

		availableMobsBuilder.append((white?"":"§7")+iMob.name());
                availableMobsBuilder.append('\n');
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.getConfigWrapper().getConfig().getString("messages.give-command.mob-not-found")));
            sender.sendMessage(availableMobsBuilder.toString().split("\n"));
            return false;
	}
	Player player = Bukkit.getPlayer(playerName);
	player.getInventory().addItem(mob.getSkull(this.plugin));
        return true;
    }
    
}
