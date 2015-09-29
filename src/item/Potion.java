package item;

import entity.Player;
import item.potion.Effect;

public class Potion extends Item{
	public Effect effect;
	
	public Potion(String name, Effect effect) {
		super(name);
		this.effect = effect;
	}
	
	public void use(Player player){
		effect.effect(player);
	}

	@Override
	public String toString() {
		return "The potion has name " + name;
	}
}
