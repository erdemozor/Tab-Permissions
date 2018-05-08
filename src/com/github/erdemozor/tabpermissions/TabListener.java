package com.github.erdemozor.tabpermissions;

/*import java.lang.reflect.InvocationTargetException;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
*/
public class TabListener {
	/*
	  public void register()
	  {
	    ProtocolLibrary.getProtocolManager().addPacketListener(getTabCompleteListener());
	  }
	  
	  
	  public PacketAdapter getTabCompleteListener()
	  {
	    new PacketAdapter(Main.getInstance(), new PacketType[] { PacketType.Play.Client.TAB_COMPLETE })
	    {
	      public void onPacketReceiving(PacketEvent event)
	      {
	        Player player = event.getPlayer();
	        if (event.getPacketType().equals(PacketType.Play.Client.TAB_COMPLETE))
	        {
	          String message = (String)event.getPacket().getStrings().read(0);
	          if ((message.startsWith("/")) && 
	            (!player.hasPermission("tperms.override")))
	          {
	            String command = message.split(" ")[0].substring(1).toLowerCase();
	            PacketContainer completions = new PacketContainer(PacketType.Play.Server.TAB_COMPLETE);
	            
	            completions.getStringArrays().write(0, CommandUtils.getCompletions(player, command));
	            if (!message.contains(" ")) {
	              try
	              {
	                ProtocolLibrary.getProtocolManager().sendServerPacket(player, completions);
	                event.setCancelled(true);
	              }
	              catch (InvocationTargetException e)
	              {
	                e.printStackTrace();
	              }
	            } else if (!CommandUtils.checkWhitelistedCommand(player, command)) {
	              event.setCancelled(true); 
	            }
	          }
	        }
	      }
	    };
	  }
	
	*/
}
