package rooms;

import Player.Player;

public class TrapRoom extends Room{

	@Override
	public String toString() {
		return "Trap Room";
	}

	@Override
	public boolean canEnert() {
		return true;
	}

	@Override
	public void event(Player player) {}


}
