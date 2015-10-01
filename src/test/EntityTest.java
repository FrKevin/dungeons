package test;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Entity;
import entity.Player;

public class EntityTest {

	@Test
	public void testEntity() {
		Entity e = new Player(20, "test");
		assertTrue(e.getHealthPoints()== 20);
		assertTrue(e.getName().compareTo("test") == 0);
	}

	@Test
	public void testClone() {
		Entity e = new Player(20, "test");
		
		Entity clone = e.clone();
		e.setHealthPoints(10);
		assertTrue(clone.getHealthPoints()== 20);
		assertTrue(clone.getName().compareTo("test") == 0);
	}

	@Test
	public void testSetHealthPoints() {
		Entity e = new Player(20, "test");
		
		e.setHealthPoints(50);
		assertTrue(e.getHealthPoints()== 50);
	}

	@Test
	public void testDeath() {
		Entity e = new Player(20, "test");
		
		e.setHealthPoints(-50);
		assertTrue(e.death());
	}
}
