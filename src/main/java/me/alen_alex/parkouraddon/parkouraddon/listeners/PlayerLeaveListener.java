package me.alen_alex.parkouraddon.parkouraddon.listeners;

import me.alen_alex.parkouraddon.parkouraddon.ParkourAddon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {

    private ParkourAddon plugin;

    public PlayerLeaveListener(ParkourAddon plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLeaveEvent(PlayerQuitEvent event){
        final Player player = event.getPlayer();

        if(plugin.getInPvP().contains(player))
            plugin.getInPvP().remove(player);
    }

}
