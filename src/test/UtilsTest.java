package test;

import static org.junit.Assert.*;

import org.junit.Test;

import other.Utils;
import other.Way;

public class UtilsTest {

	@Test
	public void testReverseWay() {
		assertTrue(Utils.reverseWay(Way.NORTH) == Way.SOUTH);
		assertTrue(Utils.reverseWay(Way.EAST) == Way.WEST);
	}

	@Test
	public void testUpperRound() {
		assertTrue(Utils.upperRound(5f/2f) == 3);
		assertTrue(Utils.upperRound(1/3) == 0);
	}

}
