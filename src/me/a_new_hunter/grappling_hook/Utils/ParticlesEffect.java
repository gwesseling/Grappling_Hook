package me.a_new_hunter.grappling_hook.Utils;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;

public class ParticlesEffect {
	
	public ParticlesEffect(Plugin plugin) {

	}
	
	public enum ParticleType {
		CIRCLE,
		SPIRAL,
		DOUBLE_SPIRAL,
		CLOUD
	}
	
	public void cloud(Location loc, String particleeffect, int amount, double xoffset, double yoffset, double zoffset) {	
        sendParticles(particleeffect, loc, xoffset, yoffset, zoffset, amount);   	
	}
	
    public ArrayList<Location> getCircle(Location center, double radius, int amount)
    {
        World world = center.getWorld();
        double increment = (2 * Math.PI) / amount;
        ArrayList<Location> locations = new ArrayList<Location>();
        for(int i = 0;i < amount; i++)
        {
            double angle = i * increment;
            double x = center.getX() + (radius * Math.cos(angle));
            double z = center.getZ() + (radius * Math.sin(angle));
            locations.add(new Location(world, x, center.getY(), z));
        }
        return locations;
    }
    
    public ArrayList<Location> getSpiral(Location center, double radius, int amount)
    {
        World world = center.getWorld();
        double increment = (2 * Math.PI) / amount;
        ArrayList<Location> locations = new ArrayList<Location>();
        for(int i = 0;i < amount * 2; i++)
        {
            double angle = i * increment;
            double x = center.getX() + (radius * Math.cos(angle));
            double z = center.getZ() + (radius * Math.sin(angle));
            locations.add(new Location(world, x, center.getY() + (i * 0.025), z));
        }
        return locations;
    }
    
    public ArrayList<Location> getBackwardsSpiral(Location center, double radius, int amount)
    {
        World world = center.getWorld();
        double increment = (2 * Math.PI) / amount;
        ArrayList<Location> locations = new ArrayList<Location>();
        for(int i = 0;i < amount * 2; i++)
        {
            double angle = i * increment;
            double x = center.getX() - (radius * Math.cos(angle));
            double z = center.getZ() - (radius * Math.sin(angle));
            locations.add(new Location(world, x, center.getY() + (i * 0.025), z));
        }
        return locations;
    }
	
	public void sendParticles(String particle,Location loc,double d,double f,double e,int amount) {
		World world = loc.getWorld();

		world.spawnParticle(
			Particle.valueOf(particle), 
			loc,
			amount,
			d,
			f,
			e,
			0
		);
	}
}
