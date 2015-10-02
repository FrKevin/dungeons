package item;

import entity.Entity;
/**
 * The ItemStack is a stack of item
 */
public class ItemStack {
	protected int number;
	protected Item item;
	
	/**
	 * Init ItemStack with one item
	 * @param item:
	 * @throws Exception
	 */
	public ItemStack(Item item) throws Exception{
		this(1, item);
	}
	
	/**
	 * Init ItemStack
	 * @param number:
	 * 		the number of item
	 * @param item
	 * @throws Exception if number < 0
	 */
	public ItemStack(int number, Item item) throws Exception{
		if(number < 0 )
			throw new Exception();
		this.number = number;
		this.item = item;
	}
	
	/**
	 * Can use the stack of item ?
	 * @return boolean 
	 */
	public boolean canUse(){
		return number > 0;
	}
	
	/**
	 * Use an item
	 * @param entity
	 */
	public void use(Entity entity){
		if(!canUse()){
			return;
		}
		number--;
		item.use(entity);
	}
	
	/**
	 * Add item in the stack of item if is equals
	 * @param item
	 */
	public void add(Item item){
		if(this.item.equals(item)){
			number++;
		}
	}
	
	public Item getItem() {
		return item;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
