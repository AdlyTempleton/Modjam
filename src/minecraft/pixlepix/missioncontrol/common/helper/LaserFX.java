package pixlepix.missioncontrol.common.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.lwjgl.util.Color;

public class LaserFX extends EntityFX {

	double movX = 0.0D;
    double movY = 0.0D;
    double movZ = 0.0D;

    private float length = 0.0F;
    private float rotYaw = 0.0F;
    private float rotPitch = 0.0F;
    private float prevYaw = 0.0F;
    private float prevPitch = 0.0F;
    private float targetX;
    private float targetY;
    private float targetZ;
    private float endModifier = 1.0F;
    private boolean reverse = false;
    private boolean pulse = false;
    private int rotationSpeed = 20;
    private float prevSize = 0.0F;
    private float beamD = 0.08f;
    private String texture;
    
    
    public float calculateDistance(float x1,float y1,float z1,float x2,float y2, float z2){
    	return (float)Math.sqrt(Math.pow(x1-x2, 2))+(Math.pow(y1-y2, 2))+(Math.pow(z1-z2, 2));
    	
    }
    
    public LaserFX(World world, float startX,float startY, float startZ, float endX, float endY, float endZ, Color color, String texture, int age)
    {
        super(world, startX, startY, startY, 0.0D, 0.0D, 0.0D);

        this.setRGB(color.getRed(), color.getGreen(), color.getBlue());

        this.texture = texture;

        this.setSize(0.02F, 0.02F);
        this.noClip = true;
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.targetX = endX;
        this.targetY= endY;
        this.targetZ=endZ;
        float xd = (float) (this.posX - this.targetX);
        float yd = (float) (this.posY - this.targetY);
        float zd = (float) (this.posZ - this.targetZ);
        this.length = (float) new Vector3(this).distanceTo(this.target);
        double var7 = MathHelper.sqrt_double(xd * xd + zd * zd);
        this.rotYaw = ((float) (Math.atan2(xd, zd) * 180.0D / 3.141592653589793D));
        this.rotPitch = ((float) (Math.atan2(yd, var7) * 180.0D / 3.141592653589793D));
        this.prevYaw = this.rotYaw;
        this.prevPitch = this.rotPitch;

        this.particleMaxAge = age;

        /** Sets the particle age based on distance. */
        EntityLivingBase renderentity = Minecraft.getMinecraft().renderViewEntity;
        int visibleDistance = 50;

        if (!Minecraft.getMinecraft().gameSettings.fancyGraphics)
        {
            visibleDistance = 25;
        }
        if (renderentity.getDistance(this.posX, this.posY, this.posZ) > visibleDistance)
        {
            this.particleMaxAge = 0;
        }
    }
    
    @Override
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        this.prevYaw = this.rotYaw;
        this.prevPitch = this.rotPitch;

        float xd = (float) (this.posX - this.targetX);
        float yd = (float) (this.posY - this.targetY);
        float zd = (float) (this.posZ - this.targetZ);

        this.length = MathHelper.sqrt_float(xd * xd + yd * yd + zd * zd);

        double var7 = MathHelper.sqrt_double(xd * xd + zd * zd);

        this.rotYaw = ((float) (Math.atan2(xd, zd) * 180.0D / 3.141592653589793D));
        this.rotPitch = ((float) (Math.atan2(yd, var7) * 180.0D / 3.141592653589793D));

        if (this.particleAge++ >= this.particleMaxAge)
        {
            setDead();
        }
    }

    public void setRGB(float r, float g, float b)
    {
        this.particleRed = r;
        this.particleGreen = g;
        this.particleBlue = b;
    }
	
	
}
