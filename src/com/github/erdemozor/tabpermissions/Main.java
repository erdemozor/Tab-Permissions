package me.erdemozor.tabpermissions;

//import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin {
	public void onEnable(){
		PluginDescriptionFile pdfFile = getDescription();
		//Logger logger = Logger.getLogger("Minecraft");
		
		//logger.info(ChatColor.AQUA + pdfFile.getName() + " version " + ChatColor.WHITE + pdfFile.getVersion() + ChatColor.AQUA + " has been enabled");
		
		getServer().getConsoleSender().sendMessage(ChatColor.AQUA+ pdfFile.getName() +ChatColor.WHITE+" Version "+ pdfFile.getVersion() +ChatColor.AQUA+ " Initialized");
		
	}
	
	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		getServer().getConsoleSender().sendMessage(ChatColor.RED + pdfFile.getName() +" Disabled");
		
	}

	
	
	
	
}
