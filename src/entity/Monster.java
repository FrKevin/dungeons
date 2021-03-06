package entity;

/**
 * The monster extends Entity, it's all hostil entity
 *
 */
public abstract class Monster extends Entity{
	private String [] drop;
	private int damage;
	
	/**
	 * Init Monster:
	 * @param healthPoints:
	 * 		the life for the Entity
	 * @param name: 
	 * 		the name of Entity
	 * @param damage:
	 * 		the damage for this entity
	 */
	public Monster(int healthPoints, String name, int damage) {
		super(healthPoints, name);
		this.damage = damage;
	}
	
	/**
	 * When the entity death, she drop many items (Not implemented)
	 */
	public abstract void entityDropItem();
	
	/**
	 * The monster can attack entity
	 * @param entity:
	 * 		The entity target
	 */
	public void attackEntity(Entity entity){
		entity.setHealthPoints(entity.getHealthPoints() - damage);
	}
	
	public String toString(){
		return "Monster "+ name;
	}
}
