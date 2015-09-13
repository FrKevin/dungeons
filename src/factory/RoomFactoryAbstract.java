package factory;

import rooms.Room;

public interface RoomFactoryAbstract {
	Room createTrap();
	Room createRoom();
	Room createExitRoom();
}
