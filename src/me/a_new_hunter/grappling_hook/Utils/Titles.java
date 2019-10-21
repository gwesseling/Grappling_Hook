package me.a_new_hunter.grappling_hook.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_14_R1.IChatBaseComponent;
import net.minecraft.server.v1_14_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_14_R1.PlayerConnection;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;

public class Titles {

	public void send(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
		
		PlayerConnection con = ((CraftPlayer) player).getHandle().playerConnection;
        con.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, fadeIn, stay, fadeOut));

        if (title != null) {
            con.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', title) + "\"}")));
        }
        
        if (subtitle != null) {
            con.sendPacket(new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + ChatColor.translateAlternateColorCodes('&', subtitle) + "\"}")));
        }
    }
}
