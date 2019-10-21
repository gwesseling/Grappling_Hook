package me.a_new_hunter.grappling_hook.commands;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.a_new_hunter.grappling_hook.Utils.Itemstack;

public class Grappling_Hook implements CommandExecutor {
	
	private Itemstack i;
	
	public Grappling_Hook() {
		this.i = new Itemstack();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player){
			Player player = (Player) sender;

			if (label.equalsIgnoreCase("grappling_hook")) {
				
				ItemStack item = i.CreateItemStack(Material.FISHING_ROD, 1, "&a&lGrappling Hook", Arrays.asList("&7Use to get to new places."), false, true);
				player.getInventory().addItem(item);
				
				return true;
			}
		}
		
		return false;
	}
}
