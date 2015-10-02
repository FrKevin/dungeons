package item;

import entity.Entity;

public class Container {
	protected ItemStack[] container;
	protected int size;
	protected int indexLastInsertItem;
	
	public Container(){
		this(10);
	}
	
	public Container(int sizeOfContainer){
		this.size = sizeOfContainer;
		this.indexLastInsertItem = 0;
		container = new ItemStack[this.size];
	}
	
	public int contains(Item item){
		for(int i=0; i<container.length && container[i] != null; i++){
			if(container[i].getItem().equals(item)){
				return i;
			}
		}
		return -1;
	}
	
	public void add(Item item){
		int contain = contains(item);
		if(contain == -1 && indexLastInsertItem == this.size){
			System.out.println("The container is full");
			return;
		}
		if(contain == -1){
			try {
				container[indexLastInsertItem] = new ItemStack(item);
				indexLastInsertItem++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			container[contain].add(item);
		}
	}
	
	public void use(Item item, Entity entity){
		int contain = contains(item);
		if(contain == -1){
			System.out.println("You can not use this item");
			return;
		}
		container[contain].use(entity);
	}
	
	public String toString(){
		return "The inventory contains:\n\t "+ container.toString();
	}

	public int getSize() {
		return size;
	}

	public ItemStack[] getContainer() {
		return container;
	}

	public int getIndexLastInsertItem() {
		return indexLastInsertItem;
	}
	
}
