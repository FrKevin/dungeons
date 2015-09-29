package entity;

import room.Room;

public abstract class Monster extends Entity{
	private String [] drop;
	private int damage;
	
	public Monster(int healthPoints, String name, int damage) {
		super(healthPoints, name);
		this.damage = damage;
	}
	
	public abstract void entityDropItem();
	
	public void attackEntity(Entity entity){
		entity.setHealthPoints(entity.getHealthPoints() - damage);
	}
	
	public String toString(){
		return "Monster "+ name;
	}
}
