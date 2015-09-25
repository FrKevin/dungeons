package item;

import entity.Entity;

public class ItemSword extends Item{
	private double damage;
	private int durability;

	public ItemSword(String name, int durability, double damage) {
		super(name);
		this.durability = durability;
		this.damage = damage;
	}

	public void attackEntity(Entity entity){
		entity.setHealthPoints(entity.getHealthPoints() - damage);
	}
	
	public boolean isBroken(){
		return durability == 0;
	}	
	
}
