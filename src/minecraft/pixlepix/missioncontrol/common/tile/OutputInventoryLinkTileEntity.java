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
	
	@Override
	public void invalidate(){
		MinecraftForge.EVENT_BUS.unregister(this);
	}
	public void dropItem(ItemStack item){
		worldObj.spawnEntityInWorld(new EntityItem(worldObj,xCoord+0.5,yCoord+2.5,zCoord+0.5,item));
	}
	@ForgeSubscribe
	public void onPickup(EntityItemPickupEvent e){
		System.out.println("1+"+worldObj.isRemote);
		if(worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)){

			System.out.println("2+"+worldObj.isRemote);
			return;
		}
		if(e.entityPlayer.username.equals(player)){

			System.out.println("3+"+worldObj.isRemote);
			ItemStack stack=e.item.getEntityItem();

			System.out.println("4+"+worldObj.isRemote);
			e.item.setDead();

			System.out.println("5+"+worldObj.isRemote);
			e.setCanceled(true);

			System.out.println("6+"+worldObj.isRemote);
			dropItem(stack);

			System.out.println("7+"+worldObj.isRemote);
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
