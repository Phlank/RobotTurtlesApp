package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import android.util.Log;
import edu.bsu.cs222.enums.Direction;
import edu.bsu.cs222.game.maps.GameMap;
import edu.bsu.cs222.tiles.OpenSpaceTile;
import edu.bsu.cs222.tiles.Tile;

public class TurtleBot {

	private static final int WEST_BLOCK_MODIFIER = -1;
	private static final int EAST_BLOCK_MODIFIER = 1;
	private static final int NORTH_BLOCK_MODIFIER = -8;
	private static final int SOUTH_BLOCK_MODIFIER = 8;
	private static final int BACKWARDS_LEFT_COUNT = 2;
	private static final int FORWARDS_LEFT_COUNT = 2;

	private List<Tile> visited = new ArrayList<Tile>();
	private List<Tile> deadEnds = new ArrayList<Tile>();
	private MapTileSetter setter;
	private TurtleMover mover;
	private GameMap map;
	private static int leftCount = 0;

	public TurtleBot(MapTileSetter setter, GameMap map) {
		this.setter = setter;
		this.mover = setter.getTurtleMover();
		this.map = map;
	}

	public void go() {
		setter.getTurtleMover().findTurtleAndNextTile();
		boolean nextBlockIsForwards = setter.getTurtleMover().canMoveFoward() && leftCount != BACKWARDS_LEFT_COUNT;
		if (nextBlockIsForwards) {
			Log.d("GO", "Moving forward");
			leftCount = 0;
			Location lastLocation = mover.getTile().getLocation();
			setter.moveTurtleForward();
			visited.add(map.getTile(lastLocation));
		} else if (leftCount == FORWARDS_LEFT_COUNT) {
				deadEnd();
				leftCount = 0;
		} else {
			setter.turnTurtleToLeft();
			leftCount++;
		}
	}

	public void deadEnd() {
		Location deadLocation = setter.getTurtleTile().getLocation();
		moveToLastVisitedTile();
		deadEnds.add(map.getTile(deadLocation));
		go();
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
		}
	}

}
