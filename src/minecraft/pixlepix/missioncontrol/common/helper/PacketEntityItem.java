package pixlepix.missioncontrol.common.helper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemExpireEvent;

public class PacketEntityItem extends EntityItem {

	public PacketEntityItem(World par1World, double par2, double par4,
			double par6, ItemStack par8ItemStack) {
		super(par1World, par2, par4, par6, par8ItemStack);
	}
	public void onUpdate()
    {
	ItemStack stack = this.getDataWatcher().getWatchableObjectItemStack(10);
    if (stack != null && stack.getItem() != null)
    {
        if (stack.getItem().onEntityItemUpdate(this))
        {
            return;
        }
    }

    super.onUpdate();

    

    this.prevPosX = this.posX;
    this.prevPosY = this.posY;
    this.prevPosZ = this.posZ;
    this.noClip = this.pushOutOfBlocks(this.posX, (this.boundingBox.minY + this.boundingBox.maxY) / 2.0D, this.posZ);
    this.moveEntity(this.motionX, this.motionY, this.motionZ);
    boolean flag = (int)this.prevPosX != (int)this.posX || (int)this.prevPosY != (int)this.posY || (int)this.prevPosZ != (int)this.posZ;

    if (flag || this.ticksExisted % 25 == 0)
    {
        if (this.worldObj.getBlockMaterial(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) == Material.lava)
        {
            this.motionY = 0.20000000298023224D;
            this.motionX = (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
            this.motionZ = (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
            this.playSound("random.fizz", 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
        }

       
    }

    

    
    ++this.age;

    ItemStack item = getDataWatcher().getWatchableObjectItemStack(10);

    if (!this.worldObj.isRemote && this.age >= lifespan)
    {
        if (item != null)
        {   
            ItemExpireEvent event = new ItemExpireEvent(this, (item.getItem() == null ? 6000 : item.getItem().getEntityLifespan(item, worldObj)));
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                lifespan += event.extraLife;
            }
            else
            {
                this.setDead();
            }
        }
        else
        {
            this.setDead();
        }
    }

    if (item != null && item.stackSize <= 0)
    {
        this.setDead();
    }
}

	
}
