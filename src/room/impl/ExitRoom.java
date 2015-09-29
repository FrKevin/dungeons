package room.impl;

import player.Player;
import room.Room;
import room.geninfo.RoomGenInfo;

public class ExitRoom extends Room{

	public ExitRoom(RoomGenInfo roomGenInfo) {
		super(roomGenInfo);
		// TODO Auto-generated constructor stub
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
