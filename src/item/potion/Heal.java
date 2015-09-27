package item.potion;

import entity.Player;

public class Heal implements Effect{
	protected int life;
	
	public Heal(int life){
		this.life = life;
	}
	
	@Override
	public void effect(Player player) {
		player.setHealthPoints(player.getHealthPoints() + life);
	}

}
