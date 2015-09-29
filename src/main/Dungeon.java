package main;

import java.util.Scanner;

import manager.CommandeManager;
import player.Player;
import room.Room;

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
