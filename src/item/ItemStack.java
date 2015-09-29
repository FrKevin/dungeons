package item;

public class ItemStack {
	protected int number;
	protected Item item;
	
	public ItemStack(Item item) throws Exception{
		this(1, item);
	}
	
	public ItemStack(int number, Item item) throws Exception{
		if(number < 0 )
			throw new Exception();
		this.number = number;
		this.item = item;
	}
	
	public boolean canUse(){
		return number > 0;
	}
	
	public void use(){
		if(canUse()){
			number--;
		}
	}
	
}
