package rooms;

import entity.Player;

public class EnterRoom extends Room{

	@Override
	public String toString() {
		return " entrance room.";
	}

	@Override
	public boolean canEnert() {
		return true;
	}

	@Override
	public void event(Player player) {}

}
