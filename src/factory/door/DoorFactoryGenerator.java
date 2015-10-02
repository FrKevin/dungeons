package factory.door;

import java.util.ArrayList;
import java.util.List;

import factory.AbstractDoorFactory;
import other.Button;
import other.Door;
import other.Utils;
import room.Room;

public class DoorFactoryGenerator extends AbstractDoorFactory {
	
	protected List<Button> buttons;
	
	public DoorFactoryGenerator() {
		buttons = new ArrayList<>();
	}

	@Override
	public Door createDoor(Room room, Room newRoom) {
		Door door = new Door(room, newRoom);
		
		if(Utils.rnd.nextFloat() <= lockedDoorChance) {
			door.setOpened(false);
			buttons.add(new Button(door) {
				public void swt() {
					door.setOpened(true);
				}
			});
		}
		if(Utils.rnd.nextFloat() <= hiddenDoorChance) {
			door.setVisible(false);
			buttons.add(new Button(door) {
				public void swt() {
					door.setVisible(true);
				}
			});
		}
		
		return door;
	}
	
}
