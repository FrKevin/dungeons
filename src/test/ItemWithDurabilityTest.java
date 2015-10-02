package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import item.weapons.Sword;

public class ItemWithDurabilityTest {
	public Sword s = new Sword("wooden_sword");
	
	@Test
	public void testItemWithDurability() {
		assertTrue( s.getName().compareTo("wooden_sword") == 0);
		assertTrue( s.getDurability() == 1);
	}

	@Test
	public void testIsBroken() {
		assertFalse(s.isBroken());
		s.setDurability(0);
		assertTrue(s.isBroken());
	}

}
