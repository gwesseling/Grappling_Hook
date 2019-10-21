package me.a_new_hunter.grappling_hook;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.a_new_hunter.grappling_hook.commands.Grappling_Hook;
import me.a_new_hunter.grappling_hook.events.FishEvent;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		System.out.println("Grappling hook > enabled");
		
		registerEvents();
		registerCommands();
	}
	
	public void onDisable() {
		System.out.println("Grappling hook > disabled");
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new FishEvent(this), this);
	}
	
	public void registerCommands(){
		getCommand("grappling_hook").setExecutor(new Grappling_Hook());
	}
}
