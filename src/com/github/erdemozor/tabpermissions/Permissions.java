package com.github.erdemozor.tabpermissions;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.help.HelpTopic;
import javafx.util.Pair;

public class Permissions {
	private static Main main = Main.getInstance();
	
	public static ArrayList<String> array = new ArrayList<String>();
	public static ArrayList<Pair<String,String>> array2 = new ArrayList<Pair<String,String>>();
	
	public static void setPerms() {
		if(Config.enabled) {
			for (HelpTopic cmdLabel : main.getServer().getHelpMap().getHelpTopics()) {
				try {
					String cmd = cmdLabel.getName().replaceFirst("/", "");
					if(main.getServer().getPluginCommand(cmd).getPermissionMessage()==null) {
						if(Config.exIndex.contains(cmd)) {
							main.getServer().getPluginCommand(cmd).setPermission(Config.getPerm(cmd));
						}
						else {
							main.getServer().getPluginCommand(cmd).setPermission(main.getServer().getPluginCommand(cmd).getPlugin().getName()+"."+main.getServer().getPluginCommand(cmd).getName());
						}
					}
				}catch(Exception e){
					//HelpTopic isn't a command
				}
			}
			
		}
		else {main.getServer().getConsoleSender().sendMessage(ChatColor.GREEN+"TablClearer not enabled.");}

	}
	public static void permCommands() {
		
		for (HelpTopic cmdLabel : main.getServer().getHelpMap().getHelpTopics()) {
			Pair<String, String> pair = new Pair<String, String>(cmdLabel.getName(),main.getServer().getPluginCommand(cmdLabel.getName()).getPermission());
			array2.add(pair);
		}
		main.getServer().broadcastMessage(array2.toString());
	}
	
	public static String test(String cmd) {
		//return Config.exceptions.get(a).getKey()+":"+Config.exceptions.get(a).getValue();
		//Config.exceptions.contains(Pair<String,String>("a","b"));
		//return Config.exVal.get(Config.exIndex.indexOf(cmd));
		return main.getServer().getPluginCommand(cmd).getPermission();

	}
	
	public static Boolean testCmd(String cmd, CommandSender target) {
		return main.getServer().getPluginCommand(cmd).testPermissionSilent(target);
	}

}
