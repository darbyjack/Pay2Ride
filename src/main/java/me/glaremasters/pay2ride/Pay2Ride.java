package me.glaremasters.pay2ride;

import java.util.HashMap;
import java.util.stream.Stream;
import me.glaremasters.pay2ride.commands.CommandHelp;
import me.glaremasters.pay2ride.commands.CommandPay;
import me.glaremasters.pay2ride.commands.base.CommandHandler;
import me.glaremasters.pay2ride.events.PlayerMountEvent;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by GlareMasters on 1/31/2018.
 */
public class Pay2Ride extends JavaPlugin {

    private static Pay2Ride i;
    private CommandHandler commandHandler;
    public static String prefix;
    private static Economy econ = null;
    private static int duration;
    public static HashMap<String, Long> allowedMount = new HashMap<>();

    public static Pay2Ride getI() {
        return i;


    }

    @Override
    public void onEnable() {
        i = this;

        prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("plugin-prefix"))
                + ChatColor.RESET + " ";

        duration = getConfig().getInt("duration");

        saveDefaultConfig();

        commandHandler = new CommandHandler();
        commandHandler.enable();

        getAllowedMount();

        setupEconomy();

        getCommand("p2r").setExecutor(commandHandler);

        Stream.of(
                new CommandHelp(), new CommandPay()
        ).forEach(commandHandler::register);

        Bukkit.getPluginManager().registerEvents(new PlayerMountEvent(), this);

    }

    @Override
    public void onDisable() {
        commandHandler.disable();
        if (getAllowedMount().size() > 0) {
            getAllowedMount().clear();
        }
    }

    public static String getPrefix() {
        return prefix;
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    public Economy getEconomy() {
        return econ;
    }


    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager()
                .getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static int getDuration() {
        return duration;
    }

    public static HashMap<String, Long> getAllowedMount() {
        return allowedMount;
    }
}
