package item.weapons;

import entity.Entity;
import item.ItemWithDurability;

public class Sword extends ItemWithDurability{
	private double damage;

	public Sword(String name, int durability, double damage) {
		super(name, durability);
		this.damage = damage;
	}
	
	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}
	
	@Override
	public void use(Entity entity){
		entity.setHealthPoints(entity.getHealthPoints() - damage);
	}

	@Override
	public String toString() {
		return "The sword have name " + name + ", \n\t + " + damage + " damage";
	}	
}
