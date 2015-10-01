package item;

import entity.Entity;
import item.potion.Effect;

public class Potion extends Item{
	public Effect effect;
	
	public Potion(String name, Effect effect) {
		super(name);
		this.effect = effect;
	}
	
	@Override
	public void use(Entity entity){
		effect.effect(entity);
	}

	@Override
	public String toString() {
		return "The potion has name " + name;
	}
}
