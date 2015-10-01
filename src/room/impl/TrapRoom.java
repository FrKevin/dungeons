package room.impl;

import entity.Player;
import room.Room;

public class TrapRoom extends Room{

	public TrapRoom() {
		
	}

	@Override
	public String toString() {
		return "Trap Room";
	}

	@Override
	public boolean canEnter() {
		return true;
	}

	@Override
	public void event(Player player) {}


}
