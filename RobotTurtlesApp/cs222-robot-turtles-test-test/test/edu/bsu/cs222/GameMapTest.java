package edu.bsu.cs222;

import junit.framework.TestCase;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.OpenSpaceTile;

public class GameMapTest extends TestCase{
	
	private GameMap map;
	private static final Location OPEN_TILE_LOCATION = new Location(0);
	private static final Integer MAP_SIZE = 1; 
	
	protected void setUp(){
		map = GameMap.create();
	}
	
	public void testThatGameMapIsEmpty(){
		assertTrue(map.isEmpty());
	}
	
	public void testThatMapIsNotEmpty(){
		addOneTileToMap();
		assertTrue(!map.isEmpty());
	}
	
	public void testThatLocationIsFound(){
		addOneTileToMap();
		assertTrue(map.doesLocationExist(OPEN_TILE_LOCATION));
	}
	
	public void testThatLocationIsNotFound(){
		assertFalse(map.doesLocationExist(OPEN_TILE_LOCATION));
	}
	
	public void testThatMapHasOneElement(){
		addOneTileToMap();
		Integer actual = map.getMapSize();
		Integer expected = MAP_SIZE;
		assertEquals(expected, actual);
	}
	
	public void addOneTileToMap(){
		OpenSpaceTile openSpaceTile = new OpenSpaceTile(OPEN_TILE_LOCATION);
		map.addSingleTileToMap(openSpaceTile);
		
	}
}
