package factory.dungeon;

import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import dungeon.Dungeon;
import entity.monster.Spider;
import factory.AbstractDungeonFactory;
import factory.door.DoorFactoryGenerator;
import factory.room.RoomFactoryGenerator;
import other.Door;
import other.Utils;
import other.Way;
import room.Room;
import room.geninfo.MainRoomGenInfo;
import room.geninfo.RoomGenInfo;

public class DungeonFactoryGenerator extends AbstractDungeonFactory {
	
	protected int maxRoom;
	protected int nbRoomCreated;
	
	protected RoomFactoryGenerator roomFactory;
	protected DoorFactoryGenerator doorFactory;
	private static final Random RAND = new Random();
	
	public DungeonFactoryGenerator(){
		this(20);
	}
	
	public DungeonFactoryGenerator(int maxRoom) {
		this.maxRoom = maxRoom;
	}
	
	@Override
	public Dungeon create() {
		return new Dungeon(nbRoomCreated, generateRooms());
	}
	
	public Room generateRooms() {
		nbRoomCreated = 1;
		
		roomFactory = new RoomFactoryGenerator(maxRoom);
		doorFactory = new DoorFactoryGenerator();
		
		Room firstRoom = roomFactory.createRoom();
		firstRoom.setDoor(Utils.reverseWay(Way.NORTH), new Door());
		generateRoom(Way.NORTH, firstRoom, new MainRoomGenInfo(maxRoom, Utils.reverseWay(Way.NORTH)));
		
		return firstRoom;
	}
	
	public Room generateRoom(Way previousWay, Room room, RoomGenInfo roomGeninfo) {
		Map<Way, RoomGenInfo> ways = roomGeninfo.createWays(previousWay);
			
		for(Entry<Way, RoomGenInfo> roomGenInfoEntry : ways.entrySet()) {
			Room newRoom = roomFactory.createRoom();
			Door newDoor = doorFactory.createDoor(room, newRoom);
			boolean haveMonster = ( RAND.nextInt(10) == 1);
			if(haveMonster){
				newRoom.setMonster(new Spider());
			}
			boolean havechest = ( RAND.nextInt(5) == 1);
			if(havechest){
				
			}
			room.setDoor(roomGenInfoEntry.getKey(), newDoor);
			newRoom.setDoor(Utils.reverseWay(roomGenInfoEntry.getKey()), newDoor);
			
			generateRoom(roomGenInfoEntry.getKey(), newRoom, roomGenInfoEntry.getValue());
		}
		
		return room;
	}
}
