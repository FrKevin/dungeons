package item.potion;

import entity.Player;

public class Poison implements Effect{
	
	protected int dammage;
	
	public Poison(int dammage){
		this.dammage = dammage;
	}
	
	@Override
	public void effect(Player player) {
		player.setHealthPoints(player.getHealthPoints() - dammage);
	}
}
