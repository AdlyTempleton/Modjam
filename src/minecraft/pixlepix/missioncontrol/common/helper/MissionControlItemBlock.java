package pixlepix.missioncontrol.common.helper;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MissionControlItemBlock extends ItemBlock {

	
	public MissionControlItemBlock(int par1) {
		super(par1);
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

				list.add(EnumColor.ORANGE+"Allows remote access to a player's inventory");
			}
		}
	}
}
