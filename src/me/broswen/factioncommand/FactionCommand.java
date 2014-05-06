package me.broswen.factioncommand;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.UPlayer;

public class FactionCommand extends JavaPlugin{
	public static FactionCommand plugin;
	public String prefix = ChatColor.GRAY + "[FC] " + ChatColor.RESET;
	
	public void onEnable(){
		
	}
	
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("factioncommand")){
			
			if(!sender.hasPermission("factioncommand.fc")){
				sender.sendMessage(prefix + "You don't have permission!");
				return true;
			}
			
			if(!(args.length >= 2)){
				sender.sendMessage(prefix + "Usage: /factioncommand 'faction' 'command' 'args...'");
				return true;
			}
			
			for(Player player : Bukkit.getOnlinePlayers()) {
				UPlayer uplayer = UPlayer.get(player);
				String factionName = uplayer.getFaction().getName();
				
				int argsLength = args.length;
				
				if(factionName.equalsIgnoreCase(args[0])){
					
					String thefinalstring = "";
					for (int i = 1; i < args.length; i++) {
					    thefinalstring += args[i] + ' ';
					}
					
					sender.sendMessage(prefix + "Sending command '" + thefinalstring + "' to faction '" + args[0] + "'!");
					player.chat(thefinalstring);
				}
			}
			
			
			
			
		}
		
		return true;
	}
}
