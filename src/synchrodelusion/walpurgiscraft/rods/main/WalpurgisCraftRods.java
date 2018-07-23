package synchrodelusion.walpurgiscraft.rods.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import synchrodelusion.walpurgiscraft.main.WalpurgisCraft;
import synchrodelusion.walpurgiscraft.main.api.WalpurgisCraftAPI;

public class WalpurgisCraftRods extends JavaPlugin{
	private static WalpurgisCraftRods inst;
	private WalpurgisCraftAPI api;
	public void onEnable() {
		inst=this;
		WalpurgisCraft wc=(WalpurgisCraft)Bukkit.getPluginManager().getPlugin("WalpurgisCraft");
		api=wc.getAPI();
	}
	public static WalpurgisCraftRods getInst() {
		return inst;
	}
	public WalpurgisCraftAPI getWalpurgisAPI() {
		return api;
	}
}
