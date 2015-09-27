package factory;

import entity.monster.Spider;
import rooms.BasicRoom;
import rooms.ExitRoom;
import rooms.Room;

public class DefaultRoomFactory implements RoomFactoryAbstract{

	@Override
	public Room createTrap() {
		Room room = new BasicRoom();
		room.setMonster(new Spider());
		return room;
	}

	@Override
	public Room createRoom() {
		return new BasicRoom();
	}

	@Override
	public Room createExitRoom() {
		return new ExitRoom();
	}

}
