package dungeons;

import java.util.Scanner;

import Player.Player;
import manager.CommandeManager;
import rooms.Room;

public class Dungeon {
	
	protected Room currentRoom;
	
	public Dungeon(Room currentRoom){
		this.currentRoom = currentRoom;
	}
	
	public void run(){
		currentRoom.event(Main.player);
		Main.commandeManager.interpretCommand();
	}
	
	public boolean isExit() {
		return currentRoom.isExit();
	}
	
	public Room getCurrentRoom(){
		return currentRoom;
	}
	
	public void setCurrentRoom(Room room){
		this.currentRoom = room;
	}
}
