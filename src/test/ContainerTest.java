package test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import item.Container;
import item.weapons.Sword;

public class ContainerTest {
	public Container container;
	
	@Before
	public void init(){
		container = new Container();
	}
	
	@Test
	public void testContainer() {
		assertTrue(container.getSize() == 10);
		assertTrue(container != null);
		assertTrue(container.getContainer().length == 10);
	}
	
	@Test
	public void testContainerInt() {
		Container c = new Container(100);
		assertTrue(c.getSize() == 100);
		assertTrue(c != null);
		assertTrue(c.getContainer().length == 100);
	}
	
	@Test
	public void testContains() {
		assertTrue( container.contains(new Sword("wooden_sword")) == -1);
		Sword s = new Sword("wooden_sword_toto", 100, 250);
		container.add(s);
		assertTrue(container.contains(s) != -1);
	}
	
	@Test
	public void testAdd() {
		container.add(new Sword("wooden_sword"));
		assertTrue(container.getIndexLastInsertItem() ==1);
		container.add(new Sword("wooden_sword"));
		assertTrue(container.getIndexLastInsertItem() ==1);
		assertTrue(container.getContainer()[0].getNumber() == 2);
		for(int i=1; i<10; i++){
			container.add(new Sword("wooden_sword", i, i+2*5));
		}
		for(int i=1; i< 10; i++){
			assertTrue(container.getContainer()[i].getNumber() == 1);
		}
		assertTrue(container.getIndexLastInsertItem() == 10);
	}
}
