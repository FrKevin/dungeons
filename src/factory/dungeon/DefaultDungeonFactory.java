package factory.dungeon;

import java.util.Random;

import dungeon.Dungeon;
import factory.AbstractDungeonFactory;
import factory.AbstractRoomFactory;

public class DefaultDungeonFactory extends AbstractDungeonFactory{

    private static final Random RAND = new Random();
	private final AbstractRoomFactory abstractFactory;
	private final int numberOfRooms = 10;
	
	public DefaultDungeonFactory(AbstractRoomFactory abstractFactory){
		this.abstractFactory = abstractFactory;
	}

	@Override
	public Dungeon create() {
		/*Room rooms = new EnterRoom();
		rooms.setRoom("north", new BasicRoom());	
		rooms.getRoom("north").setRoom("west", new TrapRoom());
		rooms.getRoom("north").setRoom("north", new ExitRoom());
		return rooms;*/
		return null; //TO DO
	}
	
	
}
