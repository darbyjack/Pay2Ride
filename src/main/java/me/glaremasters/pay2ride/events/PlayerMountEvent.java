package me.glaremasters.pay2ride.events;

import me.glaremasters.pay2ride.Pay2Ride;
import me.glaremasters.pay2ride.commands.CommandPay;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.spigotmc.event.entity.EntityMountEvent;

/**
 * Created by GlareMasters on 1/31/2018.
 */
public class PlayerMountEvent implements Listener {

    @EventHandler
    public void onPlayerMount(EntityMountEvent event) {
        Entity entity = event.getEntity();
        String name = entity.getName();
        if (entity instanceof Player) {
            if (Pay2Ride.getAllowedMount().containsKey(name)) {
                event.setCancelled(false);
                return;
            }
            event.setCancelled(true);
        }

    }
}
