package room.impl;

import player.Player;
import room.Room;
import room.geninfo.RoomGenInfo;

public class EnterRoom extends Room{

	public EnterRoom(RoomGenInfo roomGenInfo) {
		super(roomGenInfo);
		// TODO Auto-generated constructor stub
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
