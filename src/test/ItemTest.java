package test;

import static org.junit.Assert.*;

import org.junit.Test;

import item.Item;
import item.weapons.Sword;

public class ItemTest {
	public Item i = new Sword("toto");
	
	@Test
	public void testItem() {
		assertTrue(i.getName().compareTo("toto") == 0);
	}

	@Test
	public void testEqualsObject() {
		Item i2 = new Sword("toto");
		assertTrue( i.equals(i2));
		i2 = new Sword("tata");
		assertFalse( i.equals(i2));
	}

}
