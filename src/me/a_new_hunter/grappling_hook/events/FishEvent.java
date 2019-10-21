package me.a_new_hunter.grappling_hook.events;

import java.util.Arrays;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import me.a_new_hunter.grappling_hook.Utils.Itemstack;
import me.a_new_hunter.grappling_hook.Utils.ParticlesEffect;

public class FishEvent implements Listener {

	private ParticlesEffect pe;
	private Itemstack i;
	
	public FishEvent(Plugin pl) {
		this.pe = new ParticlesEffect(pl);
		this.i = new Itemstack();
	}

	
	@EventHandler
	public void OnPlayerFishEvent(PlayerFishEvent e) {
		Player p = e.getPlayer();
		State state = e.getState();
		
		if (p.getInventory().getItemInMainHand().equals(i.CreateItemStack(Material.FISHING_ROD, 1, "&a&lGrappling Hook", Arrays.asList("&7Use to get to new places."), false, true)) && (state == State.REEL_IN || state == State.IN_GROUND)) {

			Location l1 = p.getLocation();
			Location l2 = e.getHook().getLocation();
			Vector v = l2.toVector().subtract(l1.toVector());
			p.setVelocity(v.multiply(0.35));
			pe.cloud(p.getLocation(), "CLOUD", 10, 0.5, 0.25, 0.5);
		}
	}
	
}
