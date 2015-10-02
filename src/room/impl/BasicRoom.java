package room.impl;

import room.Room;

public class BasicRoom extends Room{

	public BasicRoom() {
		super();
	}

	@Override
	public String toString() {
		return "Basic room";
	}

	@Override
	public boolean canEnter() {
		return true;
	}
}
