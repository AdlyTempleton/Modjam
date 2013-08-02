package pixlepix.missioncontrol.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import pixlepix.missioncontrol.common.helper.MissionControlTab;
import pixlepix.missioncontrol.common.tile.EnderInventoryLinkTileEntity;
import pixlepix.missioncontrol.common.tile.InventoryLinkTileEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EnderInventoryLink extends Block {

	public EnderInventoryLink(int par1) {
		super(par1, Material.anvil);

        this.setHardness(0.5F);
        this.setStepSound(Block.soundAnvilFootstep);
        this.setUnlocalizedName("Ender Inventory Link");
        this.setCreativeTab(MissionControlTab.instance);
        LanguageRegistry.addName(this, "Ender Inventory Link");
        MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 3);

        GameRegistry.registerBlock(this, "Ender Inventory Link");
        GameRegistry.registerTileEntity(InventoryLinkTileEntity.class, "Ender Inventory Link");
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {

		blockIcon = par1IconRegister.registerIcon("missioncontrol:EnderInventoryLink");
	}
	@Override
	public TileEntity createTileEntity(World var1, int metadata) {
		
		return new EnderInventoryLinkTileEntity();

	}
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	@Override
	public boolean onBlockActivated(World world, int x,int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9){
		if(!world.isRemote&&world.getBlockTileEntity(x, y, z)!=null&&world.getBlockTileEntity(x, y, z) instanceof EnderInventoryLinkTileEntity){
			EnderInventoryLinkTileEntity tile=(EnderInventoryLinkTileEntity) world.getBlockTileEntity(x, y, z);
			tile.player=par5EntityPlayer.getEntityName();
			par5EntityPlayer.addChatMessage("\u00a7b"+"Linked your inventory to this block.");

			par5EntityPlayer.addChatMessage("\u00a7b"+"This can be dangerous.");
		}
		return true;
	}
	

}
