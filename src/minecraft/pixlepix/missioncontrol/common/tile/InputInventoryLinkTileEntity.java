package pixlepix.missioncontrol.common.tile;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.item.ItemTossEvent;

public class InputInventoryLinkTileEntity extends TileEntity {
	public String player;
	
	public InputInventoryLinkTileEntity(){
		MinecraftForge.EVENT_BUS.register(this);
	}
	public void dropItem(ItemStack item){
		worldObj.spawnEntityInWorld(new EntityItem(worldObj,xCoord+0.5,yCoord+2.5,zCoord+0.5,item));
	}
	@ForgeSubscribe
	public void onDrop(ItemTossEvent e){
		if(e.player.username.equals(player)){
			ItemStack stack=e.entityItem.getEntityItem();
			e.setCanceled(true);
			dropItem(stack);
		}
	}
}
