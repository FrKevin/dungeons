package rooms;

import java.util.HashMap;

public abstract class Room {
	protected HashMap<String, Room> rooms = new HashMap<>();
	
	
	public Room interpretCommand(StringBuffer stringBuffer){
		return this;
	}
	
	public void printAllExit(){
		System.out.println(rooms.toString());
	}
	
	public abstract String toString();
}
