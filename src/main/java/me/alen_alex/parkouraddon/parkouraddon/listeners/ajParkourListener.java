package me.alen_alex.parkouraddon.parkouraddon.listeners;

import me.alen_alex.parkouraddon.parkouraddon.ParkourAddon;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import us.ajg0702.parkour.api.events.PrePlayerStartParkourEvent;

public class ajParkourListener implements Listener {

    private ParkourAddon plugin;

    public ajParkourListener(ParkourAddon plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onParkourStart(PrePlayerStartParkourEvent event){
        if(event.isCancelled())
            return;

        Player player = event.getPlayer();

         if(plugin.getInPvP().contains(player)) {
             event.setCancelled(true);
             player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cYou are unable to start the parkour during your pvp session!"));
         }

    }


}
