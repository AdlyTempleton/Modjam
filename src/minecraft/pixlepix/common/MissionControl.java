package pixlepix.common;

import pixlepix.common.blocks.InventoryLink;
import pixlepix.complexmachines.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;

@Mod(modid = "missioncontrol", name = "Mission Control", version = "0.1.0")
public class MissionControl {
	public static InventoryLink inventoryLink;

	

	@Instance("missioncontrol")
	public static MissionControl instance;
	@SidedProxy(clientSide = "pixlepix.complexmachines.client.ClientProxy", serverSide = "pixlepix.complexmachines.common.CommonProxy")
	public static CommonProxy proxy;
	
}
