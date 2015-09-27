package item;

public abstract class ItemWithDurability extends Item{
	
	private int durability;
	
	public ItemWithDurability(String name, int durability) {
		super(name);
		this.durability = durability;
	}
	
	public boolean isBroken(){
		return durability == 0;
	}
}
