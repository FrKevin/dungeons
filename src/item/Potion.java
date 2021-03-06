package item;

import entity.Entity;
import item.potion.Effect;

public class Potion extends Item{
	public Effect effect;
	
	/**
	 * Init Potion
	 * @param name:
	 * 		The name of potion
	 * @param effect:
	 * 		The effect of potion
	 */
	public Potion(String name, Effect effect) {
		super(name);
		this.effect = effect;
	}
	
	/**
	 * Use effect of potion
	 * @param entity:
	 * 		the target
	 */
	@Override
	public void use(Entity entity){
		effect.effect(entity);
	}

	@Override
	public String toString() {
		return "The potion has name " + name;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		Potion item = (Potion) obj;
		return (this.name.compareTo(item.name) == 0 && this.effect.equals(item.effect) );
	}
}
