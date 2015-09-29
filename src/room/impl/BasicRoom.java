package room.impl;

import entity.Player;
import room.Room;
import room.geninfo.RoomGenInfo;

public class BasicRoom extends Room{

	public BasicRoom(RoomGenInfo roomGenInfo) {
		super(roomGenInfo);
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
