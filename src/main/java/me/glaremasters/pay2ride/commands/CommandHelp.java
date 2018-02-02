package me.glaremasters.pay2ride.commands;

import me.glaremasters.pay2ride.Pay2Ride;
import me.glaremasters.pay2ride.commands.base.CommandBase;
import me.glaremasters.pay2ride.util.ColorUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by GlareMasters on 1/31/2018.
 */
public class CommandHelp extends CommandBase {

    public CommandHelp() {
        super("help", "List all commands", "p2w.help", false, null, null, 0, 0);
    }

    public void execute(CommandSender sender, String[] args) {
        FileConfiguration config = Pay2Ride.getI().getConfig();

        sender.sendMessage(ColorUtil.color(config.getString("messages.paycommand")));
    }

}
