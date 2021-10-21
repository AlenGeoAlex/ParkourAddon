package me.alen_alex.parkouraddon.parkouraddon.listeners;

import me.alen_alex.parkouraddon.parkouraddon.ParkourAddon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import sv.file14.hubpvpsword.api.event.PlayerEnterPvPModeEvent;
import sv.file14.hubpvpsword.api.event.PlayerExitPvPModeEvent;

import java.util.HashMap;

public class HubPvPSwordListener implements Listener {

    private ParkourAddon plugin;
    public HubPvPSwordListener(ParkourAddon plugin) {
        this.plugin = plugin;

    }

    @EventHandler
    public void onPvPJoin(PlayerEnterPvPModeEvent event){
        final Player player = event.getPlayer();
        if(!plugin.getInPvP().contains(player))
            plugin.getInPvP().add(player);

        if(plugin.getPlayerSpeeds().containsKey(player))
            plugin.getPlayerSpeeds().remove(player);

        plugin.getPlayerSpeeds().put(player,player.getWalkSpeed());


    }

    @EventHandler
    public void onPvPLeave(PlayerExitPvPModeEvent event){
        final Player player = event.getPlayer();

        if(plugin.getInPvP().contains(player))
            plugin.getInPvP().remove(player);

        if(plugin.getPlayerSpeeds().containsKey(player)){
            player.setWalkSpeed(plugin.getPlayerSpeeds().get(player));
            plugin.getPlayerSpeeds().remove(player);
        }

    }



}
