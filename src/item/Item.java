package item;

public abstract class Item {
	private String name;
	private int durability; 
	
	public Item(String name, int durability){
		this.name = name;
		this.durability = durability;
	}
	
	public boolean isBroken(){
		return durability == 0;
	}
}
