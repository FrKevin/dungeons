package rooms;

import entity.Player;

public class BasicRoom extends Room{

	@Override
	public String toString() {
		return "Basic room";
	}

	@Override
	public boolean canEnert() {
		return true;
	}

	@Override
	public void event(Player player) {}

}
