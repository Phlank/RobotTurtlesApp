package edu.bsu.cs222;

import edu.bsu.cs222.enums.Direction;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.IceBlockTile;
import edu.bsu.cs222.tiles.OpenSpaceTile;
import edu.bsu.cs222.tiles.WoodBlockTile;
import junit.framework.TestCase;

public class TurtleMoverTest extends TestCase {
	
	private GameMap gameMap;
	private static final Location FIRST_LOCATION = new Location(0);
	private static final Location SECOND_LOCATION = new Location(1);
	private static final Location THIRD_LOCATION = new Location(2);	
	private TurtleTile turtle;
	private TurtleMover turtleMover;
	    
	    protected void setUp(){
	    	gameMap = GameMap.create();
	    	turtle = TurtleTile.withLocation(FIRST_LOCATION).andDirection(Direction.EAST);
	    }
	    
	    public void testTurtleMovesForward(){
	    	moveTurtleTileInMap();
	    	assertTrue(gameMap.getTile(SECOND_LOCATION).isTurtleTile());
	    }
	    
	    public void testOldTileIsReplaced(){
	    	moveTurtleTileInMap();
	    	assertTrue(gameMap.getTile(FIRST_LOCATION).isOpenSpaceTile());
	    }
	    
	    public void testThatTurtleMovesWoodBlock(){
	    	pushWoodBlockInMap();
	    	assertTrue(gameMap.getTile(THIRD_LOCATION).isWoodBlockTile());
	    }
	    
	    public void testLaserIsFired(){
	    	fireLaserInMap();
	    	assertTrue(gameMap.getTile(SECOND_LOCATION).isPuddleTile());
	    }
	    
	    private void fireLaserInMap(){
	    	IceBlockTile iceBlockTile = new IceBlockTile(SECOND_LOCATION);
	    	gameMap.addSingleTileToMap(turtle);
	    	gameMap.addSingleTileToMap(iceBlockTile);
	    	turtleMover = new TurtleMover(gameMap);
	    	turtleMover.fireLaser();
	    }
	    
	    private void pushWoodBlockInMap(){
	    	WoodBlockTile woodTile = new WoodBlockTile(SECOND_LOCATION);
	    	addOpenSpaceTile(THIRD_LOCATION);
	    	gameMap.addSingleTileToMap(woodTile);
	    	gameMap.addSingleTileToMap(turtle);
	    	moveTurtle();
	    }
	    
	    private void moveTurtleTileInMap(){
	    	addOpenSpaceTile(SECOND_LOCATION);
	    	turtle = TurtleTile.withLocation(turtle.getLocation()).andDirection(Direction.EAST);
	    	gameMap.addSingleTileToMap(turtle);
	    	moveTurtle();
	    }
	    
	    private void addOpenSpaceTile(Location location){
	    	OpenSpaceTile openSpaceTile = new OpenSpaceTile(location);
	    	gameMap.addSingleTileToMap(openSpaceTile);
	    }
	    
	    private void moveTurtle(){
	    	turtleMover = new TurtleMover(gameMap);
	    	turtleMover.moveForward();
	    }
}
