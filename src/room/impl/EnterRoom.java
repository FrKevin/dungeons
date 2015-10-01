package room.impl;

import entity.Player;
import room.Room;
import room.geninfo.RoomGenInfo;

public class EnterRoom extends Room{

	public EnterRoom() {
		
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
