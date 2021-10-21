package me.alen_alex.parkouraddon.parkouraddon.listeners;

import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import me.alen_alex.parkouraddon.parkouraddon.ParkourAddon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import sv.file14.bowhub.api.event.PlayerBowTeleportEvent;

public class PlayerBowTeleportListener implements Listener {

    private ParkourAddon plugin;

    public PlayerBowTeleportListener(ParkourAddon plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerBowTeleportEvent(PlayerBowTeleportEvent event){
        if(event.isCancelled())
            return;

        final Player player = event.getPlayer();

        if(plugin.getInPvP().contains(player))
            event.setCancelled(true);

    }
}
