package com.github.erdemozor.tabpermissions;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

//import org.bukkit.entity.Player;


public class Commands implements CommandExecutor{
	private static Main main = Main.getInstance();
	public static String cmd1 = "tperms";
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("tperms")) {
			
			if(!(args.length==0)) {
				sender.sendMessage(ChatColor.AQUA+"If Checking");
			}
			else {
				sender.sendMessage(ChatColor.AQUA+"TPerms");
				sender.sendMessage(ChatColor.AQUA+"Viewing "+ChatColor.GREEN+"/tperms help");
				//help();
			
						
		}
		}
		else return true;
//		main.getServer().getConsoleSender().sendMessage(ChatColor.RED +" Disabled");
		return false;
		
	}
	

}






/*	public String cmd1 = "tperms";
@Override
public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
 
	if(command.getName().equalsIgnoreCase("cmd1"))
		if(!(args.length==0)) {
			if(args[0].equalsIgnoreCase("reload")) {
//				Config.load();
			if(args[0].equalsIgnoreCase("message")) {
				sender.sendMessage(Config.getcommandmessage());
				}
			}
		}
		else {
			sender.sendMessage("Help here");
			return true;
		}
	
	
	
	
	
	
	if(sender instanceof Player) {
		Player player =(Player) sender;
		
		if(command.getName().equalsIgnoreCase("tperms"))
			if(!(args.length==0)) {
				
			}
			else {
				sender.sendMessage("");
			}
	} 
	return false;
}*/