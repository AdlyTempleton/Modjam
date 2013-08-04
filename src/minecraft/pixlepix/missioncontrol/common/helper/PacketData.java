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
	int ticks;
	public PacketData(EntityItem entity, double endX, double endY, double endZ) {
		this.entity=entity;
		this.endX=endX;
		this.endY=endY;
		this.endZ=endZ;

		entity.boundingBox.setBounds(0, 0,0,0,0,0);
		this.startX=entity.posX;

		this.startY=entity.posY;

		this.startZ=entity.posZ;
		
		
	}
	
	
	
	
}
