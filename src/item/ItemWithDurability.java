package item;

public abstract class ItemWithDurability extends Item{
	protected int durability;
	
	public ItemWithDurability(String name, int durability) {
		super(name);
		this.durability = durability;
	}
	
	public boolean isBroken(){
		return durability <= 0;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}
	
}
