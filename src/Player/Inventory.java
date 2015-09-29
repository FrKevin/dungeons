package Player;

import java.util.ArrayList;

import item.ItemStack;

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
