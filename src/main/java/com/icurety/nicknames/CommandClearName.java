package com.icurety.nicknames;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClearName implements CommandExecutor {

    private void clearName(Player player) {
        NameRegistry.clearName(player);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.isOp())
        {
            if(args.length > 0)
            {
                String playerName = args[0];

                Player player = sender.getServer().getPlayer(playerName);
                if(player != null)
                {
                    clearName(player);
                    sender.sendMessage("Cleared the name of " + player.getName());
                }
                else sender.sendMessage("That player isn't logged in!");
                return true;
            }
            return false;
        }
        else {
            sender.sendMessage("You are not authorized to use this command");
        }
        return true;
    }
}
