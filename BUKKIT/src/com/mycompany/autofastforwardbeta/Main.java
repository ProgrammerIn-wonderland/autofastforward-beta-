package com.mycompany.autofastforwardbeta;

import org.bukkit.plugin.java.JavaPlugin;
import dosse.upnp.UPnP;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Main extends JavaPlugin {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("pf")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                //gets data of argument
                String port = String.join(" ", args);
                //convert string to int
                int intport = Integer.parseInt(port);
                //forwards port
                UPnP.openPortUDP(intport);
                UPnP.openPortTCP(intport);
                System.out.println("Port " + intport + " forwarded.");
            }

        // If the player (or console) uses our command correct, we can return true
        return true;
        }else if(cmd.getName().equalsIgnoreCase("unpf")){
            if (sender instanceof Player) {
                Player player = (Player) sender;
                //gets data of argument
                String port = String.join(" ", args);
                //convert string to int
                int intport = Integer.parseInt(port);
                //unforwards port
                UPnP.closePortUDP(intport);
                UPnP.closePortTCP(intport);
                System.out.println("Port " + intport + " forwarded.");
            }
                // If the player (or console) uses our command correct, we can return true
                return true;
        }
    // If the player (or console) uses our command correct, we can return false
    return false;
    }
 
    @Override
    public void onEnable(){
        System.out.println("Forwarding......");
        //forwards port
        UPnP.openPortUDP(getServer().getPort());
        UPnP.openPortTCP(getServer().getPort());
        System.out.println("Port " + getServer().getPort() + " forwarded.");
    }
 
    @Override
    public void onDisable(){
        System.out.println("unforwarding");
        //unforwards port
        UPnP.closePortUDP(getServer().getPort());
        UPnP.closePortTCP(getServer().getPort());
        System.out.println("Port " + getServer().getPort() + " unforwarded.");
    }
}