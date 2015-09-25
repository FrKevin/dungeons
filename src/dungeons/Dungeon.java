package dungeons;

import java.util.Scanner;

import entity.Player;
import rooms.Room;

public class Dungeon {
	
	protected Room currentRoom;
	protected Player player;
	protected boolean gameIsFinished;
	protected final Scanner scanner;
	
	public Dungeon(Player player, Room currentRoom){
		this.player = player;
		this.currentRoom = currentRoom;
		this.gameIsFinished = false;
		this.scanner = new Scanner(System.in);
	}
	
	public boolean checkArgument(String string){
		boolean b = string.length() == 0;
		if( b ){
			System.out.println("Missing one argument !");
		}
		return b;
	}
	
	public void goDirection(String string){
		if( !checkArgument(string) ){
			currentRoom = currentRoom.getRoom(string);
			System.out.println("Your are in the "+ currentRoom);
		}
	}
	
	public void show(String string){
		if( !checkArgument(string) ){
			if(string.compareTo("room") == 0)
				System.out.println(currentRoom.showExit());
			else 
				noCommandFound();
		}
	}
	
	public void use(){
		
	}
	
	public void noCommandFound(){
		System.out.println("Error no command found");
	}
	
	public void interpretCommand(){
		System.out.println("What do you do ?");
		System.out.print("> ");
		StringBuffer commandBuffer = new StringBuffer(scanner.nextLine().toLowerCase());
		if(commandBuffer.indexOf("go") != -1){
			goDirection(commandBuffer.delete (0, 3).toString());
		}
		else if(commandBuffer.indexOf("use") != -1){
			
		}
		else if(commandBuffer.indexOf("show") != -1){
			 show(commandBuffer.delete (0, 5).toString());
		}
		else{
			noCommandFound();
		}
	}
	
	public void isFinished(){
		gameIsFinished = currentRoom.isExit() || player.death();
	}
	
	public void start(){
		System.out.println("You are in "+ currentRoom);
		do{
			interpretCommand();
			currentRoom.event(player);
			isFinished();
		}while(gameIsFinished == false);
		System.out.println("========== FIN ==========");
	}
}
