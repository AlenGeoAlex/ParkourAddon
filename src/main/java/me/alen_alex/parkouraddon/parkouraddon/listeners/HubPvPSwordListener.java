package me.alen_alex.parkouraddon.parkouraddon.listeners;

import me.alen_alex.parkouraddon.parkouraddon.ParkourAddon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import sv.file14.hubpvpsword.api.event.PlayerEnterPvPModeEvent;
import sv.file14.hubpvpsword.api.event.PlayerExitPvPModeEvent;

public class HubPvPSwordListener implements Listener {

    private ParkourAddon plugin;

    public HubPvPSwordListener(ParkourAddon plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPvPJoin(PlayerEnterPvPModeEvent event){
        Player player = event.getPlayer();

        if(!plugin.getInPvP().contains(player))
            plugin.getInPvP().add(player);
    }

    @EventHandler
    public void onPvPLeave(PlayerExitPvPModeEvent event){
        Player player = event.getPlayer();

        if(plugin.getInPvP().contains(player))
            plugin.getInPvP().remove(player);
    }



}
