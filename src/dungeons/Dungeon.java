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
	
	public void goDirection(StringBuffer stringBuffer){
		currentRoom = currentRoom.interpretCommand(stringBuffer);
		System.out.println( currentRoom.printAllExit() );
	}
	
	public void use(){
		
	}
	
	public void interpretCommand(){
		System.out.println("What do you do ?");
		System.out.print("> ");
		StringBuffer commandBuffer = new StringBuffer(scanner.nextLine().toLowerCase());
		if(commandBuffer.indexOf("go ") != -1){
			goDirection(commandBuffer.delete (0, 3));
		}
		else if(commandBuffer.indexOf("use ") != -1){
			
		}
		else{
			System.out.println("Error no command found");
		}
	}
	
	public void start(){
		do{
			System.out.println( currentRoom.toString() );
			interpretCommand();
		}while(gameIsFinished == false);
	}
}
