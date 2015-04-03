package edu.bsu.cs222;

import edu.bsu.cs222.enums.Direction;
import junit.framework.TestCase;

public class LocationTest extends TestCase{
	
	private Location location;
	private static final Location FIRST_LOCATION = new Location(0);
	private static final Location SECOND_LOCATION = new Location(10);
	private static final Location THIRD_LOCATION = new Location(20);
	private static final Integer TEST_LOCATION = 35;
	private static final Integer SECOND_TEST_LOCATION = 25;
	
	protected void setUp(){
		location = FIRST_LOCATION;
	}
	
	public void testThatLocationsAreEqual_sameLocation(){
		assertTrue(location.equals(location));
	}
	
	public void testThatLocationsAreEqual_differentLocation(){
		Location firstLocation = new Location(TEST_LOCATION);
		Location secondLocation = new Location(TEST_LOCATION);
		assertTrue(firstLocation.equals(secondLocation));
	}
	
	public void testThatLocationsAreNotEqual(){
		Location firstLocation = new Location(TEST_LOCATION);
		Location secondLocation = new Location(SECOND_TEST_LOCATION);
		assertFalse(firstLocation.equals(secondLocation));
	}
	
	public void testThatForwardLocationIsFound(){
		Location actual = location.getForwardLocation(Direction.SOUTH);
		Location expected = SECOND_LOCATION;
		assertEquals(expected, actual);
	}
	
	public void testThatSecondForwardLocationIsFound(){
		Location actual = location.getSecondForwardLocation(Direction.SOUTH);
		Location expected = THIRD_LOCATION;
		assertEquals(expected, actual);
	}

}
