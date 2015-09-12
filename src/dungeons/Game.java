package dungeons;

public class Game {
	protected Dungeon dungeon;
	protected Player player; 
	
	public  Game(Dungeon dungeon){
		this.dungeon = dungeon;
	}
	
	public void run(){
		System.out.println("Welcome to the dungeon !");
		dungeon.start();
	}
}
