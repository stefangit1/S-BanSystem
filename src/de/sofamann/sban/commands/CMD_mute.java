package de.sofamann.sban.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.sofamann.sban.main.Main;

public class CMD_mute implements CommandExecutor, Listener {

    @EventHandler
    public void handleMutedChat(AsyncPlayerChatEvent e) {
    	
    	Player p = e.getPlayer();
    	
        if(!Main.mutedPlayers.contains(p.getName())) {

        	e.setCancelled(true);

            if(p.hasPermission("ls.admin")) {

                Bukkit.broadcastMessage("§4Admin §7// §4" + e.getPlayer().getName() + " §7: " + e.getMessage());

            } else if(p.hasPermission("ls.mod")) {

                Bukkit.broadcastMessage("§cMod §7// §c" + e.getPlayer().getName() + " §7: " + e.getMessage());

            } else if(p.hasPermission("ls.builder")) {

                Bukkit.broadcastMessage("§2Builder §7// §2" + e.getPlayer().getName() + " §7: " + e.getMessage());

            } else {

                Bukkit.broadcastMessage("§7Spieler // " + e.getPlayer().getName() + " §7: " + e.getMessage());

            }

        } else {
        	
        	e.setCancelled(true);

            p.sendMessage("§7[§cBan§7] Du bist gemutet!");
        }
    }

    @SuppressWarnings("deprecation")
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    	if(sender instanceof Player) {

            Player p = (Player) sender;

            if(args.length == 1) {

                if(p.hasPermission("bs.mute")) {

                    Player target = Bukkit.getPlayer(args[0]);
                    OfflinePlayer target1 = Bukkit.getOfflinePlayer(args[0]);

                    if(target != null) {

                        if(!Main.mutedPlayers.contains(target.getName())) {

                            if(target.hasPermission("bs.mutebypass")) {

                                p.sendMessage("§7[§cBan§7] Der Spieler kann nicht gemutet werden!");

                            } else {

                                Main.mutedPlayers.add(target.getName());
                                p.sendMessage("§7[§cBan§7] Der Spieler §c" + target.getName() + " §7wurde gemutet!");

                            }

                        } else {

                            p.sendMessage("§7[§cBan§7] Der Spieler §c" + target.getName() + " §7ist bereits gemutet!");

                        }
                        
                    } else {

                        if(!Main.mutedPlayers.contains(target1.getName())) {

                            Main.mutedPlayers.add(target1.getName());
                            p.sendMessage("§7[§cBan§7] Der Spieler §c" + target1.getName() + " §7wurde gemutet!");

                        } else {

                            p.sendMessage("§7[§cBan§7] Der Spieler §c" + target1.getName() + " §7ist bereits gemutet!");

                        }

                    }

                } else {

                    p.sendMessage("§7[§cBan§7] Du hast nicht genügend Berechtigung!");

                }

            } else {

                p.sendMessage("§7[§cBan§7] Falscher Syntex, bitte benutze: /mute <Spieler>");

            }

        }
        return false;
    }

}