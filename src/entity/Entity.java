package entity;

public abstract class Entity {
	protected int healthPoints;
	protected String name;

	public Entity(int healthPoints, String name){
		this.healthPoints = healthPoints;
		this.name = name;
	}
	
	public int getHealthPoints(){
		return healthPoints;
	}
	
	public void setHealthPoints(int healthPoints){
		this.healthPoints = healthPoints;
	}
	
	public boolean death(){
		return healthPoints <= 0;
	}
}
