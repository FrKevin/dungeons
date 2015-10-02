package dungeon;

import main.Main;
import room.Room;

public class Dungeon {
	protected int nbRoom;
	protected Room currentRoom;
	
	/**
	 * Init a dungeon
	 * @param nbRoom:
	 * 		number of room
	 * @param currentRoom: 
	 * 		The first room
	 */
	public Dungeon(int nbRoom, Room currentRoom) {
		this.nbRoom = nbRoom;
		this.currentRoom = currentRoom;
	}
	
	/**
	 * Run a one tour
	 */
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
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	public int getNbRoom() {
		return nbRoom;
	}
}
