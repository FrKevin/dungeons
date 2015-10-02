package room.impl;

import room.Room;
import room.RoomType;
import room.geninfo.RoomGenInfo;

public class EnterRoom extends Room{

	public EnterRoom(RoomType type) {
		super(type);
	}

	@Override
	public String toString() {
		return " entrance room.";
	}

	@Override
	public boolean canEnter() {
		return true;
	}
}
