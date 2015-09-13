package factory;

import rooms.BasicRoom;
import rooms.ExitRoom;
import rooms.Room;
import rooms.TrapRoom;

public class DefaultRoomFactory implements RoomFactoryAbstract{

	@Override
	public Room createTrap() {
		return new TrapRoom();
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
