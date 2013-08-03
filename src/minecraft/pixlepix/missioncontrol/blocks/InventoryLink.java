package pixlepix.missioncontrol.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import pixlepix.missioncontrol.common.helper.MissionControlTab;
import pixlepix.missioncontrol.common.tile.InventoryLinkTileEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class InventoryLink extends Block {

	public InventoryLink(int par1) {
		super(par1, Material.anvil);

        this.setHardness(0.5F);
        this.setStepSound(Block.soundAnvilFootstep);
        this.setUnlocalizedName("Inventory Link");
        this.setCreativeTab(MissionControlTab.instance);
        LanguageRegistry.addName(this, "Inventory Link");
        MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 3);

        GameRegistry.registerBlock(this, "Inventory Link");
        GameRegistry.registerTileEntity(InventoryLinkTileEntity.class, "Inventory Link");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {

		blockIcon = par1IconRegister.registerIcon("missioncontrol:InventoryLink");
	}
	@Override
	public TileEntity createTileEntity(World var1, int metadata) {
		
		return new InventoryLinkTileEntity();

	}
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	@Override
	public boolean onBlockActivated(World world, int x,int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9){
		if(!world.isRemote&&world.getBlockTileEntity(x, y, z)!=null&&world.getBlockTileEntity(x, y, z) instanceof InventoryLinkTileEntity){
			InventoryLinkTileEntity tile=(InventoryLinkTileEntity) world.getBlockTileEntity(x, y, z);
			tile.player=par5EntityPlayer.getEntityName();
			par5EntityPlayer.addChatMessage("\u00a7b"+"Linked your inventory to this block.");

			par5EntityPlayer.addChatMessage("\u00a7b"+"This can be dangerous.");
		}
		return true;
	}
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		TileEntity tile = par1World.getBlockTileEntity(x, y, z);

		if (tile instanceof InventoryLinkTileEntity)
		{
			InventoryLinkTileEntity tileEntity = (InventoryLinkTileEntity) tile;
			if (tileEntity.player!=null &&par1World.getPlayerEntityByName(tileEntity.player)!=null)
			{
				 int l = par1World.getBlockMetadata(par2, par3, par4);
		            float f = (float)par2 + 0.5F;
		            float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
		            float f2 = (float)par4 + 0.5F;
		            float f3 = 0.52F;
		            float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

		            if (l == 4)
		            {
		                par1World.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
		                par1World.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
		            }
		            else if (l == 5)
		            {
		                par1World.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
		                par1World.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
		            }
		            else if (l == 2)
		            {
		                par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
		                par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
		            }
		            else if (l == 3)
		            {
		                par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
		                par1World.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
		            }
			}
		}
	}
	

}
