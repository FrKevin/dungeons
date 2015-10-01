package factory;

import other.Door;
import room.Room;

public abstract class AbstractDoorFactory {

	protected float hiddenDoorChance = 0.5f;
	protected float lockedDoorChance = 0.5f;
	
	public abstract Door createDoor(Room room, Room newRoom);
	
}
