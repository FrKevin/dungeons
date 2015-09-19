package rooms;

import java.util.HashMap;

public abstract class Room {
	protected HashMap<String, Room> rooms = new HashMap<>();
	
	public String showExit(){
		String issue = "Il y a " + rooms.size() + " sortie(s).\n";
		for(String s: rooms.keySet()){
			issue += "\t °"+s+"\n";
		}
		return issue;
	}
	
	public abstract String toString();
	
	public abstract boolean canEnert();
	
	public boolean isExit(){
		return false;
	}
	
	public void setRoom(String direction, Room room){
		rooms.put(direction, room);
	}
	
	public boolean checkExist(String string){
		if(!rooms.containsKey(string)){
			System.out.println("No exit for this direction");
			return false;
		}
		return true;	
	}
	
	public Room getRoom(String string){
		if(checkExist(string)){
			return rooms.get(string);
		}
		return this;
	}
}
