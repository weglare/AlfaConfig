package com.glare.config;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.glare.config.Files.Updater;
import com.glare.config.Events;
import com.glare.config.Commands;
import com.glare.config.Main;
import com.glare.config.Files.Log;

public class Main extends JavaPlugin implements Listener{
	
	  public static String latestUpdate = "null";
	  public static String prefix = "§6[AlfaConfig] ";
	  public static String nopermission = "§aYou do not have permission to run this command. ";
	  public static Main instance = null;

    public void onEnable() {
            instance = this;
            new Events().register();
            if (!getDataFolder().exists()) getDataFolder().mkdir();
            Config.init();
            getCommand("alfaconfig").setExecutor((CommandExecutor) new Commands());
                Log.info("Version " + getDescription().getVersion() + " disabled.");
            }
	
   
	public void onDisable() {
		System.out.println("[AlfaConfig] Plugin Disabled!");
		
	}
	
	}

