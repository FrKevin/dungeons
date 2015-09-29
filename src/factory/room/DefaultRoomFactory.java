package factory.room;

import entity.monster.Spider;
import factory.AbstractRoomFactory;
import room.Room;
import room.impl.BasicRoom;
import room.impl.ExitRoom;

public class DefaultRoomFactory extends AbstractRoomFactory{

	@Override
	public Room createRoom() {
		//return new BasicRoom();
		return null; //TO DO
	}

}
