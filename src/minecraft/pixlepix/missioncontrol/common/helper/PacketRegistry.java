package pixlepix.missioncontrol.common.helper;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class PacketRegistry implements ITickHandler {

	
	
	
	public static ArrayList<PacketData> packets=new ArrayList();
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		Iterator<PacketData> iter=packets.iterator();
		while(iter.hasNext()){
			PacketData currentPacket=iter.next();

			currentPacket.entity.delayBeforeCanPickup=1000;
			
			currentPacket.entity.motionX= (currentPacket.entity.posX-currentPacket.endX)/-160;

			currentPacket.entity.motionY= (currentPacket.entity.posY-currentPacket.endY)/-160;
			currentPacket.entity.motionZ= (currentPacket.entity.posZ-currentPacket.endZ)/-160;
			currentPacket.entity.fallDistance=0;
			
			if(calculateDistance(currentPacket.endX,currentPacket.endY,currentPacket.endZ,currentPacket.entity.posX,currentPacket.entity.posY,currentPacket.entity.posZ)<2){
				currentPacket.entity.setDead();
				iter.remove();
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {

		return EnumSet.of(TickType.WORLD);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Packet Registry";
	}
	
	public double calculateDistance(double x1,double y1,double z1,double x2,double y2, double z2){
    	return (double)Math.sqrt(Math.pow(x1-x2, 2)+(Math.pow(y1-y2, 2))+(Math.pow(z1-z2, 2)));
    	
    }

}
