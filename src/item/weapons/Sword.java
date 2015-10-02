package item.weapons;

import entity.Entity;
import item.Item;
import item.ItemWithDurability;

public class Sword extends ItemWithDurability{
	private double damage;

	public Sword(String name){
		this(name, 1, 1);
	}
	
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
	
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		Sword sword = (Sword) obj;
		return (this.name.compareTo(sword.name) == 0 && this.damage == sword.damage && this.durability == sword.durability);
	}
}
