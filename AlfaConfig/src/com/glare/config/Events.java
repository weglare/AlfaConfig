package com.glare.config;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import com.glare.config.Config;
import com.glare.config.Main;

public class Events 
  implements Listener{
	
	public void register()
	{
	Bukkit.getPluginManager().registerEvents(this, Main.instance);
	}
	
	 @EventHandler(priority=EventPriority.MONITOR)
	  public void handleUpdate(PlayerJoinEvent event)
	  {
	    final Player p = event.getPlayer();

	    if ((Config.UPDATE_CHECKING) && (!Main.latestUpdate.equals("null")) && (p.hasPermission("alfaconfig.getupdates")))
	      Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable()
	      {
	        public void run() {
	          p.sendMessage("§f[§aAlfaConfig§f] §7" + Main.latestUpdate + " §eis now available!");
	          p.sendMessage("§f[§aAlfaConfig§f] §ehttp://dev.bukkit.org/bukkit-plugins/alfaconfig/");
	          p.sendMessage("§f[§aAlfaConfig§f] §eRun §7/ac update §eto update now.");
	        }
	      }
	      , 110L);
	  }
	 
	@EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
			e.setJoinMessage(null);
            Player p = e.getPlayer();
            if(Config.getConfig().getBoolean("Join-Enable") == true){
            p.sendMessage(ChatColor.GREEN + Config.getConfig().getString("Join-Message").replace("&1", "§1").replace("&2", "§2").replace("&3", "§3").replace("&4", "§4").replace("&5", "§5").replace("&6", "§6").replace("&7", "§7").replace("&8", "§8").replace("&9", "§9").replace("&0", "§0").replace("&a", "§a").replace("&b", "§b").replace("&c", "§c").replace("&d", "§d").replace("&e", "§e").replace("&f", "§f").replace("&k", "§k").replace("&l", "§l").replace("&m", "§m").replace("&n", "§n").replace("&o", "§o").replace("&r", "§r").replace("%player", p.getDisplayName()));
            }
    }
	
	@EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
			e.setQuitMessage(null);
            Player p = e.getPlayer();
            if(Config.getConfig().getBoolean("Quit-Enable") == true){
            p.sendMessage(ChatColor.GREEN + Config.getConfig().getString("Quit-Message").replace("&1", "§1").replace("&2", "§2").replace("&3", "§3").replace("&4", "§4").replace("&5", "§5").replace("&6", "§6").replace("&7", "§7").replace("&8", "§8").replace("&9", "§9").replace("&0", "§0").replace("&a", "§a").replace("&b", "§b").replace("&c", "§c").replace("&d", "§d").replace("&e", "§e").replace("&f", "§f").replace("&k", "§k").replace("&l", "§l").replace("&m", "§m").replace("&n", "§n").replace("&o", "§o").replace("&r", "§r").replace("%player", p.getDisplayName()));
            }
    }
   
	 @EventHandler
	 public void onPlayerChat(AsyncPlayerChatEvent e){
	  Player p = e.getPlayer();
      if(Config.getConfig().getBoolean("Chat-Format-Enable") == true){
	  String m = e.getMessage();
	  e.setFormat(Config.getConfig().getString("Chat-Format").replace("&1", "§1").replace("&2", "§2").replace("&3", "§3").replace("&4", "§4").replace("&5", "§5").replace("&6", "§6").replace("&7", "§7").replace("&8", "§8").replace("&9", "§9").replace("&0", "§0").replace("&a", "§a").replace("&b", "§b").replace("&c", "§c").replace("&d", "§d").replace("&e", "§e").replace("&f", "§f").replace("&k", "§k").replace("&l", "§l").replace("&m", "§m").replace("&n", "§n").replace("&o", "§o").replace("&r", "§r").replace("%player", p.getDisplayName()).replace("%message", m));
	  }	  
	 }
	 

}
