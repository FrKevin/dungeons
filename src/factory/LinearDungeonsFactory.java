package factory;

import java.util.Random;

import rooms.BasicRoom;
import rooms.EnterRoom;
import rooms.ExitRoom;
import rooms.Room;

public class LinearDungeonsFactory implements DungeonFactoryAbstract{
	private final RoomFactoryAbstract abstractFactory;
	private final int numberOfRooms;
	private static final Random RAND = new Random();
	
	public LinearDungeonsFactory(RoomFactoryAbstract abstractFactory, int numberOfRooms){
		this.abstractFactory = abstractFactory;
		this.numberOfRooms = numberOfRooms;
	}
	
	@Override
	public Room create() {
		String [] issues = {"north", "south", "west", "east","up","down"};
		int index = 0; 
		Room rooms = new EnterRoom();
		int rand1 = 0;
		int rand2 = 0;
		Room tmp = rooms;
		while(index < numberOfRooms){
			rand1 = RAND.nextInt(6);
			rand2 = RAND.nextInt(6);
			while(rand2 == (rand1+1))
				rand2 = RAND.nextInt(6);
			tmp.setRoom(issues[rand1], new BasicRoom());
			tmp = tmp.getRoom(issues[rand1]);
			tmp.setRoom(issues[rand2], new BasicRoom());
			tmp = tmp.getRoom(issues[rand2]);
			index+=2;
			System.out.println("rand1="+ issues[rand1] +" et rand2 = "+ issues[rand2]);
		}
		tmp.setRoom("north", new ExitRoom());
		return rooms;
	}

}
