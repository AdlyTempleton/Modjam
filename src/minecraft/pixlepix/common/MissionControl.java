package pixlepix.common;

import pixlepix.common.blocks.InventoryLink;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "missioncontrol", name = "Mission Control", version = "0.1.0")
public class MissionControl {
	public static InventoryLink inventoryLink;

	

	@Instance("missioncontrol")
	public static MissionControl instance;
	@SidedProxy(clientSide = "pixlepix.complexmachines.client.ClientProxy", serverSide = "pixlepix.complexmachines.common.CommonProxy")
	public static CommonProxy proxy;
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		this.inventoryLink=new InventoryLink(1215);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		
	}
	
}
