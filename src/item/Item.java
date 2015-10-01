package item;

import entity.Entity;

public abstract class Item {
	protected String name;
	
	public Item(String name){
		this.name = name;
	}
	
	public abstract String toString();
	
	public abstract void use(Entity entity);

	public String getName() {
		return name;
	}
	
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
	
}
