package factory;

import java.util.Random;

import rooms.EnterRoom;
import rooms.Room;

public class DefaultDungeonsFactory implements DungeonFactoryAbstract{

    private static final Random RAND = new Random();
	private final RoomFactoryAbstract abstractFactory;
	private final int numberOfRooms = 10;
	
	public DefaultDungeonsFactory(RoomFactoryAbstract abstractFactory){
		this.abstractFactory = abstractFactory;
	}

	@Override
	public Room create() {
		Room rooms = new EnterRoom();
		String [] issues = {"up", "down", "left", "right","ascend","toto"};
		int number = 0;
		int issue = RAND.nextInt(4);
		rooms.setRoom( issues[issue], abstractFactory.createRoom());
		Room tmp = rooms.getRoom(issues[issue]);
		while( number <= numberOfRooms){
			for(int i=0; i< 6; i++){
				boolean hasIssue = issue == 5;
				if(hasIssue == true){
					boolean isTrap = RAND.nextInt(10) == 5;
					if( isTrap == true ){
						tmp.setRoom(issues[i], abstractFactory.createTrap());
					}
					else{
						System.out.println(tmp);
						tmp.setRoom(issues[i], abstractFactory.createRoom() );
					}
					tmp = tmp.getRoom(issues[i]);
				}
			}
			number++;
		}
		return rooms;
	}
	
	
}
