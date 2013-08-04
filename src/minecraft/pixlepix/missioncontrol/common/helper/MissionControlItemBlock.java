package pixlepix.missioncontrol.common.helper;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import pixlepix.missioncontrol.common.tile.InventoryLinkTileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MissionControlItemBlock extends ItemBlock {

	
	public MissionControlItemBlock(int par1) {
		super(par1);
	}
	
	
	@Override
	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
    	boolean place = super.placeBlockAt(stack, player, world, x, y, z, side, hitX, hitY, hitZ, metadata);
    	
    	if(place)
    	{
    		
    		if(tileEntity instanceof InventoryLinkTileEntity){
    		InventoryLinkTileEntity tileEntity = (InventoryLinkTileEntity)world.getBlockTileEntity(x, y, z);
    		tileEntity.player=player.username;
    		}
    	}
    	
    	return place;
    }
	
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4){
		if(!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
		{
			list.add("Hold " + EnumColor.AQUA + "shift" + EnumColor.GREY + " for more details.");
		}
		else {
			if(par1ItemStack.itemID==Config.inventoryLink){
				list.add(EnumColor.ORANGE+"Allows remote access to a player's inventory");

				list.add(EnumColor.ORANGE+"Use pipes/hoppers to access the inventory");
			}

			if(par1ItemStack.itemID==Config.selectiveInventoryLink){
				list.add(EnumColor.ORANGE+"Accesses part of the inventory");

				list.add(EnumColor.ORANGE+"Shift click to cycle modes");
			}

			if(par1ItemStack.itemID==Config.focusedInventoryLink){
				list.add(EnumColor.ORANGE+"Accesses one item type from an inventory");

				list.add(EnumColor.ORANGE+"Left click to configura target");
			}

			if(par1ItemStack.itemID==Config.proximityInventoryLink){
				list.add(EnumColor.ORANGE+"Provides access to the nearest players inventory");

				list.add(EnumColor.ORANGE+"Ten block maximum radius");
			}

			if(par1ItemStack.itemID==Config.enderInventoryLink){
				list.add(EnumColor.ORANGE+"Provides access to the ender chest of a player");
			}
			if(par1ItemStack.itemID==Config.outputInventoryLink){
				list.add(EnumColor.ORANGE+"Collects all items a player picks up");

				list.add(EnumColor.ORANGE+"Drops items above the block");
			}
			if(par1ItemStack.itemID==Config.inputInventoryLink){
				list.add(EnumColor.ORANGE+"Collects all items a player drops");

				list.add(EnumColor.ORANGE+"Drops items above the block");
			}
			if(par1ItemStack.itemID==Config.deathInventoryLink){
				list.add(EnumColor.ORANGE+"Collects all items a player drops on death");

				list.add(EnumColor.ORANGE+"20 second wait before items are collected");

				list.add(EnumColor.ORANGE+"Drops items above the block");
			}

		}
	}
}
