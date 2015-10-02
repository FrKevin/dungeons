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
	protected boolean haveMonster;
	protected Monster monster;
	
	protected Map<Way, Door> doors;
	
	public Room() {
		doors = new HashMap<>();
	}
	
	/**
	 * @return String: all issue
	 */
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
	
	/**
	 * If the room have a monster the event run
	 * @param player
	 */
	public void eventMonster(Player player){
		System.out.println("=========== Attack ==========");
		while(!player.death() && !monster.death() ){
			// your turn 
			Main.commandManager.interpretCommandAttack(monster);
			// Monster turn
			System.out.println("Monster attack");
			monster.attackEntity(player);
			System.out.println("You have "+ player.getHealthPoints()+" HP");
		}
		System.out.println("=============================");
	}
	
	/**
	 * All event
	 * @param player
	 */
	public void event(Player player){
		if(haveMonster){
			eventMonster(player);
			haveMonster= false;
		}
	}
	
	public abstract String toString();
	
	public abstract boolean canEnter();
	
	/**
	 * The room is a exit room ?
	 * @return
	 */
	public boolean isExit(){
		return false;
	}
	
	/**
	 * Check the if exist a room for one direction
	 * @param str String the direction
	 * @return
	 */
	public Door checkExist(String str){
		for(Entry<Way, Door> entry : doors.entrySet()) {
			if(entry.getKey().toString().toLowerCase().equals(str))
				return entry.getValue();
		}
		System.out.println("No exit for this direction");
		return null;
	}
	
	/**
	 * Return a room (if exist) for one direction
	 * @param String the direction
	 * @return Room
	 */
	public Room getRoom(String string){
		Door door;
		if((door = checkExist(string)) != null) {
			return door.getAdjacentRoom(this);
		}
		return this;
	}
	
	/**
	 * Insert a monster in the room
	 * @param monster 
	 */
	public void setMonster(Monster monster){
		this.monster = monster;
		this.haveMonster = true;
	}

	public boolean isHaveMonster() {
		return haveMonster;
	}

	public Monster getMonster() {
		return monster;
	}
	
	public Map<Way, Door> getDoors() {
		return doors;
	}
	
	/**
	 * Connect a room 
	 * @param way, the direction
	 * @param door the door to connect room
	 */
	public void setDoor(Way way, Door door) {
		doors.put(way, door);
	}
}
