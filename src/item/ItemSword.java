package item;

import entity.Entity;

public class ItemSword extends Item{
	private int damage;
	
	public ItemSword(String name, int durability, int damage) {
		super(name, durability);
		this.damage = damage;
	}
	
	public void attackEntity(Entity entity){
		entity.setHealthPoints(entity.getHealthPoints() - damage);
	}
}
