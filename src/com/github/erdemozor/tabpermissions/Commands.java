package com.github.erdemozor.tabpermissions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.CommandExecutor;

public class Commands implements CommandExecutor,TabCompleter{
	private static Main main = Main.getInstance();
	public static String cmd1 = "tperms";
	public static String cmd2 = "pt";


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
	
		if(command.getName().equalsIgnoreCase("tperms")||command.getName().equalsIgnoreCase("pt")) {
			
			if(!(args.length==0) && !args[0].equalsIgnoreCase("help")) {
				if(args[0].equalsIgnoreCase("ver")) {
					sender.sendMessage(ChatColor.AQUA+"TPerms v"+main.getVer());

				}
				else if(args[0].equalsIgnoreCase("reload")) {
					if(Config.load()) {
						sender.sendMessage(ChatColor.AQUA+"Successfully reloaded config.");
					}
					else {
						sender.sendMessage(ChatColor.AQUA+"Error reloading config");
					}
					Permissions.setPerms();
					sender.sendMessage(ChatColor.AQUA+"Re-saved commands");
				}
				
				else if(args[0].equalsIgnoreCase("message")) {
					sender.sendMessage(ChatColor.AQUA+"Message: "+ChatColor.WHITE+Config.message);
				}
				
				else if(args[0].equalsIgnoreCase("testcmd")) {
					try{
						sender.sendMessage(Permissions.testCmd(args[1], sender).toString());
				}catch (Exception e) {
					main.printStackTrace(e);}
			}
				else if(args[0].equalsIgnoreCase("reset")) {
					Permissions.setPerms();
				}
				
				else if(args[0].equalsIgnoreCase("test")) {
					if(true) {
						sender.sendMessage(Permissions.test(args[1]));
					}
				}
				
				else {
					if(args[0].equalsIgnoreCase("help")) {
						help(sender,true);
					}
					help(sender,false);
				}	
			}
			else {
				help(sender,true);
			}
		}
		else return true;
//		main.getServer().getConsoleSender().sendMessage(ChatColor.RED +" Disabled");
		return true;		
		}
	private static void help(CommandSender sender, Boolean bool) {
		if(bool) {
			sender.sendMessage(ChatColor.AQUA+"TPerms v"+main.getVer());
		}
		else {
			sender.sendMessage(ChatColor.RED+"Unknown command");
		}
		sender.sendMessage(ChatColor.AQUA+"Viewing "+ChatColor.GREEN+"/tperms help");
		sender.sendMessage(ChatColor.AQUA+"Currently Working Commands:");
		sender.sendMessage(ChatColor.AQUA+"/tperms message");
		sender.sendMessage(ChatColor.AQUA+"/tperms reload");
		sender.sendMessage(ChatColor.AQUA+"/tperms reset");
		sender.sendMessage(ChatColor.AQUA+"/tperms testcmd");

	}
	private List<String> cmdList(){
		ArrayList<String> cmdList = new ArrayList<String>();
		cmdList.add("help");
		cmdList.add("reload");
		cmdList.add("message");
		cmdList.add("reset");
		cmdList.add("reset");
		return cmdList;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		
		
		if(command.getName().equalsIgnoreCase("tperms")||command.getName().equalsIgnoreCase("pt")) {
			
			if(args.length==1) {
				ArrayList<String> list = new ArrayList<>();
				if(!(args[0]=="")) {
					for(String a:cmdList()) {
						if(a.toLowerCase().startsWith(args[0].toLowerCase())) {
							list.add(a);
						}
					}
				
				}
				else {
					for(String a:cmdList()) {
						list.add(a);
					}
				}
				Collections.sort(list);
				return list;
			}
		}
		return null;
	}
}
	//public List<String> onTabComplete(CommandSender sender, //registers the auto tab completer






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