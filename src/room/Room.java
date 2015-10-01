package room;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import entity.Monster;
import entity.Player;
import main.Main;
import other.Door;
import other.Way;

public abstract class Room {
	public boolean haveMonster;
	public Monster monster;
	
	protected Map<Way, Door> doors;
	
	public Room() {
		doors = new HashMap<>();
	}
	
	public Map<Way, Door> getDoors() {
		return doors;
	}
	
	public void setDoor(Way way, Door door) {
		doors.put(way, door);
	}
	
	public String showExit(){
		String issue = "\nThere are " + doors.size() + " output(s).\n";
		if(doors.size() == 1){
			issue = "\nThere is an output\n";
		}
		
		for(Way w: doors.keySet()){
			issue += "\t"+w.toString()+"\n";
		}
		return issue;
	}
	
	public void eventMonster(Player player){
		System.out.println("=========== Attack ==========");
		while(!player.death() && !monster.death() ){
			// your turn 
			Main.commandManager.interpretCommandAttack(monster);
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
	
	public Door checkExist(String str){
		
		for(Entry<Way, Door> entry : doors.entrySet()) {
			if(entry.getKey().toString().toLowerCase().equals(str))
				return entry.getValue();
		}
		System.out.println("No exit for this direction");
		return null;
	}
	
	public Room getRoom(String string){
		Door door;
		if((door = checkExist(string)) != null) {
			return door.getAdjacentRoom(this);
		}
		return this;
	}
	
	public void setMonster(Monster monster){
		this.monster = monster;
		this.haveMonster = true;
	}
}
