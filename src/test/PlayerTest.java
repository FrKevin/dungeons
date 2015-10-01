package test;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Player;

public class PlayerTest {
	
	
	@Test
	public void testPlayerString() {
		Player p = new Player("test");
		
		assertTrue(p.getHealthPoints() == 20);
		assertTrue(p.getName().compareTo("test") == 0);
	}

	@Test
	public void testPlayerIntString() {
		Player p = new Player(50, "test");
		
		assertTrue(p.getHealthPoints() == 50);
		assertTrue(p.getName().compareTo("test") == 0);
	}

	@Test
	public void testAttack() {
		Player p1 = new Player("test1");
		Player p2 = new Player("test2");
		
		p1.attack(p2);
		assertTrue(p2.getHealthPoints() < 20);
		assertTrue(p2.getHealthPoints() == (20 - p1.getArms().getDamage()));
	}
}
