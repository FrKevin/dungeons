package factory.dungeon;

import java.util.Map;
import java.util.Map.Entry;

import dungeon.Dungeon;
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
	//protected Room currentRoom;
	
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
		
		Room firstRoom = roomFactory.getNewRoom(new MainRoomGenInfo(maxRoom, Utils.reverseWay(Way.NORTH)));
		firstRoom.setDoor(Utils.reverseWay(Way.NORTH), new Door());
		generateRoom(Way.NORTH, firstRoom);
		
		return firstRoom;
	}
	
	public Room generateRoom(Way previousWay, Room room) {
		
		Map<Way, RoomGenInfo> ways = room.getRoomGenInfo().createWays(previousWay);
			
		for(Entry<Way, RoomGenInfo> roomGenInfoEntry : ways.entrySet()) {
			System.out.println("gen");
			System.out.println(roomGenInfoEntry.getKey()+" info "+roomGenInfoEntry.getValue());
			Room newRoom = roomFactory.getNewRoom(roomGenInfoEntry.getValue()); // on passe roomGenInfo
			
			//Door newDoor = new Door(room, newRoom);
			Door newDoor = doorFactory.createDoor(room, newRoom);
			
			room.setDoor(roomGenInfoEntry.getKey(), newDoor);
			newRoom.setDoor(Utils.reverseWay(roomGenInfoEntry.getKey()), newDoor);
			
			generateRoom(roomGenInfoEntry.getKey(), newRoom);
		}
		
		return room;
	}
	
	/*public Room getCurrentRoom() {
		return currentRoom;
	}*/
	
}
