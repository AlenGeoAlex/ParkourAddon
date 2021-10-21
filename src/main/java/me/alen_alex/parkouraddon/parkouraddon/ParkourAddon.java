package me.alen_alex.parkouraddon.parkouraddon;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import me.alen_alex.parkouraddon.parkouraddon.listeners.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ParkourAddon extends JavaPlugin {

    private static ParkourAddon plugin;
    private static List<Player> inPvP = new ArrayList<Player>();
    private static HashMap<Player,Float> playerSpeeds= new HashMap<Player,Float>();
    private boolean worldguardEnabled = false;
    private WorldGuardPlugin worldGuardPlugin;

    @Override
    public void onEnable() {
        plugin = this;
        if( !getServer().getPluginManager().isPluginEnabled("ajParkour") && !getServer().getPluginManager().isPluginEnabled("HubPvPSword")){
            getLogger().severe("This plugin requires ajParkour and HubPvPSword enabled on the server to intialize!!");
            getLogger().severe("The plugin will be disabled!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getServer().getPluginManager().registerEvents(new ajParkourListener(this), this);
        getServer().getPluginManager().registerEvents(new HubPvPSwordListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerBowTeleportListener(this),this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(this),this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveListener(this),this);
        getLogger().info("Plugin is enabled!");
    }

    @Override
    public void onDisable() {

    }

    public static ParkourAddon getPlugin() {
        return plugin;
    }

    public List<Player> getInPvP() {
        return inPvP;
    }

    public WorldGuardPlugin getWorldGuardPlugin() {
        return worldGuardPlugin;
    }

    public HashMap<Player, Float> getPlayerSpeeds() {
        return playerSpeeds;
    }
}
