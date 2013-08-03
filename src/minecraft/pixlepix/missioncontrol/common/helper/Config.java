package pixlepix.missioncontrol.common.helper;

import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

	
	public static int inventoryLink=1215;

	public static int selectiveInventoryLink=1216;

	public static int focusedInventoryLink=1218;

	public static int proximityInventoryLink=1217;

	public static int enderInventoryLink=1219;

	public static int outputnventoryLink=1220;

	public static int inputInventoryLink=1221;

	public static int deathInventoryLink=1222;
	
	@ForgeSubscribe
	public static void configure(FMLPreInitializationEvent event){
		
	}
}
