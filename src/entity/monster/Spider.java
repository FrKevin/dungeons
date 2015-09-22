package entity.monster;

import entity.Monster;

public class Spider extends Monster{
	
	public Spider(){
		this(16, 2.5);
	}
	
	public Spider(int healthPoints, damage damage){
		super(healthPoints, "Spider", damage);
	}
	
	@Override
	public void entityDropItem() {
		
	}
	
}
