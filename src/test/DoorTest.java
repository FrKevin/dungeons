package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import other.Door;
import room.Room;
import room.impl.BasicRoom;
import room.impl.ExitRoom;

public class DoorTest {
	public Door door;
	public Door d;
	public Room basic;
	
	@Before
	public void init(){
		door = new Door();
		basic = new BasicRoom();
		d = new Door(basic, new ExitRoom());
	}
	
	@Test
	public void testDoor() {
		assertTrue(door.getRooms() == null );
	}
	
	@Test
	public void testDoorRoomRoom() {
		assertFalse(d.getRooms() == null );
		assertFalse(d.getRooms()[0] == null );
		assertFalse(d.getRooms()[1] == null );
	}

	@Test
	public void testGetAdjacentRoom() {
		Room tmp = d.getAdjacentRoom(new ExitRoom());
		assertTrue( tmp.toString().compareTo("Basic room") == 0);
		tmp = d.getAdjacentRoom(basic);
		assertTrue(tmp.toString().compareTo("final room.") == 0);
	}
}
