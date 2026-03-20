package de.sofamann.sban.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.sofamann.sban.commands.CMD_ban;
import de.sofamann.sban.commands.CMD_kick;
import de.sofamann.sban.commands.CMD_mute;
import de.sofamann.sban.commands.CMD_unban;
import de.sofamann.sban.commands.CMD_unmute;
import de.sofamann.sban.events.PlayerLoginEvent_E;

public class Main extends JavaPlugin {
	
	public static ArrayList<String> mutedPlayers = new ArrayList<>();
	
	public void onEnable() {
		
	CMD_mute mutecmd = new CMD_mute();
	
	getCommand("ban").setExecutor(new CMD_ban());
	getCommand("unban").setExecutor(new CMD_unban());
	getCommand("mute").setExecutor(mutecmd);
	getCommand("unmute").setExecutor(new CMD_unmute());
	getCommand("kick").setExecutor(new CMD_kick());
	
	PluginManager plm = Bukkit.getPluginManager();
	plm.registerEvents(new PlayerLoginEvent_E(), this);
	plm.registerEvents(mutecmd, this);
	
	}

}