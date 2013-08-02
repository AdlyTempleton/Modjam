package pixlepix.missioncontrol.common.tile;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class OutputInventoryLinkTileEntity extends TileEntity {
	public String player;
	
	public OutputInventoryLinkTileEntity(){
		MinecraftForge.EVENT_BUS.register(this);
	}
	public void dropItem(ItemStack item){
		worldObj.spawnEntityInWorld(new EntityItem(worldObj,xCoord+0.5,yCoord+2.5,zCoord+0.5,item));
	}
	@ForgeSubscribe
	public void onPickup(EntityItemPickupEvent e){
		if(e.entityPlayer.username.equals(player)){
			ItemStack stack=e.item.getEntityItem();
			e.item.setDead();
			e.setCanceled(true);
			dropItem(stack);
		}
	}
}
