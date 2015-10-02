package main;

import dungeon.Dungeon;
import entity.Player;
import factory.AbstractDungeonFactory;
import factory.dungeon.DungeonFactoryGenerator;
import manager.CommandManager;

public class Main {
	public static Dungeon dungeon;
	public static CommandManager commandManager;
	public static Player player;
	public static Game game;
	
	public static void main(String[] args) {
		//LinearDungeonsFactory factoryDungeons = new LinearDungeonsFactory(new DefaultRoomFactory(), 5);
		

		
		
		commandManager = new CommandManager();
		//dungeon = new Dungeon(room);
		//player = new Player("Kevin");
		
		game = new Game();
		//Game game = new Game(dungeon, player);
		//Clear memory
		//factoryDungeons = null;
		
		game.run();
	}	
}
