package entity;

public abstract class Entity {
	protected double healthPoints;
	protected String name;

	public Entity(int healthPoints, String name){
		this.healthPoints = healthPoints;
		this.name = name;
	}
	
	public double getHealthPoints(){
		return healthPoints;
	}
	
	public void setHealthPoints(double healthPoints){
		this.healthPoints = healthPoints;
	}
	
	public boolean death(){
		return healthPoints <= 0;
	}
}
