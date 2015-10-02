package room.impl;

import room.Room;
import room.RoomType;
import room.geninfo.RoomGenInfo;

public class BasicRoom extends Room{

	public BasicRoom(RoomType roomType) {
		super(roomType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Basic room";
	}

	@Override
	public boolean canEnter() {
		return true;
	}
}
