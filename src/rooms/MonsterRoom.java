package rooms;

import Player.Player;
import entity.Monster;

public class MonsterRoom extends Room{
	private Monster monster;
	
	public MonsterRoom(Monster monster){
		this.monster = monster;
	}
	
	@Override
	public void event(Player player) {
		if(event == true){
			System.out.println("=========== Attack ==========");
			while(!player.death() && !monster.death() ){
				System.out.println("HP monster "+ monster.getHealthPoints());
				System.out.println("HP player "+ player.getHealthPoints());
				player.attack(monster);
				monster.attackEntity(player);
			}
			if(player.getHealthPoints() == 0 ){
				System.out.println("HP monster "+ monster.getHealthPoints());
				System.out.println("HP player "+ player.getHealthPoints());
				System.out.println("Game Over  !");
			}
			else{
				System.out.println("win");
				System.out.println(player.getHealthPoints());
			}
			System.out.println();
			System.out.println("=============================");
		}
		else
			event = false;
	}

	@Override
	public String toString() {
		return "monster room";
	}

	@Override
	public boolean canEnter() {
		return true;
	}

}
