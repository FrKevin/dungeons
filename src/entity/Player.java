package entity;

import item.Items;
import item.weapons.Sword;
import room.Room;

public class Player extends Entity{
	protected int score;
	protected Sword sword;
	
	public Player(Room room, String name){
		this(room, 20, name);
		sword = Items.wooden_sword;
	}
	
	public Player(Room room, int healthPoints, String name){
		super(room, healthPoints, name);
		this.score = 0;
	}
	
	public void attack(Entity entity){
		sword.attackEntity(entity);
	}
	
	public String toString(){
		return "Plyer " + name; 
	}
}
