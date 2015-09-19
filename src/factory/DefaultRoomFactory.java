package factory;

import entity.monster.Spider;
import rooms.BasicRoom;
import rooms.ExitRoom;
import rooms.MonsterRoom;
import rooms.Room;

public class DefaultRoomFactory implements RoomFactoryAbstract{

	@Override
	public Room createTrap() {
		
		return new MonsterRoom(new Spider());
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
