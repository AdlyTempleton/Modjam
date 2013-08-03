package pixlepix.missioncontrol.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ProximityInventoryLinkTileEntity extends InventoryLinkTileEntity implements IInventory {
	public EntityPlayer getPlayer(){
		return worldObj.getClosestPlayer(xCoord, yCoord, zCoord, 10);
	}
	@Override
	public int getSizeInventory() {
		if(worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord)){
			return 0;
		}
		return 31;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		
		
		EntityPlayer entityPlayer=getPlayer();
		if(entityPlayer==null){
			return null;
		}
		return entityPlayer.inventory.getStackInSlot(i);
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		
		EntityPlayer entityPlayer=getPlayer();
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
		
		
		
		EntityPlayer entityPlayer=getPlayer();
		if(entityPlayer==null){
			return;
		}
		entityPlayer.inventory.setInventorySlotContents(i, itemstack);
	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return "Proximity Inventory Link";
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
		
		
		EntityPlayer entityPlayer=getPlayer();
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

}
