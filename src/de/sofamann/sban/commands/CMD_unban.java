package de.sofamann.sban.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_unban implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(args.length == 1) {
				
				if(p.hasPermission("bs.unban")) {
					
					OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
					
					if(target != null) {
						
						if(target.isBanned() != true) {
					
							p.sendMessage("§7[§cBan§7] Der Spieler §c" + target.getName() + " §7ist nicht gebannt!");
							
						} else {
							
							target.setBanned(false);
							p.sendMessage("§7[§cBan§7] Der Spieler §c" + target.getName() + " §7wurde entbannt!");
							
						}
						
					} else {
						
						p.sendMessage("§7[§cBan§7] Der Spieler §c" + args[0] + " §7existiert nicht!");
						
					}
					
				} else {
					
					p.sendMessage("§7[§cBan§7] Du hast nicht genügend Berechtigung!");
					
				}
				
			} else {
				
				p.sendMessage("§7[§cBan§7] Falscher Syntex, bitte benutze: /unban <Spieler>");
				
			}
			
		}
		return false;
	}

}