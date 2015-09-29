package entity;

import room.Room;

public abstract class Entity implements Cloneable {
	protected double healthPoints;
	protected String name;

	protected Room room;
	
	public Entity(Room room, int healthPoints, String name) {
		this.room = room;
		this.healthPoints = healthPoints;
		this.name = name;
	}
	
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
	
	public void setHealthPoints(double d){
		this.healthPoints = d;
	}
	
	public boolean death(){
		return healthPoints <= 0;
	}
}
