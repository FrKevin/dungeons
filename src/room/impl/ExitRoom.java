package room.impl;

import entity.Player;
import room.Room;
import room.RoomType;
import room.geninfo.RoomGenInfo;

public class ExitRoom extends Room{

	public ExitRoom(RoomType type) {
		super(type);
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
