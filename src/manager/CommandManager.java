package manager;

import java.util.Scanner;

import entity.Monster;
import main.Main;

/**
 * All command is here
 * You can:
 * 		go
 * 		show 
 * 		use
 */
public class CommandManager {
	protected final Scanner scanner;
	
	public CommandManager(){
		this.scanner = new Scanner(System.in);
	}
	/**
	 * Check if have a parameter
	 * @param string:
	 * 		the command
	 * @return Boolean
	 */
	public boolean checkArgument(String string){
		boolean b = string.length() == 0;
		if( b ){
			System.out.println("Missing one argument !");
		}
		return b;
	}
	
	/**
	 * The string are present in the command .?
	 * @param commandBuffer:
	 * 		The command
	 * @param string
	 * @return boolean
	 */
	public boolean containsString(StringBuffer commandBuffer, String string){
		return commandBuffer.indexOf(string) != -1;
	}
	
	/**
	 * Go command
	 * @param commandBuffer 
	 * 		The command
	 * @return boolean
	 */
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
	
	/**
	 * Show command
	 * @param commandBuffer
	 * 		The command
	 * @return boolean
	 */
	public boolean show(StringBuffer commandBuffer){
		if(containsString(commandBuffer, "show")){
			commandBuffer.delete (0, 5);
			if( !checkArgument(commandBuffer.toString()) ){
				if(commandBuffer.toString().compareTo("room") == 0)
					System.out.println(Main.dungeon.getCurrentRoom().showExit());
				if(commandBuffer.toString().compareTo("inventory") == 0)
					System.out.println(Main.player.showInventory());
				else{
					noCommandFound();
					return false;
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * use command
	 * @param commandBuffer
	 * 		The command
	 * @return boolean
	 */
	public boolean use(StringBuffer commandBuffer){
		if(containsString(commandBuffer, "use")){
			commandBuffer.delete (0, 4);
			if( !checkArgument(commandBuffer.toString()) ){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * attack command
	 * @param commandBuffer
	 * 		The command
	 * @param monster
	 * @return boolean
	 */
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
	
	/**
	 * Interpret a command
	 */
	public void interpretCommand(){
		System.out.println("What do you do ?");
		System.out.print("> ");
		StringBuffer commandBuffer = new StringBuffer(scanner.nextLine().toLowerCase());
		boolean commandeFound = goDirection(commandBuffer) || use(commandBuffer) || show(commandBuffer);
		if(!commandeFound){
			noCommandFound();
		}
	}
	
	/**
	 * if a room have a monster event the commandManager use this
	 * @param monster
	 */
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
