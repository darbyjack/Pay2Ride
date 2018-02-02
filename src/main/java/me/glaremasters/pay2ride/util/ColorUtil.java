package me.glaremasters.pay2ride.util;

import me.glaremasters.pay2ride.Pay2Ride;
import org.bukkit.ChatColor;

/**
 * Created by GlareMasters on 1/31/2018.
 */
public class ColorUtil {

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', Pay2Ride.getPrefix() + string);
    }

}