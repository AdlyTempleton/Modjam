package pixlepix.missioncontrol.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import pixlepix.missioncontrol.blocks.DeathInventoryLink;
import pixlepix.missioncontrol.blocks.EnderInventoryLink;
import pixlepix.missioncontrol.blocks.FocusedInventoryLink;
import pixlepix.missioncontrol.blocks.InputInventoryLink;
import pixlepix.missioncontrol.blocks.InventoryLink;
import pixlepix.missioncontrol.blocks.OutputInventoryLink;
import pixlepix.missioncontrol.blocks.ProximityInventoryLink;
import pixlepix.missioncontrol.blocks.SelectiveInventoryLink;
import pixlepix.missioncontrol.common.helper.CommonProxy;
import pixlepix.missioncontrol.common.helper.Config;
import pixlepix.missioncontrol.common.helper.MissionControlTab;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "missioncontrol", name = "Mission Control", version = "0.2.0")
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
		Config.configure(event);
		this.inventoryLink=new InventoryLink(Config.inventoryLink);

		this.selectiveInventoryLink=new SelectiveInventoryLink(Config.selectiveInventoryLink);

		this.proximityInventoryLink=new ProximityInventoryLink(Config.proximityInventoryLink);

		this.focusedInventoryLink=new FocusedInventoryLink(Config.focusedInventoryLink);

		this.enderInventoryLink=new EnderInventoryLink(Config.enderInventoryLink);

		this.outputInventoryLink=new OutputInventoryLink(Config.outputInventoryLink);

		this.inputInventoryLink=new InputInventoryLink(Config.inputInventoryLink);

		this.deathInventoryLink=new DeathInventoryLink(Config.deathInventoryLink);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabMissionControl", "Mission Control");
		
		GameRegistry.addShapedRecipe(new ItemStack(inventoryLink), "xyx","yzy","xyx",'x',new ItemStack(Item.ingotIron),'y',new ItemStack(Item.redstone),'z',new ItemStack(Block.hopperBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(selectiveInventoryLink), new ItemStack(inventoryLink),new ItemStack(Block.glass));
		GameRegistry.addShapelessRecipe(new ItemStack(focusedInventoryLink), new ItemStack(inventoryLink),new ItemStack(Item.flint));
		GameRegistry.addShapelessRecipe(new ItemStack(proximityInventoryLink), new ItemStack(inventoryLink),new ItemStack(Block.pressurePlateStone));
		GameRegistry.addShapelessRecipe(new ItemStack(selectiveInventoryLink), new ItemStack(inventoryLink),new ItemStack(Block.glass));
		GameRegistry.addShapelessRecipe(new ItemStack(selectiveInventoryLink), new ItemStack(inventoryLink),new ItemStack(Block.glass));
		GameRegistry.addShapelessRecipe(new ItemStack(selectiveInventoryLink), new ItemStack(inventoryLink),new ItemStack(Block.glass));
		GameRegistry.addShapelessRecipe(new ItemStack(selectiveInventoryLink), new ItemStack(inventoryLink),new ItemStack(Block.glass));
		
	}
	
}
