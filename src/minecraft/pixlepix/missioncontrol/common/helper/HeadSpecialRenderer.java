package pixlepix.missioncontrol.common.helper;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import pixlepix.missioncontrol.common.tile.DeathInventoryLinkTileEntity;
import pixlepix.missioncontrol.common.tile.InputInventoryLinkTileEntity;
import pixlepix.missioncontrol.common.tile.InventoryLinkTileEntity;
import pixlepix.missioncontrol.common.tile.OutputInventoryLinkTileEntity;

public class HeadSpecialRenderer extends TileEntitySpecialRenderer {

	
	
	 private final RenderBlocks renderBlocks = new RenderBlocks();
	 	public String getPlayerName(TileEntity entity){
	 		if(entity instanceof InventoryLinkTileEntity){
	 			return ((InventoryLinkTileEntity)entity).player;
	 		}
	 		if(entity instanceof InputInventoryLinkTileEntity){
	 			return ((InputInventoryLinkTileEntity)entity).player;
	 		}
	 		if(entity instanceof OutputInventoryLinkTileEntity){
	 			return ((OutputInventoryLinkTileEntity)entity).player;
	 		}
	 		if(entity instanceof DeathInventoryLinkTileEntity){
	 			return ((DeathInventoryLinkTileEntity)entity).player;
	 		}
	 		return null;
	 	}
	    @Override
	    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float var8)
	    {
	    	for (int side = 2; side < 6; side++)
            {
	    		ForgeDirection direction = ForgeDirection.getOrientation(side);
                if (tileCrate.worldObj.isBlockSolidOnSide(tileCrate.xCoord + direction.offsetX, tileCrate.yCoord, tileCrate.zCoord + direction.offsetZ, direction.getOpposite()))
                {
                    continue;
                }
            }
	    }
}
