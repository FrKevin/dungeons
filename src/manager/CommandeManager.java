package manager;

import java.util.Scanner;

public class CommandeManager {
	protected final Scanner scanner;
	
	public CommandeManager(){
		this.scanner = new Scanner(System.in);
	}
	
	public void goDirection(String string) {
		
	}

	private void show(String string) {
		
	}
	
	private void noCommandFound() {
		
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
	
	public void interpretCommandAttack(){
		
	}
	
	public void sendmessage(){
		
	}
}
