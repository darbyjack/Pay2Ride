package me.glaremasters.pay2ride.events;

import java.util.HashMap;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityMountEvent;

/**
 * Created by GlareMasters on 1/31/2018.
 */
public class PlayerMountEvent implements Listener {

    public static HashMap<String, Long> cooldowns = new HashMap<>();

    @EventHandler
    public void onPlayerMount(EntityMountEvent event) {

    }


}
