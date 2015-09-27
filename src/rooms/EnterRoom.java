package rooms;

import Player.Player;

public class EnterRoom extends Room{

	@Override
	public String toString() {
		return " entrance room.";
	}

	@Override
	public boolean canEnert() {
		return true;
	}
}
