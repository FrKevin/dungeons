package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import entity.Entity;
import entity.monster.Spider;
import item.weapons.Sword;

public class SwordTest {
	public Sword s = new Sword("wooden_sword", 100, 50);
	
	@Test
	public void testUse() {
		Entity e = new Spider();
		double life = e.getHealthPoints();
		s.use(e);
		assertTrue(e.getHealthPoints() == (life - s.getDamage()));
	}

	@Test
	public void testSwordStringIntDouble() {
		assertTrue( s.getName().compareTo("wooden_sword") == 0);
		assertTrue(s.getDurability() == 100);
		assertTrue( s.getDamage() == 50);
	}
	
	@Test
	public void testEqualsObject() {
		Sword s2 = new Sword("wooden_sword", 100, 50);
		assertTrue( s.equals(s2));
		s2 = new Sword("wooden_sword", 100, 49);
		assertFalse( s.equals(s2));
		s2 = new Sword("wooden_sword", 99, 50);
		assertFalse( s.equals(s2));
	}
}
