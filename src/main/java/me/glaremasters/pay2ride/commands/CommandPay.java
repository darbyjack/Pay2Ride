package me.glaremasters.pay2ride.commands;

import java.util.HashMap;
import java.util.Map;
import me.glaremasters.pay2ride.Pay2Ride;
import me.glaremasters.pay2ride.commands.base.CommandBase;
import me.glaremasters.pay2ride.util.ColorUtil;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by GlareMasters on 1/31/2018.
 */
public class CommandPay extends CommandBase {

    public CommandPay() {
        super("pay", "Get access to ride mounts",
                "p2r.pay", false, null, null, 0, 0);
    }

    @Override
    public void execute(Player player, String[] args) {
        FileConfiguration config = Pay2Ride.getI().getConfig();
        Economy economy = Pay2Ride.getI().getEconomy();
        int duration = config.getInt("duration");

        double cost = config.getDouble("price");

        double balance = economy.getBalance(player);
        if (balance >= cost) {
            player.sendMessage(ColorUtil.color(config.getString("messages.pay")));
            HashMap<String, Long> allowedMount = Pay2Ride.getAllowedMount();
            allowedMount.put(player.getName(), System.currentTimeMillis());
            Bukkit.getServer().getScheduler()
                    .runTaskLater(Pay2Ride.getI(), () -> allowedMount.remove(player.getName()),
                            duration * 20);
            return;
        }
        player.sendMessage(ColorUtil.color(config.getString("message.not-enough-money")));


    }
}


