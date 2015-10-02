package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import entity.Entity;
import entity.monster.Spider;
import item.ItemStack;
import item.weapons.Sword;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class ItemStackTest {
	public ItemStack itemStack;
	public int number;
	
	@Before
	public void initValue(){
		try {
			itemStack = new ItemStack(new Sword("sword"));
			this.number = itemStack.getNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testItemStackItem() {
		try {
			ItemStack stack = new ItemStack(new Sword("sword"));
			assertTrue(stack.getNumber() == 1);
			assertTrue(stack.getItem().getName().compareTo("sword") == 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(expected= Exception.class)
	public void testItemStackIntItem() throws Exception {
		ItemStack stack = new ItemStack(-1, new Sword("sword"));
	}

	@Test
	public void testCanUse() {
		assertTrue(itemStack.canUse());
		itemStack.setNumber(0);
		assertFalse(itemStack.canUse());
	}

	@Test
	public void testUse() {
		Entity e = new Spider();
		itemStack.use(e);
		assertFalse(itemStack.canUse());
	}

	@Test
	public void testAdd() {
		itemStack.add(new Sword("sword"));
		assertTrue(itemStack.getNumber() == (number+1));
		itemStack.add(new Sword("sword2"));
		assertTrue(itemStack.getNumber() == (number+1));
	}
}
