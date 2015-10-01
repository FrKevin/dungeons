package room.impl;

import room.Room;

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
