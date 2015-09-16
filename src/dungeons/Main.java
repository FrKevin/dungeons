package dungeons;

import factory.DefaultRoomFactory;
import factory.DefaultDungeonsFactory;
import factory.LinearDungeonsFactory;
import rooms.EnterRoom;
import rooms.Room;

public class Main {
	public static void main(String[] args) {
		LinearDungeonsFactory factoryDungeons = new LinearDungeonsFactory(new DefaultRoomFactory(), 5);
		Room r = factoryDungeons.create();
		
		Player player = new Player("Kevin");
		Game game = new Game(new Dungeon(player, r ));
		game.run();
		
	}
}
