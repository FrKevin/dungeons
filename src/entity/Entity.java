package entity;

import room.Room;

/**
 * The Entity implements Cloneable
 *
 */
public abstract class Entity implements Cloneable {
	protected double healthPoints;
	protected String name;
	/**
	 * 
	 * @param healthPoints:
	 * 		the life for the Entity
	 * @param name:
	 * 		the name of Entity
	 */
	public Entity(int healthPoints, String name) {
		this.healthPoints = healthPoints;
		this.name = name;
	}
	
	/**
	 * clone the Entity
	 * @return Entity
	 */
	public Entity clone() {
		try {
			return (Entity)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public double getHealthPoints(){
		return healthPoints;
	}
	public String getName(){
		return name;
	}
	
	public void setHealthPoints(double d){
		this.healthPoints = d;
	}
	
	public boolean death(){
		return healthPoints <= 0;
	}
}
