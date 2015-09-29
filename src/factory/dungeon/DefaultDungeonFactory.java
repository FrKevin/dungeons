package factory.dungeon;

import java.util.Random;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

import factory.AbstractDungeonFactory;
import factory.AbstractRoomFactory;
import room.Room;
import room.impl.BasicRoom;
import room.impl.EnterRoom;
import room.impl.ExitRoom;
import room.impl.TrapRoom;

public class DefaultDungeonFactory extends AbstractDungeonFactory{

    private static final Random RAND = new Random();
	private final AbstractRoomFactory abstractFactory;
	private final int numberOfRooms = 10;
	
	public DefaultDungeonFactory(AbstractRoomFactory abstractFactory){
		this.abstractFactory = abstractFactory;
	}

	@Override
	public Room create() {
		/*Room rooms = new EnterRoom();
		rooms.setRoom("north", new BasicRoom());	
		rooms.getRoom("north").setRoom("west", new TrapRoom());
		rooms.getRoom("north").setRoom("north", new ExitRoom());
		return rooms;*/
		return null; //TO DO
	}
	
	
}
