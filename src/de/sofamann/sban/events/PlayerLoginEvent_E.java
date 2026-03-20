package de.sofamann.sban.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLoginEvent_E implements Listener {
	
	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		
		Player p = e.getPlayer();
		
		if(p.isBanned() == true) {
			
			p.kickPlayer("§7Du wurdest vom Server gebannt! \\nGrund: §cHacking \\n§7Dauer: §cPermanent");
			
		}
		
	}

}