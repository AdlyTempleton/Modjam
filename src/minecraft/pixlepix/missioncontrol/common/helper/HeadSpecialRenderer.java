package pixlepix.missioncontrol.common.helper;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeDirection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import pixlepix.missioncontrol.common.tile.DeathInventoryLinkTileEntity;
import pixlepix.missioncontrol.common.tile.InputInventoryLinkTileEntity;
import pixlepix.missioncontrol.common.tile.InventoryLinkTileEntity;
import pixlepix.missioncontrol.common.tile.OutputInventoryLinkTileEntity;

public class HeadSpecialRenderer extends TileEntitySpecialRenderer {

	//This does nothing
	//It's a mess
	
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
	    	
	    	String username=this.getPlayerName(tileEntity);
            EntityPlayer player=tileEntity.worldObj.getPlayerEntityByName(username);
            ResourceLocation resourcelocation = AbstractClientPlayer.field_110314_b;

            if (username != null && username.length() > 0)
            {
                resourcelocation = AbstractClientPlayer.func_110305_h(username);
                AbstractClientPlayer.func_110304_a(resourcelocation, username);
            }
            
            this.func_110628_a(resourcelocation);
	    	for (int side = 2; side < 6; side++)
            {
	    		ForgeDirection direction = ForgeDirection.getOrientation(side);
                if (tileEntity.worldObj.isBlockSolidOnSide(tileEntity.xCoord + direction.offsetX, tileEntity.yCoord, tileEntity.zCoord + direction.offsetZ, direction.getOpposite()))
                {
                    continue;
                }

                GL11.glPushMatrix();
                switch (side)
                {
                    case 2:
                        GL11.glTranslated(x + 0.65, y + 0.9, z - 0.01);
                        break;
                    case 3:
                        GL11.glTranslated(x + 0.35, y + 0.9, z + 1.01);
                        GL11.glRotatef(180, 0, 1, 0);
                        break;
                    case 4:
                        GL11.glTranslated(x - 0.01, y + 0.9, z + 0.35);
                        GL11.glRotatef(90, 0, 1, 0);
                        break;
                    case 5:
                        GL11.glTranslated(x + 1.01, y + 0.9, z + 0.65);
                        GL11.glRotatef(-90, 0, 1, 0);
                        break;
                }
                float f4 = 0.0625F;
                GL11.glEnable(GL12.GL_RESCALE_NORMAL);
                GL11.glScalef(-1.0F, -1.0F, 1.0F);
                GL11.glEnable(GL11.GL_ALPHA_TEST);
                GL11.glPopMatrix();
            }
	    }
}
