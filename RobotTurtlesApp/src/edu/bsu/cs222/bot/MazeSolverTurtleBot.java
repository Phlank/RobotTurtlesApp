package edu.bsu.cs222.bot;

import java.util.ArrayList;

import android.util.Log;
import edu.bsu.cs222.Location;
import edu.bsu.cs222.MapTileSetter;
import edu.bsu.cs222.TurtleMover;
import edu.bsu.cs222.enums.Direction;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.Tile;

public class MazeSolverTurtleBot {

	private static final int WEST_BLOCK_MODIFIER = -1;
	private static final int EAST_BLOCK_MODIFIER = 1;
	private static final int NORTH_BLOCK_MODIFIER = -8;
	private static final int SOUTH_BLOCK_MODIFIER = 8;
	private static final int BACKWARDS_LEFT_COUNT = 2;
	private static final int FORWARDS_LEFT_COUNT = 4;

	private static ArrayList<Tile> visited = new ArrayList<Tile>();
	private static ArrayList<Tile> deadEnds = new ArrayList<Tile>();
	private MapTileSetter setter;
	private TurtleMover mover;
	private GameMap map;
	private static int leftCount = 0;

	public MazeSolverTurtleBot(MapTileSetter setter, GameMap map) {
		this.setter = setter;
		this.mover = setter.getTurtleMover();
		this.map = map;
	}

	public void go() {
		setter.getTurtleMover().findTurtleAndNextTile();
		// Looking backwards
		if (leftCount == BACKWARDS_LEFT_COUNT) {
			setter.turnTurtleToLeft();
			leftCount++;
		} // Looking at empty block (not backwards)
		else if (setter.getTurtleMover().canMoveFoward() && !visited.contains(setter.getForwardTile())) {
			Log.d("GO", "Moving forward");
			leftCount = 0;
			Location lastLocation = setter.getTurtleTile().getLocation();
			setter.moveTurtleForward();
			visited.add(map.getTile(lastLocation));
		} // Looking at first block to look at after arriving at current tile
		else if (leftCount == FORWARDS_LEFT_COUNT
				&& !deadEnds.contains(setter.getForwardTile())) {
			deadEnd();
			leftCount = 2;
		} // Looking at either left or right of arrival position and no path
		else {
			setter.turnTurtleToLeft();
			leftCount++;
		}
	}

	public void deadEnd() {
		Location deadLocation = setter.getTurtleTile().getLocation();
		moveToLastVisitedTile();
		deadEnds.add(map.getTile(deadLocation));
	}

	// Turtle turns left until it faces the last visited tile and moves forward
	private void moveToLastVisitedTile() {
		if (visited.size() > 0) {
			// West
			if (visited.get(visited.size() - 1).getLocation().getTileLocation() == mover
					.getTile().getLocation().getTileLocation()
					- WEST_BLOCK_MODIFIER) {
				while (mover.getTile().getDirection() != Direction.WEST) {
					setter.turnTurtleToLeft();
				}
			}
			// East
			else if (visited.get(visited.size() - 1).getLocation()
					.getTileLocation() == mover.getTile().getLocation()
					.getTileLocation()
					+ EAST_BLOCK_MODIFIER) {
				while (mover.getTile().getDirection() != Direction.EAST) {
					setter.turnTurtleToLeft();
				}
			}
			// North
			else if (visited.get(visited.size() - 1).getLocation()
					.getTileLocation() == mover.getTile().getLocation()
					.getTileLocation()
					- NORTH_BLOCK_MODIFIER) {
				while (mover.getTile().getDirection() != Direction.NORTH) {
					setter.turnTurtleToLeft();
				}
			}
			// South
			else if (visited.get(visited.size() - 1).getLocation()
					.getTileLocation() == mover.getTile().getLocation()
					.getTileLocation()
					- SOUTH_BLOCK_MODIFIER) {
				while (mover.getTile().getDirection() != Direction.SOUTH) {
					setter.turnTurtleToLeft();
				}
			}
			visited.remove(visited.size() - 1);
			setter.moveTurtleForward();
		}
	}

	public void resetArrays() {
		visited = new ArrayList<Tile>();
		deadEnds = new ArrayList<Tile>();
	}

}
