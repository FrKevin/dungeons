package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import entity.monster.Spider;
import other.Door;
import other.Way;
import room.impl.BasicRoom;
import room.impl.ExitRoom;

public class BasicRoomTest {
	public BasicRoom room;
	
	@Before
	public void init(){
		room = new BasicRoom();
	}
	
	@Test
	public void testBasicRoom() {
		BasicRoom room2 = new BasicRoom();
		assertTrue(room2.getDoors() != null);
		assertTrue(room2.getDoors().size() == 0);
		assertTrue(room2.getMonster() == null);
	}
	
	@Test
	public void testSetMonster() {
		assertFalse( room.isHaveMonster());
		room.setMonster(new Spider());
		assertTrue(room.isHaveMonster());
		assertTrue(room.getMonster() != null);
	}
	
	@Test
	public void testSetDoor() {
		assertFalse(room.getDoors().size() == 1);
		room.setDoor(Way.NORTH, new Door());
		assertTrue(room.getDoors().size() == 1);
	}

	@Test
	public void testIsExit() {
		assertFalse( room.isExit());
		ExitRoom exit = new ExitRoom();
		assertTrue( exit.isExit());
	}

	@Test
	public void testCheckExist() {
		assertTrue( room.checkExist("north") == null);
		room.setDoor(Way.NORTH, new Door());
		assertFalse(room.checkExist("north") == null);
	}
}
