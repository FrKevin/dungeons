package factory.room;

import entity.monster.Spider;
import factory.AbstractRoomFactory;
import rooms.BasicRoom;
import rooms.ExitRoom;
import rooms.Room;

public class DefaultRoomFactory extends AbstractRoomFactory{

	@Override
	public Room createRoom() {
		return new BasicRoom();
	}

}
