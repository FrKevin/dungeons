package entity.monster;

import entity.Monster;
import room.Room;

public class Spider extends Monster{
	
	public Spider(Room room){
		this(room, 16, 2);
	}
	
	public Spider(Room room, int healthPoints, int damage){
		super(room, healthPoints, "Spider", damage);
	}
	
	@Override
	public void entityDropItem() {
		
	}
	
}
