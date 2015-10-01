package factory.door;

import java.util.ArrayList;
import java.util.List;

import factory.AbstractDoorFactory;
import factory.room.RoomFactoryGenerator;
import other.Button;
import other.Door;
import other.Utils;
import room.Room;

public class DoorFactoryGenerator extends AbstractDoorFactory {
	
	protected List<Button> buttons;
	
	public DoorFactoryGenerator() {
		buttons = new ArrayList<>();
	}
	
	/*public void randomGeneration(RoomFactoryGenerator roomFactory) {
		if(Utils.rnd.nextFloat() <= roomFactory.getLockedDoorChance()) {
			opened = false;
			buttons.add(new Button(this) {
				public void swt() {
					Door.this.opened = true;
				}
			});
		}
		if(Utils.rnd.nextFloat() <= roomFactory.getHiddenDoorChance()) {
			visible = false;
			buttons.add(new Button(this) {
				public void swt() {
					Door.this.visible = true;
				}
			});
		}
	}*/

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
