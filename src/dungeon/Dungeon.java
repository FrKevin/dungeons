package dungeon;

import java.util.Map.Entry;

import main.Game;
import main.Main;
import other.Door;
import other.Way;
import room.Room;

public class Dungeon {
	
	protected int nbRoom;
	protected Room currentRoom;
	
	protected Room firstRoom;

	protected Entry<Way, Door> exitDoor;
	
	public Dungeon(int nbRoom, Room firstRoom, Entry<Way, Door> exitDoor) {
		this.nbRoom = nbRoom;
		this.firstRoom = firstRoom;
		this.exitDoor = exitDoor;
		this.currentRoom = firstRoom;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public int getNbRoom() {
		return nbRoom;
	}
	
	public void run(){
		currentRoom.event(Game.getPlayer());
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
	
	public Room getFirstRoom() {
		return firstRoom;
	}
}
