package main;

import dungeon.Dungeon;
import entity.Player;

public class Game {
	protected final Dungeon dungeon;
	protected final Player player; 
	
	public  Game(Dungeon dungeon, Player player){
		this.dungeon = dungeon;
		this.player = player;
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
