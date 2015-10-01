package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import factory.room.RoomFactoryGenerator;
import room.Room;

public class Door {
	
	protected List<Button> buttons;
	protected Room[] rooms;
	
	protected boolean visible;
	protected boolean opened;
	
	public Door() {}
	
	public Door(Room room, Room newRoom) {
		rooms = new Room[2];
		rooms[0] = room;
		rooms[1] = newRoom;
	}
	
	
	
	public void randomGeneration(RoomFactoryGenerator roomFactory) {
		if(Utils.rnd.nextFloat() <= roomFactory.getLockedDoorChance()) {
			opened = false;
			buttons.add(new Button(this) {
				public void swt() {
					Door.this.opened = true;
				}
			});
		}
		if(Utils.rnd.nextFloat() <= roomFactory.getHiddenDoorChance()) {
			visible = false;
			buttons.add(new Button(this) {
				public void swt() {
					Door.this.visible = true;
				}
			});
		}
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
	
}
