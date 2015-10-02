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
	
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		Heal heal = (Heal) obj;
		return (this.life == heal.life);
	}
}
