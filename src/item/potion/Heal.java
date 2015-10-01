package item.potion;

import entity.Entity;

public class Heal implements Effect{
	protected int life;
	
	public Heal(int life){
		this.life = life;
	}
	
	@Override
	public void effect(Entity entity) {
		entity.setHealthPoints(entity.getHealthPoints() + life);
	}

}
