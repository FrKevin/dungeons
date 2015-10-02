package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import entity.Player;
import item.Potion;
import item.potion.Heal;

public class PotionTest {	
	@Test
	public void testHeal() {
		Player player = new Player("test");
		Potion heal = new Potion("heal", new Heal(10));
		double playerLife = player.getHealthPoints();
		
		assertTrue(heal.effect != null);
		assertTrue(heal.getName().compareTo("heal") == 0);
		heal.use(player);
		assertTrue(player.getHealthPoints() == (playerLife + 10));
	}
	
	@Test
	public void testEqualsObject() {
		Potion heal1 = new Potion("heal", new Heal(10));
		Potion heal2 = new Potion("heal", new Heal(20));
		Potion heal3 = new Potion("heal", new Heal(10));
		Potion heal4 = new Potion("Mega heal", new Heal(10));
		
		assertTrue(heal1.equals(heal3));
		assertFalse(heal1.equals(heal2));
		assertFalse(heal1.equals(heal4));
	}
}
