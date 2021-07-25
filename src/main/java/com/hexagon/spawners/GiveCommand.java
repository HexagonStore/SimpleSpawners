package com.hexagon.spawners;

import java.util.Arrays;

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
            sender.sendMessage("Uso: /givespawner <Mob> (Player)");
            return false;
        }
        String mobname = args[0];
        String playerName = sender.getName();
        if(args.length >= 2){
            playerName = args[1];
            if(args.length != 2){
                sender.sendMessage("Aviso! Estes argumentos vão ser ignorados: '"+String.join(" ", Arrays.copyOfRange(args, 0, args.length))+"'");
            }
        }
        Mobs mob = Mobs.valueOfSafe(mobname);
        if(mob == null){
            sender.sendMessage("Esse mob não existe!");
            StringBuilder availableMobsBuilder = new StringBuilder();
            for(Mobs iMob: Mobs.values()){
                availableMobsBuilder.append(iMob.name());
                availableMobsBuilder.append('\n');
            }
            sender.sendMessage("Mobs disponiveis: ");
            sender.sendMessage(availableMobsBuilder.toString().split("\n"));
            return false;
	}
	Player player = (Player) sender;
	player.getInventory().addItem(mob.getSkull(this.plugin));
        return true;
    }
    
}
