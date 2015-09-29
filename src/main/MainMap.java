package main;

import dungeon.Dungeon;
import dungeon_map.Window;
import factory.AbstractDungeonFactory;
import factory.dungeon.GeneratorDungeonFactory;

public class MainMap {

	public static void main(String[] args) {
		AbstractDungeonFactory factoryDungeons = new GeneratorDungeonFactory();
		Dungeon dungeon = factoryDungeons.create();
		
		new Window(400, 400, dungeon);
	}
}
