package main;

import dungeon.Dungeon;
import factory.AbstractDungeonFactory;
import factory.dungeon.GeneratorDungeonFactory;
import factory.dungeon.LinearDungeonFactory;
import factory.room.DefaultRoomFactory;
import manager.CommandeManager;
import player.Player;
import room.Room;

public class Main {
	public static Dungeon dungeon;
	public static CommandeManager commandeManager;
	public static Player player;
	
	public static void main(String[] args) {
		//LinearDungeonsFactory factoryDungeons = new LinearDungeonsFactory(new DefaultRoomFactory(), 5);
		
		AbstractDungeonFactory factoryDungeons = new GeneratorDungeonFactory();
		Dungeon dungeon = factoryDungeons.create();
		
		commandeManager = new CommandeManager();
		//dungeon = new Dungeon(room);
		player = new Player(dungeon.getCurrentRoom(), "Kevin");
		
		Game game = new Game(dungeon, player);
		//Clear memory
		factoryDungeons = null;
		game.run();
	}	
}
