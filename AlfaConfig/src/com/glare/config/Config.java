package com.glare.config;

import com.glare.config.Main;
import com.glare.config.Files.Log;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config
{
  private static FileConfiguration config = null;
  private static File configFile = null;
  public static boolean ENABLED;
  public static boolean UPDATE_CHECKING;
  public static boolean PPT_ENABLED;
  public static boolean PPT_STREAM_ENABLED_BY_DEF;
  public static boolean JOIN_ENABLE;
  public static boolean JOIN_MESSAGE;
  public static boolean JOIN_USE_PERMS;
  public static int JOIN_ONLINE_AMOUNT;
  public static boolean CHAT_FORMAT_ENABLE;
  public static boolean CHAT_FORMAT;
  public static boolean NO_PERMISSION_MESSAGE;
  public static boolean QUIT_ENABLE;
  public static boolean QUIT_MESSAGE;
  public static boolean QUIT_USE_PERMS;
  public static int QUIT_ONLINE_AMOUNT;

  public static void init()
  {
    reload(); load(); reload();
    Log.info("Configuration loaded.");
  }

  private static void load() {
    config.options().header("AlfaDevelopment 2014 © \nLead Developer: Glare\n%player = Player Display Name\nPlease use § for color coding.");

    config.addDefault("Enabled", Boolean.valueOf(true));
    config.addDefault("CheckForUpdates", Boolean.valueOf(true));

    for (String s : new String[] { "Join", "Quit", "Chat-Formatting", "No-Permission" }) {
        if (config.get(s + ".Enabled") != null) {
          config.set(s + ".Hide" + s, Boolean.valueOf(config.getBoolean(s + ".Enabled")));
          config.set(s + ".Enabled", null);
        }

      config.addDefault("Join-Enable", Boolean.valueOf(true));
      config.addDefault("Join-Message", "&aWelcome to the server, %player!");
      config.addDefault("Quit-Enable", Boolean.valueOf(true));
      config.addDefault("Quit-Message", "&aGoodbye, %player!");
      config.addDefault("Chat-Format-Enable", Boolean.valueOf(false));
      config.addDefault("Chat-Format", "&9%player: &7%message");
      config.addDefault("No-Permission-Message", "&aYou do not have permission to execute this command.");
      
    }

    getConfig().options().copyDefaults(true);
    save();

    ENABLED = config.getBoolean("Enabled");
    UPDATE_CHECKING = config.getBoolean("CheckForUpdates");

    CHAT_FORMAT_ENABLE = config.getBoolean("Chat-Format-Enable");
    CHAT_FORMAT = config.getBoolean("Chat-Format");
    
    NO_PERMISSION_MESSAGE = config.getBoolean("No-Permission-Message");
    
    JOIN_ENABLE = config.getBoolean("Join-Enable");
    JOIN_MESSAGE = config.getBoolean("Join-Message");
    JOIN_USE_PERMS = config.getBoolean("Join.Permissions.UsePermissions");
    JOIN_ONLINE_AMOUNT = config.getInt("Join.NeedsToBeOnline");

    QUIT_ENABLE = config.getBoolean("Quit-Enable");
    QUIT_MESSAGE = config.getBoolean("Quit-Message");
    QUIT_USE_PERMS = config.getBoolean("Quit.Permissions.UsePermissions");
    QUIT_ONLINE_AMOUNT = config.getInt("Quit.NeedsToBeOnline");
  }

  public static void reload() {
    if (configFile == null) {
      configFile = new File(Main.instance.getDataFolder(), "config.yml");
    }
    config = YamlConfiguration.loadConfiguration(configFile);
  }

  public static FileConfiguration getConfig() {
    if (config == null) reload();
    return config;
  }

  public static void save() {
    if ((config == null) || (configFile == null)) {
      return;
    }
    try
    {
      config.save(configFile);
    } catch (IOException ex) {
      Log.severe("Could not save config.yml to " + configFile.getAbsolutePath());
      ex.printStackTrace();
    }
  }

  public static String colorize(String s) {
    if (s == null) return "";
    return s.replaceAll("&([0-9a-f])", "§$1");
  }
}