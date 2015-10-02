package item;

import entity.Entity;

public class Container {
	protected ItemStack[] container;
	protected int size;
	protected int indexLastInsertItem;
	
	/**
	 * Init Container with a default size (10)
	 */
	public Container(){
		this(10);
	}
	
	/**
	 * Init Container
	 * @param sizeOfContainer:
	 * 		the size of container
	 */
	public Container(int sizeOfContainer){
		this.size = sizeOfContainer;
		this.indexLastInsertItem = 0;
		container = new ItemStack[this.size];
	}
	
	/**
	 * The container contains an item ?
	 * @param item
	 * @return int the index of items or -1 if the item is not présent in this container
	 */
	public int contains(Item item){
		for(int i=0; i<container.length && container[i] != null; i++){
			if(container[i].getItem().equals(item)){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Add an item in the container, 
	 * if is full the container not add the item
	 * @param item
	 */
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
	
	/**
	 * Use any item present in this container
	 * @param item
	 * @param entity:
	 * 		The entity target
	 */
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
