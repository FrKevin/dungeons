package dungeons;

import Player.Player;
import rooms.Room;
import factory.DefaultRoomFactory;
import factory.LinearDungeonsFactory;
import manager.CommandeManager;

public class Main {
	public static Dungeon dungeon;
	public static CommandeManager commandeManager;
	public static Player player;
	
	public static void main(String[] args) {
		LinearDungeonsFactory factoryDungeons = new LinearDungeonsFactory(new DefaultRoomFactory(), 5);
		Room room = factoryDungeons.create();
		
		commandeManager = new CommandeManager();
		dungeon = new Dungeon(room);
		player = new Player("Kevin");
		
		Game game = new Game(dungeon, player);
		//Clear memory
		factoryDungeons = null;
		game.run();
	}	
}
