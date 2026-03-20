package de.sofamann.sban.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_ban implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(args.length == 1) {
				
				if(p.hasPermission("bs.ban")) {
					
					Player target = Bukkit.getPlayer(args[0]);
					OfflinePlayer target1 = Bukkit.getOfflinePlayer(args[0]);
					
					if(target != null) {
						
						if(target.isBanned() == false) {
						
							if(target.hasPermission("bs.banbypass")) {
					
								p.sendMessage("§7[§cBan§7] Der Spieler kann nicht gebannt werden!");
							
							} else {
							
								target.setBanned(true);
								target.kickPlayer("§7Du wurdest vom Server gebannt! \nGrund: §cHacking \n§7Dauer: §cPermanent");
								p.sendMessage("§7[§cBan§7] Der Spieler §c" + target.getName() + " §7wurde gebannt!");
							
							}
							
						} else {
							
							p.sendMessage("§7[§cBan§7] Der Spieler §c" + target.getName() + " §7ist bereits gebannt!");
							
						}
						
					} else {
						
						if(target1.isBanned() == false) {
						
							target1.setBanned(true);
							p.sendMessage("§7[§cBan§7] Der Spieler §c" + target1.getName() + " §7wurde gebannt!");
						
						} else {
							
							p.sendMessage("§7[§cBan§7] Der Spieler §c" + target1.getName() + " §7ist bereits gebannt!");
							
						}
						
					}
					
				} else {
					
					p.sendMessage("§7[§cBan§7] Du hast nicht genügend Berechtigung!");
					
				}
				
			} else {
				
				p.sendMessage("§7[§cBan§7] Falscher Syntex, bitte benutze: /ban <Spieler>");
				
			}
			
		}
		return false;
	}

}