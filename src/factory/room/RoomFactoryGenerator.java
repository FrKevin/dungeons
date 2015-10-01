package factory.room;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Entity;
import entity.geninfo.EntityGenerationDetails;
import factory.AbstractRoomFactory;
import room.Room;
import room.impl.BasicRoom;

public class RoomFactoryGenerator extends AbstractRoomFactory {
	protected int maxRoom;
	protected int nbRoomCreated;
	
	protected List<EntityGenerationDetails> entitiesGenerationDetails;
	
	protected Map<String, Map<String, Entity>> entities;
	
	public RoomFactoryGenerator(int maxRoom) {
		this.maxRoom = maxRoom;
		this.nbRoomCreated = 1;
	}
	
	public Room createRoom() {
		Room room = new BasicRoom();
		entities = new HashMap<>();
		entitiesGenerationDetails = new ArrayList<>();
		
		for(int i = 0; i < entitiesGenerationDetails.size(); i++) {
			Map<String, Entity> tmp;
			if((tmp = entities.get(entitiesGenerationDetails.get(i).getClassName())) == null) {
				tmp = new HashMap<String, Entity>();
				entities.put(
					entitiesGenerationDetails.get(i).getClassName(), 
					tmp
				);
			}
			
			while(!entitiesGenerationDetails.get(i).isGenerationFinished()) {	
				Entity entity = entitiesGenerationDetails.get(i).generateNewEntity();
				tmp.put(
					entity.getClass().getSimpleName()+
					entitiesGenerationDetails.get(i).getGenCount(), 
					entity
				);
			}
		}
		return room;
	}
		
	public Map<String, Map<String, Entity>> getEntities() {
		return entities;
	}
	
}
