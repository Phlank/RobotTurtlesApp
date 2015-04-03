package edu.bsu.cs222;

import junit.framework.TestCase;
import edu.bsu.cs222.finders.JewelFinder;
import edu.bsu.cs222.finders.TileFinder;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.JewelTile;
import edu.bsu.cs222.tiles.OpenSpaceTile;

public class JewelFinderTest extends TestCase{

	private TileFinder tileFinder;
	private GameMap gameMap;
	private static final Location JEWEL_LOCATION = new Location(1);
	private static final Location OPEN_TILE_LOCATION = new Location(0);
	private static final Location NOT_FOUND_LOCATION = new Location(-1);
	private OpenSpaceTile openTile = new OpenSpaceTile(OPEN_TILE_LOCATION);
	
	protected void setUp(){
		gameMap = GameMap.create();
		tileFinder = new TileFinder(new JewelFinder());
	}
	
	public void testThatJewelIsNotFound_noJewel(){
		gameMap.addSingleTileToMap(openTile);
		Location actual = tileFinder.findTile(gameMap).getLocation();
		Location expected = NOT_FOUND_LOCATION;
		assertEquals(expected, actual);
	}
	
	public void testThatJewelIsFound(){
		JewelTile jewel = new JewelTile(JEWEL_LOCATION);
		gameMap.addSingleTileToMap(jewel);
		gameMap.addSingleTileToMap(openTile);
		Location actual = tileFinder.findTile(gameMap).getLocation();
		Location expected = JEWEL_LOCATION;
		assertEquals(expected, actual);
	}
}
