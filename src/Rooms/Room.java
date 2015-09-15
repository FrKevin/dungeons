package rooms;

import java.util.HashMap;

public abstract class Room {
	protected HashMap<String, Room> rooms = new HashMap<>();
	
	
	public Room interpretCommand(StringBuffer stringBuffer){
		if( rooms.containsKey(stringBuffer.toString())){
			System.out.println(rooms.get(stringBuffer.toString()));
			return rooms.get(stringBuffer.toString());
		}
		return this;
	}
	
	public String printAllExit(){
		return rooms.toString();
	}
	
	public abstract String toString();
	
	public abstract boolean canEnert();
	
	public void setRoom(String direction, Room room){
		rooms.put(direction, room);
	}
	
	public Room getRoom(String direction){
		return rooms.get(direction);
	}
}
