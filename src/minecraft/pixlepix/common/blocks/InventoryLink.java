package pixlepix.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;
import pixlepix.common.MissionControlTab;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class InventoryLink extends Block {

	public InventoryLink(int par1) {
		super(par1, Material.anvil);

        this.setHardness(0.5F);
        this.setStepSound(Block.soundAnvilFootstep);
        this.setUnlocalizedName("Inventory Link");
        this.setCreativeTab(MissionControlTab.instance);
        LanguageRegistry.addName(this, "Inventory Link");
        MinecraftForge.setBlockHarvestLevel(this, "pickaxe", 3);
	}
	

}
