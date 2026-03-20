package de.sofamann.sban.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_kick implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			
			Player p = (Player) sender;
			
			if(args.length == 1) {
				
				if(p.hasPermission("bs.kick")) {
					
					Player target = Bukkit.getPlayer(args[0]);
					
					if(target == null) {
						
						p.sendMessage("§7[§cBan§7] Dieser Spieler ist nicht online!");
						
					}else if(!target.hasPermission("bs.kickbypass")) {
						
						target.kickPlayer("§7Du wurdest gekickt!");
						p.sendMessage("§7[§cBan§7] Der Spieler §c" + target.getName() + " §7wurde gekickt!");
						
					} else {
						
						p.sendMessage("§7[§cBan§7] Du kannst diesen Spieler nicht kicken!");
						
					}
					
				} else {
					
					p.sendMessage("§7[§cBan§7] Du hast nicht genügend Berechtigung!");
					
				}
				
			} else {
				
				p.sendMessage("§7[§cBan§7] Falscher Syntax, bitte benutze: /kick <Spieler>");
				
			}
			
		}
		return false;
	}

}