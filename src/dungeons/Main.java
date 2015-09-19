package dungeons;

import rooms.Room;
import entity.Player;
import factory.DefaultRoomFactory;
import factory.LinearDungeonsFactory;

public class Main {
	public static void main(String[] args) {
		LinearDungeonsFactory factoryDungeons = new LinearDungeonsFactory(new DefaultRoomFactory(), 5);
		Room r = factoryDungeons.create();
		
		Player player = new Player("Kevin");
		Game game = new Game(new Dungeon(player, r ));
		//Clear memory
		factoryDungeons = null;
		game.run();
	}
}
