package edu.bsu.cs222;

import edu.bsu.cs222.finders.TileFinder;
import edu.bsu.cs222.finders.TurtleFinder;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.OpenSpaceTile;
import edu.bsu.cs222.tiles.PuddleTile;
import edu.bsu.cs222.tiles.Tile;
import edu.bsu.cs222.tiles.WoodBlockTile;

public class TurtleMover {

	private TurtleTile turtle;
	private GameMap map;
	private Location locationToMove;
	private Tile nextTile;
	private TileFinder tileFinder;

	public TurtleMover(GameMap map) {
		this.map = map;
	}

	public GameMap moveForward() {
		findTurtleAndNextTile();
		if (canMoveFoward()) {
			moveTurtleTileForward();
		} else if (canPushBlock()) {
			pushWoodBlockForward();
		}
		return map;
	}

	private void findTurtleAndNextTile() {
		tileFinder = new TileFinder(new TurtleFinder());
		turtle = (TurtleTile) tileFinder.findTile(map);
		locationToMove = turtle.getForwardTileLocation();
		nextTile = (Tile) map.getTile(locationToMove);
	}

	public boolean canMoveFoward() {
		boolean canTurtleMove = canMove(locationToMove);
		return (canTurtleMove && nextTile.isOpenSpaceTile());
	}

	private boolean canPushBlock() {
		boolean canTurtleMove = canMove(locationToMove);
		return (canTurtleMove && nextTile.isWoodBlockTile());
	}

	private GameMap moveTurtleTileForward() {
		Location turtleLocation = turtle.getLocation();
		turtle.setLocation(locationToMove);
		map.addSingleTileToMap(turtle);
		map.addSingleTileToMap(new OpenSpaceTile(turtleLocation));
		return map;
	}

	private GameMap pushWoodBlockForward() {
		Location secondLocationToMove = turtle.getSecondForwardTileLocation();
		Tile thirdTile = map.getTile(secondLocationToMove);
		if (canMove(secondLocationToMove) && thirdTile.isOpenSpaceTile()) {
			moveTurtleTileForward();
			map.addSingleTileToMap(new WoodBlockTile(thirdTile.getLocation()));
		}
		return map;
	}

	public GameMap fireLaser() {
		findTurtleAndNextTile();
		if (canMove(locationToMove) && nextTile.isIceBlockTile()) {
			map.addSingleTileToMap(new PuddleTile(nextTile.getLocation()));
		}
		return map;
	}

	private boolean canMove(Location locationToMove) {
		return map.doesLocationExist(locationToMove);
	}
	
	public TurtleTile getTile() {
		return turtle;
	}
}