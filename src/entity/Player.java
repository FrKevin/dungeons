package entity;

public class Player extends Entity{
	private int score;
	
	public Player(String name){
		this(20, name);
	}
	
	public Player(int healthPoints, String name){
		super(healthPoints, name);
		this.score = 0;
	}
	
}
