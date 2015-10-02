package factory.dungeon;

import java.util.AbstractMap;
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
import room.RoomType;
import room.geninfo.MainRoomGenInfo;
import room.geninfo.RoomGenInfo;
import room.geninfo.RoomGenInfoWrapper;
import room.impl.BasicRoom;
import room.impl.ExitRoom;

public class DungeonFactoryGenerator extends AbstractDungeonFactory {
	
	protected int maxRoom;
	protected int nbRoomCreated;
	
	protected RoomFactoryGenerator roomFactory;
	protected DoorFactoryGenerator doorFactory;
	private static final Random RAND = new Random();
	
	protected MainRoomGenInfo mainRoomGenInfo;
	protected RoomGenInfoWrapper roomGenInfoWrapper;
	
	protected Room exitRoom;
	protected Way lastPreviousMainWay;
	protected Entry<Way, Door> exitDoor;
	
	public DungeonFactoryGenerator(){
		this(20);
	}
	
	public DungeonFactoryGenerator(int maxRoom) {
		this.maxRoom = maxRoom;
	}
	
	@Override
	public Dungeon create() {
		return new Dungeon(nbRoomCreated, generateRooms(), exitDoor);
	}
	
	public void prepareRoomGenInfo() {
		if(exitDoor == null)
			mainRoomGenInfo = new MainRoomGenInfo(4, Utils.reverseWay(Way.NORTH)); // maxRoom
		else {
			mainRoomGenInfo = new MainRoomGenInfo(4, Utils.reverseWay(exitDoor.getKey())); // maxRoom
		}
	}
	
	public Room generateRooms() {
		nbRoomCreated = 1;
		
		prepareRoomGenInfo();
		roomGenInfoWrapper = new RoomGenInfoWrapper(mainRoomGenInfo);
		roomFactory = new RoomFactoryGenerator(maxRoom, roomGenInfoWrapper);
		doorFactory = new DoorFactoryGenerator();
		
		Room firstRoom = roomFactory.createRoom();
		generateRoom(bindDungeons(firstRoom), firstRoom, mainRoomGenInfo);
		
		bindExitDoor();
		
		return firstRoom;
	}
	
	public void bindExitDoor() {
		System.out.println(" - finished");
		Way way = mainRoomGenInfo.genExitDoorWay(lastPreviousMainWay);
		Door door = new Door(exitRoom, null);
		exitRoom.setDoor(way, door);
		exitDoor = new AbstractMap.SimpleEntry<Way, Door>(way, door);
	}
	
	public Way bindDungeons(Room nextRoom) {
		if(exitDoor == null)
			nextRoom.setDoor(Utils.reverseWay(Way.NORTH), new Door());
		else {
			nextRoom.setDoor(Utils.reverseWay(exitDoor.getKey()), exitDoor.getValue());
			exitDoor.getValue().setRoomPipe(nextRoom);
			return exitDoor.getKey();
		}
		return Way.NORTH;
	}
	
	public Room generateRoom(Way previousWay, Room room, RoomGenInfo roomGeninfo) {
		//roomGenInfoWrapper.setRoomGenInfo(roomGeninfo);
		if(room.getRoomType() == RoomType.MAIN_ROOM) {
			exitRoom = room;
			lastPreviousMainWay = previousWay;
		}
		System.out.println(roomGeninfo);
		System.out.println(room.getRoomType());
		
		//Map<Way, RoomGenInfo> ways = room.getRoomGenInfo().createWays(previousWay);
		Map<Way, RoomGenInfo> ways = roomGeninfo.createWays(previousWay);
			
		for(Entry<Way, RoomGenInfo> roomGenInfoEntry : ways.entrySet()) {
			roomGenInfoWrapper.setRoomGenInfo(roomGenInfoEntry.getValue());
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
	
	public Entry<Way, Door> getExitDoor() {
		return exitDoor;
	}
	
	/*public Room getCurrentRoom() {
		return currentRoom;
	}*/
	
}
