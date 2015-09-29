package room.geninfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import other.Utils;
import other.Way;
import room.RoomType;

public abstract class RoomGenInfo {
	
	protected RoomType roomType;
	
	protected int maxRoom;
	protected int nbRoomCreated;
	
	public RoomGenInfo(int maxRoom, RoomType roomType) {
		this.maxRoom = maxRoom;
		nbRoomCreated = 1;
		this.roomType = roomType;
	}
	
	public RoomType getRoomType() {
		return roomType;
	}
	
	public int getRemainingRooms(int n) {
		if(maxRoom-nbRoomCreated >= n)
			return n;
		return maxRoom-nbRoomCreated;
	}
	
	public void adjustRemainingRooms(List<Way> ways) {

		int remaining = ways.size()-getRemainingRooms(ways.size());
		
		for(int i = 0; i < remaining; i++) {
			ways.remove(Utils.rnd.nextInt(ways.size()));
		}
	}
	
	public void rndWays(List<Way> ways) {
		
		if(ways.size() == 0)
			return;
		
		int nbRnd = Utils.rnd.nextInt(ways.size());
		if(nbRnd+1 == ways.size())
			return;
		
		int c = ways.size()-(nbRnd+1);
		while(c > 0) {
			ways.remove(Utils.rnd.nextInt(ways.size()));
			c--;
		}
	}
	
	//public abstract Map<Way, RoomGenInfo> createWays();
	public abstract Map<Way, RoomGenInfo> createWays(Way previousWay);
	
	public boolean isGenerationFinished() {
		if(maxRoom-nbRoomCreated == 0)
			return true;
		return false;
	}

}
