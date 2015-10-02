package main;

import dungeon.Dungeon;
import dungeon_map.Map;
import dungeon_map.Window;
import entity.Player;
import factory.AbstractDungeonFactory;
import factory.dungeon.DungeonFactoryGenerator;

public class Game {
	protected Dungeon dungeon;
	protected Dungeon tmpDungeon;
	protected static Player player = null; 
	
	protected final Map map;
	
	protected final AbstractDungeonFactory dungeonFactory;
	
	public  Game() {
	/**
	 * Init Game:
	 * @param dungeon
	 * @param player
	 */
		
		dungeonFactory = new DungeonFactoryGenerator(50);
		
		dungeon = dungeonFactory.create();
		Game.player = new Player("Kevin");
		
		map = new Map(this);
		new Window(400, 400, this);
	}
	
	public void run(){	
		System.out.println("Welcome to the dungeon !");
		while(!isFinished()){
			dungeon.run();
			
	        if(map.isRoomChanged()) {
	        	/*if(dungeonFactory.getExitDoor() != null && map.getLastRoom() 
	        			== dungeonFactory.getExitDoor().getValue().getAdjacentRoom(null))
	        		tmpDungeon = dungeonFactory.create();*/
	        	
	        	if(dungeonFactory.getExitDoor() != null) {
	        		 if(dungeon.getCurrentRoom() == dungeon.getExitDoor().getValue().getAdjacentRoom(null))
	 	        		tmpDungeon = dungeonFactory.create();
	        		 else if(tmpDungeon != null && dungeon.getCurrentRoom() == tmpDungeon.getFirstRoom()) {
	        			 dungeon = tmpDungeon;
	        			 tmpDungeon = null;
	        		 }
	        	}
	        	
	        	map.repaint();
	        }
	        System.out.println(dungeon);
	        
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
	
	public Dungeon getDungeon() {
		return dungeon;
	}
	
	public Map getMap() {
		return map;
	}
	
	public AbstractDungeonFactory getDungeonFactory() {
		return dungeonFactory;
	}
	
	public static Player getPlayer() {
		return player;
	}
}
