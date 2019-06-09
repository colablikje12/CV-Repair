package nl.craftville.repair;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Hello world!
 *
 */
public class Repair extends JavaPlugin{
	public static Repair instance;

	@Override
	public void onEnable() {
		instance = this;

		// REGISTER
		Bukkit.getServer().getPluginManager().registerEvents(new RepairSign(), this);

	}

	@Override
	public void onDisable() {

	}

	public static Repair getInstance() {
		return instance;
	}
}
