package rooms;

import entity.Player;

public class ExitRoom extends Room{

	@Override
	public String toString() {
		return "final room.";
	}

	@Override
	public boolean canEnert() {
		return true;
	}
	@Override
	public boolean isExit(){
		return true;
	}

	@Override
	public void event(Player player) {}
}
