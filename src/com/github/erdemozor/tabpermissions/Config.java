package com.github.erdemozor.tabpermissions;



import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;

public class Config {
	private static Main main = Main.getInstance();
	public static Boolean enabled;
	public static ArrayList<String> exVal = new ArrayList<String>();
	public static ArrayList<String> exIndex = new ArrayList<String>();
	public static Boolean msgbool;
	public static String message;
	private static List<String> except;
	public static boolean load() {
		try{main.saveDefaultConfig();
		enabled = main.getConfig().getBoolean("enabled");
		msgbool = main.getConfig().getBoolean("Message.enabled");
		message = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Message.message"));
		except = main.getConfig().getStringList("Command Exceptions");
		for(String a :except) {
			String[] val = a.split(":");
			//Pair<String, String> asd = new Pair<String, String>(val[0], val[1].substring(1));
			//exceptions.add(asd);
			exIndex.add(val[0]);
			exVal.add(val[1]);
		}
		return true;
		}catch(Exception e) {
			return false;
		}

	}
	
	public static String getPerm(String cmd) {
		try {
			return exVal.get(exIndex.indexOf(cmd));
		}catch(Exception e){
			return null;
		}
		
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