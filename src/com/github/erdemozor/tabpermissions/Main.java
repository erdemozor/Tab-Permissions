package com.github.erdemozor.tabpermissions;



//import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
//import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.permission.Permission;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
//import org.bukkit.event.Listener;

//import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin {
	private static Main instance;
	public static Permission permission = null;
	
	public void onEnable(){
		instance = this;
		setupPermissions();

		Config.load();
		if(true) {
			Permissions.setPerms();
		}
		getCommand(Commands.cmd1).setExecutor(new Commands());
		getCommand(Commands.cmd2).setExecutor(new Commands());
		//getCommand(Commands.cmd1).setTabCompleter(new Commands());
		logInit();
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
	
	PluginDescriptionFile pdfFile = getDescription();
	private void logInit() {
		//PluginDescriptionFile pdfFile = getDescription();
		getServer().getConsoleSender().sendMessage(ChatColor.AQUA+ pdfFile.getName() +ChatColor.WHITE+" Version "+ pdfFile.getVersion() +ChatColor.AQUA+ " Initialized");
	}
	public String getVer() {
		return pdfFile.getVersion();
	}

    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }
    
	public void printStackTrace(Throwable t)
	  {
	    Logger log = getLogger();
	    log.severe("Tperms Internal error!");
	    log.severe("Exception:");
	    log.severe("          ======= Exception Start =======");
	    StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    t.printStackTrace(pw);
	    for(String l: sw.toString().replace("\r", "").split("\n"))
	      log.severe(l);
	    pw.close();
	    try
	    {
	      sw.close();
	    }
	    catch(IOException e)
	    {
	    }
	    log.severe("          ======= Exception End =======");
	    log.severe("");
	  }
}
