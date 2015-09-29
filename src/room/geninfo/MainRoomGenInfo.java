package room.geninfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import other.Config;
import other.Utils;
import other.Way;
import room.RoomType;
import room.distributor.OptionalRoomDistributor;

public class MainRoomGenInfo extends RoomGenInfo {

	protected Way mainWay;
	
	protected OptionalRoomDistributor optionalRoomDistributor;
	
	public MainRoomGenInfo(int nbRoom, Way excludeWay) {
		super(nbRoom, RoomType.MAIN_ROOM);
		do {
			mainWay = Way.values()[Utils.rnd.nextInt(Way.values().length)];
		} while(mainWay == excludeWay);
		
		optionalRoomDistributor = new OptionalRoomDistributor(nbRoom-Config.optionalRoomNb, Config.optionalRoomNb);
	}
	
	public Map<Way, RoomGenInfo> createWays(Way previousWay) {
		if(isGenerationFinished())
			return new HashMap<Way, RoomGenInfo>();
		
		Way reverseWay = Utils.reverseWay(previousWay);
		Way nextMainWay = genMainWay(reverseWay);
		
		List<Way> waysList = new ArrayList<>();
		
		int optionalRoomNb = 0;
		
		if(!optionalRoomDistributor.isGenerationFinished() && 
				optionalRoomDistributor.isRoomPop()) {
			optionalRoomNb = optionalRoomDistributor.nextRoomNumber();
			
			Way[] tmp = Way.values();
			for(int i = 0; i < tmp.length; i++) {
				if(tmp[i] != reverseWay && tmp[i] != nextMainWay)
					waysList.add(tmp[i]);
			}
		}
		nbRoomCreated++; //Don't forget to count next main way
		
		adjustRemainingRooms(waysList);
		rndWays(waysList);
		
		Map<Way, RoomGenInfo> ways = new HashMap<>();
		ways.put(nextMainWay, this);
		for(int i = 0; i < waysList.size(); i++) {
			
			int roomNb = Utils.rnd.nextInt(optionalRoomNb)+1;
			int index = Utils.rnd.nextInt(waysList.size());
			ways.put(waysList.get(index), new OptionalRoomGenInfo(roomNb));
			waysList.remove(index);
			optionalRoomNb -= roomNb;
			nbRoomCreated++; //Don't forget to count optional room creation
			
			if(optionalRoomNb == 0)
				i = waysList.size();
			
			//ways.put(waysList.get(i), new OptionalRoomGenInfo(optionalRoomNb/waysList.size()));
		}
		//nbRoomCreated += waysList.size(); //Don't forget to count optional room creation
		
		return ways;
	}
	
	public Way genMainWay(Way reverseWay) {
		//TO DO
		if(Utils.rnd.nextInt(Config.maxSide-1) == 0) {
			Way nextWay;
			do {
				nextWay = Way.values()[Utils.rnd.nextInt(Way.values().length)];
			} while(nextWay == mainWay || nextWay == reverseWay);
			mainWay = nextWay;
		}
		return mainWay;
	}
	
}
