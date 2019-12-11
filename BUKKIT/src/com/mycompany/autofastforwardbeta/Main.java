package com.mycompany.autofastforwardbeta;

import dosse.upnp.UPnP;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Main extends JavaPlugin {
  @Override
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
        File inputFile = new File("ports.apf");
        File tempFile = new File("ports.apf.temp");
            try{
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        
            String lineToRemove = port;
            String currentLine;
            
            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            Path inputpath =  inputFile.toPath();
            Path temppath =  tempFile.toPath();
            
            Files.move(temppath, inputpath, StandardCopyOption.REPLACE_EXISTING);
            writer.close(); 
            reader.close(); 

        } catch (IOException ex) {  
              Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          }
      } 
      
      return true;
    } 
    
    return false;
  }

  @Override
  public void onEnable() {
    System.out.println("Forwarding......");
    
    UPnP.openPortUDP(getServer().getPort());
    UPnP.openPortTCP(getServer().getPort());
    File file = new File("ports.apf");
    if (file.exists()){
        try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader("ports.apf"));
            String line;
            while((line = br.readLine()) != null){
                int intline = Integer.parseInt(line);
                UPnP.openPortUDP(intline);
                UPnP.openPortTCP(intline);
                System.out.println("Port " + intline + " forwarded.");
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    else{
        System.out.println("anti yeet :(");
        try {
            PrintWriter writer;
            writer = new PrintWriter("ports.apf", "UTF-8");
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    System.out.println("Port " + getServer().getPort() + " forwarded.");
  }

  @Override
  public void onDisable() {
    System.out.println("unforwarding");
    
    UPnP.closePortUDP(getServer().getPort());
    UPnP.closePortTCP(getServer().getPort());
    File file = new File("ports.apf");
    if (file.exists()){
        try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader("ports.apf"));
            String line;
            while((line = br.readLine()) != null){
                int intline = Integer.parseInt(line);
                UPnP.closePortUDP(intline);
                UPnP.closePortTCP(intline);
                System.out.println("Port " + intline + " forwarded.");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    else{
        try {
            PrintWriter writer;
            writer = new PrintWriter("ports.apf", "UTF-8");
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    System.out.println("Port " + getServer().getPort() + " unforwarded.");
  }
}
