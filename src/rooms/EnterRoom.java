package rooms;

import Player.Player;

public class EnterRoom extends Room{

	@Override
	public String toString() {
		return " entrance room.";
	}

	@Override
	public boolean canEnter() {
		return true;
	}

	@Override
	public void event(Player player) {}

}