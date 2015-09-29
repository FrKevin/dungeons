package room.geninfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import other.Way;
import other.Utils;
import room.RoomType;

public class OptionalRoomGenInfo extends RoomGenInfo {

	public OptionalRoomGenInfo(int maxRoom) {
		super(maxRoom, RoomType.OPTIONAL_ROOM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<Way, RoomGenInfo> createWays(Way previousWay) {
		if(isGenerationFinished())
			return new HashMap<Way, RoomGenInfo>();
		
		Way reverseWay = Utils.reverseWay(previousWay);
		
		List<Way> waysList = new ArrayList<>();
		
		Way[] tmp = Way.values();
		for(int i = 0; i < tmp.length; i++) {
			if(tmp[i] != reverseWay)
				waysList.add(tmp[i]);
		}
		
		adjustRemainingRooms(waysList);
		rndWays(waysList);
		
		Map<Way, RoomGenInfo> ways = new HashMap<>();
		for(int i = 0; i < waysList.size(); i++) {
			ways.put(waysList.get(i), this);
			nbRoomCreated++;
		}
		
		return ways;
	}

}
