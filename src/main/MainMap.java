package main;

import dungeon.Dungeon;
import dungeon_map.Map;
import dungeon_map.Window;
import factory.AbstractDungeonFactory;
import factory.dungeon.GeneratorDungeonFactory;

public class MainMap {

	public static void main(String[] args) {
		AbstractDungeonFactory factoryDungeons = new GeneratorDungeonFactory(50);
		Dungeon dungeon = factoryDungeons.create();
		
		Map map = new Map(dungeon);
		new Window(400, 400, dungeon, map);
	}
}
