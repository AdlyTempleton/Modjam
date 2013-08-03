package pixlepix.missioncontrol.common;

import pixlepix.missioncontrol.blocks.DeathInventoryLink;
import pixlepix.missioncontrol.blocks.EnderInventoryLink;
import pixlepix.missioncontrol.blocks.FocusedInventoryLink;
import pixlepix.missioncontrol.blocks.InputInventoryLink;
import pixlepix.missioncontrol.blocks.InventoryLink;
import pixlepix.missioncontrol.blocks.OutputInventoryLink;
import pixlepix.missioncontrol.blocks.ProximityInventoryLink;
import pixlepix.missioncontrol.blocks.SelectiveInventoryLink;
import pixlepix.missioncontrol.common.helper.CommonProxy;
import pixlepix.missioncontrol.common.helper.MissionControlTab;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "missioncontrol", name = "Mission Control", version = "0.2.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { "MissionCont" }, packetHandler = PacketHandler.class)
public class MissionControl {
	public static InventoryLink inventoryLink;

	public static SelectiveInventoryLink selectiveInventoryLink;

	public static FocusedInventoryLink focusedInventoryLink;

	public static ProximityInventoryLink proximityInventoryLink;

	public static EnderInventoryLink enderInventoryLink;

	public static OutputInventoryLink outputInventoryLink;

	public static InputInventoryLink inputInventoryLink;

	public static DeathInventoryLink deathInventoryLink;
	public static MissionControlTab tab=new MissionControlTab();
	

	@Instance("missioncontrol")
	public static MissionControl instance;
	@SidedProxy(clientSide = "pixlepix.missioncontrol.common.helper.ClientProxy", serverSide = "pixlepix.missioncontrol.common.helper.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		this.inventoryLink=new InventoryLink(1215);

		this.selectiveInventoryLink=new SelectiveInventoryLink(1216);

		this.proximityInventoryLink=new ProximityInventoryLink(1217);

		this.focusedInventoryLink=new FocusedInventoryLink(1218);

		this.enderInventoryLink=new EnderInventoryLink(1219);

		this.outputInventoryLink=new OutputInventoryLink(1220);

		this.inputInventoryLink=new InputInventoryLink(1221);

		this.deathInventoryLink=new DeathInventoryLink(1222);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabMissionControl", "Mission Control");
	}
	
}
