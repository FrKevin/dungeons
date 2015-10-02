package factory;

import java.util.Map.Entry;

import other.Door;
import other.Way;
import room.Room;

public abstract class AbstractRoomFactory {
	
	public abstract Room createRoom();
}
