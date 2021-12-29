package com.icurety.nicknames;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetName implements CommandExecutor {

    private void changeName(Player player, String nickname) {
        NameRegistry.saveName(player, nickname);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.isOp())
        {
            if(args.length > 0)
            {
                if(args.length == 1)
                {
                    String newName = args[0];
                    if(sender instanceof Player)
                    {
                        Player player = (Player) sender;
                        changeName(player, newName);
                        sender.sendMessage("Set the name of " + player.getName() + " to " + newName);
                    }
                    else sender.sendMessage("You can't change your own name like this in the console!");
                }
                else {
                    String playerName = args[0];
                    String nickname = args[1];

                    Player player = sender.getServer().getPlayer(playerName);
                    if(player != null)
                    {
                        changeName(player, nickname);
                        sender.sendMessage("Set the name of " + player.getName() + " to " + nickname);
                    }
                    else sender.sendMessage("That player isn't logged in!");
                }
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
