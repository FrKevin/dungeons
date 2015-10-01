package factory.room;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Entity;
import entity.geninfo.EntityGenerationDetails;
import factory.AbstractRoomFactory;
import room.Room;
import room.geninfo.RoomGenInfo;
import room.impl.BasicRoom;

public class RoomFactoryGenerator extends AbstractRoomFactory {
	
	protected int maxRoom;
	protected int nbRoomCreated;
	
	/*protected float hiddenDoorChance = 0.5f;
	protected float lockedDoorChance = 0.5f;*/
	
	protected List<EntityGenerationDetails> entitiesGenerationDetails;
	
	protected Map<String, Map<String, Entity>> entities;
	
	public RoomFactoryGenerator(int maxRoom) {
		this.maxRoom = maxRoom;
		this.nbRoomCreated = 1;
	}
	
	@Override
	public Room createRoom() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Room getNewRoom(RoomGenInfo roomGenInfo) {
		return newRoom(roomGenInfo);
	}
	
	public Room newRoom(RoomGenInfo roomGenInfo) {
		
		Room room = new BasicRoom(roomGenInfo);
		
		entities = new HashMap<>();
		
		entitiesGenerationDetails = new ArrayList<>();
		/*entitiesGenerationDetails.add(
			new EntityGenerationDetails(new Treasure(this, room), 2, 7)
		);
		entitiesGenerationDetails.add(
			new EntityGenerationDetails(new Monster(this, room), 2, 7)
		);*/
		
		for(int i = 0; i < entitiesGenerationDetails.size(); i++) {
			
			Map<String, Entity> tmp;
			if((tmp = entities.get(entitiesGenerationDetails.get(i)
					.getClassName())) == null) {
				tmp = new HashMap<String, Entity>();
				entities.put(
					entitiesGenerationDetails.get(i).getClassName(), 
					tmp
				);
			}
			
			while(!entitiesGenerationDetails.get(i).isGenerationFinished()) {
				
				Entity entity = 
						entitiesGenerationDetails.get(i).generateNewEntity();
				
				tmp.put(
					entity.getClass().getSimpleName()+
					entitiesGenerationDetails.get(i).getGenCount(), 
					entity
				);
			}
		}
		
		room.init(this);
		
		return room;
	}
	
	
	/*public float getHiddenDoorChance() {
		return hiddenDoorChance;
	}
	
	public float getLockedDoorChance() {
		return lockedDoorChance;
	}*/
	
	public Map<String, Map<String, Entity>> getEntities() {
		return entities;
	}
	
}
