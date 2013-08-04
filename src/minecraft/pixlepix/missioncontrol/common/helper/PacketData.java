package pixlepix.missioncontrol.common.helper;

import net.minecraft.entity.item.EntityItem;

public class PacketData {
	EntityItem entity;
	double endX;
	double endY;
	double endZ;
	double startX;
	double startY;
	double startZ;
	double speed;
	boolean headingDown;
	
	public PacketData(EntityItem entity, double endX, double endY, double endZ) {
		this.entity=entity;
		this.endX=endX;
		this.endY=endY;
		this.endZ=endZ;
		this.startX=entity.posX;

		this.startY=entity.posY;

		this.startZ=entity.posZ;
		
	}
	
	
	
	public double calculateDistance(double x1,double y1,double z1,double x2,double y2, double z2){
    	return (double)Math.sqrt(Math.pow(x1-x2, 2)+(Math.pow(y1-y2, 2))+(Math.pow(z1-z2, 2)));
    	
    }
}
