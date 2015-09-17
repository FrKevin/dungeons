package rooms;

import java.util.HashMap;

public abstract class Room {
	protected HashMap<String, Room> rooms = new HashMap<>();
	
	public String showIssue(){
		return rooms.toString();
	}
	
	public abstract String toString();
	
	public abstract boolean canEnert();
	
	public void setRoom(String direction, Room room){
		rooms.put(direction, room);
	}
	
	public Room getRoom(String string){
		if( rooms.containsKey(string)){
			return rooms.get(string);
		}
		return this;
	}
}
