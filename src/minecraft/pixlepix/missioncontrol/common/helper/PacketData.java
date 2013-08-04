package pixlepix.missioncontrol.common.helper;

import net.minecraft.entity.item.EntityItem;

public class PacketData {
	EntityItem entity;
	double endX;
	double endY;
	double endZ;
	float speed;
	boolean headingDown;
	
	public PacketData(EntityItem entity, double endX, double endY, double endZ);
	
	
	
	public float calculateDistance(float x1,float y1,float z1,float x2,float y2, float z2){
    	return (float)Math.sqrt(Math.pow(x1-x2, 2)+(Math.pow(y1-y2, 2))+(Math.pow(z1-z2, 2)));
    	
    }
}
