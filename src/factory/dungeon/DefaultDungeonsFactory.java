package factory.dungeon;

import java.util.Random;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

import factory.AbstractDungeonFactory;
import factory.AbstractRoomFactory;
import rooms.BasicRoom;
import rooms.EnterRoom;
import rooms.ExitRoom;
import rooms.Room;
import rooms.TrapRoom;

public class DefaultDungeonsFactory extends AbstractDungeonFactory{

    private static final Random RAND = new Random();
	private final AbstractRoomFactory abstractFactory;
	private final int numberOfRooms = 10;
	
	public DefaultDungeonsFactory(AbstractRoomFactory abstractFactory){
		this.abstractFactory = abstractFactory;
	}

	@Override
	public Room create() {
		Room rooms = new EnterRoom();
		rooms.setRoom("north", new BasicRoom());	
		rooms.getRoom("north").setRoom("west", new TrapRoom());
		rooms.getRoom("north").setRoom("north", new ExitRoom());
		return rooms;
	}
	
	
}
