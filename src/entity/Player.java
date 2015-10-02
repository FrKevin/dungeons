package entity;

import item.Container;
import item.weapons.Sword;

public class Player extends Entity{
	protected int score;
	protected Sword arms;
	protected Container inventory;
	
	public Player(String name){
		this(20, name);
	}
	/**
	 * 
	 * @param healthPoints
	 * 		the life for the Entity
	 * @param name
	 * 		the name of Entity
	 */
	public Player(int healthPoints, String name){
		super(healthPoints, name);
		this.score = 0;
		arms = new Sword("wooden_sword", 60, 5);
		inventory = new Container();
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public Sword getArms() {
		return arms;
	}
	public void attack(Entity entity){
		arms.use(entity);
	}
	
	public String showInventory(){
		return inventory.toString();
	}
	
	public String toString(){
		return "Player " + name +", The inventory contains:\n\t" + inventory +"\n Your arms is: \n"+ arms; 
	}
	public Container getInventory() {
		return inventory;
	}
}
