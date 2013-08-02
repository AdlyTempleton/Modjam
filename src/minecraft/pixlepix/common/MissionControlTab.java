package pixlepix.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MissionControlTab extends CreativeTabs {
	public MissionControlTab() {
		super("tabMissionControl");
	}
	
	@Override
	public ItemStack getIconItemStack() {
		
		return MissionControl.inventoryLinker;
		
	}
}
