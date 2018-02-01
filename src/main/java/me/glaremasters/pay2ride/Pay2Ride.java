package me.glaremasters.pay2ride;

import me.glaremasters.pay2ride.events.PlayerMountEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by GlareMasters on 1/31/2018.
 */
public class Pay2Ride extends JavaPlugin {

    private static Pay2Ride i;

    public static Pay2Ride getI() {
        return i;
    }

    @Override
    public void onEnable() {
        i = this;

        Bukkit.getPluginManager().registerEvents(new PlayerMountEvent(), this);

    }

    @Override
    public void onDisable() {

    }

}
