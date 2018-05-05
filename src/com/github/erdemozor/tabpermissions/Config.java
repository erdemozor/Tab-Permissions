package com.github.erdemozor.tabpermissions;



import org.bukkit.ChatColor;

public class Config {
	private static Main main = Main.getInstance();
	public static String message;
	public static void load() {
		main.saveDefaultConfig();
		message = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("message", "&4Message"));
	}

	}





/*private static FileConfiguration getConfig() {

if (!new File("/CommandWhitelist/config.yml").exists()) {
	getConfig().options().copyDefaults(true);
  }
}


/*public static void load() {
FileConfiguration config = getConfig();

commandmessage = ChatColor.translateAlternateColorCodes('&', config.getString("message", "&4Message"));
} 

public static String getcommandmessage() {
return commandmessage;
}
}*/