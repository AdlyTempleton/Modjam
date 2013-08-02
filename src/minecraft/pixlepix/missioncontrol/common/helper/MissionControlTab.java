package pixlepix.missioncontrol.common.helper;

import pixlepix.missioncontrol.common.MissionControl;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MissionControlTab extends CreativeTabs {
	public static MissionControlTab instance;
	public MissionControlTab() {
		super("tabMissionControl");

		instance=this;
	}
	
	@Override
	public ItemStack getIconItemStack() {
		
		return new ItemStack(MissionControl.inventoryLink);
		
	}
}
