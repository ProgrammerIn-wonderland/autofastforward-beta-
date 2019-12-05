package com.mycompany.autofastforwardbeta;

import dosse.upnp.UPnP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (cmd.getName().equalsIgnoreCase("pf")) {
      if (sender instanceof Player) {
        Player player = (Player)sender;
        
        String port = String.join(" ", (CharSequence[])args);
        
        int intport = Integer.parseInt(port);
        
        UPnP.openPortUDP(intport);
        UPnP.openPortTCP(intport);
        player.sendMessage("Port " + intport + " forwarded.");
        System.out.println("Port " + intport + " forwarded.");
      } 

      
      return true;
    }  if (cmd.getName().equalsIgnoreCase("unpf")) {
      if (sender instanceof Player) {
        Player player = (Player)sender;
        
        String port = String.join(" ", (CharSequence[])args);
        
        int intport = Integer.parseInt(port);
        
        UPnP.closePortUDP(intport);
        UPnP.closePortTCP(intport);
        player.sendMessage("Port " + intport + " unforwarded.");
        System.out.println("Port " + intport + " unforwarded.");
      } 
      
      return true;
    } 
    
    return false;
  }

  
  public void onEnable() {
    System.out.println("Forwarding......");
    
    UPnP.openPortUDP(getServer().getPort());
    UPnP.openPortTCP(getServer().getPort());
    System.out.println("Port " + getServer().getPort() + " forwarded.");
  }
