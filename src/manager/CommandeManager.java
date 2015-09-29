package manager;

import java.util.Scanner;

import dungeon_map.Window;
import entity.Monster;
import main.Main;

public class CommandeManager {
	protected final Scanner scanner;
	
	public CommandeManager(){
		this.scanner = new Scanner(System.in);
	}
	
	public boolean checkArgument(String string){
		boolean b = string.length() == 0;
		if( b ){
			System.out.println("Missing one argument !");
		}
		return b;
	}
	
	public boolean containsString(StringBuffer commandBuffer, String string){
		return commandBuffer.indexOf(string) != -1;
	}
	
	public boolean goDirection(StringBuffer commandBuffer){
		//check
		if(containsString(commandBuffer, "go")){
			commandBuffer.delete (0, 3);
			if( !checkArgument(commandBuffer.toString()) ){
				Main.dungeon.setCurrentRoom(Main.dungeon.getCurrentRoom().getRoom(commandBuffer.toString()));
				System.out.println("Your are in the "+ Main.dungeon.getCurrentRoom());
			}
			return true;
		}
		return false;
	}
	
	public boolean show(StringBuffer commandBuffer){
		if(containsString(commandBuffer, "show")){
			commandBuffer.delete (0, 5);
			if( !checkArgument(commandBuffer.toString()) ){
				if(commandBuffer.toString().compareTo("room") == 0)
					System.out.println(Main.dungeon.getCurrentRoom().showExit());
				if(commandBuffer.toString().compareTo("inventory") == 0)
					System.out.println(Main.player.showInventory());
				if(commandBuffer.toString().compareTo("map") == 0)
					new Window(500, 500, Main.dungeon);
				else{
					noCommandFound();
					return false;
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean use(StringBuffer commandBuffer){
		if(containsString(commandBuffer, "use")){
			commandBuffer.delete (0, 4);
			if( !checkArgument(commandBuffer.toString()) ){
				return true;
			}
		}
		return false;
	}
	
	public boolean attack(StringBuffer commandBuffer, Monster monster){
		if(containsString(commandBuffer, "attack")){
			Main.player.attack(monster);
			return true;
		}
		return false;
	}
	private void noCommandFound() {
		System.out.println("No command found !");
	}
	
	public void interpretCommand(){
		System.out.println("What do you do ?");
		System.out.print("> ");
		StringBuffer commandBuffer = new StringBuffer(scanner.nextLine().toLowerCase());
		boolean commandeFound = goDirection(commandBuffer) || use(commandBuffer) || show(commandBuffer);
		if(!commandeFound){
			noCommandFound();
		}
	}
	
	public void interpretCommandAttack(Monster monster){
		boolean commandeFound;
		do{
			System.out.println("It's your turn, What do you do ?");
			System.out.print("> ");
			StringBuffer commandBuffer = new StringBuffer(scanner.nextLine().toLowerCase());
			commandeFound = use(commandBuffer) || show(commandBuffer) || attack(commandBuffer, monster);
			if(!commandeFound){
				noCommandFound();
			}
		}while(!commandeFound);
	}
}
