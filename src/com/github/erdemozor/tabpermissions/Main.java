package com.github.erdemozor.tabpermissions;



//import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
//import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
//import org.bukkit.event.Listener;

//import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin {
	private static Main instance;

	
	public void onEnable(){
		instance = this;
		logInit();
		Config.load();
		getCommand(Commands.cmd1).setExecutor(new Commands());
	}
	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		getServer().getConsoleSender().sendMessage(ChatColor.RED + pdfFile.getName() +" Disabled");
	}
	
	public static Main getInstance() {
		return instance;
		}
	public void loadconfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	private void logInit() {
		PluginDescriptionFile pdfFile = getDescription();

		
		getServer().getConsoleSender().sendMessage(ChatColor.AQUA+ pdfFile.getName() +ChatColor.WHITE+" Version "+ pdfFile.getVersion() +ChatColor.AQUA+ " Initialized");
	}

		
		
		
}
	
	
	
	
	
//public static Permission permission = null;
//private Commands commands = new Commands();

//	Config.load();
/*	getCommand(commands.cmd1).setExecutor(commands);
	if(!setupPermissions()) {
		Bukkit.shutdown(); */

//Logger logger = Logger.getLogger("Minecraft");

//logger.info(ChatColor.AQUA + pdfFile.getName() + " version " + ChatColor.WHITE + pdfFile.getVersion() + ChatColor.AQUA + " has been enabled");
	
	/*	 private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }*/
