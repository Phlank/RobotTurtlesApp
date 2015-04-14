package edu.bsu.cs222.enums;

import junit.framework.Assert;

import org.junit.Test;

public class DirectionTest {
	
	@Test
	public void testNorthLocationModifierIsMinusRow() {
		int[] expected = {-1, 0};
		Assert.assertEquals(expected[0],  Direction.NORTH.locationModifier()[0]);
		Assert.assertEquals(expected[1],  Direction.NORTH.locationModifier()[1]);
	}

}
