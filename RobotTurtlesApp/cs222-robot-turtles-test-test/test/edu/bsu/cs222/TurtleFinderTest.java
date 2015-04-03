package edu.bsu.cs222;

import junit.framework.TestCase;
import edu.bsu.cs222.enums.Direction;
import edu.bsu.cs222.finders.TileFinder;
import edu.bsu.cs222.finders.TurtleFinder;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.OpenSpaceTile;

public class TurtleFinderTest extends TestCase{
	
	private TileFinder tileFinder;
	private GameMap gameMap;
	private static final Location TURTLE_LOCATION = new Location(1);
	private static final Location OPEN_TILE_LOCATION = new Location(0);
	private static final Location NOT_FOUND_LOCATION = new Location(-1);
	private OpenSpaceTile openTile = new OpenSpaceTile(OPEN_TILE_LOCATION);
	private TurtleTile locatedTurtle;
	
	protected void setUp(){
		tileFinder = new TileFinder(new TurtleFinder());
		gameMap = GameMap.create();
	}
	
	public void testThatTurtleIsNotFound_noTurtle(){
		gameMap.addSingleTileToMap(openTile);
		locatedTurtle = (TurtleTile) tileFinder.findTile(gameMap);
		Location actual = locatedTurtle.getLocation();
		Location expected = NOT_FOUND_LOCATION;
		assertEquals(expected, actual);
	}
	
	public void testThatTurtleIsFound(){
		TurtleTile turtle = TurtleTile.withLocation(TURTLE_LOCATION).andDirection(Direction.SOUTH);
		gameMap.addSingleTileToMap(turtle);
		gameMap.addSingleTileToMap(openTile);
		Location actual = tileFinder.findTile(gameMap).getLocation();
		Location expected = TURTLE_LOCATION;
		assertEquals(expected, actual);
	}

}
