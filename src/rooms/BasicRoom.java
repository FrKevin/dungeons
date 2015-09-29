package rooms;

import Player.Player;

public class BasicRoom extends Room{

	@Override
	public String toString() {
		return "Basic room";
	}

	@Override
	public boolean canEnter() {
		return true;
	}
}
