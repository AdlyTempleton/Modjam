package pixlepix.missioncontrol.common.helper;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

	
	public static int inventoryLink=1215;

	public static int selectiveInventoryLink=1216;

	public static int focusedInventoryLink=1218;

	public static int proximityInventoryLink=1217;

	public static int enderInventoryLink=1219;

	public static int outputInventoryLink=1220;

	public static int inputInventoryLink=1221;

	public static int deathInventoryLink=1222;

	public static int packet=21222;

	public static Configuration config;
	public static void configure(FMLPreInitializationEvent event){

		config = new Configuration(event.getSuggestedConfigurationFile());
		inventoryLink=config.getBlock("Inventory Link",inventoryLink).getInt();

		selectiveInventoryLink=config.getBlock("selective Inventory Link", selectiveInventoryLink).getInt();

		focusedInventoryLink=config.getBlock("focused Inventory Link", focusedInventoryLink).getInt();

		proximityInventoryLink=config.getBlock("proximity Inventory Link", proximityInventoryLink).getInt();

		enderInventoryLink=config.getBlock("ender Inventory Link", enderInventoryLink).getInt();

		outputInventoryLink=config.getBlock("output Inventory Link", outputInventoryLink).getInt();

		inputInventoryLink=config.getBlock("input Inventory Link", inputInventoryLink).getInt();

		deathInventoryLink=config.getBlock("death Inventory Link", deathInventoryLink).getInt();

		deathInventoryLink=config.getBlock("Packet Animation", packet).getInt();
		
				
	}
}
