package main;

import dungeon.Dungeon;
import dungeon_map.Map;
import dungeon_map.Window;
import entity.Player;

public class Game {
	protected final Dungeon dungeon;
	protected final Player player; 
	
	protected final Map map;
	
	public  Game(Dungeon dungeon, Player player){
		this.dungeon = dungeon;
		this.player = player;
		
		map = new Map(dungeon);
		new Window(400, 400, dungeon, map);
	}
	
	public void run(){	
		System.out.println("Welcome to the dungeon !");
		while(!isFinished()){
			dungeon.run();
			
	        if(map.isRoomChanged()) 
	        	map.repaint();
	        try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isFinished(){
		return dungeon.isExit() || player.death();
	}
}
