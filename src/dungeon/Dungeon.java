package dungeon;

import java.util.Map.Entry;

import main.Main;
import other.Door;
import other.Way;
import room.Room;

public class Dungeon {
	
	protected int nbRoom;
	protected Room currentRoom;
	
	protected Entry<Way, Door> exitDoor;
	
	public Dungeon(int nbRoom, Room currentRoom, Entry<Way, Door> exitDoor) {
		this.nbRoom = nbRoom;
		this.currentRoom = currentRoom;
		this.exitDoor = exitDoor;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public int getNbRoom() {
		return nbRoom;
	}
	
	public void run(){
		currentRoom.event(Main.player);
		Main.commandManager.interpretCommand();
	}
	
	public boolean isExit() {
		return currentRoom.isExit();
	}
	
	public void setCurrentRoom(Room room){
		this.currentRoom = room;
	}
	
	public Entry<Way, Door> getExitDoor() {
		return exitDoor;
	}
}
