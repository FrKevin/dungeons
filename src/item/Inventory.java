package item;

import java.util.ArrayList;

public class Inventory {
	protected ArrayList<ItemStack> inventory;
	
	public Inventory(){
		inventory = new ArrayList<>();
	}
	
	public boolean contains(){
		return true;
	}
	
	public void add(){
		
	}
	
	public void use(int index){
		inventory.get(index).use();
	}
	
	public String toString(){
		return "The inventory contains:\n\t "+ inventory.toString();
	}
}
