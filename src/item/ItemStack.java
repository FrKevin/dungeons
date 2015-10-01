package item;

import entity.Entity;

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
	
	public void use(Entity entity){
		if(!canUse()){
			return;
		}
		number--;
		item.use(entity);
	}
	
	public void add(Item item){
		if(this.item.equals(item)){
			number++;
		}
	}
	
	public Item getItem() {
		return item;
	}
}
