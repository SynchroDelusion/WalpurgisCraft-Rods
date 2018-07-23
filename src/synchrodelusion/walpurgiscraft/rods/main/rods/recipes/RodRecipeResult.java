package synchrodelusion.walpurgiscraft.rods.main.rods.recipes;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import de.tr7zw.itemnbtapi.NBTItem;
import synchrodelusion.walpurgiscraft.main.api.CauldronRecipeResult;
import synchrodelusion.walpurgiscraft.main.cauldron.Cauldron;

public class RodRecipeResult implements CauldronRecipeResult{
	public RodRecipeResult() {
		ItemStack rod=new ItemStack(Material.TRIDENT);
		NBTItem nbt=new NBTItem(rod);
		nbt.setBoolean("walpurgiscraft_rod", true);
		
	}
	

	@Override
	public void effect(Cauldron caul, Material[] mats) {
		
	}
}
