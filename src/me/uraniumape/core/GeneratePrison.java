package me.uraniumape.core;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.bukkit.BukkitPlayer;
import com.sk89q.worldedit.internal.annotation.Selection;
import com.sk89q.worldedit.regions.Region;

public class GeneratePrison implements CommandExecutor{

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.isOp() && sender instanceof Player) {
			Player p = (Player) sender;
			BukkitPlayer bPlayer = BukkitAdapter.adapt(p);
			int level = Integer.parseInt(args[0]);
			int minX,minY,minZ,maxX,maxY,maxZ;
			Region sel = null;
			Level l = new Level(level);
			
			//Get the players selection
			try {
				sel = WorldEdit.getInstance().getSessionManager().get(bPlayer).getSelection(bPlayer.getWorld());
			
			} catch (IncompleteRegionException e) {
				p.sendMessage("Complete region first");
				return true;
			}
			
			minX = sel.getMinimumPoint().getBlockX();
			maxX = sel.getMaximumPoint().getBlockX();

			minY = sel.getMinimumPoint().getBlockY();
			maxY = sel.getMaximumPoint().getBlockY();
			
			minZ = sel.getMinimumPoint().getBlockZ();
			maxZ = sel.getMaximumPoint().getBlockZ();
			
			for(int x = minX; x<=maxX; x++) {
				for(int y = minY; y<=maxY; y++) {
					for(int z = minZ; z<=maxZ; z++) {
						p.getWorld().getBlockAt(x, y, z).setType(l.generateBlock());
					}
					
				}
				
			}
			
			
		}
		return false;
	}

}
