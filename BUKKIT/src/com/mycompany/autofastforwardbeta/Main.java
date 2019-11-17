package com.mycompany.autofastforwardbeta;

import org.bukkit.plugin.java.JavaPlugin;
import dosse.upnp.UPnP;

public class Main extends JavaPlugin {
 
    @Override
    public void onEnable(){
        System.out.println("Forwarding......");
        UPnP.openPortUDP(getServer().getPort());
        UPnP.openPortTCP(getServer().getPort());
        System.out.println("Port " + getServer().getPort() + " forwarded.");
    }
 
    @Override
    public void onDisable(){
        System.out.println("unforwarding");
        UPnP.closePortUDP(getServer().getPort());
        UPnP.closePortTCP(getServer().getPort());
        System.out.println("Port " + getServer().getPort() + " unforwarded.");
    }
}