package dungeons;

import java.util.Scanner;

import rooms.Room;

public class Dungeon {
	
	protected Room currentRoom;
	protected Player player;
	protected boolean gameIsFinished;
	protected final Scanner scanner;
	
	public Dungeon(Player player, Room currentRoom){
		this.player = player;
		this.currentRoom = currentRoom;
		this.gameIsFinished = gameIsFinished;
		this.scanner = new Scanner(System.in);
	}
	
	public void goDirection(String string){
		currentRoom = currentRoom.getRoom(string);
	}
	
	public void show(StringBuffer stringBuffer){
		System.out.println(stringBuffer);
		currentRoom.showIssue();
	}
	
	public void use(){
		
	}
	
	public void interpretCommand(){
		System.out.println("What do you do ?");
		System.out.print("> ");
		StringBuffer commandBuffer = new StringBuffer(scanner.nextLine().toLowerCase());
		if(commandBuffer.indexOf("go ") != -1){
			goDirection(commandBuffer.delete (0, 3).toString());
		}
		else if(commandBuffer.indexOf("use ") != -1){
			
		}
		else if(commandBuffer.indexOf("show ") != -1){
			show(commandBuffer.delete (0, 5));
		}
		else{
			System.out.println("Error no command found");
		}
	}
	
	public void start(){
		do{
			System.out.println("You are in "+ currentRoom);
			interpretCommand();
		}while(gameIsFinished == false);
	}
}
