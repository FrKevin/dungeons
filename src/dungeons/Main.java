package dungeons;

import Player.Player;
import rooms.Room;
import factory.DefaultRoomFactory;
import factory.LinearDungeonsFactory;

public class Main {
	public static void main(String[] args) {
		LinearDungeonsFactory factoryDungeons = new LinearDungeonsFactory(new DefaultRoomFactory(), 5);
		Room room = factoryDungeons.create();

		Game game = new Game(new Dungeon(room), new Player("Kevin"));
		//Clear memory
		factoryDungeons = null;
		game.run();
	}	
}
