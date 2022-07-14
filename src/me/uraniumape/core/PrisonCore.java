package me.uraniumape.core;

import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.WorldEdit;



public class PrisonCore extends JavaPlugin{
	
	private static PrisonCore instance;
	
    @Override
	public void onEnable() {
		saveDefaultConfig();

		this.getCommand("generate-prison").setExecutor(new GeneratePrison());
		instance = this;
	}
    
    public static PrisonCore getInstance() {
    	return instance;
    }
	
}
