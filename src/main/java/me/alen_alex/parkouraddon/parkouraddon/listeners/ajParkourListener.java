package me.alen_alex.parkouraddon.parkouraddon.listeners;

import me.alen_alex.parkouraddon.parkouraddon.ParkourAddon;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import us.ajg0702.parkour.api.AjPakour;
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
             System.out.println(AjPakour.getManager().getPlayer(player));
             if(AjPakour.getManager().getPlayer(player) != null){
                 AjPakour.getManager().kickPlayer(player);
                 System.out.println(AjPakour.getManager().getPlayer(player));
             }
             player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cYou are unable to start the parkour during your pvp session!"));
             return;
         }

        if(player.getItemInHand() != null) {
            ItemStack sword = player.getItemInHand();
                if(sword.getType() == Material.DIAMOND_SWORD){
                    if(sword.hasItemMeta()){
                        if(sword.getItemMeta().hasDisplayName() && sword.getItemMeta().getDisplayName().equals(ChatColor.translateAlternateColorCodes('&',"&aPvP Sword &7(Hold To Fight)"))){
                            event.setCancelled(true);
                            if(AjPakour.getManager().getPlayer(player) != null){
                                AjPakour.getManager().kickPlayer(player);
                            }
                            return;
                        }
                    }
                }
            }
        }


    }


