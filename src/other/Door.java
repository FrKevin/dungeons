package other;

import room.Room;

public class Door {
	
	protected Room[] rooms;
	
	protected boolean visible;
	protected boolean opened;
	
	/*public Door() {}*/
	
	public Door(Room room, Room newRoom) {
		rooms = new Room[2];
		rooms[0] = room;
		rooms[1] = newRoom;
	}
	
	public boolean setRoomPipe(Room room) {
		
		if(rooms[1] != null) {
			return false;
		} else if(rooms[0] == null) {
			rooms[0] = room;
		} else {
			rooms[1] = room;
		}
		return true;
	}
	
	public Door() {
		// TODO Auto-generated constructor stub
	}

	public Room getAdjacentRoom(Room room) {
		if(room == rooms[0]) {
			return rooms[1];
		}
		return rooms[0];
	}
	
	public boolean isLinked() {
		if(rooms[0] != null && rooms[1] != null)
			return true;
		return false;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}
	
	
}
