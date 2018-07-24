package synchrodelusion.walpurgiscraft.rods.main.rods.recipes;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.tr7zw.itemnbtapi.NBTItem;
import synchrodelusion.walpurgiscraft.main.api.CauldronRecipe;
import synchrodelusion.walpurgiscraft.main.api.CauldronRecipeResult;
import synchrodelusion.walpurgiscraft.main.cauldron.Cauldron;
import synchrodelusion.walpurgiscraft.rods.main.WalpurgisCraftRods;

public class RodRecipeResult implements CauldronRecipeResult{
	public RodRecipeResult() {
		Material[] mts=new Material[3];
		for(int i=0; i<=1; i++) {
			mts[i]=Material.GOLD_BLOCK;
		}
		for(RodType type:RodType.values()) {
			Material[] materials=mts.clone();
			materials[3]=getRodMaterial(type);
			CauldronRecipe rc=new CauldronRecipe(this, materials);
			WalpurgisCraftRods.getInst().getWalpurgisAPI().register(rc);
		}
	}
	
	private ItemStack getItem(RodType type) {
		ItemStack rod=new ItemStack(Material.TRIDENT);
		NBTItem nbt=new NBTItem(rod);
		nbt.setBoolean("walpurgiscraft_rod", true);
		nbt.setString("walpurgiscraft_rod_type", type.name());
		ItemMeta meta=rod.getItemMeta();
		meta.setDisplayName(getName(type));
		rod.setItemMeta(meta);
		return rod;
	}
	@Override
	public void effect(Cauldron caul, Material[] mats) {
		for(RodType type:RodType.values()) {
			if(ArrayUtils.contains(mats, getRodMaterial(type))) {
				Location loc=caul.getLocation().clone();
				loc.add(0.5, 1, 0.5);
				ItemStack item=getItem(type);
				Item drop=loc.getWorld().dropItem(loc, item);
				drop.setGravity(false);
				drop.setGlowing(true);
				drop.teleport(loc);
				break;
			}
		}
	}
	
	private String getName(RodType type) {
		if(type==RodType.FIRE) return "§c§lOgnista Ró¿d¿ka";
		if(type==RodType.WATER) return "§b§lWodna Ró¿d¿ka";
		return null;
	}
	private Material getRodMaterial(RodType type) {
		if(type==RodType.FIRE) return Material.LAVA_BUCKET;
		if(type==RodType.WATER) return Material.WATER_BUCKET;
		return null;
	}
}
