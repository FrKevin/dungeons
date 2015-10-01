package item.potion;

import entity.Entity;
import entity.Player;

public class Poison implements Effect{
	
	protected int dammage;
	
	public Poison(int dammage){
		this.dammage = dammage;
	}
	
	@Override
	public void effect(Entity entity) {
		entity.setHealthPoints(entity.getHealthPoints() - dammage);
	}
}
