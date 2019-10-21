package me.a_new_hunter.grappling_hook.Utils;

import java.util.ArrayList;
import java.util.List;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

public class Itemstack {
	
	public ItemStack CreateItemStack(Material material, int amount, String name,List<String> lore, boolean unbreakable, boolean glow) {
	    ItemStack stack = new ItemStack(material, amount);
	    
		if (glow) {
			stack.addUnsafeEnchantment(Enchantment.MENDING, 1);
		}
		
	    ItemMeta meta = stack.getItemMeta();

	    if (glow) meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
	    
	    if (name != null) meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		
		if (unbreakable) {
			meta.setUnbreakable(true);
			meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		}
		
		List<String> lores = new ArrayList<String>();
		for (String single : lore) {
			lores.add(ChatColor.translateAlternateColorCodes('&', single));
		} 
		
		meta.setLore(lores);
		
		meta.addItemFlags(ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ATTRIBUTES);
	
	    stack.setItemMeta(meta);
		stack.setAmount(amount);
	    
		return stack;	
	}
}
