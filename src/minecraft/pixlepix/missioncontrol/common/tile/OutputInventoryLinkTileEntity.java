package pixlepix.missioncontrol.common.tile;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
		if(worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)){
			return;
		}
		if(e.entityPlayer.username.equals(player)){
			ItemStack stack=e.item.getEntityItem();
			e.item.setDead();
			e.setCanceled(true);
			dropItem(stack);
		}
	}
	@Override
	 public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		this.player=nbt.getString("Player");
	 }
	 @Override
	 public void writeToNBT(NBTTagCompound nbt){
		 super.writeToNBT(nbt);
		 nbt.setString("Player", player);
	 }
}
