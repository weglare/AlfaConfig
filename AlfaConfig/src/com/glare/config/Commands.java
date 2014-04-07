package com.glare.config;

import com.glare.config.Main;
import com.glare.config.Config;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class Commands
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args)
  {
    if (cmd.getName().equalsIgnoreCase("alfaconfig")) {
      if ((sender instanceof Player)) {
        if (args.length == 0) {
          if (sender.hasPermission("alfaconfig.command.list")) {
            String s = Main.instance.getDescription().getFullName();

            if (s.split("\\.").length > 2)
              sender.sendMessage("------------------- §6" + s + "§f -------------------");
            else {
              sender.sendMessage("------------------- §6" + s + "§f -------------------");
            }
            sender.sendMessage("§6/ac reload");
            sender.sendMessage(" §7-> §aReload the configuration file.");
            sender.sendMessage("§6/ac enable");
            sender.sendMessage(" §7-> §aEnable AlfaConfig.");
            sender.sendMessage("§6/ac disable");
            sender.sendMessage(" §7-> §aDisable AlfaConfig.");
            sender.sendMessage("§6/ac update");
            sender.sendMessage(" §7-> §aAuto/force update AlfaConfig.");
            sender.sendMessage("§6/ac");
            sender.sendMessage(" §7-> §aBrings up this command.");
            sender.sendMessage("-----------------------------------------------------");
          } else {
              sender.sendMessage(Main.nopermission);
          }
        } else if (args.length > 0) {
          if (args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("alfaconfig.command.reload"))
              reload(sender);
            else
                sender.sendMessage(Main.nopermission);
          }
          else if (args[0].equalsIgnoreCase("enable")) {
            if (sender.hasPermission("alfaconfig.command.enable"))
              enable(sender);
            else
                sender.sendMessage(Config.getConfig().getString("No-Permission-Message"));
          }
          else if (args[0].equalsIgnoreCase("disable")) {
            if (sender.hasPermission("alfaconfig.command.disable"))
              disable(sender);
            else
                sender.sendMessage(Main.nopermission);
        }
          
      else if (args.length == 0) {
        String s = Main.instance.getDescription().getFullName();

        if (s.split("\\.").length > 2)
          sender.sendMessage("------------------- " + s + " ------------------");
        else {
          sender.sendMessage("------------------- " + s + " -------------------");
        }
        sender.sendMessage("/ac reload");
        sender.sendMessage(" -> Reload the configuration file.");
        sender.sendMessage("/ac enable");
        sender.sendMessage(" -> Enable AlfaConfig.");
        sender.sendMessage("/ac disable");
        sender.sendMessage(" -> Disable AlfaConfig.");
        sender.sendMessage("/ac update");
        sender.sendMessage(" -> Auto/force update AlfaConfig.");
        sender.sendMessage("/alfaconfig");
        sender.sendMessage(" -> Brings up this command.");
        sender.sendMessage("-----------------------------------------------------");
      } else if (args.length > 0) {
        if (args[0].equalsIgnoreCase("reload"))
          reload(sender);
        else if (args[0].equalsIgnoreCase("enable"))
          enable(sender);
        else if (args[0].equalsIgnoreCase("disable"))
          disable(sender);
        }
        else {
          sender.sendMessage("Unknown command. Run '/alfaconfig' for help.");
        }
      }

      return true;
    }
    return false;
    }
	return false;
  }
  private void reload(CommandSender sender) {
    if (!Main.instance.getDataFolder().exists()) Main.instance.getDataFolder().mkdir();
    Config.init();

    sender.sendMessage(Main.prefix + "§aConfiguration file reloaded!");
  }

  private void enable(CommandSender sender) {
    if (Config.ENABLED) {
      sender.sendMessage(Main.prefix + "§aAlfaConfig is already enabled!");
    } else {
      Config.getConfig().set("Enabled", Boolean.valueOf(true));
      Config.save();
      Config.ENABLED = true;
      sender.sendMessage(Main.prefix + "§aEnabled AlfaConfig!");
    }
  }

  private void disable(CommandSender sender) {
    if (!Config.ENABLED) {
      sender.sendMessage(Main.prefix + "§aAlfaConfig is already disabled!");
    } else {
      Config.getConfig().set("Enabled", Boolean.valueOf(false));
      Config.save();
      Config.ENABLED = false;
      sender.sendMessage(Main.prefix + "§aDisabled AlfaConfig!");
    }
  }
  }
