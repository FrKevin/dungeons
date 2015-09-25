package dungeons;

import manager.CommandeManager;
import Player.Player;

public class Game {
	protected final Dungeon dungeon;
	protected final Player player; 
	protected final CommandeManager commandManager;
	
	public  Game(Dungeon dungeon, Player player){
		this.dungeon = dungeon;
		this.player = player;
		this.commandManager = new CommandeManager();
	}
	
	public void run(){
		System.out.println("Welcome to the dungeon !");
		while(!isFinished()){
			dungeon.run();
		}
	}
	
	public boolean isFinished(){
		return dungeon.isExit() || player.death();
	}
}
