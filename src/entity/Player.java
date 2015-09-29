package entity;

import item.Items;
import item.weapons.Sword;

public class Player extends Entity{
	protected int score;
	protected Sword sword;
	
	public Player(String name){
		this(20, name);
		sword = Items.wooden_sword;
	}
	
	public Player(int healthPoints, String name){
		super(healthPoints, name);
		this.score = 0;
	}
	
	public void attack(Entity entity){
		sword.attackEntity(entity);
	}
	
	public String toString(){
		return "Plyer " + name; 
	}
}
