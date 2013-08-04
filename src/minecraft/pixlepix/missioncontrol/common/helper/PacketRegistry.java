package pixlepix.missioncontrol.common.helper;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class PacketRegistry implements ITickHandler {

	
	
	
	ArrayList<PacketData> packets;
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		Iterator<PacketData> iter=packets.iterator();
		while(iter.hasNext()){
			PacketData currentPacket=iter.next();
			
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

}
