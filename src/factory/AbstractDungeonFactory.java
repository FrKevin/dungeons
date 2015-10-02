package factory;

import java.util.Map.Entry;

import dungeon.Dungeon;
import other.Door;
import other.Way;

public abstract class AbstractDungeonFactory {
	
	public abstract Dungeon create();
	public abstract Entry<Way, Door> getExitDoor();
}
