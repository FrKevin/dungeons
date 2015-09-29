package main;

import dungeon.Dungeon;
import entity.Player;
import factory.AbstractDungeonFactory;
import factory.dungeon.GeneratorDungeonFactory;
<<<<<<< HEAD
import factory.dungeon.LinearDungeonFactory;
import factory.room.DefaultRoomFactory;
import manager.CommandManager;
import player.Player;
import room.Room;
=======
import manager.CommandeManager;
>>>>>>> ac1b8243bc814f99714e263940c51127e1cbeb01

public class Main {
	public static Dungeon dungeon;
	public static CommandManager commandeManager;
	public static Player player;
	
	public static void main(String[] args) {
		//LinearDungeonsFactory factoryDungeons = new LinearDungeonsFactory(new DefaultRoomFactory(), 5);
		
<<<<<<< HEAD
		AbstractDungeonFactory factoryDungeons = new GeneratorDungeonFactory();
=======
		AbstractDungeonFactory factoryDungeons = new GeneratorDungeonFactory(50);
>>>>>>> ac1b8243bc814f99714e263940c51127e1cbeb01
		dungeon = factoryDungeons.create();
		
		commandeManager = new CommandManager();
		//dungeon = new Dungeon(room);
		player = new Player("Kevin");
		
		Game game = new Game(dungeon, player);
		//Clear memory
		factoryDungeons = null;
		game.run();
	}	
}
