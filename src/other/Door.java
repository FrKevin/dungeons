package other;

import room.Room;

/**
 * The door is connect of two room
 */
public class Door {
	
	protected Room[] rooms;
	
	protected boolean visible;
	protected boolean opened;
	
	/*public Door() {}*/
	/**
	 * Init Door
	 * @param room
	 * @param newRoom
	 */
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

	/**
	 * Get the adjacent room
	 * @param room
	 */
	public Room getAdjacentRoom(Room room) {
		if(room == rooms[0]) {
			return rooms[1];
		}
		return rooms[0];
	}
	
	/**
	 * The door is correct linked ?
	 * @return boolean
	 */
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

	public Room[] getRooms() {
		return rooms;
	}
	
	
}
