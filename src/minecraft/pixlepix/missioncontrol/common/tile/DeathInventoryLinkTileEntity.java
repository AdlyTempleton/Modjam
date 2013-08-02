package pixlepix.missioncontrol.common.tile;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class DeathInventoryLinkTileEntity extends TileEntity {
	public String player;
	public int timeToCollect;
	public ArrayList<EntityItem> drops;
	public DeathInventoryLinkTileEntity(){
		MinecraftForge.EVENT_BUS.register(this);
	}
	public void dropItem(ItemStack item){
		worldObj.spawnEntityInWorld(new EntityItem(worldObj,xCoord+0.5,yCoord+2.5,zCoord+0.5,item));
	}
	@ForgeSubscribe
	public void onPickup(LivingDropsEvent e){
		if(e.entity instanceof EntityPlayer&&((EntityPlayer)e.entity).username.equals(player)){
			drops=e.drops;
		}
	}
	public void updateEntity(){
		Iterator<EntityItem> iter=drops.iterator();
		while(iter.hasNext()){
			EntityItem e=iter.next();
			if(!e.isDead){
				dropItem(e.getEntityItem());
				e.setDead();
			}
		}
	}
}
