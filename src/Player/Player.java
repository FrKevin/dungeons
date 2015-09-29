package Player;

import java.util.ArrayList;

import entity.Entity;
import item.ItemStack;
import item.weapons.Sword;

public class Player extends Entity{
	protected int score;
	protected Sword arms;
	protected Inventory inventory;
	
	public Player(String name){
		this(20, name);
		inventory = new Inventory();
	}
	
	public Player(int healthPoints, String name){
		super(healthPoints, name);
		this.score = 0;
		arms = new Sword("wooden_sword", 60, 5);
	}
	
	public void attack(Entity entity){
		arms.attackEntity(entity);
	}
	
	public String showInventory(){
		return inventory.toString();
	}
	
	public String toString(){
		return "Player " + name +", The inventory contains:\n\t" + inventory +"\n Your arms is: \n"+ arms; 
	}
}
