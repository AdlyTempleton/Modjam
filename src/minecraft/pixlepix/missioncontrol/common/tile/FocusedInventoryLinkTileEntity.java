package pixlepix.missioncontrol.common.tile;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class FocusedInventoryLinkTileEntity extends TileEntity implements IInventory {
	public String player;
	public Item target;
	@Override
	public int getSizeInventory() {
		ItemStack[] stacks=getRelaventStacks();
		if(stacks==null){
			return 0;
		}
		System.out.println(stacks);
		return getRelaventStacks().length;
	}
	public ItemStack[] getRelaventStacks(){
		if(player==null){
			return null;
		}
		
		EntityPlayer entityPlayer=worldObj.getPlayerEntityByName(player);
		if(entityPlayer==null){
			return null;
		}
		ArrayList<ItemStack> toReturn=new ArrayList<ItemStack>();
		
		for(int i=0;i<entityPlayer.inventory.getSizeInventory();i++){
			if(entityPlayer.inventory.getStackInSlot(i)!=null&&entityPlayer.inventory.getStackInSlot(i).getItem()==target){
				toReturn.add(entityPlayer.inventory.getStackInSlot(i));
			}
		}
		return toReturn.toArray(new ItemStack[1]);
	} 
	
	public int getRealStackIndex(int mirrorIndex){
		if(player==null){
			return 0;
		}
		
		EntityPlayer entityPlayer=worldObj.getPlayerEntityByName(player);
		if(entityPlayer==null){
			return 0;
		}
		int count=0;
		
		for(int i=0;i<entityPlayer.inventory.getSizeInventory();i++){
			if(entityPlayer.inventory.getStackInSlot(i)!=null&&entityPlayer.inventory.getStackInSlot(i).getItem()==target){
				count++;
			}
			if(count==mirrorIndex){
				return i;
			}
		}
		return 0;
		
	}
	@Override
	public ItemStack getStackInSlot(int i) {
		if(getRelaventStacks()!=null){
			return getRelaventStacks()[i];
		}
		return null;
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

		return entityPlayer.inventory.decrStackSize(getRealStackIndex(i), j);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemStack) {
		
		if(player==null){
			return;
		}
		
		EntityPlayer entityPlayer=worldObj.getPlayerEntityByName(player);
		if(entityPlayer==null){
			return;
		}

		entityPlayer.inventory.setInventorySlotContents(getRealStackIndex(i), itemStack);
	}

	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return "Focused Inventory Link";
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
