package dungeons;

import factory.DefaultRoomFactory;
import factory.FactoryDungeons;
import rooms.EnterRoom;
import rooms.Room;

public class Main {
	public static void main(String[] args) {
		FactoryDungeons factoryDungeons = new FactoryDungeons(new DefaultRoomFactory());
		Room r = factoryDungeons.create();
		
		Player player = new Player("Kevin");
		Game game = new Game(new Dungeon(player, r));
		game.run();
		
	}
}
