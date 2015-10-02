package item;

import entity.Entity;

public abstract class Item {
	protected String name;
	/**
	 * Init Item
	 * @param name:
	 * 		The name of item
	 */
	public Item(String name){
		this.name = name;
	}
	
	public abstract void use(Entity entity);
	
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		Item item = (Item) obj;
		return (this.name.compareTo(item.name) == 0);
	}
	
	public abstract String toString();
	
	public String getName() {
		return name;
	}
}
