package entity.monster;

import entity.Monster;

public class Spider extends Monster{
	
	public Spider(){
		this(16, 2);
	}
	
	public Spider(int healthPoints, int damage){
		super(healthPoints, "Spider", damage);
	}
	
	@Override
	public void entityDropItem() {
		
	}
	
}
