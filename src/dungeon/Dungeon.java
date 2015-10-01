package dungeon;

import main.Main;
import room.Room;

public class Dungeon {
	
	protected int nbRoom;
	protected Room currentRoom;
	
	public Dungeon(int nbRoom, Room currentRoom) {
		this.nbRoom = nbRoom;
		this.currentRoom = currentRoom;
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
}
