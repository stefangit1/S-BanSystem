package de.sofamann.sban.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sofamann.sban.main.Main;

public class CMD_unmute implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    	if(sender instanceof Player) {

            Player p = (Player) sender;

            if(args.length == 1) {

                if(p.hasPermission("bs.unmute")) {

                    Player target = Bukkit.getPlayer(args[0]);
                    OfflinePlayer target1 = Bukkit.getOfflinePlayer(args[0]);

                    if(target != null) {

                        if(Main.mutedPlayers.contains(target.getName())) {

                                Main.mutedPlayers.remove(target.getName());
                                p.sendMessage("§7[§cBan§7] Der Spieler §c" + target.getName() + " §7wurde entmutet!");

                        } else {

                            p.sendMessage("§7[§cBan§7] Der Spieler §c" + target.getName() + " §7ist nicht gemutet!");

                        }
                        
                    } else {

                        if(Main.mutedPlayers.contains(target1.getName())) {

                            Main.mutedPlayers.remove(target1.getName());
                            p.sendMessage("§7[§cBan§7] Der Spieler §c" + target1.getName() + " §7wurde entmutet!");

                        } else {

                            p.sendMessage("§7[§cBan§7] Der Spieler §c" + target1.getName() + " §7ist nicht gemutet!");

                        }

                    }

                } else {

                    p.sendMessage("§7[§cBan§7] Du hast nicht genügend Berechtigung!");

                }

            } else {

                p.sendMessage("§7[§cBan§7] Falscher Syntex, bitte benutze: /unmute <Spieler>");

            }

        }
        return false;
    }

}