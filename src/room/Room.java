package room;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import entity.Entity;
import entity.Monster;
import entity.Player;
import factory.room.RoomFactoryGenerator;
import main.Main;
import other.Door;
import other.Way;
import room.geninfo.RoomGenInfo;

public abstract class Room {
	//protected HashMap<String, Room> rooms = new HashMap<>();
	
	public boolean haveMonster;
	public Monster monster;
	
	protected Map<String, Map<String, Entity>> entities;
	protected Map<Way, Door> doors;
	
	protected RoomGenInfo roomGenInfo;
	
	public Room(RoomGenInfo roomGenInfo) {
		this.roomGenInfo = roomGenInfo;
		doors = new HashMap<>();
	}
	
	public void init(RoomFactoryGenerator roomFactory) {
		
		this.entities = roomFactory.getEntities();
	};
	
	public RoomGenInfo getRoomGenInfo() {
		return roomGenInfo;
	}
	
	public Map<String, Map<String, Entity>> getEntities() {
		return entities;
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
	
	/*public void setRoom(String direction, Room room){
		rooms.put(direction, room);
	}*/
	
	public Door checkExist(String str){
		
		for(Entry<Way, Door> entry : doors.entrySet()) {
			if(entry.getKey().toString().equals(str))
				return entry.getValue();
		}
		System.out.println("No exit for this direction");
		return null;
	}
	
	public Room getRoom(String string){
		Door door;
		if((door = checkExist(string.toUpperCase())) != null)
			return door.getAdjacentRoom(this);
		return this;
	}
	
	public void setMonster(Monster monster){
		this.monster = monster;
		this.haveMonster = true;
	}
}
