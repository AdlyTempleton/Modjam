package pixlepix.missioncontrol.common.tile;

import ibxm.Player;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.common.network.PacketDispatcher;

public class InventoryLinkTileEntity extends TileEntity implements IInventory {
	public String player;
	@Override
	public int getSizeInventory() {
		
		return 31;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		if(player==null){
			return null;
		}
		
		EntityPlayer entityPlayer=worldObj.getPlayerEntityByName(player);
		if(entityPlayer==null){
			return null;
		}
		return entityPlayer.inventory.getStackInSlot(i);
	}
	@Override
	public void updateEntity(){
		if (this.worldObj.getTotalWorldTime() % 3 == 0)
		{
			
			
			Object[] players=this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord-20, yCoord-20, zCoord-20, xCoord+20, yCoord+20, zCoord+20)).toArray();
			
			for (Object player : players)
			{
				
				PacketDispatcher.sendPacketToPlayer(getDescriptionPacket(), (Player) player);
			}
		}
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if(player==null){
			return null;
		}
		
		EntityPlayer entityPlayer=worldObj.getPlayerEntityByName(player);
		if(entityPlayer==null){
			return null;
		}

		return entityPlayer.inventory.decrStackSize(i, j);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		
		if(player==null){
			return;
		}
		
		EntityPlayer entityPlayer=worldObj.getPlayerEntityByName(player);
		if(entityPlayer==null){
			return;
		}
		entityPlayer.inventory.setInventorySlotContents(i, itemstack);
	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return "Inventory Link";
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void onInventoryChanged() {
		if(player==null){
			return;
		}
		
		EntityPlayer entityPlayer=worldObj.getPlayerEntityByName(player);
		if(entityPlayer==null){
			return;
		}
		entityPlayer.inventory.onInventoryChanged();
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return true;
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
