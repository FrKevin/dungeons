package factory.dungeon;

import java.util.Map.Entry;
import java.util.Random;

import dungeon.Dungeon;
import factory.AbstractDungeonFactory;
import factory.AbstractRoomFactory;
import other.Door;
import other.Way;

public class LinearDungeonFactory extends AbstractDungeonFactory{
	private final AbstractRoomFactory abstractFactory;
	private final int numberOfRooms;
	private static final Random RAND = new Random();
	
	public LinearDungeonFactory(AbstractRoomFactory abstractFactory, int numberOfRooms){
		this.abstractFactory = abstractFactory;
		this.numberOfRooms = numberOfRooms;
	}
	
	@Override
	public Dungeon create() {
		/*String[] issues = {"north", "south", "west", "east","up","down"};
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
			boolean trapRoom = ( RAND.nextInt(2) == 1);
			if(trapRoom)
				tmp.setRoom(issues[rand1], abstractFactory.createTrap());
			else
				tmp.setRoom(issues[rand1], abstractFactory.createRoom());
			tmp = tmp.getRoom(issues[rand1]);
			trapRoom = ( RAND.nextInt(2) == 1);
			if(trapRoom)
				tmp.setRoom(issues[rand2], abstractFactory.createTrap());
			else
				tmp.setRoom(issues[rand2], abstractFactory.createRoom());
			tmp = tmp.getRoom(issues[rand2]);
			index+=2;
			System.out.println("rand1="+ issues[rand1] +" et rand2 = "+ issues[rand2]);
		}
		tmp.setRoom("north", abstractFactory.createExitRoom());
		return rooms;*/
		return null; // TO DO
	}

	@Override
	public Entry<Way, Door> getExitDoor() {
		// TODO Auto-generated method stub
		return null;
	}

}
