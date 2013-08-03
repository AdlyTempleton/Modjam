package pixlepix.missioncontrol.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class SelectiveInventoryLinkTileEntity extends InventoryLinkTileEntity implements IInventory {
	public String player;
	public byte mode=0;
	@Override
	public int getSizeInventory() {
		switch(mode){
			case 0:
				return 9;
			case 1:
				return 27;
			case 2:
				return 4;
		}
		return 27;
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
		int shiftedIndex=i;
		switch(mode){
			case 0:
				break;
			case 1:
				shiftedIndex+=9;
				break;
			case 2:
				shiftedIndex+=36;
		}
		shiftedIndex=Math.max(shiftedIndex, 0);
		return entityPlayer.inventory.getStackInSlot(shiftedIndex);
				
				
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
		int shiftedIndex=i;
		switch(mode){
			case 0:
				break;
			case 1:
				shiftedIndex+=9;
				break;
			case 2:
				shiftedIndex+=36;
		}
		shiftedIndex=Math.max(shiftedIndex, 0);
		return entityPlayer.inventory.decrStackSize(shiftedIndex, j);
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
		}int shiftedIndex=i;
		switch(mode){
		case 0:
			break;
		case 1:
			shiftedIndex+=9;
			break;
		case 2:
			shiftedIndex+=36;
	}
	shiftedIndex=Math.max(shiftedIndex, 0);
		entityPlayer.inventory.setInventorySlotContents(shiftedIndex, itemstack);
	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return "Selective Inventory Link";
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

}
