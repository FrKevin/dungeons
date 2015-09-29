package rooms;

import java.util.HashMap;

import entity.Monster;
import Player.Player;
import dungeons.Main;

public abstract class Room {
	protected HashMap<String, Room> rooms = new HashMap<>();
	
	public boolean haveMonster;
	public Monster monster;
	
	public String showExit(){
		String issue = "\nThere are " + rooms.size() + " output(s).\n";
		if(rooms.size() == 1){
			issue = "\nThere is an output\n";
		}
		
		for(String s: rooms.keySet()){
			issue += "\t"+s+"\n";
		}
		return issue;
	}
	
	public void eventMonster(Player player){
		System.out.println("=========== Attack ==========");
		while(!player.death() && !monster.death() ){
			// your turn 
			Main.commandeManager.interpretCommandAttack(monster);
			// Monster turn
			monster.attackEntity(player);
		}
		System.out.println("=============================");
	}
	
	public void event(Player player){
		if(haveMonster){
			eventMonster(player);
			haveMonster= false;
		}
	}
	
	public abstract String toString();
	
	public abstract boolean canEnter();
	
	public boolean isExit(){
		return false;
	}
	
	public void setRoom(String direction, Room room){
		rooms.put(direction, room);
	}
	
	public boolean checkExist(String string){
		if(!rooms.containsKey(string)){
			System.out.println("No exit for this direction");
			return false;
		}
		return true;	
	}
	
	public Room getRoom(String string){
		if(checkExist(string)){
			return rooms.get(string);
		}
		return this;
	}
	
	public void setMonster(Monster monster){
		this.monster = monster;
		this.haveMonster = true;
	}
}
