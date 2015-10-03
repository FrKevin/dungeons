package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;
import room.RoomType;
import room.impl.BasicRoom;
import room.impl.EnterRoom;
import room.impl.ExitRoom;

public class DungeonTest {
	public Dungeon dungeon;
	
	@Before
	public void init(){
		dungeon = new Dungeon(10, new EnterRoom(RoomType.MAIN_ROOM), null);
	}
	
	@Test
	public void testDungeon() {
		assertTrue( dungeon.getCurrentRoom().toString().compareTo(" entrance room.") == 0);
		assertTrue(dungeon.getNbRoom() == 10);
	}

	@Test
	public void testGetCurrentRoom() {
		assertTrue( dungeon.getCurrentRoom().toString().compareTo(" entrance room.") == 0);
		dungeon.setCurrentRoom(new BasicRoom(RoomType.MAIN_ROOM));
		assertTrue( dungeon.getCurrentRoom().toString().compareTo("Basic room") == 0);
	}

	@Test
	public void testIsExit() {
		assertFalse(dungeon.isExit());
		dungeon.setCurrentRoom(new ExitRoom(RoomType.MAIN_ROOM));
		assertTrue(dungeon.isExit());
	}
}
