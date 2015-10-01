package room.impl;

import room.Room;

public class ExitRoom extends Room{

	public ExitRoom() {
		
	}

	@Override
	public String toString() {
		return "final room.";
	}

	@Override
	public boolean canEnter() {
		return true;
	}
	@Override
	public boolean isExit(){
		return true;
	}
}
