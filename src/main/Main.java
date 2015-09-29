package main;

import dungeon.Dungeon;
import factory.AbstractDungeonFactory;
import factory.dungeon.GeneratorDungeonFactory;
import factory.dungeon.LinearDungeonFactory;
import factory.room.DefaultRoomFactory;
import manager.CommandManager;
import player.Player;
import room.Room;

public class Main {
	public static Dungeon dungeon;
	public static CommandManager commandeManager;
	public static Player player;
	
	public static void main(String[] args) {
		//LinearDungeonsFactory factoryDungeons = new LinearDungeonsFactory(new DefaultRoomFactory(), 5);
		
		AbstractDungeonFactory factoryDungeons = new GeneratorDungeonFactory();
		dungeon = factoryDungeons.create();
		
		commandeManager = new CommandManager();
		//dungeon = new Dungeon(room);
		player = new Player(dungeon.getCurrentRoom(), "Kevin");
		
		Game game = new Game(dungeon, player);
		//Clear memory
		factoryDungeons = null;
		game.run();
	}	
}
