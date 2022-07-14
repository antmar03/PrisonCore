package me.uraniumape.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

public class Level {

	private List<Material> items = new ArrayList<Material>();
	
	public Level(int level) {
		FileConfiguration config = PrisonCore.getInstance().getConfig();
		String secPath = "levels.level_" + level;
		for(String path : config.getConfigurationSection(secPath).getKeys(false)){
			
			Material item = Material.valueOf(path);
			int odds = config.getInt("levels.level_" + level + "." + path);
			
			Bukkit.getLogger().info(String.valueOf(odds));
			
			for(int i = 0 ; i<= odds ; i++) {
				items.add(item);
			}
			
		}
		
		Collections.shuffle(items);
		Bukkit.getLogger().info(items.toString());
		
		
		
	}
	
	
	public Material generateBlock() {
		int random = ThreadLocalRandom.current().nextInt(items.size());
		
		return items.get(random);

	}
	
	
}
